public class Player {
    private int position;
    private String name;
    private int health;

    public Player(String name) {
        this.position = 0;
        this.name= name;
        this.health = 100;
    }
    public int getPosition() {
        return this.position;
    }
    public void setPosition(int position) {
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public int getPlayerHealth() {
        return this.health;
    }
    public String getPlayerInfo() {
        return "Name: "+name+" Health: "+health+" Position: ";
    }
}
