import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Guessing Game!");
        int minRange = 1;
        int maxRange = 100;
        int attempts = 10;
        int rounds = 0;
        int score = 0;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        do {
            rounds++;
            int randomNum = generateRandomNumber(minRange, maxRange, random);
            System.out.printf("Guess the number between %d and %d.%n", minRange, maxRange);

            int roundScore = playRound(randomNum, attempts, scanner);
            score += roundScore;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        } while (true);

        System.out.printf("%nGame Over!%nRounds Played: %d%nScore: %d%n", rounds, score);
        scanner.close();
    }

    private static int generateRandomNumber(int min, int max, Random random) {
        return random.nextInt(max - min + 1) + min;
    }

    private static int getUserGuess(Scanner scanner) {
        int guess;
        while (true) {
            try {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // clear the input buffer
            }
        }
        return guess;
    }

    private static String compareGuessWithRandomNumber(int guess, int randomNum) {
        if (guess == randomNum) {
            return "Correct";
        } else if (guess < randomNum) {
            return "Too low";
        } else {
            return "Too high";
        }
    }

    private static int playRound(int randomNum, int attempts, Scanner scanner) {
        for (int attempt = 1; attempt <= attempts; attempt++) {
            int userGuess = getUserGuess(scanner);
            String result = compareGuessWithRandomNumber(userGuess, randomNum);

            if (result.equals("Correct")) {
                System.out.printf("Congratulations! You guessed the correct number %d in %d attempts.%n",
                        randomNum, attempt);
                return 1;
            } else {
                System.out.printf("Attempt %d: %s! Try again.%n", attempt, result);
            }
        }

        System.out.printf("Sorry, you've run out of attempts. The correct number was %d.%n", randomNum);
        return 0;
    }
}
