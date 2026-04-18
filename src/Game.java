import java.util.Scanner;
import java.util.Random;
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

    private void combat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which enemy?");
        String enemy_name = scanner.nextLine();
        boolean combat_state = true;
        if (map.checkIfEnemyExistsInCurrentRoom(player.getPosition(), enemy_name)) {
            Enemy enemy = map.getEnemy(player.getPosition(), enemy_name);
            //Battle logic
            System.out.println("Battle begins.");
            /*Random generator = new Random();
            boolean randomStart = generator.nextBoolean(); --incase I would change it in the future to randomize who starts in fight */
            while (combat_state) {
                int damage_dealt = enemy.getHealth();
                enemy.setHealth(enemy.getHealth() - player.getDamage());
                damage_dealt -= enemy.getHealth();
                System.out.println(enemy.getHealth());
                System.out.printf("You did %d damage!%n",damage_dealt);
                if (enemy.getHealth() == 0) {
                    // remove all references for enemy
                    System.out.printf("You successfully defeated %s%n",enemy.getName());
                    enemiesManager.getHashMapWithEnemies().remove(enemy.getId());
                    enemiesManager.getEnemies().remove(enemy);
                    map.findRoomByID(player.getPosition()).getEnemies().remove(enemy);
                    combat_state = false;
                }
                player.setHealth(player.getHealth() - enemy.getDamage());
                if (player.getHealth()<=0) {
                System.out.println("YOU LOST THE GAME");
                gameLoop = false;
                }
            }

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
        Scanner scanner = new Scanner(System.in);
        enemies();
        items();
        boolean enemiesPlayerState = false;
        boolean itemsPlayerState = false;
        while(true) {
            System.out.println("Do you want to fight any enemies(Y/N)");
            String state = scanner.nextLine();
            if (state.equals("Y")) {
                combat();
                break;
            }
            else if (state.equals("N")) {
                break;
            }
        }
        while(true) {
            System.out.println("Do you want to use any items(Y/N)");
            String state = scanner.nextLine();
            if (state.equals("Y")) {
                itemsPlayerState = true;
                break;
            } else if (state.equals("N")) {
                break;
            }
        }
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