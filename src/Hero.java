public class Hero extends Fighter {
    private int baseATK;
    private int baseHealth;
    private int baseMana;

    Hero(){}
    Hero(int role){
        if(role == 1){
            baseATK = 5;
            baseHealth = 100;
            baseMana = 100;
        }else if (role == 2){
            baseATK = 10;
            baseHealth = 80;
            baseMana = 125;
        }
    }

    @Override
    public int getHealth(){
        return baseHealth;
    };

    @Override
    public void setHealth(int Health){
        baseHealth = Health;
    };

    @Override
    public void setMana(int Mana){
        baseMana = Mana;
    };

    @Override
    public int getMana(){
       return baseMana;
    };

    @Override
    public int getATK(){
        return baseATK;
    }

    @Override
    public void setATK(int ATK) {
        baseATK=ATK;
    }



}
