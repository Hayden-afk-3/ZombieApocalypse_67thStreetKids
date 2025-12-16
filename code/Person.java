package code;

abstract class Person {
    private String name;
    private int energy;
    private int health;
    private int satiation;
    private Weapon weapon;
    public static String[] activityList = {"Scavenge Walmart","Take a Nap"};
    public static String[] activityListExplain = {"Attempt to loot. Possibility of finding zombies.","Regain Energy"};

    public abstract String[] getActivityListClass();
    public abstract String[] getActivityListExplainClass();
    public abstract void parseActivity(int choice);

    public Person(String theName) {
        name = theName;
        energy = (int)(Math.random()*(99-60+1)+60); // 60-99
        health = (int)(Math.random()*(89-70+1)+70); // 70-89
        satiation = (int)(Math.random()*(69-40+1)+40); // 40-69
    }
    public void personInfo() {
        System.out.println("Player Information:");
        System.out.println("\tName: " + this.getName());
        System.out.println("\tEnergy: " + this.getEnergy());
        System.out.println("\tHealth: " + this.getHealth());
        System.out.println("\tSatiation: " + this.getSatiation());
    }
    public void personStatus() {
        System.out.println("Player Status:");
        System.out.println("\tEnergy: " + this.getEnergy());
        System.out.println("\tHealth: " + this.getHealth());
        System.out.println("\tSatiation: " + this.getSatiation());
    }
    public void setWeapon(Weapon newWeapon){
        this.weapon = newWeapon;
    }
    public Weapon getWeapon(){
        return this.weapon;
    }
    public void weaponInfo() {
        System.out.println("Weapon Information:");
        System.out.println("\tName: " + this.weapon.getName());
        System.out.println("\tDamage: " + this.weapon.getDamage());
    }
    public String getName() {
        return name;
    }
    public int getEnergy(){
        return energy;
    }
    public int getHealth(){
        return health;
    }
    public int getSatiation(){
        return satiation;
    }
    public void setHealth(int newHealth){
        this.health = newHealth;
    }
    public void setEnergy(int newEnergy){
        this.energy = newEnergy;
    }
    public void sleep(){
        this.energy = (int)(Math.random()*((this.energy/2.0+49)-this.energy+1)+this.energy);
        this.health = (int)(Math.random()*(-0.0109*(this.health-100)*(this.health-100)+99-this.health+1)+this.health);
        this.satiation = (int)(Math.random()*(0.85*(this.satiation-10)-this.satiation+1)+this.satiation);
    }
    public void setSatiation(int newSatiation){
        this.satiation = newSatiation;
    }
    public void scavengeWalmart(){
    }
    public void takeANap(){
    }
    public void printActivityList(){
        int i = 1;
        System.out.println("Here are your activity options:");
        for (; i <= activityList.length; i++){
            System.out.println("\t" + i + ": " + activityList[i-1]);
            System.out.println("\t\t" + activityListExplain[i-1]);
        }
        for (; i <= this.getActivityListClass().length + activityList.length; i++){
            System.out.println("\t" + i + ": " + this.getActivityListClass()[i-1-activityList.length]);
            System.out.println("\t\t" + this.getActivityListExplainClass()[i-1-activityList.length]);
        }
    }
    public void zombieFight(int day) {
        System.out.println("You ran into a zombie!");
        Zombie zombie = new Zombie((int)(5*Math.log(day)+4),(int)(4*Math.log(day)+2));
        while (zombie.getHealth()>0){
            int zombieAttack = (int)(zombie.getDamage()*(0.5*Math.random()+0.75));
            if (this.health-zombieAttack<0){
                break;
            }
            System.out.println("Zombie attacks!\n\t"+this.name+"'s Health: "+this.health+" -" + zombieAttack);
            this.health -= zombieAttack;
            int playerAttack = (int)(this.weapon.getDamage()*(0.5*Math.random()+0.75));
            System.out.println("Player attacks!\n\t"+this.name+"'s Health: "+this.health+" -" + playerAttack);
            zombie.setHealth(zombie.getHealth()-playerAttack);
        }
    }
}