public class ArabicConverter {

    public static int Convert(String num) {

        int v;

        switch (num) {
            case "I":
                v = 1;
                break;
            case "II":
                v = 2;
                break;
            case "III":
                v = 3;
                break;
            case "IV":
                v = 4;
                break;
            case "V":
                v = 5;
                break;
            case "VI":
                v = 6;
                break;
            case "VII":
                v = 7;
                break;
            case "VIII":
                v = 8;
                break;
            case "IX":
                v = 9;
                break;
            case "X":
                v = 10;
                break;
            default:
                throw new IllegalArgumentException("Введённые числа должны быть от I до X включительно");
        }

        return v;
    }
}
