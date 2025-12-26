import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ItemsManager {
    private ArrayList<Item> listOfItems;
    private HashMap<Integer,Item> mapOfItems;

    public ItemsManager() {
        this.listOfItems = new ArrayList<>();
        this.mapOfItems = new HashMap<>();
    }
    public void loadItems() {
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
        String section = "";
        String line;
        while ((line = br.readLine()) != null) {

                if(line.equals("ITEMS")){section = "ITEMS"; continue;}
                if(line.isEmpty()) continue;

                switch (section) {
                    case "ITEMS":
                        String[] parts = line.split(",");
                        Item item = new Item(Integer.parseInt(parts[0]),parts[1],parts[2],Integer.parseInt(parts[3]),Boolean.parseBoolean(parts[4]));
                        listOfItems.add(item);
                        mapOfItems.put(item.getId(),item);
                        switch(parts[5]) {
                            case "health":
                                item.setHealth(Integer.parseInt(parts[6]));
                                break;
                            case "defense":
                                item.setDefense(Integer.parseInt(parts[6]));
                                break;
                            case "damage":
                                item.setDamage(Integer.parseInt(parts[6]));
                                break;
                        }

                        break;

                }

            }



        } catch (Exception e) {
        System.out.println(e.getMessage());
        }
    }

    public ArrayList<Item> getItems() {
        return listOfItems;
    }



}
