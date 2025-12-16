package code;
class Medic extends Person{
    private  String[] activityListClass = {"Heal Self"};
    private  String[] activityListExplainClass = {"Regain Health"};
    public Medic(String theName) {
        super(theName);
    }
    public void healSelf() {
        int healAmount = (int)(Math.random()*(6)+3);
        if (healAmount+this.getHealth()>100){
            healAmount=100-this.getHealth();
        }
        System.out.println(this.getName()+" starts to heal themselves.");
        System.out.println("\tHealth: " + this.getHealth() + " +" + healAmount + " --> " + (this.getHealth()+healAmount));
        this.setHealth(this.getHealth()+healAmount);
    }
    @Override
    public String[] getActivityListClass() {
        return activityListClass;
    }
    @Override
    public String[] getActivityListExplainClass() {
        return activityListExplainClass;
    }
    @Override
    public void parseActivity(int choice) {
        switch (choice) {
            case 1:
                this.scavengeWalmart();
                break;
            case 2:
                this.takeANap();
                break;
            case 3:
                this.healSelf();
                break;
        }
    }
}