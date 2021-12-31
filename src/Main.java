public class Main {
    public static void main(String[] args) {

        GameSetup gameSetup = new GameSetup();                                                                //Should be created only one time and must not be use in any other class to create object.
        Board.runBoardSetup(gameSetup.getBoardSize());                                                         // Static methods can be accessed without creating an object of it
        Dice gameDice = new Dice(gameSetup.getDiceCount());
        SnakeLadderPositions obstaclePositions = new SnakeLadderPositions();
        WinCondition gameCondition = new WinCondition(gameSetup.getPlayerCount());

        Player[] gamePlayers = new Player[gameSetup.getPlayerCount()];                                        // It creates an Array to store the instances of the objects.
        for(int i=0;i<gameSetup.getPlayerCount();i++){
            gamePlayers[i] = new Player(gameSetup.getBoardSize());                                          // For every loop a new object is created and assigned to the respective position in the array.

        }
        while(gameCondition.getCompletedPlayersCount() != gameSetup.getPlayerCount()){                          //If completed player count equals the total player count then the loop breaks

            for(int i=0;i<gameSetup.getPlayerCount();i++){                                                    // Executes for each player
                if(gamePlayers[i].isWin())continue;                                                           //Skips remaining instructions when current player already reached end
                int currDiceValue=0,throwLimit=3;
                do{
                    System.out.print("Player "+(i+1)+" : Press enter to roll the dice.");
                    try {
                        System.in.read();
                    }
                    catch(Exception e){
                        System.out.println("Maybe you have pressed the wrong key..");
                    }
                    int temp=gameDice.rollDice();
                    System.out.println("You have got : "+temp);
                    currDiceValue+=temp;
                    if(temp != gameDice.diceMax())break;
                    throwLimit--;
                }while(throwLimit>0);
                gamePlayers[i].addToCurrentPosition(currDiceValue);

                int currPosition = gamePlayers[i].getCurrentPosition();
                while((obstaclePositions.isItSnake(currPosition)!=-1)  || (obstaclePositions.isItLadder(currPosition)!=-1)){           //While loop is used because if there exist any chain of snakes and ladders
                    /*Checking that is it snake*/
                    if(obstaclePositions.isItSnake(currPosition)!=-1){
                        System.out.println("OOPS!! You have bitten by a snake at "+currPosition);
                        gamePlayers[i].updateCurrentPosition(obstaclePositions.isItSnake(currPosition));                            //Updating the current position
                        currPosition = gamePlayers[i].getCurrentPosition();                                                         //Updating the current position
                    }
                    /*Checking tha is it ladder*/
                    if(obstaclePositions.isItLadder(currPosition)!=-1){
                        System.out.println("Congrats you have got a ladder "+currPosition);
                        gamePlayers[i].updateCurrentPosition(obstaclePositions.isItLadder(currPosition));                           //Updating the current position
                        currPosition = gamePlayers[i].getCurrentPosition();                                                         //Updating the current position
                    }
                }
                if(gamePlayers[i].isWin())gameCondition.setCompletedPlayers(i);
                System.out.println("Player "+(i+1)+" current position is : "+currPosition);
            }
        }
        System.out.println("Rankings of the current game :");
        for(int i=0;i< gameSetup.getPlayerCount();i++){
            System.out.println((i+1)+". Player "+(gameCondition.getCompletedPlayersList(i)+1));
        }
    }
}


class WinCondition{
    private final int[] completedPlayers;
    private int lastPosition=0;
    WinCondition(int size){
        completedPlayers = new int[size];
    }

    void setCompletedPlayers(int position){
        completedPlayers[lastPosition] = position;
        lastPosition++;
    }
    int getCompletedPlayersList(int position){
        return completedPlayers[position];
    }
    int getCompletedPlayersCount(){
        return lastPosition;
    }


}
