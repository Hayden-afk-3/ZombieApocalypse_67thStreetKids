package code;
public class Person {
    private String name;
    /*
    * Constructor for objects of class Person
    * @param theName The name of the person
    */
    public Person(String theName) {
        name = theName;
        int energy = 100;
        int health = 100;
        int happiness = 100;
        System.out.println("Welcome " + name + " to the zombie apocalypse!");
    }

}
