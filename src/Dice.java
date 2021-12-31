//Initialises a random integer generator.
//Consists only a single function of rollDice() which works according to the dice count.

import java.util.Random;
public class Dice {
    private final int diceCount;
    private final Random generateRandomInt = new Random();
    Dice(int diceCount){
        this.diceCount = diceCount;//Right side diceCount is only valid within the constructor scope.
    }
    int rollDice(){
        return generateRandomInt.nextInt(1,diceCount*6+1);//It generates integer values from origin to bound.(Including origin excluding bound)
    }

    int diceMax(){              //Returns the maximum value that current dice can achieve.
        return diceCount*6;
    }
}
