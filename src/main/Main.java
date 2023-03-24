package encryptdecrypt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Set default values for command-line arguments
        String mode = "enc";
        int key = 0;
        String data = "";
        Optional<Path> inPath = Optional.empty();
        Optional<Path> outPath = Optional.empty();
        String algorithm = "shift";

        // Parse command-line arguments
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode" -> mode = args[++i];
                case "-key" -> key = Integer.parseInt(args[++i]);
                case "-data" -> data = args[++i];
                case "-in" -> inPath = Optional.of(Paths.get(args[++i]));
                case "-out" -> outPath = Optional.of(Paths.get(args[++i]));
                case "-alg" -> {
                    switch (args[++i]) {
                        case "shift" -> algorithm = "shift";
                        case "unicode" -> algorithm = "unicode";
                        default -> {
                            System.err.println("Unknown algorithm: " + args[i]);
                            System.exit(1);
                        }
                    }
                }
                default -> {
                    System.err.println("Unknown option: " + args[i]);
                    System.exit(1);
                }
            }
        }

        // If no input data is provided, read from input file
        if (data.isEmpty()) {
            try {
                byte[] bytes = Files.readAllBytes(inPath.orElseThrow(() -> new IllegalArgumentException("Input file path not specified")));
                data = new String(bytes);
            } catch (IOException e) {
                System.err.println("Error: could not read input file");
                System.exit(1);
            }
        }

        // Process data
        String result = processData(mode, key, data, algorithm);

        // Write output to file or console
        try {
            outPath.ifPresent(path -> {
                try {
                    Files.write(path, result.getBytes());
                } catch (IOException e) {
                    System.err.println("Error: could not write output file");
                    System.exit(1);
                }
            });
        } catch (Exception e) {
            System.err.println("Error: could not write output file");
            System.exit(1);
        }
        System.out.println(result);
    }

    // Define the processData method used in the main method
    private static String processData(String mode, int key, String data, String algorithm) {
        // Check the value of mode and use the appropriate encryption or decryption method
        switch (mode) {
            case "enc" -> {
                return encrypt(data, key, algorithm);
            }
            case "dec" -> {
                return decrypt(data, key, algorithm);
            }
            default -> {
                System.err.println("Unknown mode: " + mode);
                System.exit(1);
                return "";
            }
        }
    }

    // Define the encrypt method used in processData
    private static String encrypt(String data, int key, String algorithm) {
        // Check the value of algorithm and use the appropriate encryption method
        switch (algorithm) {
            case "shift" -> {
                return Algorithms.ShiftEncrypt(data, key);
            }
            case "unicode" -> {
                return Algorithms.UnicodeEncrypt(data, key);
            }
            default -> {
                System.err.println("Unknown algorithm: " + algorithm);
                System.exit(1);
                return "";
            }
        }
    }

    // Define the decrypt method used in processData
    private static String decrypt(String data, int key, String algorithm) {
        // Check the value of algorithm and use the appropriate decryption method
        switch (algorithm) {
            case "shift" -> {
                return Algorithms.ShiftDecrypt(data, key);
            }
            case "unicode" -> {
                return Algorithms.UnicodeDecrypt(data, key);
            }
            default -> {
                System.err.println("Unknown algorithm: " + algorithm);
                System.exit(1);
                return "";
            }
        }
    }
}
