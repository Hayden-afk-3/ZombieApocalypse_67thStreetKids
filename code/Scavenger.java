package code;
class Scavenger extends Person{
    private  String[] activityListClass = {"Scavenge Bass Pro Shops"};
    private  String[] activityListExplainClass = {"High chance to find good loot. High chance of finding zombies."};
    public Scavenger(String theName) {
        super(theName);
    }
    @Override
    public String[] getActivityListClass() {
        return activityListClass;
    }
    @Override
    public String[] getActivityListExplainClass() {
        return activityListExplainClass;
    }
    public void bassProShop(){
        if(this.getEnergy() < 15){
            System.out.println("Not enough energy to go to Bass Pro Shop!");
            return;
        }
        this.setEnergy(this.getEnergy()-15);
        // Scavenger-specific bassProShop method
        // Going to Bass Pro Shop restores more health but costs energy
        int options = (int)(Math.random()*3);
        switch (options) {
            case 0:
                this.setHealth(this.getHealth() + 15);
                System.out.println("You went to Bass Pro Shop and found food! Energy -15, Health + 15.");
                break;
            case 1:
                System.out.println("You went to Bass Pro shop and found a new weapon!");
                int newDamage = (int)(Math.random()*7+1);
                System.out.println("New weapon damage: " + newDamage);
                System.out.println("Old weapon damage: " + this.getWeapon().getDamage());
                System.out.println("Do you want to equip the new weapon? (1 for yes, 2 for no)");
                int newWeaponChoice = input.nextInt();
                if (newWeaponChoice == 1){
                    System.out.println("You have equipped the new weapon.");
                    this.setWeapon(new Weapon(newDamage));
                }
                else {
                    System.out.println("You decided to keep your old weapon.");
                    break;
                }
            case 2:
                System.out.println("You went to Bass Pro Shop and found nothing. Energy -15.");
                break;
            }
        }
}