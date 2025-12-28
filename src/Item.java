public class Item {
    private int id;
    private String name;
    public String description;
    private String usage;
    private int location;
    private boolean canLeave;     // means if player can leave with item(put it in his backpack/inventory slots from now on backpack)
    private int damage;
    private int health;
    private int defense;

    public Item(int id,String name,String description,int location,boolean canLeave) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.canLeave = canLeave; //later rewind

    }
    public String getName(){return this.name;}
    public int getLocation() {return this.location;}
    public int getId(){return this.id;}
    public void setDamage(int number) {
        this.damage+=number;
    }
    public int getDamage() {
        return this.damage;
    }
    public void setHealth(int number) {
        this.health+=health;
    }
    public int getHealth() {
        return this.health;
    }
    public void setDefense(int number) {this.defense+=number;}
    public int getDefense() {return this.defense;}



}
