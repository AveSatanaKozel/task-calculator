import java.util.*;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        scanner.close();

        String[] splitString = a.split(" ");

        ArrayList<String> characters = new ArrayList<>();
        ArrayList<Integer> arabNumbers = new ArrayList<>();
        ArrayList<String> romNumbers = new ArrayList<>();

        int arabicRes;
        int romanRes;

        for (String partsOfString : splitString) {
            if (partsOfString.equals("+") || partsOfString.equals("-")
                    || partsOfString.equals("*") || partsOfString.equals("/")) {
                characters.add(partsOfString);
            } else if (partsOfString.contains("I") || partsOfString.contains("V") || partsOfString.contains("X")) {
                romNumbers.add(partsOfString);
            } else arabNumbers.add(Integer.parseInt(partsOfString));
        }
        if (characters.size() > 1) {
            throw new IllegalArgumentException("Формат математической операции не удовлетворяет заданию - " +
                    "два операнда и один оператор (+, -, /, *)");
        }

        if (arabNumbers.size() < 2 && romNumbers.size() < 1) {
            throw new IllegalArgumentException("Строка не является математической операцией");
        } else if ((romNumbers.size() < 2 && arabNumbers.size() < 1)) {
            throw new IllegalArgumentException("Строка не является математической операцией");
        }

        int countRoman = 0;
        int countArabic = 0;

        try {
            int c = Integer.parseInt(String.valueOf(arabNumbers.get(0)));
            countArabic++;
            int c1 = Integer.parseInt(String.valueOf(arabNumbers.get(1)));
            countArabic++;
        } catch (Exception e) {
            countRoman++;
        }

        if (countArabic > countRoman) {
            if (arabNumbers.get(0) < 1 || arabNumbers.get(0) > 10 || arabNumbers.get(1) < 1 ||
                    arabNumbers.get(1) > 10) {
                throw new IllegalArgumentException(("Введённые числа должны быть от 1 до 10 включительно"));
            }

            arabicRes = ArithmeticLogic.Create(characters.get(0), arabNumbers.get(0), arabNumbers.get(1));

            System.out.println(arabicRes);

        } else if (countArabic < countRoman) {

            int v = ArabicConverter.Convert(romNumbers.get(0));
            int g = ArabicConverter.Convert(romNumbers.get(1));

            romanRes = ArithmeticLogic.Create(characters.get(0), v, g);

            if (romanRes < 1) {
                throw new IllegalArgumentException("В римской системе нет отрицательных чисел и ноля");
            }
            System.out.println(RomanConverter.RomanNumerals(romanRes));
        } else throw new IllegalArgumentException("Используются одновременно разные системы счисления");
    }
}
