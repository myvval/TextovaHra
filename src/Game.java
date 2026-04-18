import javax.crypto.EncryptedPrivateKeyInfo;
import java.util.Scanner;

public class Game {
    private boolean gameLoop = true;
    private WorldMap map;
    private ItemsManager itemsManager;
    private EnemiesManager enemiesManager;
    private Player player;

    public Game() {
        map = new WorldMap();
        itemsManager = new ItemsManager();
        enemiesManager = new EnemiesManager();
    }

    public void setupGame() {
        // loads enemies, map, items
        map.loadMap();
        map.connectRooms();
        itemsManager.loadItems();
        enemiesManager.loadEnemies();

        // assign enemies, items to rooms
        for (Item item : itemsManager.getItems()) map.returnListOfRoom().get(item.getLocation()).addItem(item);
        for (Enemy enemy : enemiesManager.getEnemies()) map.returnListOfRoom().get(enemy.getLocation()).addEnemy(enemy);
        System.out.println("START OF THE GAME");
    }

    public void game() {
    }

    private void enemies() {
        if (map.getNumberOfEnemies(player.getPosition()) > 0) { //check by instance of if its aggressive or passive
            System.out.println("ENEMIES IN THIS ROOM:");
            map.getEnemiesString(player.getPosition());
        }
    }

    private void items() {
        if (map.getNumberOfItemsInRoom(player.getPosition()) > 0) {
            System.out.println("ITEMS IN THIS ROOM:");
            map.getItemsString(player.getPosition());
        }
    }

    public void setPlayerName() {
        Scanner scanner = new Scanner(System.in);
        player = new Player("NO NAME");
        String input;
        do {
            System.out.println("WHAT YOUR NAME SHOULD BE?");
            input = scanner.nextLine();
        } while (input.isBlank());
        player.setName(input);
    }

    public void startGame() {
        System.out.println(player.getPlayerInfo() + map.currentRoomString(player.getPosition()));
        System.out.println("ROOMS ARROUND:");
        map.currentRoomString(player.getPosition());
        map.getRoomsAroundString(player.getPosition());
        System.out.println("\nIN WHICH ROOM YOU WANT TO GO? (North/South/East/West)");
        /*String nextRoom = scanner.nextLine();
        //System.out.println(nextRoom);
        player.setPosition(map.changePlayerRoom(player.getPosition(), nextRoom));*/
    }

    public void gameLoop() {
        Scanner scanner = new Scanner(System.in);/*
        enemies();
        items();
        boolean enemiesPlayerState = false;
        boolean itemsPlayerState = false;
        while(true) {
            String state = scanner.nextLine();
            System.out.println("Do you want to fight any enemies(Y/N)");
            if (state.equals("Y")) {
                enemiesPlayerState = true;
                break;
            } else if (state.equals("N")) {
                break;
            }
        }
        while(true) {
            String state = scanner.nextLine();
            System.out.println("Do you want to use any items(Y/N)");
            if (state.equals("Y")) {
                itemsPlayerState = true;
                break;
            } else if (state.equals("N")) {
                break;
            }
        }*/
        while (gameLoop) {
            System.out.println("Player info:");
            System.out.println(player.getPlayerInfo() + map.currentRoomString(player.getPosition()));
            System.out.println("ROOMS ARROUND:");
            map.currentRoomString(player.getPosition());
            map.getRoomsAroundString(player.getPosition());
            System.out.println("\nIN WHICH ROOM YOU WANT TO GO? (North/South/East/West)");
            String nextRoom = scanner.nextLine();
            player.setPosition(map.changePlayerRoom(player.getPosition(), nextRoom));
            if (player.getPosition() == 10) {
                System.out.println("YOU WON THE GAME");
                gameLoop = false;
            }
        }
    }
}