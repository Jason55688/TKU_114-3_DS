public class Contestant {

    private String id;
    private String name;
    private int score;
    private int finishTime;

    public Contestant(String id,
                      String name,
                      int score,
                      int finishTime) {

        this.id = id;
        this.name = name;
        this.score = score;
        this.finishTime = finishTime;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getFinishTime() {
        return finishTime;
    }

    @Override
    public String toString() {

        return id + " | "
                + name + " | "
                + score + " | "
                + finishTime + "秒";
    }
}
