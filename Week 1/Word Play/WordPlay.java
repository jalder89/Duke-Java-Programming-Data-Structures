
/**
 * Write a description of class WordPlay here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordPlay
{
    private Boolean isVowel(char character) {
        String vowels = "AEIOU";
        if (vowels.indexOf(Character.toUpperCase(character)) != -1) {
            return true;
        } else {
            return false;
        }
    }
    
    private String replaceVowels(String phrase, char character) {
        String vowels = "AEIOU";
        StringBuilder stringBuilder = new StringBuilder();
        
        for (int i = 0; i < phrase.length(); i++) {
            if (vowels.indexOf(Character.toUpperCase(phrase.charAt(i))) != -1) {
                stringBuilder.append(character);
            } else {
                stringBuilder.append(phrase.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
    
    private String emphasize(String phrase, char character) {
        StringBuilder stringBuilder = new StringBuilder();
        
        for (int i = 0; i < phrase.length(); i++) {
            if (i % 2 == 0 && Character.toString(character).toUpperCase().indexOf(phrase.toUpperCase().charAt(i)) != -1) {
                stringBuilder.append("*");
            } else if (i % 2 != 0 && Character.toString(character).toUpperCase().indexOf(phrase.toUpperCase().charAt(i)) != -1) {
                stringBuilder.append("+");
            } else {
                stringBuilder.append(phrase.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
    
    public void testIsVowel(char character) {
        System.out.println("Is character " + character + " a vowel: " + isVowel(character));
    }
    
    public void testReplaceVowels(String phrase, char character) {
        System.out.println("Original: " + phrase);
        System.out.println("Vowels Replaced: " + replaceVowels(phrase, character));
    }
    
    public void testEmphasize(String phrase, char character) {
        System.out.println("Original: " + phrase);
        System.out.println("Vowels Replaced: " + emphasize(phrase, character));
    }
}
