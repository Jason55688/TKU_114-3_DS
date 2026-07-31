public class ScoreRankingPractice {

    public static void selectionSortDescending(int[] scores) {

        for (int start = 0; start < scores.length - 1; start++) {

            int maxIndex = start;

            for (int i = start + 1; i < scores.length; i++) {

                if (scores[i] > scores[maxIndex]) {
                    maxIndex = i;
                }
            }

            int temp = scores[start];
            scores[start] = scores[maxIndex];
            scores[maxIndex] = temp;
        }
    }

    public static void displayRanking(int[] scores) {

        int rank = 1;

        for (int i = 0; i < scores.length; i++) {

            if (i > 0 && scores[i] != scores[i - 1]) {
                rank = i + 1;
            }

            System.out.println(
                    "第" + rank + "名 : " + scores[i]);
        }
    }

    public static void main(String[] args) {

        int[] scores = {
                85, 92, 78, 92,
                88, 75, 88, 95
        };

        System.out.println("原始成績：");

        for (int score : scores) {
            System.out.print(score + " ");
        }

        System.out.println("\n");

        selectionSortDescending(scores);

        System.out.println("排序後成績：");

        for (int score : scores) {
            System.out.print(score + " ");
        }

        System.out.println("\n");
        System.out.println("=== 成績排名 ===");

        displayRanking(scores);
    }
}