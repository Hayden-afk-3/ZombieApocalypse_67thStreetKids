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
    private int adjectiveChoice;
    private int weaponChoice;
    private int verbChoice;

    /**
     * Constructor for Weapon class
     * @param theDamage damage assigned to the weapon
     */
    public Weapon(int theDamage) {
        // generates a name of format: [adjective] [weapon] of [verb]
        adjectiveChoice = (int)(Math.random()*(adjectives.length+1));
        weaponChoice = (int)(Math.random()*(weapons.length+1));
        verbChoice = (int)(Math.random()*(verbs.length+1));
        name = adjectives[adjectiveChoice] + " " + weapons[weaponChoice] + " of " + verbs[verbChoice];
        damage = theDamage;
    }

    /**
     * Detailed constructor for Weapon class, used for loading saved games
     * @param adjectiveChoice index of adjective in adjectives array
     * @param weaponChoice index of weapon in weapons array
     * @param verbChoice index of verb in verbs array
     * @param theDamage damage assigned to the weapon
     */
    public Weapon(int adjectiveChoice, int weaponChoice, int verbChoice, int theDamage) {
        // generates a name of format: [adjective] [weapon] of [verb]
        this.adjectiveChoice = adjectiveChoice;
        this.weaponChoice = weaponChoice;
        this.verbChoice = verbChoice;
        name = adjectives[adjectiveChoice] + " " + weapons[weaponChoice] + " of " + verbs[verbChoice];
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

    /**
     * Encodes the weapon name into a string of format adjective_weapon_verb
     * @return encoded weapon name
     */
    public String encodeWeaponName(){
        return adjectiveChoice + "_" + weaponChoice + "_" + verbChoice;
    }
}