public class Enemy {
    private int id;
    private String name;
    private int health;
    private int damage;
    private int location;
    public Enemy(int id,String name,int health,int damage,int location) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.location = location;
    }
    public int getLocation(){
        return this.location;
    }
    public int getHealth(){return this.health;}
    public void setHealth(int health) {
        this.health = health;
        if (this.health < 0) {
            this.health = 0;
        }
    }
    public int getDamage() {return this.damage;}
    public String getName(){return this.name;}
    public int getId(){return this.id;}
}
