package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static boolean error = false;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        game(prepareSecretCode(scanner), scanner);

    }

    private static void game(String prepareSecretCode, Scanner scanner) {
        if (error) {
            return;
        }

        System.out.println("Okay, let's start a game!");

        int turnCount = 1;

        while (true) {
            System.out.println("Turn " + turnCount + ":");
            String answer = scanner.next();
            int bullsCount = 0;
            int cowsCount = 0;

            for (int i = 0; i < answer.length(); i++) {
                for (int j = 0; j < prepareSecretCode.length(); j++) {
                    if (prepareSecretCode.charAt(j) == answer.charAt(i)) {
                        if (i == j) {
                            bullsCount++;
                            continue;
                        }
                        cowsCount++;
                    }
                }
            }
            if (bullsCount == prepareSecretCode.length()) {
                System.out.println("Grade: " + prepareSecretCode.length() + " bulls");
                System.out.println("Congratulations! You guessed the secret code.");
                break;
            } else if (bullsCount != 0 && cowsCount != 0) {
                System.out.print("Grade: " + bullsCount + " bull(s) and "
                        + cowsCount + " cow(s)");
            } else if (bullsCount != 0) {
                System.out.print("Grade: " + bullsCount + " bull(s)");
            } else if (cowsCount != 0) {
                System.out.print("Grade: " + cowsCount + " cow(s)");
            } else {
                System.out.print("Grade: None.");
            }

            System.out.println();
            turnCount++;
        }

    }

    static String prepareSecretCode(Scanner scanner) {

        System.out.println("Input the length of the secret code:");
        String secretCodeLengthStr = scanner.nextLine();
        if (!secretCodeLengthStr.matches("[-+]?\\d+")) {
            error = true;
            System.out.println("Error: \"" + secretCodeLengthStr + "\" isn't a valid number.");
            return null;
        }
        System.out.println("Input the number of possible symbols in the code:");
        String symbolsNumberStr = scanner.nextLine();
        if (!symbolsNumberStr.matches("[-+]?\\d+")) {
            System.out.println("Error: \"" + symbolsNumberStr + "\" isn't a valid number.");
            error = true;
            return null;
        }
        int secretCodeLength = Integer.parseInt(secretCodeLengthStr);
        int symbolsNumber = Integer.parseInt(symbolsNumberStr);

        if (symbolsNumber > 36) {
            error = true;
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return null;
        }

        if (secretCodeLength <= 0) {
            error = true;
            System.out.println("Error.");
            return null;
        }


        int lettersNumber = symbolsNumber - 10;

        if (symbolsNumber < secretCodeLength) {
            System.out.println("Error: it's not possible to generate a code with a length of "
                    + secretCodeLength + " with " + symbolsNumber + " unique symbols.");
            error = true;
            return null;
        }

        String numbers = "0123456789";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder secretCode = new StringBuilder(numbers + alphabet.substring(0, lettersNumber));
        String stars = "************************************";
        String starsCode = stars.substring(0, secretCodeLength);

        if (secretCode.length() > 10) {
            System.out.println("The secret is prepared: " + starsCode + " (0-9, " + secretCode.charAt(10)
                    + "-" + secretCode.charAt(secretCode.length() - 1) + ").");
        } else {
            System.out.println("The secret is prepared: " + starsCode + " (0-9).");
        }


        Random random = new Random();
        for (int i = 0; i < secretCode.length(); i++) {
            int randomIndex = random.nextInt(symbolsNumber);
            char temp = secretCode.charAt(i);
            secretCode.setCharAt(i, secretCode.charAt(randomIndex));
            secretCode.setCharAt(randomIndex, temp);
        }

        return secretCode.substring(0, secretCodeLength);
    }
}
