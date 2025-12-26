import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
        System.out.println(player.getPlayerInfo()+map.currentRoomString(player.getPosition()));
        System.out.println("ROOMS ARROUND:");
        //map.currentRoomString(player.getPosition());
        map.getRoomsArroundString(player.getPosition());


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
