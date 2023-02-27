/**
 * Write a description of class CaeserCipher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.File;

public class CaeserCipher
{
    // Encrypt the string content of a provided input based on a given key
    private String encrypt(String input, int key) {
        // Create a StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        // Get the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // Shift the Alphabet
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        // Look at each character in input
        for (int i = 0; i < input.length(); i++) {
            // If the character is alphabetical
            if (Character.isLetter(input.charAt(i)) && Character.isUpperCase(input.charAt(i))) {
                // Get the index of the given character in the alphabet
                int index = alphabet.indexOf(input.charAt(i));
                // Get the character matching the index from the shiftedAlphabet
                char shiftedCharacter = shiftedAlphabet.charAt(index);
                // Add the shiftedAlphabet character to the StringBuilder
                stringBuilder.append(shiftedCharacter);
            } else if (Character.isLetter(input.charAt(i)) && Character.isLowerCase(input.charAt(i))) {
                // Get the index of the given character in the alphabet as lowercase
                int index = alphabet.toLowerCase().indexOf(input.charAt(i));
                // Get the character matching the index from the shiftedAlphabet
                char shiftedCharacter = shiftedAlphabet.toLowerCase().charAt(index);
                // Add the shiftedAlphabet character to the StringBuilder
                stringBuilder.append(shiftedCharacter);
            } else {
                // Otherwise, do nothing
                stringBuilder.append(input.charAt(i));
            }
        }
            
    
        // Return the builtString
        return stringBuilder.toString();
    }

    private String encryptTwoKeys(String input, int key1, int key2) {
        // Create a StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        // Get the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // Shift the Alphabet wth key1
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        // Shift the Alphabet with key2
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        // Look at each character in input
        for (int i = 0; i < input.length(); i++) {
            // Get the index of the given character in the alphabet as lowercase
            int index = alphabet.indexOf(input.toUpperCase().charAt(i));
            
            if (i % 2 == 0) {
                // If the character is alphabetical
                if (Character.isLetter(input.charAt(i)) && Character.isUpperCase(input.charAt(i))) {
                    // Get the character matching the index from the shiftedAlphabet
                    char shiftedCharacter = shiftedAlphabet1.charAt(index);
                    // Add the shiftedAlphabet character to the StringBuilder
                    stringBuilder.append(shiftedCharacter);
                } else if (Character.isLetter(input.charAt(i)) && Character.isLowerCase(input.charAt(i))) {
                    // Get the character matching the index from the shiftedAlphabet
                    char shiftedCharacter = shiftedAlphabet1.toLowerCase().charAt(index);
                    // Add the shiftedAlphabet character to the StringBuilder
                    stringBuilder.append(shiftedCharacter);
                } else {
                    // Otherwise, do nothing
                    stringBuilder.append(input.charAt(i));
                }
            } else {
                // If the character is alphabetical
                if (Character.isLetter(input.charAt(i)) && Character.isUpperCase(input.charAt(i))) {
                    // Get the character matching the index from the shiftedAlphabet
                    char shiftedCharacter = shiftedAlphabet2.charAt(index);
                    // Add the shiftedAlphabet character to the StringBuilder
                    stringBuilder.append(shiftedCharacter);
                } else if (Character.isLetter(input.charAt(i)) && Character.isLowerCase(input.charAt(i))) {
                    // Get the character matching the index from the shiftedAlphabet
                    char shiftedCharacter = shiftedAlphabet2.toLowerCase().charAt(index);
                    // Add the shiftedAlphabet character to the StringBuilder
                    stringBuilder.append(shiftedCharacter);
                } else {
                    // Otherwise, do nothing
                    stringBuilder.append(input.charAt(i));
                }
            }
        }
            
        // Return the builtString
        return stringBuilder.toString();
    }

    public void testEncrypt(int key) {
        DirectoryResource directoryResource = new DirectoryResource();
        String rawText;
        String encrypted;
        String decrypted;
        
        for (File file : directoryResource.selectedFiles()) {
            FileResource fileResource = new FileResource(file);
            rawText = fileResource.asString();
            
            encrypted = encrypt(rawText, key);
            decrypted = encrypt(encrypted, 26 - key);
            System.out.println("Raw: " + rawText + "\nEncrypted: " + encrypted + "\nDecrypted: " + decrypted);
        }
    }
    
    public void testTwoKeys(int key1, int key2) {
        DirectoryResource directoryResource = new DirectoryResource();
        String rawText;
        String encrypted;
        String decrypted;
        
        for (File file : directoryResource.selectedFiles()) {
            FileResource fileResource = new FileResource(file);
            rawText = fileResource.asString();
            
            encrypted = encryptTwoKeys(rawText, key1, key2);
            decrypted = encryptTwoKeys(encrypted, 26 - key1, 26 - key2);
            System.out.println("Raw: " + rawText + "\nEncrypted: " + encrypted + "\nDecrypted: " + decrypted);
        }
    }
}
