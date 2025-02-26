import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Password {
    /**
     * Hashes the provided password using the SHA-256 algorithm.
     * 
     * @param password the password to be hashed
     * @return a hexadecimal string representing the hashed password
     * @throws RuntimeException if the SHA-256 algorithm is not available
     */
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());

            StringBuilder hexString = new StringBuilder();

            for (byte b : hashedBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    /**
     * Attempts a brute-force attack to find the 6-digit number
     * 
     * @param targetHash the target hash to match
     * @return the 6-digit number that matches, or null if no match is found
     */
    public static String bruteForce6Digit(String targetHash) {

        for (int i = 0; i < 1000000; i++) {

            Password password = new Password();
            String content = String.format("%06d", i);
            String hashedPassword = password.hashPassword(content);
            boolean isEqual = hashedPassword.equals(targetHash);
            if (isEqual) {
                String result = content;
                return (result);
            }
        }
        return null;
    }

    /**
     * Checks if the given password is strong according to the following criteria:
     * 
     * <ul>
     * <li>Minimum length of 12 characters</li>
     * <li>At least one uppercase letter</li>
     * <li>At least one lowercase letter</li>
     * <li>At least one digit</li>
     * <li>No whitespace characters</li>
     * </ul>
     * 
     * @param password the password to check
     * @return true if the password is strong, false otherwise
     */
    public static boolean isStrongPassword(String password) {
        boolean hasTwelveCharacters = password.length() > 11;
        boolean hasOneUppercaseLetter = false;
        boolean hasOneLowercaseLetter = false;
        boolean hasOneDigit = false;
        boolean hasNoWhitespace = true;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) {
                hasOneUppercaseLetter = true;
            }
            if (Character.isLowerCase(c)) {
                hasOneLowercaseLetter = true;
            }
            if (Character.isDigit(c)) {
                hasOneDigit = true;
            }
            if (Character.isWhitespace(c)) {
                hasNoWhitespace = false;
            }
        }

        if (hasTwelveCharacters && hasOneUppercaseLetter && hasOneLowercaseLetter && hasOneDigit && hasNoWhitespace) {
            return true;
        }
        ;

        return false;
    }

    /**
     * Checks the strength of multiple passwords and stores the results in a
     * HashMap.
     *
     * @param passwords An ArrayList of passwords to be checked.
     * @return A HashMap where each password is mapped to a Boolean value:
     *         true if the password is strong, false otherwise
     */
    public static HashMap<String, Boolean> checkPasswordsList(ArrayList<String> passwords) {

        HashMap<String, Boolean> results = new HashMap<>();
        for (String password : passwords) {
            boolean strong = Password.isStrongPassword(password);
            results.put(password, strong);
        }

        return results;
    }

    /**
     * Generates a secure random password with at least:
     * <ul>
     * <li>1 uppercase letter</li>
     * <li>1 lowercase letter</li>
     * <li>1 digit</li>
     * <li>1 special character</li>
     * </ul>
     * 
     * @param nbCar The desired length of the password (minimum 4).
     * @return A randomly generated password that meets the security criteria.
     */
    public static String generatePassword(int nbCar) {

        assert nbCar >= 4;

        List<Character> liCar = new ArrayList<>();
        liCar.addAll(List.of('A', 'a', '0', '.'));

        SecureRandom random = new SecureRandom();
        int randomInteger1 = random.nextInt(10);
        char chiffre1 = (char) (randomInteger1 + '0');
        int randomInteger2 = random.nextInt(10);
        char chiffre2 = (char) (randomInteger2 + '0');

        Character minuscule1 = (char) (random.nextInt(26) + 97);
        Character minuscule2 = (char) (random.nextInt(26) + 97);

        Character majuscule1 = (char) (random.nextInt(26) + 65);
        Character majuscule2 = (char) (random.nextInt(26) + 65);

        Character special1 = (char) (random.nextInt(16) + 32);
        Character special2 = (char) (random.nextInt(16) + 32);

        liCar.addAll(List.of(special1, special2, chiffre1, chiffre2, minuscule1, minuscule2, majuscule1, majuscule2));
        Collections.shuffle(liCar);

        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < liCar.size() - 1) {
            sb.append(liCar.get(i));
            i++;
        }
        sb.append(liCar.get(i));

        String res = sb.toString();
        return res;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            // No arguments provided, running all questions
            for (int i = 1; i <= 4; i++)
                runQuestion(String.valueOf(i));
        } else {
            for (String arg : args) {
                runQuestion(arg);
            }
        }
    }

    private static void runQuestion(String questionNumber) {

        System.out.println("\nQ" + questionNumber + "\n" + "-".repeat(20));
        switch (questionNumber) {
            case "1":
                String HashedPwd = "a97755204f392b4d8787b38d898671839b4a770a864e52862055cdbdf5bc5bee";
                String bruteForcedPwd = bruteForce6Digit(HashedPwd);
                System.out.println(bruteForcedPwd != null ? bruteForcedPwd : "No result found");
                break;

            case "2":
                System.out.println("Abc5          -> " + isStrongPassword("1234"));
                System.out.println("abcdef123456  -> " + isStrongPassword("abcdef123456"));
                System.out.println("AbCdEf123456  -> " + isStrongPassword("AbCdEf123456"));
                System.out.println("AbCdEf 123456 -> " + isStrongPassword("AbCdEf 123456"));
                break;

            case "3":
                ArrayList<String> passwords = new ArrayList<>(
                        List.of("Abc5", "abcdef123456", "AbCdEf123456", "AbCdEf 123456"));
                HashMap<String, Boolean> password_map = checkPasswordsList(passwords);

                if (password_map != null) {
                    for (Map.Entry<String, Boolean> entry : password_map.entrySet()) {
                        System.out.println(entry.getKey() + " -> " + entry.getValue());
                    }
                }
                break;

            case "4":
                System.out.println("Generated password: " + generatePassword(12));
                break;

            default:
                System.out.println("Invalid question number: " + questionNumber);
        }
    }

}
