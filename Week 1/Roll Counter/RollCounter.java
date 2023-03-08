/**
 * Write a description of class RollCounter here.
 *
 * @author Jessica Alder
 * @version 0.0.1
 */
import java.util.Random;

public class RollCounter
{
    int[] counts = new int[13];
    
    // Simulate the dice rolls and return the array of rolls
    private int[] simulate(int rolls) {
        Random roll = new Random();
        
        for (int i = 0; i < rolls; i++) {
            int d1 = roll.nextInt(6);
            int d2 = roll.nextInt(6);
            int sum = d1 + d2;
            
            counts[sum] = counts[sum] + 1;
        }
        
        return counts;
    }
    
    // Get the number of times to roll from the user, then print number of times each number was rolled.
    public void countRolls(int diceRolls) {
        System.out.println("You rolled the dice " + diceRolls + " times!");
        counts = simulate(diceRolls);
        
        System.out.println("Here is the count for each number rolled: ");
        for (int i = 1; i <= counts.length; i++) {
            System.out.println(i + " was rolled " + counts[i] + " times.");
        }
    }
}
