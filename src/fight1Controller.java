import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.animation.Interpolator;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.util.Duration;

public class fight1Controller implements Initializable {

    private static int role, karakterPilih, weapon;
    private static boolean state;
    AttWeapon BD;
    Chara t1;
    Dialog d1;
    Chara c1;
    Villain v1;

    FightingScene p1;
    FightingScene p2;

    Image skillJoe = new Image("/res/Joe Skill.png");
    Image skillBiden = new Image("res/Biden Skill.png");
    Image skillZydan = new Image("/res/Zydan Skill.png");
    Image skillBagas = new Image("/res/Bagas Skill.png");
    Image skillBilbo = new Image("/res/Bilbo Skill.png");
    Image skillJanus = new Image("/res/Janus Skill.png");
    Image skillZenon = new Image("/res/Zenon Skill.png");
    Image box = new Image("/res/box putih.png");
    Image heal = new Image("/res/heal eefek.png");
    Image bilbo = new Image("/res/v1.png");
    Image janus = new Image("/res/v2.png");
    Image zenon = new Image("/res/v3.png");
    Image healmusuh = new Image("/res/healeffectv.png");

    @FXML
    private Text playerName;

    @FXML
    private ImageView background;

    @FXML
    private Text villainName;

    @FXML
    private Text matchStage;

    @FXML
    private Text hpStatusPlayer;

    @FXML
    private Text manaStatusPlayer;

    @FXML
    private Text hpStatusVillain;

    @FXML
    private Text manaStatusVillain;

    @FXML
    private Button attackButton;

    @FXML
    private Button skillButton;

    @FXML
    private Button healButton;

    @FXML
    private ImageView karakter;

    @FXML
    private ImageView senjata;

    @FXML
    private ImageView villain;

    @FXML
    private ImageView skill;

    @FXML
    private ImageView healEfek;

    @FXML
    private Pane pane;

    @FXML
    private ImageView boxPutih;

    @FXML
    private Text movesText;

    @FXML
    private ImageView resultBack;

    @FXML
    private ImageView result;

    @FXML
    private Text resultText;

    @FXML
    private Button lanjutUlangButton;

    @FXML
    private Button menuButton;

    @FXML
    private ImageView healthMusuh;

    @FXML
    void backToMenu() throws IOException {
        Parent start = FXMLLoader.load(getClass().getResource("Start.fxml"));
        Scene pilih = new Scene(start, 800, 600);
        Stage stage = (Stage)menuButton.getScene().getWindow();
        stage.setResizable(false);
    
        stage.setTitle("Fighting Impact 0.2");
        stage.setScene(pilih);
        stage.show();
    }

    @FXML
    void lanjutUlang() throws IOException{
        Parent start = FXMLLoader.load(getClass().getResource("Fight1.fxml"));
        Scene pilih = new Scene(start, 800, 600);
        Stage stage = (Stage)lanjutUlangButton.getScene().getWindow();
        stage.setResizable(false);
    
        stage.setTitle("Fighting Impact 0.2");
        stage.setScene(pilih);
        stage.show(); 
    }

    @FXML
    void playerAttack() {

        pane.getChildren().addAll(boxPutih, movesText);
        boxPutih.setImage(box);

        movesText.setText(Chara.getCharaName() + " attacked " + villainName.getText() + " !");

        RotateTransition rt = new RotateTransition(Duration.millis(100), senjata);
        rt.setByAngle(60);
        rt.setCycleCount(2);
        rt.setInterpolator(Interpolator.LINEAR);
        rt.setAutoReverse(true);
        rt.play();
        rt.setNode(senjata);
        PauseTransition pause = new PauseTransition(Duration.seconds(1.2));
        RotateTransition wr = new RotateTransition(Duration.millis(400), villain);
        wr.setByAngle(360);
        wr.setCycleCount(1);
        wr.setInterpolator(Interpolator.LINEAR);
        wr.play();
        wr.setNode(villain);
        pause.setOnFinished(e -> {

            pane.getChildren().remove(boxPutih);
            pane.getChildren().remove(movesText);


        });
        pause.play();
        p1.hit(p2);
        hpStatusVillain.setText("HP      : " + p2.getLifePoint() + "/" + p2.getFullHp());
        System.out.println("Nyawa Musuh : " + p2.getLifePoint());
        System.out.println("Attack Player : " + p1.getPowerAtk());
        state = true;


    }

    @FXML
    void playerHeal() {

        if (p1.getAmount() == 0)
            pane.getChildren().remove(healButton);

        if (p1.getLifePoint() >= p1.getFullHp())
            p1.setLifePoint(p1.getFullHp());
        else if (p1.getLifePoint() < p1.getFullHp()) {
            healEfek.setImage(heal);
            pane.getChildren().addAll(boxPutih, movesText);
            boxPutih.setImage(box);
            movesText.setText(Chara.getCharaName() + " used a Medkit!");
            p1.heal();
            Task<Void> sleeper = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ignored) {
                    }
                    return null;
                }
            };
            sleeper.setOnSucceeded((EventHandler<WorkerStateEvent>) new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent event) {
                    healEfek.setImage(null);
                    pane.getChildren().remove(boxPutih);
                    pane.getChildren().remove(movesText);



                }
            });
            new Thread(sleeper).start();
        }


        hpStatusPlayer.setText("HP      : " + p1.getLifePoint() + "/" + p1.getFullHp());
        state = true;


    }

    @FXML
    void playerSkill() {
        if (Chara.getCharaName().equals("Joe"))
            skill.setImage(skillJoe);
        else if (Chara.getCharaName().equals("Biden"))
            skill.setImage(skillBiden);
        else if (Chara.getCharaName().equals("Zydan"))
            skill.setImage(skillZydan);
        else if (Chara.getCharaName().equals("Bagas"))
            skill.setImage(skillBagas);
        pane.getChildren().addAll(boxPutih, movesText);
        boxPutih.setImage(box);
        movesText.setText(Chara.getCharaName() + " used Special attack to " + villainName.getText());
        PauseTransition pause = new PauseTransition(Duration.seconds(1.2));
        RotateTransition wr = new RotateTransition(Duration.millis(400), villain);
        wr.setByAngle(360);
        wr.setCycleCount(1);
        wr.setInterpolator(Interpolator.LINEAR);
        wr.play();
        wr.setNode(villain);
        pause.setOnFinished(e -> {
            skill.setImage(null);
            pane.getChildren().remove(boxPutih);
            pane.getChildren().remove(movesText);


        });
        pause.play();
        System.out.println(Chara.getCharaName());
        p1.skill(p2);
        hpStatusVillain.setText("HP      : " + p2.getLifePoint() + "/" + p2.getFullHp());
        if (p1.getMana() < 25)
            pane.getChildren().remove(skillButton);
        manaStatusPlayer.setText("Mana  : " + p1.getMana() + "/" + p1.getFullMana());
        System.out.println(p1.getLifePoint());
        //p1.setLifePoint(10);
        state = true;


    }

    void enemyAttack() {
        Dialog.wait(1250);//t
        RotateTransition rt = new RotateTransition(Duration.millis(100), villain);
        rt.setByAngle(-60);
        rt.setCycleCount(2);
        rt.setInterpolator(Interpolator.LINEAR);
        rt.setAutoReverse(true);
        rt.play();
        rt.setNode(villain);
        RotateTransition wr = new RotateTransition(Duration.millis(400), karakter);
        wr.setByAngle(-360);
        wr.setCycleCount(1);
        wr.setInterpolator(Interpolator.LINEAR);
        wr.play();
        wr.setNode(karakter);

        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Platform.runLater(new Runnable(){

                        @Override
                        public void run() {
                            pane.getChildren().addAll(boxPutih, movesText); 
                            boxPutih.setImage(box);
                            movesText.setText(Villain.getName() + " attacked " + Chara.getCharaName() + " ,OUCHH!!!!");
                        }
                    });
                    
                    
                    Thread.sleep(1000);//t
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded((EventHandler<WorkerStateEvent>) new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                    pause.setOnFinished(e -> { 
                    pane.getChildren().remove(boxPutih);
                    pane.getChildren().remove(movesText);
                    });pause.play();
            }
        });
        new Thread(sleeper).start();

        hpStatusPlayer.setText("HP      : " + p1.getLifePoint() + "/" + p1.getFullHp());
        System.out.println(p1.getLifePoint());
        state = false;
        


    }

    void enemyHeal() {
        Dialog.wait(1250);//t

        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Platform.runLater(new Runnable(){

                        @Override
                        public void run() {

                            pane.getChildren().addAll(boxPutih, movesText, healthMusuh);
                            boxPutih.setImage(box);
                            healthMusuh.setImage(healmusuh);
                            movesText.setText(Villain.getName() + " used Ancient Magic to heal! ");
                        }
                    });
                    
                    
                    Thread.sleep(1000);//t
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded((EventHandler<WorkerStateEvent>) new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                PauseTransition pause = new PauseTransition(Duration.seconds(1)); //t
                    pause.setOnFinished(e -> {
                        pane.getChildren().remove(healthMusuh);
                    pane.getChildren().remove(boxPutih);
                    pane.getChildren().remove(movesText);
                    });pause.play();
            }
        });
        new Thread(sleeper).start();

        hpStatusVillain.setText("HP      : " + p2.getLifePoint() + "/" + p2.getFullHp());
        state = false;

    }

    void enemySkill(){
        Dialog.wait(1250);//t

        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Platform.runLater(new Runnable(){

                        @Override
                        public void run() {
                            if (Villain.getVillainOrder() == 0)
                                skill.setImage(skillBilbo);
                            else if (Villain.getVillainOrder() == 1)
                                skill.setImage(skillJanus);
                            else if (Villain.getVillainOrder() == 2)
                                skill.setImage(skillZenon);
                            pane.getChildren().addAll(boxPutih, movesText); 
                            boxPutih.setImage(box);
                            movesText.setText(Villain.getName() + " Used Special Dark Magic to attack " + Chara.getCharaName());
                            RotateTransition wr = new RotateTransition(Duration.millis(400), karakter);
                            wr.setByAngle(-360);
                            wr.setCycleCount(1);
                            wr.setInterpolator(Interpolator.LINEAR);
                            wr.play();
                            wr.setNode(karakter);
                        }
                    });
                    
                    
                    Thread.sleep(1000);//t
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded((EventHandler<WorkerStateEvent>) new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                PauseTransition pause = new PauseTransition(Duration.seconds(1.2)); //t
                    pause.setOnFinished(e -> {
                        skill.setImage(null);
                    pane.getChildren().remove(boxPutih);
                    pane.getChildren().remove(movesText);

                    });pause.play();
            }
        });
        new Thread(sleeper).start();

        hpStatusPlayer.setText("HP      : " + p1.getLifePoint() + "/" + p1.getFullHp());
        manaStatusVillain.setText("Mana  : " + p2.getMana() + "/" + p2.getFullMana());
        
        state = false;
       
    }



    void result() {
        pane.getChildren().addAll(resultBack, result, resultText, lanjutUlangButton, menuButton);
        if(Villain.getVillainOrder() == 3){
            resultText.setText("YOU WIN!!\nTHANKS FOR PLAYING!");
            v1.setUlangOrder(0);
            pane.getChildren().remove(lanjutUlangButton);
        }
    }

    

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        Image img1 = new Image("/res/1m.png");
        Image img2 = new Image("/res/2m.png");
        Image img3 = new Image("/res/melee1.png");
        Image img4 = new Image("/res/melee2.png");
        Image img5 = new Image("/res/1r.png");
        Image img6 = new Image("/res/2r.png");
        Image img7 = new Image("/res/range1.png");
        Image img8 = new Image("/res/range2.png");
        Image Background1 = new Image("/res/Background1.jpg");
        Image Background2 = new Image("/res/background 2.jpg");
        Image Background3 = new Image("/res/background 3.jpg");
        
        
        
        if(Chara.getCharaName().equals("Joe")){
            playerName.setText("Joe");
            karakter.setImage(img1);
            role = 1;
            karakterPilih = 1;

        }else if(Chara.getCharaName().equals("Biden")){
            playerName.setText("Biden");
            karakter.setImage(img2);
            role = 1;karakterPilih = 2;
        }else if(Chara.getCharaName().equals("Zydan")){
            playerName.setText("Zydan");
            karakter.setImage(img5);
            role = 2;karakterPilih = 1;
        }else if(Chara.getCharaName().equals("Bagas")){
            playerName.setText("Bagas");
            karakter.setImage(img6);
            role = 2;karakterPilih = 2;
        }
           

        if(AttWeapon.getWeaponName().equals("Sukuna Sabukyo Bakufu")){
            senjata.setImage(img3);
            weapon = 1;
        }else if(AttWeapon.getWeaponName().equals("Cursed Daimyo Blade")){
            senjata.setImage(img4);
            weapon = 2;
        }else if(AttWeapon.getWeaponName().equals("DareDevil")){
            Rotate rotate = new Rotate();
            rotate.setAngle(135);
            rotate.setPivotX(115);
            rotate.setPivotY(60);
            senjata.getTransforms().add(rotate);
            senjata.setImage(img7);
            weapon = 1;
        }
        else if(AttWeapon.getWeaponName().equals("Mariposa")){
            Rotate rotate = new Rotate();
            rotate.setAngle(135);
            rotate.setPivotX(115);
            rotate.setPivotY(65);
            senjata.getTransforms().add(rotate);
            senjata.setImage(img8);
            weapon = 2;
        }

        if(role == 1 && (karakterPilih == 1 || karakterPilih == 2) && weapon == 1){
            hpStatusPlayer.setText("HP      : 110/110");
            manaStatusPlayer.setText("Mana  : 125/125");

        }else if(role == 1 && (karakterPilih == 1 || karakterPilih == 2) && weapon == 2){
            hpStatusPlayer.setText("HP      : 100/100");
            manaStatusPlayer.setText("Mana  : 125/125");
        }else if(role == 2 && (karakterPilih == 1 || karakterPilih == 2) && weapon == 1){
            hpStatusPlayer.setText("HP      : 90/90");
            manaStatusPlayer.setText("Mana  : 150/150");
        }else if(role == 2 && (karakterPilih == 1 || karakterPilih == 2) && weapon == 2){
            hpStatusPlayer.setText("HP      : 85/85");
            manaStatusPlayer.setText("Mana  : 125/125");
        }
            
        if(Villain.getVillainOrder() == 0){
            villain.setImage(bilbo);
            Villain.setName(Villain.getVillainOrder());
            villainName.setText("Bilbo");
            hpStatusVillain.setText("HP      : 105/105");
            manaStatusVillain.setText("Mana  : 100/100");
            matchStage.setText("MATCH 1");
            background.setImage(Background3);
        }else if(Villain.getVillainOrder() == 1){
            villain.setImage(janus);
            villain.setFitWidth(230);
            villain.setFitHeight(228);
            villain.setLayoutX(561);
            villain.setLayoutY(310);
            Villain.setName(Villain.getVillainOrder());
            villainName.setText("Janus");
            hpStatusVillain.setText("HP      : 115/115");
            manaStatusVillain.setText("Mana  : 100/100");
            matchStage.setText("MATCH 2");
            background.setImage(Background2);
        }else if(Villain.getVillainOrder() == 2){
            villain.setImage(zenon);
            villain.setFitWidth(435);
            villain.setFitHeight(327);
            villain.setLayoutX(366);
            villain.setLayoutY(197);
            Villain.setName(Villain.getVillainOrder());
            villainName.setText("Zenon");
            hpStatusVillain.setText("HP      : 120/120");
            manaStatusVillain.setText("Mana  : 100/100");
            matchStage.setText("MATCH 3");
            background.setImage(Background1);
        }


        BD = new AttWeapon();
        t1 = new Chara();
        d1 = new Dialog();
        
        t1.setCharacter(role);
        t1.setCharaName(role, karakterPilih);
        
        BD.chooseWeapon(role);
        BD.setWeapon(role, weapon);
        
        c1 = new Chara(Chara.getCharaName(), role, BD);
        v1 = new Villain(Villain.getName(), Villain.getVillainOrder());

        p1 = new FightingScene(Chara.getCharaName(), c1.getATK(), c1.getHealth(), c1.getMana());
        p2 = new FightingScene(Villain.getName(), v1.getATK(), v1.getHealth(), v1.getMana());
        pane.getChildren().remove(boxPutih);
        pane.getChildren().remove(movesText);
        pane.getChildren().remove(resultBack);
        pane.getChildren().remove(lanjutUlangButton);
        pane.getChildren().remove(menuButton);
        pane.getChildren().remove(resultText);
        pane.getChildren().remove(result);
        pane.getChildren().remove(healthMusuh);

        
        Task<Void> task = new Task<Void>() {
            @Override protected Void call() throws Exception {
                
                while (p1.getLifePoint() > 0 && p2.getLifePoint() > 0) {
                    System.out.println(state);
                        attackButton.setOnAction(e -> playerAttack());
                        healButton.setOnAction(e -> playerHeal());
                        skillButton.setOnAction(e -> playerSkill());

                        if (p2.getLifePoint() <= 0) {
                            Dialog.wait(2000);
                            break;
                        }

                        if(state){

                        if(p2.getMana()<25){

                            d1.figthing2(p1,p2);
                            System.out.println(Dialog.getPilihan());
                            if(Dialog.getPilihan() == 0){
                                enemyAttack();

                            }else if(Dialog.getPilihan() == 1){
                                enemyHeal();
                            }
                            
                        }
                        else{

                            d1.figthing22(p1,p2);
                            System.out.println(Dialog.getPilihan());
                            if(Dialog.getPilihan() == 0){
                                enemyAttack();
                            }else if(Dialog.getPilihan() == 1){
                                enemySkill();
                            }else if(Dialog.getPilihan() == 2){
                                enemyHeal();
                            }
                        }
    
                        if (p1.getLifePoint() <= 0) {
                            Dialog.wait(2000);
                            break;
                        }

                     }
                }
                return null;
            }
        };
            
            
            task.setOnSucceeded(e -> {
                if (p1.getLifePoint() < p2.getLifePoint()) {
                    resultText.setText("YOU LOSE!\nWINNER : " + villainName.getText() + " :(");
                    lanjutUlangButton.setText("Retry");
                    Chara.setATKChar(0);
                    state = false;
                    p1.setAmount(2);
                    p2.setAmount(2);
                    result();
                }else if(p1.getLifePoint() > p2.getLifePoint()){
                    resultText.setText("YOU WIN!");
                    lanjutUlangButton.setText("Lanjut");
                    Chara.setATKChar(0);
                    state = false;
                    p1.setAmount(2);
                    p2.setAmount(2);
                    v1.setOrder();
                    result();
                }
            });
            Thread th = new Thread(task);
            th.setDaemon(true);
            th.start();
            
            
    }
}
