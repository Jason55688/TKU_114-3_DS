public class BmiLevel {
  public static void main(String[] args) {
    double bmi = 25;

    if (bmi < 18.5) {
      System.out.println("BMI level: Underweight");
    } else if (bmi < 24) {
      System.out.println("BMI level: Normal");
    } else if (bmi < 27) {
      System.out.println("BMI level: Overweight");
    } else {
      System.out.println("BMI level: Obese");
    }
  }
}