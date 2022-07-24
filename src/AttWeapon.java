public class AttWeapon implements Weapon {
    private static String weaponName;
    private int ATK;
    private int Health;
    private int Mana;

    public void chooseWeapon(int choice){
        if(choice==1){
            System.out.println("\nChoose Your Weapon : ");
            System.out.println("1.  Nama   : Sukuna Sabukyo Bakufu\n\tATK    : 10\n\tHealth : 10\n\tMana   : 25");
            System.out.println("2.  Nama   : Cursed Daimyo Blade\n\tATK    : 15\n\tHealth : 0\n\tMana   : 25");

        }
        else if(choice==2){
            System.out.println("\nChoose Your Weapon : ");
            System.out.println("1.  Nama   : Daredevil\n\tATK    : 15\n\tHealth : 10\n\tMana   : 25");
            System.out.println("2.  Nama   : Mariposa\n\tATK    : 25\n\tHealth : 5\n\tMana   : 0");

        }
        System.out.println("3.  Kembali");
    }
    public void setWeapon(int choice, int name){
        if(choice==1){
            if (name==1){
                ATK=10;
                Health=10;
                Mana=25;
                weaponName ="Sukuna Sabukyo Bakufu";
            }
            else if(name==2){
                ATK=15;
                Health=0;
                Mana=25;
                weaponName ="Cursed Daimyo Blade";
            }
        }
        if (choice==2){
            if (name==1){
                ATK=15;
                Health=10;
                Mana=25;
                weaponName ="DareDevil";
            }
            else if(name==2){
                ATK=25;
                Health=5;
                Mana=0;
                weaponName ="Mariposa";
            }
        }
    }

    @Override
    public int getATK() {
        return ATK;
    }

    @Override
    public void setATK(int ATK) {
       this.ATK = ATK;
    }

    @Override
    public int getMana() {
        return Mana;
    }

    @Override
    public void setMana(int Mana) {
        this.Mana = Mana;
    }

    @Override
    public int getHealth() {
        return Health;
    }

    @Override
    public void setHealth(int Health) {
        this.Health = Health;
    }

    public static String getWeaponName() {
        return weaponName;
    }
}
