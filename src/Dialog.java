import java.util.Random;

public class Dialog {
    Random rand2 = new Random();

    private static int pilihan;

    public void statusPlayer(FightingScene p1, FightingScene p2) {
        System.out.println("\n-------------------------");
        System.out.println("Your HP   : " + p1.getLifePoint() + "/" + p1.getFullHp() + "\nYour Mana : " + p1.getMana());
        System.out.println("Enemy HP  : " + p2.getLifePoint() + "/" + p2.getFullHp() + "\nEnemy Mana: " + p2.getMana());
        System.out.println("-------------------------");
    }

    public void dialogFightingHero(FightingScene p1) {
        System.out.println("\nYour Turn to Move: ");
        if (p1.getMana() < 25) {
            if (p1.getAmount() == 0 || p1.getLifePoint() >= 60) {
                System.out.println("1) Attack\n");
                System.out.print("Choice: ");
            } else if (p1.getAmount() > 0 || p1.getLifePoint() < 60) {
                System.out.println("1) Attack\n2) Heal");
                System.out.print("Choice: ");
            }
        } else {
            if (p1.getAmount() == 0 || p1.getLifePoint() >= 60) {
                System.out.println("1) Attack\n2) Skill");
                System.out.print("Choice: ");
            } else if (p1.getAmount() > 0 || p1.getLifePoint() < 60) {
                System.out.println("1) Attack\n2) Skill \n3) Heal");
                System.out.print("Choice: ");
            }
        }
    }

    /*
     * public void dialogFightingVillain(FightingScene p2){
     * System.out.println("\nEnemy Turn to Move: ");
     * 
     * if(p2.getBanyak() == 0 || p2.getLifePoint() >= 60){
     * System.out.println("1) Attack"); System.out.print("Choice: ");
     * 
     * } else if(p2.getBanyak() > 0 || p2.getLifePoint() < 60){
     * System.out.println("1) Attack\n2) Heal"); System.out.print("Choice: "); } }
     */

    public void figthing1(FightingScene p1, FightingScene p2) {
        if (p1.getAmount() == 0 || p1.getLifePoint() >= 60) {
            if (pilihan == 1) {
                p1.hit(p2);
                System.out.println(p1.getName() + " Start beating the shit out of " + p2.getName());
                System.out.println(p2.getName() + " HP: " + p2.getLifePoint() + "/" + p2.getFullHp());
            } else {
                System.out.println("Wrong button!");
            }

        }
        /*
         * switch (pilihan){ case 1 -> { p1.pukul(p2); System.out.println(p1.getName() +
         * " Start beating the shit out of " + p2.getName());
         * System.out.println(p2.getName() + " HP: " + p2.getLifePoint() + "/" +
         * p2.getFullHp()); } case 2 ->{ p1.skill(p2); System.out.println(p1.getName() +
         * " Start using his special move againts " + p2.getName());
         * System.out.println(p2.getName() + " HP: " + p2.getLifePoint() + "/" +
         * p2.getFullHp()); } default -> System.out.println("Wrong button!"); } }
         */
        else if (p1.getAmount() > 0 || p1.getLifePoint() < 60) {
            if (pilihan == 1) {
                p1.hit(p2);
                System.out.println(p1.getName() + " Start beating the shit out of " + p2.getName());
                System.out.println(p2.getName() + " HP: " + p2.getLifePoint() + "/" + p2.getFullHp());
            } else if (pilihan == 2) {
                p1.heal();
                System.out.println(p1.getName() + " started to healing!");
                System.out.println(p1.getName() + " HP: " + p1.getLifePoint() + "/" + p1.getFullHp());
            }

            /*
             * switch (pilihan) { case 1 -> { p1.pukul(p2); System.out.println(p1.getName()
             * + " Start beating the shit out of " + p2.getName());
             * System.out.println(p2.getName() + " HP: " + p2.getLifePoint() + "/" +
             * p2.getFullHp()); } case 2 ->{ p1.skill(p2); System.out.println(p1.getName() +
             * " Start using his special move againts " + p2.getName());
             * System.out.println(p2.getName() + " HP: " + p2.getLifePoint() + "/" +
             * p2.getFullHp()); } case 3 -> { p1.heal(); System.out.println(p1.getName() +
             * " started to healing!"); System.out.println(p1.getName() + " HP: " +
             * p1.getLifePoint() + "/" + p1.getFullHp()); } default ->
             * System.out.println("Wrong button!"); }
             */
        }

    }

    public void figthing12(FightingScene p1, FightingScene p2) {
        if (p1.getAmount() == 0 || p1.getLifePoint() >= 60) {
            switch (pilihan) {
                case 1 -> {
                    p1.hit(p2);
                    System.out.println(p1.getName() + " Start beating the shit out of " + p2.getName());
                    System.out.println(p2.getName() + " HP: " + p2.getLifePoint() + "/" + p2.getFullHp());
                }
                case 2 -> {
                    p1.skill(p2);
                    System.out.println(p1.getName() + " Start using his special move againts " + p2.getName());
                    System.out.println(p2.getName() + " HP: " + p2.getLifePoint() + "/" + p2.getFullHp());
                }
                default -> System.out.println("Wrong button!");
            }
        }

        else if (p1.getAmount() > 0 || p1.getLifePoint() < 60) {
            switch (pilihan) {
                case 1 -> {
                    p1.hit(p2);
                    System.out.println(p1.getName() + " Start beating the shit out of " + p2.getName());
                    System.out.println(p2.getName() + " HP: " + p2.getLifePoint() + "/" + p2.getFullHp());
                }
                case 2 -> {
                    p1.skill(p2);
                    System.out.println(p1.getName() + " Start using his special move againts " + p2.getName());
                    System.out.println(p2.getName() + " HP: " + p2.getLifePoint() + "/" + p2.getFullHp());
                }
                case 3 -> {
                    p1.heal();
                    System.out.println(p1.getName() + " started to healing!");
                    System.out.println(p1.getName() + " HP: " + p1.getLifePoint() + "/" + p1.getFullHp());
                }
                default -> System.out.println("Wrong button!");
            }
        }

    }

    public void figthing2(FightingScene p1, FightingScene p2) {
        if (p2.getAmount() == 0 || p2.getLifePoint() >= 60) {
            p2.hit(p1);
            System.out.println(p2.getName() + " Start beating " + p1.getName() + "'s ass and meat");
            System.out.println(p1.getName() + " HP: " + p1.getLifePoint() + "/" + p1.getFullHp());

        } else if (p2.getAmount() > 0 || p2.getLifePoint() < 60) {
            pilihan = rand2.nextInt(2);
            switch (pilihan) {
                case 0 -> {
                    p2.hit(p1);
                    System.out.println(p2.getName() + " Start beating " + p1.getName() + " ass");
                    System.out.println(p1.getName() + " HP: " + p1.getLifePoint() + "/" + p1.getFullHp());

                }
                case 1 -> {
                    p2.heal();
                    System.out.println(p2.getName() + " started to healing!");
                    System.out.println(p2.getName() + " HP: " + p2.getLifePoint() + "/" + p2.getFullHp());

                }
                default -> System.out.println("Wrong button!");
            }
        }

    }

    public void figthing22(FightingScene p1, FightingScene p2) {
        if (p2.getAmount() == 0 || p2.getLifePoint() >= 60) {
            pilihan = rand2.nextInt(2);
            switch (pilihan) {
                case 0 -> {
                    p2.hit(p1);
                    System.out.println(p2.getName() + " Start beating " + p1.getName() + " ass");
                    System.out.println(p1.getName() + " HP: " + p1.getLifePoint() + "/" + p1.getFullHp());
                }
                case 1 -> {
                    p2.skill(p1);
                    System.out.println(p2.getName() + " using his skill againts " + p1.getName());
                    System.out.println(p1.getName() + " HP: " + p1.getLifePoint() + "/" + p1.getFullHp());
                }
                default -> System.out.println("Wrong button!");
            }
        } else if (p2.getAmount() > 0 || p2.getLifePoint() < 60) {
            pilihan = rand2.nextInt(3);
            switch (pilihan) {
                case 0 -> {
                    p2.hit(p1);
                    System.out.println(p2.getName() + " Start beating " + p1.getName() + " ass");
                    System.out.println(p1.getName() + " HP: " + p1.getLifePoint() + "/" + p1.getFullHp());
                }
                case 1 -> {
                    p2.skill(p1);
                    System.out.println(p2.getName() + " using his skill againts " + p1.getName());
                    System.out.println(p1.getName() + " HP: " + p1.getLifePoint() + "/" + p1.getFullHp());
                }
                case 2 -> {
                    p2.heal();
                    System.out.println(p2.getName() + " started to healing!");
                    System.out.println(p2.getName() + " HP: " + p2.getLifePoint() + "/" + p2.getFullHp());
                }
                default -> System.out.println("Wrong button!");
            }
        }

    }

    public static void setChoice(int pilihan) {
        Dialog.pilihan = pilihan;
    }

    public static int getPilihan(){
        return pilihan;
    }

    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }



}
