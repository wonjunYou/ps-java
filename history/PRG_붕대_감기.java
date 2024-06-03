package history;

public class PRG_붕대_감기 {
    class Character {
        private int maxHealth;
        private int health;

        public Character(int health) {
            this.health = health;
            this.maxHealth = health;
        }

        public void decreaseHealth(int value) {
            this.health = health - value;
        }

        public void increaseHealth(int value) {
            this.health = Math.min(value + health, maxHealth);
        }

        public boolean checkAlive() {
            return health > 0;
        }

        public int getCurrentHealth() {
            return this.health;
        }
    }

    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];

        int attackIndex = 0;
        int bandageTime = 0;

        Character character = new Character(health);

        for (int i = 0; i < attacks[attacks.length - 1][0] + 1; i++) {
            bandageTime += 1;
            if (attacks[attackIndex][0] == i) {
                character.decreaseHealth(attacks[attackIndex][1]);
                bandageTime = 0;

                if (!character.checkAlive()) {
                    return -1;
                }

                attackIndex += 1;
            } else if (bandageTime == t) {
                character.increaseHealth(x + y);
                bandageTime = 0;
            } else {
                character.increaseHealth(x);
            }
        }

        return character.health;
    }
}
