public class FightingScene {

    private String name;
    private int lifePoint,powerATK ,mana;
    private int amount =2;
    private final int fullHp;
    private final int fullMana;


    public FightingScene(String name, int powerATK, int lifePoint, int mana){
        this.name =name;
        this.powerATK=powerATK;
        this.lifePoint=lifePoint;
        this.mana=mana;
        this.fullHp=lifePoint;
        this.fullMana=mana;

    }

    public void hit(FightingScene karB){
        karB.lifePoint = karB.getLifePoint() - powerATK;
    }
    public void skill(FightingScene karB) {
        this.mana=mana-25;
        karB.lifePoint = karB.getLifePoint() - powerATK - 10;
    }
    public void heal(){
        this.amount = amount -1;
        this.lifePoint=lifePoint+10;
    }

    public int getAmount(){
        return amount;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLifePoint() {
        return Math.max(lifePoint, 0);
    }

    public int getMana() {
        return mana;
    }

    public int getFullHp() {
        return fullHp;
    }

    public int getPowerAtk(){
        return powerATK;
    }

    public int getFullMana() {
        return fullMana;
    }

    public void setLifePoint(int lifePoint){
        this.lifePoint = lifePoint;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }
        
}
