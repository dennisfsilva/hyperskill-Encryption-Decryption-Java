package src.main;

public class Algorithms {
    public static String UnicodeEncrypt(String data, int key) {
        // Implement Unicode encryption algorithm
        StringBuilder result = new StringBuilder();
        for (char c : data.toCharArray()) {
            result.append((char) (c + key));
        }
        return result.toString();
    }

    public static String UnicodeDecrypt(String data, int key) {
        // Implement Unicode encryption algorithm
        StringBuilder result = new StringBuilder();
        for (char c : data.toCharArray()) {
            result.append((char) (c - key));
        }
        return result.toString();
    }

    public static String ShiftEncrypt(String data, int key) {
        // Implement Shift encryption algorithm
        StringBuilder result = new StringBuilder();
        for (char c : data.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                int base = Character.isUpperCase(c) ? 'A' : 'a';
                int offset = (c - base + key) % 26;
                result.append((char) (base + offset));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String ShiftDecrypt(String data, int key) {
        // Implement Shift encryption algorithm
        StringBuilder result = new StringBuilder();
        for (char c : data.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                int base = Character.isUpperCase(c) ? 'A' : 'a';
                int offset = (c - base - key + 26) % 26;
                result.append((char) (base + offset));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
