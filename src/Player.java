//It consists the current position of a player
//It also consists functions to check current position, is player won and also has functions to update the position of player.

public class Player {
    private int currentPosition=0;
    private final int size;
    Player(int size){
        this.size = size;// this.size refers to the instance variable size.
    }

    int getCurrentPosition(){
        return currentPosition;
    }

    boolean isWin(){
        return currentPosition == (size * size);
    }

    void addToCurrentPosition(int increment){
        if(currentPosition+increment > (size*size)){
            System.out.println("You cannot move!!");
            return;
        }
        currentPosition += increment;
    }

    void updateCurrentPosition(int value){
        currentPosition = value;
    }
}
