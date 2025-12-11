package code;
class Warrior extends Person{
    public Warrior(String theName) {
        super(theName);
        public void hunt(){
            if(this.getEnergy() < 20){
                System.out.println("Not enough energy to hunt!");
                return;
            }
            this.setEnergy(this.getEnergy()-20);
            // Warrior-specific hunt method
            // Hunting restores health but costs more energy
            int healthGain = (int)(Math.random()*20);
            if (this.getEnergy() >= huntEnergyCost) {
                this.setHealth(this.getHealth() + healthGain);
                this.setEnergy(this.getEnergy() - huntEnergyCost);
                System.out.println("You went hunting! Energy -" + huntEnergyCost + ", Health +" + healthGain + ".");
            } 
        }
    }
    
}