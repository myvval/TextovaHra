import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class QuestLog {
    private ArrayList<Quest> quests;
    private HashMap<Integer,Quest> questMap;
    public QuestLog() {
        quests = new ArrayList<>();
        questMap = new HashMap<>();
    }
    public void addQuest(Quest q) {
        quests.add(q);
        questMap.put(q.getId(),q);
    }
    public Quest findById(int id) {
        return questMap.get(id);
    }
    public void sortNatural() {
        Collections.sort(quests);
    }
    public void sortByStatus() {
        Collections.sort(quests,new QuestStatusComparator());
    }


}
