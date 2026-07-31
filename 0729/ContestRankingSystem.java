public class ContestRankingSystem {

    // Insertion Sort
    public static void insertionSort(
            Contestant[] contestants) {

        for (int i = 1; i < contestants.length; i++) {

            Contestant key = contestants[i];
            int j = i - 1;

            while (j >= 0 && compare(contestants[j], key)) {

                contestants[j + 1] = contestants[j];
                j--;
            }

            contestants[j + 1] = key;
        }
    }

    // 回傳 true 代表需要往後移動
    public static boolean compare(
            Contestant a,
            Contestant b) {

        // 分數低要往後
        if (a.getScore() < b.getScore()) {
            return true;
        }

        // 分數相同，比完成秒數
        if (a.getScore() == b.getScore()) {

            return a.getFinishTime()
                    > b.getFinishTime();
        }

        return false;
    }

    public static void displayRanking(
            Contestant[] contestants) {

        System.out.println(
                "名次\t編號\t姓名\t分數\t完成秒數");

        int rank = 1;

        for (int i = 0; i < contestants.length; i++) {

            if (i > 0) {

                boolean sameRank =
                        contestants[i].getScore()
                                == contestants[i - 1].getScore()
                        &&
                        contestants[i].getFinishTime()
                                == contestants[i - 1].getFinishTime();

                if (!sameRank) {
                    rank = i + 1;
                }
            }

            System.out.println(
                    rank + "\t"
                    + contestants[i].getId() + "\t"
                    + contestants[i].getName() + "\t"
                    + contestants[i].getScore() + "\t"
                    + contestants[i].getFinishTime());
        }
    }

    public static void main(String[] args) {

        Contestant[] contestants = {

            new Contestant(
                    "C001",
                    "Amy",
                    95,
                    120),

            new Contestant(
                    "C002",
                    "John",
                    88,
                    110),

            new Contestant(
                    "C003",
                    "Mary",
                    95,
                    115),

            new Contestant(
                    "C004",
                    "David",
                    76,
                    130),

            new Contestant(
                    "C005",
                    "Lisa",
                    88,
                    105),

            new Contestant(
                    "C006",
                    "Kevin",
                    92,
                    118),

            new Contestant(
                    "C007",
                    "Tom",
                    92,
                    140),

            new Contestant(
                    "C008",
                    "Emma",
                    95,
                    115)
        };

        System.out.println("=== 排序前 ===");

        for (Contestant c : contestants) {
            System.out.println(c);
        }

        insertionSort(contestants);

        System.out.println("\n=== 排名結果 ===");

        displayRanking(contestants);
    }
}