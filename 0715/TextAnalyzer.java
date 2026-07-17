import java.util.Scanner;

public class TextAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = readText(sc);

        System.out.println("\n=== Analysis Result ===");

        System.out.println("Character Count: "
                + countCharacters(text));

        System.out.println("Word Count: "
                + countWords(text));

        System.out.println("Vowel Count: "
                + countVowels(text));

        System.out.println("Longest Word: "
                + findLongestWord(text));

        System.out.print("\n請輸入關鍵字：");
        String keyword = sc.nextLine();

        int occurrences = countKeyword(text, keyword);

        System.out.println("Keyword Occurrences: "
                + occurrences);

        sc.close();
    }

    // 讀取文字
    public static String readText(Scanner sc) {

        String text;

        do {
            System.out.print("請輸入一行文字：");
            text = sc.nextLine().trim();
        } while (text.isEmpty());

        return text;
    }

    // 計算有效字元數
    public static int countCharacters(String text) {
        return text.length();
    }

    // 計算單字數
    public static int countWords(String text) {

        String[] words = text.trim().split("\\s+");

        return words.length;
    }

    // 計算母音數
    public static int countVowels(String text) {

        int count = 0;

        text = text.toLowerCase();

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (ch == 'a' ||
                ch == 'e' ||
                ch == 'i' ||
                ch == 'o' ||
                ch == 'u') {

                count++;
            }
        }

        return count;
    }

    // 找最長單字
    public static String findLongestWord(String text) {

        String[] words = text.trim().split("\\s+");

        String longest = words[0];

        for (String word : words) {

            if (word.length() > longest.length()) {
                longest = word;
            }
        }

        return longest;
    }

    // 計算關鍵字出現次數
    public static int countKeyword(
            String text,
            String keyword) {

        String[] words =
                text.toLowerCase().split("\\s+");

        keyword = keyword.toLowerCase();

        int count = 0;

        for (String word : words) {

            if (word.equals(keyword)) {
                count++;
            }
        }

        return count;
    }
}