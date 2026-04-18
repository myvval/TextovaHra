public class Player {
    private int position;
    private String name;
    private int health;
    private int armor; //adds to health can only nulify attack not increase health
    private int damage;

    public Player(String name) {
        this.position = 0;
        this.name= name;
        this.health = 100;
        this.armor = 0;
        this.damage = 10;
    }
    public int getPosition() {
        return this.position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public int getDamage() {return this.damage;}
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public int getHealth() {
        return this.health;
    }
    public void setHealth(int health) {if (health>0) {this.health = health;}}
    public String getPlayerInfo() {
        return "Name: "+name+" Health: "+health+" Position: ";
    }



}
