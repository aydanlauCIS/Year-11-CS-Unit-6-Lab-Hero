public class Hero {
    private final String name;
    private int hitPoints;

    public Hero(String name) {
        this.name = name;
        this.hitPoints = 100;
    }

    public String getName() {
        return this.name;
    }

    public int getHitPoints() {
        return this.hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public String toString() {
        return "Hero{name='" + this.name + "', hitPoints=" + this.hitPoints + "}";
    }

    public void attack(Hero opponent) {
        double rand = Math.random();

        if (rand < 0.5) {
            opponent.setHitPoints(opponent.getHitPoints() - 10);
        } else {
            this.hitPoints -= 10;
        }
    }

    public void senzuBean() {
        this.hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent) {
        while (true) {
            if (this.hitPoints > 0 && opponent.getHitPoints() > 0) {
                this.attack(opponent);
            } else {
                break;
            }

            if (this.hitPoints > 0 && opponent.getHitPoints() > 0) {
                opponent.attack(this);
            } else {
                break;
            }
        }
    }

    public String fightUntilTheDeath(Hero opponent) {
        this.senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);

        return this.name + ": " + this.hitPoints + "\t" + opponent.getName() + ": " + opponent.getHitPoints();
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n) {
        int[] wins = {0, 0};
        for (int i = 0; i < n; i++) {
            fightUntilTheDeath(opponent);

            if (this.hitPoints > 0) {
                wins[0]++;
            } else {
                wins[1]++;
            }

            this.senzuBean();
            opponent.senzuBean();
        }

        return wins;
    }

    String nFightsToTheDeath(Hero opponent, int n) {
        int[] wins = nFightsToTheDeathHelper(opponent, n);

        String finalMessage;
        if (wins[0] == wins[1]) {
            finalMessage = "OMG! It was actually a draw!";
        } else if (wins[0] > wins[1]) {
            finalMessage = this.name + " wins!";
        } else {
            finalMessage = opponent.getName() + " wins!";
        }

        return this.name + ": " + wins[0] + " wins\n" + opponent.getName() + ": " + wins[1] + " wins\n" + finalMessage;
    }

    private void waitOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void dramaticFightToTheDeath(Hero opponent) {
        this.senzuBean();
        opponent.senzuBean();

        while (true) {
            if (opponent.getHitPoints() > 0 && this.hitPoints > 0) {
                this.attack(opponent);
                this.waitOneSecond();
                System.out.println(this.name + ": " + this.hitPoints + "\t" + opponent.getName() + ": " + opponent.getHitPoints());
            } else {
                break;
            }

            if (opponent.getHitPoints() > 0 && this.hitPoints > 0) {
                opponent.attack(this);
                this.waitOneSecond();
                System.out.println(this.name + ": " + this.hitPoints + "\t" + opponent.getName() + ": " + opponent.getHitPoints());
            } else {
                break;
            }
        }

        if (this.hitPoints > 0) {
            System.out.println(this.name + " wins!");
        } else {
            System.out.println(opponent.getName() + " wins!");
        }

        this.senzuBean();
        opponent.senzuBean();
    }
}
