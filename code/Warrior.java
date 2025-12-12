package code;
class Warrior extends Person{
    private String[] activityListClass = {"Hunt for Food"};
    public Warrior(String theName) {
        super(theName);
    }
    @Override
    public String[] getActivityListClass() {
        return activityListClass;
    }
}