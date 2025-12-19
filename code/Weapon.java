package code;
public class Weapon {
    // initialize arrays for random name generation
    private String[] adjectives = {
        "Better", "Careful", "Clever", "Easy", "Famous", "Gifted", "Helpful","Important", "Inexpensive", "Mushy", "Odd", "Powerful", "Rich", "Shy","Tender", "Uninterested", "Vast", "Wrong", "Broad", "Chubby", "Crooked","Curved", "Deep", "Flat", "High", "Hollow", "Low", "Narrow", "Round","Shallow", "Skinny", "Square", "Steep", "Straight", "Wide", "Big","Colossal", "Fat", "Gigantic", "Great", "Huge", "Immense", "Large",    "Mammoth", "Massive", "Petite", "Puny", "Scrawny", "Tall", "Teeny", "Tiny"
    };
    private String[] weapons = {
        "Sword", "Dagger", "Knive", "Axe", "Mace", "War Hammer", "Flail","Quarterstaff", "Spear", "Pike", "Halberd", "Glaive", "Bill", "Lance","Longbow", "Short Bow", "Crossbow", "Sling", "Javelin", "Hand Cannon","Trebuchet", "Catapult", "Ballista", "Battering Ram"
    };
    private String[] verbs = {
        "Watering", "Cataloging", "Hunting", "Wanting", "Holding", "Taping","Integrating", "Worrying", "Loving", "Spending", "Fitting", "Bating","Risking", "Normalizing", "Restructuring", "Costing", "Programming","Touching", "Towing", "Altering", "Marketing", "Yelling", "Crushing","Beholding", "Agreeing", "Fencing", "Sparkling", "Wiping", "Sparking","Slaying", "Copying", "Melting"
    };
    private String name;
    private int damage;

    /**
     * Constructor for Weapon class
     * @param theDamage damage assigned to the weapon
     */
    public Weapon(int theDamage) {
        // generates a name of format: [adjective] [weapon] of [verb]
        name = adjectives[(int)(Math.random()* adjectives.length)] + " " + weapons[(int)(Math.random() * weapons.length)] + " of " + verbs[(int)(Math.random() * verbs.length)];
        damage = theDamage;
    }

    /**
     * Prints the weapon information
     */
    public void weaponInfo() {
        System.out.println("\tName: " + name);
        System.out.println("\tDamage: " + damage);
    }

    /**
     * Gets the name of the weapon
     * @return name of the weapon
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the damage of the weapon
     * @return damage of the weapon
     */
    public int getDamage(){
        return damage;
    }
    
    /**
     * Sets the damage of the weapon
     * @param theDamage new damage value for the weapon
     */
    public void setDamage(int theDamage){
        damage = theDamage;
    }
}