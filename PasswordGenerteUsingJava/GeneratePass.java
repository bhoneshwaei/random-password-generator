
import java.util.Random;
import java.util.Scanner;

public class GeneratePass {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "@#$%&*";

        String passwordChars = "";

        System.out.println("=== Password Generator ===");

        System.out.print("Include Uppercase Letters? (yes/no): ");
        String hasUpper = sc.nextLine();

        if (hasUpper.equalsIgnoreCase("yes")) {
            passwordChars += upper;
        }

        System.out.print("Include Lowercase Letters? (yes/no): ");
        String hasLower = sc.nextLine();

        if (hasLower.equalsIgnoreCase("yes")) {
            passwordChars += lower;
        }

        System.out.print("Include Numbers? (yes/no): ");
        String hasNumber = sc.nextLine();

        if (hasNumber.equalsIgnoreCase("yes")) {
            passwordChars += numbers;
        }

        System.out.print("Include Symbols? (yes/no): ");
        String hasSymbol = sc.nextLine();

        if (hasSymbol.equalsIgnoreCase("yes")) {
            passwordChars += symbols;
        }
            // Check if user selected nothing
        if (passwordChars.length() == 0) {
            System.out.println("Please select at least one option.");
            
        }

        System.out.print("Enter Password Length: ");
        int length = sc.nextInt();

        Random random = new Random();

        String password = "";

        for (int i = 0; i < length; i++) {

            int index = random.nextInt(passwordChars.length());

            password += passwordChars.charAt(index);
        }

        System.out.println("\nGenerated Password: " + password);

        // Password Strength Check
        int score = 0;

        if (password.matches(".*[A-Z].*")) {
            score++;
        }

        if (password.matches(".*[a-z].*")) {
            score++;
        }

        if (password.matches(".*[0-9].*")) {
            score++;
        }

        if (password.matches(".*[@#$%&*].*")) {
            score++;
        }

        if (password.length() >= 8) {
            score++;
        }

        if (password.length() >= 12) {
            score++;
        }

        System.out.print("Password Strength: ");

        if (score <= 2) {
            System.out.println("Weak");
        } else if (score <= 4) {
            System.out.println("Medium");
        } else {
            System.out.println("Strong");
        }

        sc.close();
    }
}
