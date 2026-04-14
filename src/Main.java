//import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        /*creates managers for world, enemies, items*/
        WorldMap map = new WorldMap();
        ItemsManager itemManager = new ItemsManager();
        EnemiesManager enemies = new EnemiesManager();

        /*loads enemies, map, items*/
        map.loadMap();
        map.connectRooms();
        itemManager.loadItems();
        enemies.loadEnemies();

        /* assign enemies, items to rooms */
        for(Item item:itemManager.getItems()) map.returnListOfRoom().get(item.getLocation()).addItem(item);
        for(Enemy enemy:enemies.getEnemies()) map.returnListOfRoom().get(enemy.getLocation()).addEnemy(enemy);






        Player player = new Player("NO NAME");
        Scanner scanner = new Scanner(System.in);
        System.out.println("START OF THE GAME");
        System.out.println("WHAT YOUR NAME SHOULD BE?");
        player.setName(scanner.nextLine());
        System.out.println(player.getPlayerInfo()+map.currentRoomString(player.getPosition()));


        if(map.getNumberOfEnemies(player.getPosition())>0) { //check by instance of if its aggressive or passive
            System.out.println("ENEMIES:");
            map.getEnemiesString(player.getPosition());
        }
        if(map.getNumberOfItemsInRoom(player.getPosition())>0) {
            System.out.println("\nITEMS:");
            map.getItemsString(player.getPosition());
        }
        System.out.println("ROOMS ARROUND:");
        map.getRoomsAroundString(player.getPosition());

        System.out.println("\nIN WHICH ROOM YOU WANT TO GO? (North/South/East/West)");
        String nextRoom = scanner.nextLine();
        //System.out.println(nextRoom);
        player.setPosition(map.changePlayerRoom(player.getPosition(),nextRoom));
        System.out.println("Current room: "+map.currentRoomString(player.getPosition()));

        System.out.println("ROOMS ARROUND:");
        map.getRoomsAroundString(player.getPosition());
        //map.showList();
    }
}
