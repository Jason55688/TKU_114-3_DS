package week1_practice;

import java.util.Scanner;

public class AtmSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int balance = 1000;

        int depositCount = 0;
        int withdrawCount = 0;

        int totalDeposit = 0;
        int totalWithdraw = 0;

        int option;

        do {

            printMenu();

            System.out.print("請輸入選項：");
            option = sc.nextInt();

            switch (option) {

                case 1:
                    printBalance(balance);
                    break;

                case 2:
                    int depositAmount =
                            readPositiveAmount(sc, "請輸入存款金額：");

                    balance = deposit(balance, depositAmount);

                    depositCount++;
                    totalDeposit += depositAmount;

                    System.out.println("存款成功！");
                    printBalance(balance);
                    break;

                case 3:
                    int withdrawAmount =
                            readPositiveAmount(sc, "請輸入提款金額：");

                    if (canWithdraw(balance, withdrawAmount)) {

                        balance = withdraw(balance, withdrawAmount);

                        withdrawCount++;
                        totalWithdraw += withdrawAmount;

                        System.out.println("提款成功！");
                        printBalance(balance);

                    } else {
                        System.out.println("餘額不足！");
                    }

                    break;

                case 4:
                    printSummary(
                            balance,
                            depositCount,
                            withdrawCount,
                            totalDeposit,
                            totalWithdraw);
                    break;

                case 0:
                    System.out.println("\n程式結束");
                    break;

                default:
                    System.out.println("無效選項！");
            }

            System.out.println();

        } while (option != 0);

        printSummary(
                balance,
                depositCount,
                withdrawCount,
                totalDeposit,
                totalWithdraw);

        sc.close();
    }

    // 顯示選單
    public static void printMenu() {

        System.out.println("=== ATM Menu ===");
        System.out.println("1. Check balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Show summary");
        System.out.println("0. Exit");
    }

    // 讀取正整數金額
    public static int readPositiveAmount(
            Scanner sc, String message) {

        System.out.print(message);
        int amount = sc.nextInt();

        while (amount <= 0) {
            System.out.print("金額必須大於 0，請重新輸入：");
            amount = sc.nextInt();
        }

        return amount;
    }

    // 存款
    public static int deposit(int balance, int amount) {
        return balance + amount;
    }

    // 提款
    public static int withdraw(int balance, int amount) {
        return balance - amount;
    }

    // 是否可提款
    public static boolean canWithdraw(
            int balance, int amount) {

        return amount <= balance;
    }

    // 顯示餘額
    public static void printBalance(int balance) {
        System.out.println("Balance: " + balance);
    }

    // 顯示摘要
    public static void printSummary(
            int balance,
            int depositCount,
            int withdrawCount,
            int totalDeposit,
            int totalWithdraw) {

        System.out.println("=== ATM Summary ===");
        System.out.println("Final balance: " + balance);
        System.out.println("Deposit count: " + depositCount);
        System.out.println("Withdraw count: " + withdrawCount);
        System.out.println("Total deposit: " + totalDeposit);
        System.out.println("Total withdraw: " + totalWithdraw);
    }
}