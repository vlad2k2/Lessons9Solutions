package app;

import java.util.Arrays;
import java.util.Random;

public class Lessons9Solutions {

    static int sumEvenLines = 0;
    static int sumOddRows = 0;
    static long multiEvenLines = 1;
    static long multiOddRows = 1;


    static public void main(String[] args){

        Random rnd = new Random();

        int[][] intMatrix = new int[4][4];

        // Заплвнення матриці
        for (int i = 0; i < intMatrix.length; i++){
            for(int j = 0; j < intMatrix[i].length; j++){
                intMatrix[i][j] = rnd.nextInt(1, 51);
            }
        }
        System.out.println("Матриця 4x4:");
        // Вивід матриці
        for (int i = 0; i < intMatrix.length; i++) {
            for (int j = 0; j < intMatrix[i].length; j++) {
                System.out.print(intMatrix[i][j] + "\t");
            }
            System.out.println();
        }
        // Знайдіть суму всіх елементів в парних рядках (рядок 0, 2)
        // та суму всіх елементів в непарних рядках (рядок 1, 3).
        for (int i = 0; i < intMatrix.length; i++) {
            for (int j = 0; j < intMatrix[i].length; j++) {
                if (i % 2 == 0) {
                    sumEvenLines += intMatrix[i][j];
                } else {
                    sumOddRows += intMatrix[i][j];
                }
                if (j % 2 == 0) {
                    multiEvenLines *= intMatrix[i][j];
                } else {
                    multiOddRows *= intMatrix[i][j];
                }
            }
        }
        System.out.println();
        System.out.println("Сума елементів у парних рядках (рядок 0, 2): " + sumEvenLines);
        System.out.println("Сума елементів у непарних рядках (рядок 1, 3): " + sumOddRows);
        System.out.println("Добуток елементів у парних стовпцях (стовпець 0, 2): " + multiEvenLines);
        System.out.println("Добуток елементів у непарних стовпцях (стовпець 1, 3): " + multiOddRows);

        // Знайдіть добуток всіх елементів в парних стовпцях (стовпцях 0, 2)
        // та добуток всіх елементів в непарних стовпцях (стовпцях 1, 3).
//        for (int i = 0; i < intMatrix.length; i++) {
//            for (int j = 0; j < intMatrix[i].length; j++) {
//                if (j % 2 == 0) {
//                    multiEvenLines *= intMatrix[i][j];
//                } else {
//                    multiOddRows *= intMatrix[i][j];
//                }
//            }
//        }
//        System.out.println("Добуток елементів у парних стовпцях (стовпець 0, 2): " + multiEvenLines);
//        System.out.println("Добуток елементів у непарних стовпцях (стовпець 1, 3): " + multiOddRows);

        // Перевірте, чи матриця є магічним квадратом. Магічний квадрат - це квадратна матриця,
        // в якій суми всіх рядків, стовпців та діагоналей рівні між собою

        // Перевірка на магічний квадрат
        if (isMagicSquare(intMatrix)) {
            System.out.println("\nМатриця є магічним квадратом.");
        } else {
            System.out.println("\nМатриця не є магічним квадратом.");
        }

    }
    // Метод для перевірки магічного квадрату
    private static boolean isMagicSquare(int[][] intMatrix) {
        int size = intMatrix.length;
        int sumSquare = 0;

        // Сума першого рядка для порівняння
        for (int j = 0; j < size; j++) {
            sumSquare += intMatrix[0][j];
        }

        // Перевірка сум рядків
        for (int i = 1; i < size; i++) {
            int rowSum = 0;
            for (int j = 0; j < size; j++) {
                rowSum += intMatrix[i][j];
            }
            if (rowSum != sumSquare) {
                return false;
            }
        }

        // Перевірка сум стовпців
        for (int j = 0; j < size; j++) {
            int colSum = 0;
            for (int i = 0; i < size; i++) {
                colSum += intMatrix[i][j];
            }
            if (colSum != sumSquare) {
                return false;
            }
        }
        //////////// Warning ////////////
        // Перевірка суми головної діагоналі можливо перенести у цікл Перевірка сум рядків
        ////////////////////////////
        int diag1Sum = 0;
        for (int i = 0; i < size; i++) {
            diag1Sum += intMatrix[i][i];
        }
        if (diag1Sum != sumSquare) {
            return false;
        }

        // Перевірка суми побічної діагоналі
        int diag2Sum = 0;
        for (int i = 0; i < size; i++) {
            diag2Sum += intMatrix[i][size - 1 - i];
        }
        if (diag2Sum != sumSquare) {
            return false;
        }
        return true;
    }

}
