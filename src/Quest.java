public class Quest implements Comparable<Quest> {
    private int id;
    private String name;
    private QuestStatus state;
    private int reward;

    public QuestStatus getState() {
        return this.state;
    }
    public int getReward() {
        return this.reward;
    }
    public int getId(){
        return this.id;
    }

    @Override
    public int compareTo(Quest that) {
        if (this.id < that.id) {
            return -1;
        } else if (this.id > that.id)
            return 1;
        return 0;
    }
}
