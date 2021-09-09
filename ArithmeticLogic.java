public class ArithmeticLogic {

    public static int Create(String arthm, int num1, int num2) {

        int res;

        switch (arthm) {
            case "+":
                res = num1 + num2;
                break;
            case "-":
                res = num1 - num2;
                break;
            case "*":
                res = num1 * num2;
                break;
            case "/":
                res = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Арифметический знак не соответствует допустимым");
        }
        return res;

    }
}
