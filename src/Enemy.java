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
    public String getName(){return this.name;}
    public int getId(){return this.id;}
}
