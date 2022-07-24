public class Chara extends Hero {
    private String weaponName;
    private static String charaName;
    private static int ATK;
    private int Health;
    private int Mana;

    Chara(){}
    Chara(String charaName, int role, AttWeapon AW){
        super(role);
        Chara.charaName = charaName;
        this.weaponName = AttWeapon.getWeaponName();
        Chara.ATK += + super.getATK() + AW.getATK();
        this.Health += + super.getHealth() + AW.getHealth();
        this.Mana += + super.getMana() + AW.getMana();
    }
    public void setCharacter(int choice){
        if (choice==1){

            System.out.println("\nChoose Your Character : ");
            System.out.println("1)  Name    : Joe (Petarung tangan kosong yang sangat cepat)");
            System.out.println("2)  Name    : Biden (Mantan petinju yang tidak memiliki keluarga");

        }
        else if(choice==2){
            System.out.println("\nChoose Your Character : ");
            System.out.println("1)  Name    : Zydan (Seorang mahasiswa upn yang suka menembak perempuan)");
            System.out.println("2)  Name    : Bagas (Seorang ahli tembak yang suka makan nasi)");
        }
        System.out.println("3)  Kembali");
    }

    public int getHealth() {
        return Health;
    }

    public int getMana() {
        return Mana;
    }

    public static void setATKChar(int ATK) {
        Chara.ATK = ATK;
    }

    public int getATK() {
        return ATK;
    }

    public static String getCharaName(){
        return charaName;
    }

    public void setCharaName(int choice2, int name) {
        if (choice2==1){
            if(name==1){
                Chara.charaName ="Joe";
            }
            else if(name==2){
                Chara.charaName ="Biden";
            }
        }
        else if(choice2==2){
            if(name==1){
                Chara.charaName ="Zydan";
            }
            else if(name==2){
                Chara.charaName ="Bagas";
            }
        }
    }

    public String getWeaponName() {
        return weaponName;
    }



    public String toString(){
        return "Name      : " + getCharaName() +
               "\nATK       : " + getATK() +
               "\nHealth    : " + getHealth() +
               "\nMana      : " + getMana() +
               "\nWeapon    : " + getWeaponName();
    }
}
