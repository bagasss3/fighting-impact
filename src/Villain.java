public class Villain extends Fighter {
    private static String name;
    private int ATK;
    private int health;
    private int mana;
    private static int villainOrder =0;
    static String[] villainName = {"Bilbo","Janus","Zenon"};
    int[] addHP = {0,10,15};
    int[] addATK = {0,5,10};
    Villain(){}
    Villain(String name, int order){
        Villain.name =name;
        this.ATK =20+addATK[order];
        this.health=105+addHP[order];
        this.mana=100;
    }

    public static void setName(int order) {
        Villain.name = villainName[order];
    }
    public void setUlangOrder(int i){
        this.villainOrder = i;
    }
    public void setOrder() {
        this.villainOrder = villainOrder +1;

    }

    public static int getVillainOrder() {
        return villainOrder;
    }

    public static String getName() {
        return name;
    }

    @Override
    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public int getATK() {
        return ATK;
    }

    public int getHealth() {
        return health;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public int totalVillain(){
        return villainName.length;
    }
    public String toString(){
        return "Name      : " + getName() +
                "\nATK       : " + getATK() +
                "\nHealth    : " + getHealth() +
                "\nMana      : " + getMana();
    }
}
