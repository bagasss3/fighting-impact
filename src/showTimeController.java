import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;


public class showTimeController implements Initializable {



    @FXML
    private ImageView karakter;

    @FXML
    private ImageView senjata;

    @FXML
    private ImageView villain;

    @FXML
    private Button GO;

    @FXML
    private Text ATKShowtime;

    @FXML
    private Text HealthShowtime;

    @FXML
    private Text ManaShowtime;

    @FXML
    private Text match;

    @FXML
    void goButton() throws IOException {
    
        Parent start = FXMLLoader.load(getClass().getResource("Fight1.fxml"));
        Scene pilih = new Scene(start, 800, 600);
        Stage stage = (Stage)GO.getScene().getWindow();
        stage.setResizable(false);
    
        stage.setTitle("Fighting Impact 0.2");
        stage.setScene(pilih);
        stage.show();
    }

    @FXML
    private Text namaKarakter;

    @FXML
    private Text namaVillain;

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
        Image v2 = new Image("/res/v2.png");
        Image v3 = new Image("/res/v3.png");
        
        if(Chara.getCharaName().equals("Joe"))
            karakter.setImage(img1);
        else if(Chara.getCharaName().equals("Biden"))
            karakter.setImage(img2);
        else if(Chara.getCharaName().equals("Zydan"))
            karakter.setImage(img5);
        else if(Chara.getCharaName().equals("Bagas"))
            karakter.setImage(img6);

        if(AttWeapon.getWeaponName().equals("Sukuna Sabukyo Bakufu"))
            senjata.setImage(img3);
        else if(AttWeapon.getWeaponName().equals("Cursed Daimyo Blade"))
            senjata.setImage(img4);
        else if(AttWeapon.getWeaponName().equals("DareDevil")){
            Rotate rotate = new Rotate();
            rotate.setAngle(135);
            rotate.setPivotX(115);
            rotate.setPivotY(60);
            senjata.getTransforms().add(rotate);
            senjata.setImage(img7);
        }
        else if(AttWeapon.getWeaponName().equals("Mariposa")){
            Rotate rotate = new Rotate();
            rotate.setAngle(135);
            rotate.setPivotX(115);
            rotate.setPivotY(65);
            senjata.getTransforms().add(rotate);
            senjata.setImage(img8);
        }

        if((Chara.getCharaName().equals("Joe") || Chara.getCharaName().equals("Biden")) && AttWeapon.getWeaponName().equals("Sukuna Sabukyo Bakufu") && Villain.getVillainOrder() == 0){
            ATKShowtime.setText("15 ATK 20");
            HealthShowtime.setText("110 HEALTH 105");
            ManaShowtime.setText("125 MANA 100");
            namaKarakter.setText(Chara.getCharaName());
        }else if((Chara.getCharaName().equals("Joe") || Chara.getCharaName().equals("Biden")) && AttWeapon.getWeaponName().equals("Cursed Daimyo Blade") && Villain.getVillainOrder() == 0){
            ATKShowtime.setText("20 ATK 20");
            HealthShowtime.setText("100 HEALTH 105");
            ManaShowtime.setText("125 MANA 100");
            namaKarakter.setText(Chara.getCharaName());
        }else if((Chara.getCharaName().equals("Zydan") || Chara.getCharaName().equals("Bagas")) && AttWeapon.getWeaponName().equals("DareDevil") && Villain.getVillainOrder() == 0){
            ATKShowtime.setText("25 ATK 20");
            HealthShowtime.setText("90 HEALTH 105");
            ManaShowtime.setText("150 MANA 100");
            namaKarakter.setText(Chara.getCharaName());
        }else if((Chara.getCharaName().equals("Zydan") || Chara.getCharaName().equals("Bagas")) && AttWeapon.getWeaponName().equals("Mariposa") && Villain.getVillainOrder() == 0){
            ATKShowtime.setText("35 ATK 20");
            HealthShowtime.setText("85 HEALTH 105");
            ManaShowtime.setText("125 MANA 100");
            namaKarakter.setText(Chara.getCharaName());//weqweqweqweqweqw
        }else if((Chara.getCharaName().equals("Joe") || Chara.getCharaName().equals("Biden")) && AttWeapon.getWeaponName().equals("Sukuna Sabukyo Bakufu") && Villain.getVillainOrder() == 1){
            ATKShowtime.setText("15 ATK 25");
            HealthShowtime.setText("110 HEALTH 115");
            ManaShowtime.setText("125 MANA 100");
            namaKarakter.setText(Chara.getCharaName());
        }else if((Chara.getCharaName().equals("Joe") || Chara.getCharaName().equals("Biden")) && AttWeapon.getWeaponName().equals("Cursed Daimyo Blade") && Villain.getVillainOrder() == 1){
            ATKShowtime.setText("20 ATK 25");
            HealthShowtime.setText("100 HEALTH 115");
            ManaShowtime.setText("125 MANA 100");
            namaKarakter.setText(Chara.getCharaName());
        }else if((Chara.getCharaName().equals("Zydan") || Chara.getCharaName().equals("Bagas")) && AttWeapon.getWeaponName().equals("DareDevil") && Villain.getVillainOrder() == 1){
            ATKShowtime.setText("25 ATK 25");
            HealthShowtime.setText("90 HEALTH 115");
            ManaShowtime.setText("150 MANA 100");
            namaKarakter.setText(Chara.getCharaName());
        }else if((Chara.getCharaName().equals("Zydan") || Chara.getCharaName().equals("Bagas")) && AttWeapon.getWeaponName().equals("Mariposa") && Villain.getVillainOrder() == 1){
            ATKShowtime.setText("35 ATK 25");
            HealthShowtime.setText("85 HEALTH 115");
            ManaShowtime.setText("125 MANA 100");
            namaKarakter.setText(Chara.getCharaName());//qweqwewqeqweq
        }else if((Chara.getCharaName().equals("Joe") || Chara.getCharaName().equals("Biden")) && AttWeapon.getWeaponName().equals("Sukuna Sabukyo Bakufu") && Villain.getVillainOrder() == 2){
            ATKShowtime.setText("15 ATK 30");
            HealthShowtime.setText("110 HEALTH 120");
            ManaShowtime.setText("125 MANA 100");
            namaKarakter.setText(Chara.getCharaName());
        }else if((Chara.getCharaName().equals("Joe") || Chara.getCharaName().equals("Biden")) && AttWeapon.getWeaponName().equals("Cursed Daimyo Blade") && Villain.getVillainOrder() == 2){
            ATKShowtime.setText("20 ATK 30");
            HealthShowtime.setText("100 HEALTH 120");
            ManaShowtime.setText("125 MANA 100");
            namaKarakter.setText(Chara.getCharaName());
        }else if((Chara.getCharaName().equals("Zydan") || Chara.getCharaName().equals("Bagas")) && AttWeapon.getWeaponName().equals("DareDevil") && Villain.getVillainOrder() == 2){
            ATKShowtime.setText("25 ATK 30");
            HealthShowtime.setText("90 HEALTH 120");
            ManaShowtime.setText("150 MANA 100");
            namaKarakter.setText(Chara.getCharaName());
        }else if((Chara.getCharaName().equals("Zydan") || Chara.getCharaName().equals("Bagas")) && AttWeapon.getWeaponName().equals("Mariposa") && Villain.getVillainOrder()==2){
            ATKShowtime.setText("35 ATK 30");
            HealthShowtime.setText("85 HEALTH 120");
            ManaShowtime.setText("125 MANA 100");
            namaKarakter.setText(Chara.getCharaName());
        }

        if(Villain.getVillainOrder() == 1){
            match.setText("Match 2");
            villain.setFitWidth(264);
            villain.setFitHeight(227);
            villain.setLayoutX(521);
            villain.setLayoutY(177);
            namaVillain.setText("Janus");
            villain.setImage(v2);
        }else if(Villain.getVillainOrder() == 2){
            match.setText("Match 3");
            villain.setFitWidth(290);
            villain.setFitHeight(222);
            villain.setLayoutX(510);
            villain.setLayoutY(192);
            namaVillain.setText("Zenon");
            villain.setImage(v3);
        }
            
    }
}