package code;
class Medic extends Person{
    private  String[] activityListClass = {"Heal Self"};
    public Medic(String theName) {
        super(theName);
    }
    public void heal() {
        int healAmount = (int)(Math.random()*11+5);
        if (healAmount+this.getHealth()>100){
            healAmount=100-this.getHealth();
            System.out.println("You have healed for " + healAmount + " health points. Your health is now full at 100.");
        } 
        else {
            this.setHealth(healAmount+this.getHealth());
            System.out.println("You have healed for " + healAmount + " health points. Your health is now " + (this.getHealth()+healAmount) + ".");
        }
    }

    @Override
    public String[] getActivityListClass() {
        return activityListClass;
    }
}