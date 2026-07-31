public class RecursiveDigitSumPractice {

    // 遞迴計算各位數總和
    public static int digitSum(int number) {

        // 處理負數
        number = Math.abs(number);

        // Base Case
        if (number < 10) {
            return number;
        }

        return (number % 10) + digitSum(number / 10);
    }

    public static void main(String[] args) {

        System.out.println("5729 -> " + digitSum(5729));
        System.out.println("12345 -> " + digitSum(12345));
        System.out.println("0 -> " + digitSum(0));
        System.out.println("-987 -> " + digitSum(-987));
        System.out.println("99999 -> " + digitSum(99999));
    }
}