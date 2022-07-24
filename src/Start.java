import java.util.Scanner;
public class Start {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AttWeapon BD = new AttWeapon();
        Chara t1 = new Chara();
        Villain t2 = new Villain();
        Dialog d1 = new Dialog();
        int character, weapon, button, match=1,role;

        //Memilih CLASS, HERO dan SENJATA
        label: do {
            System.out.println("\nChoose Your Role : "); //CLASS
            System.out.println("1. Melee (ATK:5, HP:100, MANA:100)");
            System.out.println("2. Range (ATK:10, HP:80, MANA:125)");
            System.out.print("Option: ");
            role = input.nextInt();
            label2: do {
                t1.setCharacter(role); //Pilih Character hero
                System.out.print("Option: ");
                character = input.nextInt();
                t1.setCharaName(role, character);
                if (character == 3) continue label;
                BD.chooseWeapon(role); //SENJATA (Senjata menyesuaikan dengan class yang kita pilih)
                System.out.print("Option: ");
                weapon = input.nextInt();
                BD.setWeapon(role, weapon);
                if(weapon==3) continue label2;
                break;
            }while (true);
            break;
        }while(true);

       /* System.out.println("Choose Your Role : "); //CLASS
        System.out.println("1. Melee (ATK:5, HP:100, MANA:100)");
        System.out.println("2. Range (ATK:10, HP:80, MANA:120)");
        System.out.print("Option: ");
        role = input.nextInt();

        t1.setCharacter(role); //Pilih CLASS hero
        System.out.print("Option: ");
        character = input.nextInt();
        t1.setCharaName(role, character);

        BD.chooseWeapon(role); //SENJATA (Senjata menyesuaikan dengan class yang kita pilih)
        System.out.print("Option: ");
        weapon = input.nextInt();
        BD.setWeapon(role, weapon);
        */
        while (t2.getVillainOrder()<t2.totalVillain()) { //Jika villain sudah habis, game berakhir (ada 3 villain)
            //Menampilkan atribut HERO yang kita pilih dan VILLAIN yang sudah ditentukan
            Chara c1 = new Chara(Chara.getCharaName(), role, BD);
            System.out.println("\nCharacter Profile: \n" + c1);
            Villain.setName(t2.getVillainOrder());
            Villain v1 = new Villain(Villain.getName(),t2.getVillainOrder());
            System.out.println("\nVillain Profile:");
            System.out.println(v1);

            FightingScene p1 = new FightingScene(Chara.getCharaName(), c1.getATK(), c1.getHealth(), c1.getMana());
            FightingScene p2 = new FightingScene(Villain.getName(), v1.getATK(), v1.getHealth(), v1.getMana());
            System.out.println("\n##### FIGHT "+match+" BEGIN! #####");
            //Algoritma bertarung antara hero dan villain
            while (p1.getLifePoint() > 0 && p2.getLifePoint() > 0) {//Pertarungan terus terjadi sampai nyawa salah satu hero / villain dibawah 0.

                d1.statusPlayer(p1,p2);
                d1.dialogFightingHero(p1);
                button = input.nextInt();
                Dialog.setChoice(button);

                if(p1.getMana()<25){
                    d1.figthing1(p1,p2);
                }
                else{
                    d1.figthing12(p1,p2);
                }

                if (p2.getLifePoint() <= 0) {//Untuk menghindari villain masih menyerang jika nyawanya sudah 0
                    break;
                }

                System.out.println("\nEnemy Turn to Move: ");
                Dialog.wait(4000);
                if(p2.getMana()<25){
                    d1.figthing2(p1,p2);
                }
                else{
                    d1.figthing22(p1,p2);
                }

                if (p1.getLifePoint() <= 0) {//Menghindari kita utk menyerang jika nyawa kita sudah 0
                    break;
                }
                else{
                    Dialog.wait(4000);
                }
            }

            input.nextLine();
            //MENENTUKAN PEMENANG (3 KONDISI)
            if (p1.getLifePoint() < p2.getLifePoint()) {
                System.out.println("\nYOU LOSE!\nWINNER: " + p2.getName() + " :(");
                System.out.println("Ingin mengulangi?(Y/N)");
                String retry = input.nextLine();
                if(retry.equals("Y")||retry.equals("y")){//Mengulang pertandingan
                }
                else if(retry.equals("N") || retry.equals("n")){//Menghentikan pertandingan
                    break; //Menggunakan break utk menghentikan proses WHILE
                }

            } else if (p1.getLifePoint() > p2.getLifePoint()) {
                System.out.println("\nWINNER:" + p1.getName() + "(YOU)!");
                if(t2.getVillainOrder()==t2.totalVillain()-1){
                    break;
                }
                System.out.println("Lanjut match selanjutnya?(Y/N)");
                String retry = input.nextLine();
                if(retry.equals("Y")||retry.equals("y")){//Melanjutkan pertandingan melawan musuh ke-2 sampai seterusnya
                    t2.setOrder(); //Mengganti nama, dan menambah atk dan hp untuk VILLAIN
                    match++;
                }
                else if(retry.equals("N") || retry.equals("n")){
                    break;
                }
            } else {
                System.out.println("\nDRAW! NO WINNER");
                System.out.println("Ingin mengulangi?(Y/N)");
                String retry = input.nextLine();
                if(retry.equals("Y")||retry.equals("y")){

                }
                else if(retry.equals("N") || retry.equals("n")){
                    break;
                }
            }

        }
        //PENUTUP
        input.close();
        System.out.println("\nThanks for Playing!");

    }


}



