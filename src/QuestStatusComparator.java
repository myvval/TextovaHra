import java.util.Comparator;

public class QuestStatusComparator implements Comparator<Quest> {
    @Override
    public int compare(Quest i,Quest j) {
        if (i.getState().equals(QuestStatus.OPEN) && j.getState().equals(QuestStatus.DONE)) return -1;
        else if (i.getState().equals(QuestStatus.DONE) && j.getState().equals(QuestStatus.OPEN)) return 1;
        else if(i.getState().equals(j.getState())) {if(i.getReward()>j.getReward()) return -1; else if (i.getReward()<j.getReward()) return 1;}
        return 0;
    }
}
