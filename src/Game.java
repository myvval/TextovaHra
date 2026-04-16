import java.util.Scanner;

public class Game {
    private boolean gameLoop = true;


    public void startGame() {
        // creates managers for world, enemies, items
        WorldMap map = new WorldMap();
        ItemsManager itemManager = new ItemsManager();
        EnemiesManager enemies = new EnemiesManager();

        // loads enemies, map, items
        map.loadMap();
        map.connectRooms();
        itemManager.loadItems();
        enemies.loadEnemies();

        // assign enemies, items to rooms
        for(Item item:itemManager.getItems()) map.returnListOfRoom().get(item.getLocation()).addItem(item);
        for(Enemy enemy:enemies.getEnemies()) map.returnListOfRoom().get(enemy.getLocation()).addEnemy(enemy);
        System.out.println("START OF THE GAME");
    }
    public void game() {}


    public void setPlayerName() {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player("NO NAME");
        String input;
        do {
            System.out.println("WHAT YOUR NAME SHOULD BE?");
            input = scanner.nextLine();
        } while (input.isBlank());
        player.setName(input);
    }
    public void setupGame() {
        WorldMap map = new WorldMap();
        //map.generateTestMap();
        map.loadMap();
        map.connectRooms();
        //map.showList();
        Player player = new Player("NO NAME");
        Scanner scanner = new Scanner(System.in);
        System.out.println("START OF THE GAME");
        System.out.println("WHAT YOUR NAME SHOULD BE?");
        player.setName(scanner.nextLine());
        System.out.println(player.getPlayerInfo() + map.currentRoomString(player.getPosition()));
        System.out.println("ROOMS ARROUND:");
        map.currentRoomString(player.getPosition());
        map.getRoomsAroundString(player.getPosition());
        System.out.println("\nIN WHICH ROOM YOU WANT TO GO? (North/South/East/West)");
        String nextRoom = scanner.nextLine();
        //System.out.println(nextRoom);
        player.setPosition(map.changePlayerRoom(player.getPosition(), nextRoom));
    }

}
