package code;
public class Weapon {
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

    public Weapon(int theDamage) {
        name = adjectives[(int)(Math.random()* adjectives.length)] + " " + weapons[(int)(Math.random() * weapons.length)] + " of " + verbs[(int)(Math.random() * verbs.length)];
        damage = theDamage;
    }
    public String getName() {
        return name;
    }
    public int getDamage(){
        return damage;
    }
}