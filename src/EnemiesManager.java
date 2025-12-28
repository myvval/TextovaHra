import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class EnemiesManager {
    private ArrayList<Enemy> listOfEnemies;
    private HashMap<Integer,Enemy> mapOfEnemies;
    public EnemiesManager(){
        this.listOfEnemies = new ArrayList<>();
        this.mapOfEnemies = new HashMap<>();
    }
    public void loadEnemies(){
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String line = "";
            String section = "";
            while((line = br.readLine())!= null) {
                if(line.equals("ENEMIES")) {section="ENEMIES";continue;}
                if(line.isEmpty()) {continue;}

                switch(section){ //this needs to be changed later to passive/aggressive
                    case "ENEMIES":
                        String[] parts = line.split(",");
                        if(parts[4].equals("AGGRESSIVE")) {
                            Enemy enemy = new EnemyAggressive(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]),Integer.parseInt(parts[5]));
                            listOfEnemies.add(enemy);
                            mapOfEnemies.put(enemy.getId(),enemy);
                        } else if(parts[4].equals("PASSIVE")) {
                            Enemy enemy = new EnemyPassive(Integer.parseInt(parts[0]),parts[1],Integer.parseInt(parts[2]),Integer.parseInt(parts[3]),Integer.parseInt(parts[5]));
                            listOfEnemies.add(enemy);
                            mapOfEnemies.put(enemy.getId(),enemy);
                    }

                }


            }

        } catch (Exception e) {System.out.println(e.getMessage());}
    }

    public ArrayList<Enemy> getEnemies(){
        return this.listOfEnemies;
    }


}
