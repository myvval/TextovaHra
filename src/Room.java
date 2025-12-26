import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    private int id;
    private String name;
    private String description;
    private HashMap<Directions,Room> roomsArround;
    private ArrayList<Room> roomsArroundList;
    private HashMap<String,String> connectionData;
    private ArrayList<String> directions;
    private ArrayList<Item> listOfItems;
    public Room(int id,String name,String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        roomsArround = new HashMap<>();
        connectionData = new HashMap<>();
        roomsArroundList = new ArrayList<>();
        directions = new ArrayList<>();
        listOfItems = new ArrayList<>();
    }

    public void addItem(Item item) {
        listOfItems.add(item);
    }
    public void removeItem(Item item) {
        listOfItems.remove(item);
    }
    public ArrayList<Item> getItems() {
        return listOfItems;
    }

    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }

    public void addConnectionData(String north,String south,String east,String west){
            connectionData.put("North",north);
            connectionData.put("South",south);
            connectionData.put("East",east);
            connectionData.put("West",west);
    }

    public HashMap<String, String> getConnectionData() {
        return connectionData;
    }

    public void addDirectionSouth(Room room) {
        if (room != null) {
            roomsArround.put(Directions.SOUTH,room);
            roomsArroundList.add(room);
            directions.add("S");
        }

    }
    public int getSouth() {
        return roomsArround.get(Directions.SOUTH).getId();
    }
    public int getNorth() {
        return roomsArround.get(Directions.NORTH).getId();
    }
    public int getEast() {
        return roomsArround.get(Directions.EAST).getId();
    }
    public int getWest() {
        System.out.println("west:"+roomsArround.get(Directions.WEST).getId());
        return roomsArround.get(Directions.WEST).getId();

    }

    public void addDirectionNorth(Room room) {
        if (room != null){
            roomsArround.put(Directions.NORTH,room);
            roomsArroundList.add(room);
            directions.add("N");}
    }

    public void addDirectionEast(Room room) {
        if (room != null){
            roomsArround.put(Directions.EAST,room);
            roomsArroundList.add(room);
            directions.add("E");}
    }
    public void addDirectionWest(Room room) {
        if (room != null)
            roomsArround.put(Directions.WEST,room);{
            roomsArroundList.add(room);
            directions.add("W");}
    }

    public String getRoomName(){
        return this.name;
    }
    /*public HashMap<Directions,Room> getRoomArroundChange() {
        return roomsArround;
    }*/
    public HashMap<Directions,Room> getRoomsArround() { //upravuje se tohle
        /*for(int i =0;i<roomsArroundList.size();i++) {
            if(roomsArroundList.get(i)!=null)
                System.out.print(directions.get(i)+": "+roomsArroundList.get(i).getRoomName()+"   ");
        }*/
        return roomsArround;
    }
    public void getRoomsArroundString() {
        for (int i = 0; i < roomsArroundList.size(); i++) {
            if (roomsArroundList.get(i) != null)
                System.out.print(directions.get(i) + ": " + roomsArroundList.get(i).getRoomName() + "   ");
        }
    }
    /*public String toString() {
        return this.name;
    }*/


}
