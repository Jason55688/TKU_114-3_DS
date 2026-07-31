public class RecursiveDigitCounter {

    // 遞迴統計數字出現次數
    public static int countDigit(int number, int target) {

        // 處理負數
        number = Math.abs(number);

        // 特殊情況：0
        if (number == 0) {
            return target == 0 ? 1 : 0;
        }

        // Base Case
        if (number < 10) {
            return number == target ? 1 : 0;
        }

        int count = (number % 10 == target) ? 1 : 0;

        return count + countDigit(number / 10, target);
    }

    public static void main(String[] args) {

        System.out.println("572952 , 5 -> "
                + countDigit(572952, 5));

        System.out.println("111111 , 1 -> "
                + countDigit(111111, 1));

        System.out.println("987654 , 0 -> "
                + countDigit(987654, 0));

        System.out.println("-505050 , 5 -> "
                + countDigit(-505050, 5));

        System.out.println("123456 , 9 -> "
                + countDigit(123456, 9));

        System.out.println("0 , 0 -> "
                + countDigit(0, 0));
    }
}