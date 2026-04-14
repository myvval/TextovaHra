import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class WorldMap {
    ArrayList<Room> roomList;
    HashMap<Integer, Room> roomMap;

    public WorldMap() {
        roomList = new ArrayList<>();
        roomMap = new HashMap<>();
    }

    public Room findRoomByName(String name) {
        for (Room room : roomList) {
            if (room.getName().equals(name)) return room;
        }
        return null;
    }
    public Room findRoomById(int id) {
        return roomMap.get(id);
    }


    public void loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String section = "";
            String line;
            while ((line = br.readLine()) != null) {
                /*if (line.equals("ROOMS")) {
                    section = "ROOMS";
                    continue;
                }
                if(line.equals("ITEMS")) break;
                if (line.isEmpty()) continue;
                */
                switch (section) {
                    case "ROOMS":

                        String[] parts = line.split(",");
                        Room room = new Room(Integer.parseInt(parts[0]), parts[1], parts[2]);
                        roomMap.put(room.getId(), room);
                        roomList.add(room);
                        room.addConnectionData(parts[3], parts[4], parts[5], parts[6]);
                        break;
                }


            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void connectRooms() { //this doesnt work
        for (Room room : roomList) {
            if (room.getConnectionData().get("North") != null)
                room.addDirectionNorth(findRoomByName(room.getConnectionData().get("North")));
            if (room.getConnectionData().get("South") != null)
                room.addDirectionSouth(findRoomByName(room.getConnectionData().get("South")));
            if (room.getConnectionData().get("East") != null)
                room.addDirectionEast(findRoomByName(room.getConnectionData().get("East")));
            if (room.getConnectionData().get("West") != null) {
                room.addDirectionWest(findRoomByName(room.getConnectionData().get("West")));
            }
            //System.out.println(room.getConnectionData());
        }
    }


    public String currentRoomString(int position) {
        return roomMap.get(position).getRoomName();
    }

    public void getRoomsArroundString(int position) {
        roomMap.get(position).getRoomsArroundString();
    }
    public void getItemsString(int position) {
        for(Item item:roomMap.get(position).getItems()) {
            System.out.println(item.getName());
            System.out.println("bb");
        }
    }
    public int getNumberOfItemsInRoom(int position) {
        return roomMap.get(position).getNumberOfItems();
    }
    public int getNumberOfEnemies(int position) {
        return roomMap.get(position).getNumberOfEnemies();
    }
    public void getEnemiesString(int position) {
        for(Enemy enemy:roomMap.get(position).getEnemies()) {
            System.out.println(enemy.getName());
        }
    }

    public int changePlayerRoom(int room1, String nextRoom) { //if check is wrong
        Room room = roomMap.get(room1);
        int result = room.getId();
        switch (nextRoom) {
            case "South":
                if (room.getRoomsArround().containsKey(Directions.SOUTH))
                    result = room.getSouth();
                break;

            case "West":
                if (room.getRoomsArround().containsKey(Directions.WEST))
                    result = room.getWest();
                break;
            case "East":
                if (room.getRoomsArround().containsKey(Directions.EAST))
                    result = room.getEast();
                break;
            case "North":
                if (room.getRoomsArround().containsKey(Directions.NORTH))
                    result = room.getNorth();
                    System.out.println(room.getNorth());
                break;
            default:
                break;

        }
        return result;
    }



    public void showList() {
        for(Room room: roomList) {
            System.out.println(room.getRoomsArround());
        }
    }

    public ArrayList<Room> returnListOfRoom() {
        return roomList;
    }
}
