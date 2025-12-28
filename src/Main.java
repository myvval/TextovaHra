import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
        ArrayList<Room> rooms = map.returnListOfRoom();
        for(Item item:itemManager.getItems()) rooms.get(item.getLocation()).addItem(item);
        for(Enemy enemy:enemies.getEnemies()) {rooms.get(enemy.getLocation()).addEnemy(enemy);}






        Player player = new Player("NO NAME");
        Scanner scanner = new Scanner(System.in);
        System.out.println("START OF THE GAME");
        System.out.println("WHAT YOUR NAME SHOULD BE?");
        player.setName(scanner.nextLine());
        System.out.println(player.getPlayerInfo()+map.currentRoomString(player.getPosition()));
        System.out.println("ROOMS ARROUND:");
        map.getRoomsArroundString(player.getPosition());
        map.currentRoomString(player.getPosition());

        System.out.println("\nITEMS:");
        map.getItemsString(player.getPosition());
        System.out.println("ENEMIES:");
        map.getEnemiesString(player.getPosition());

        System.out.println("\nIN WHICH ROOM YOU WANT TO GO? (North/South/East/West)");
        String nextRoom = scanner.nextLine();
        //System.out.println(nextRoom);
        player.setPosition(map.changePlayerRoom(player.getPosition(),nextRoom));
        System.out.println("Current room: "+map.currentRoomString(player.getPosition()));

        System.out.println("ROOMS ARROUND:");
        map.getRoomsArroundString(player.getPosition());
        //map.showList();
    }
}
