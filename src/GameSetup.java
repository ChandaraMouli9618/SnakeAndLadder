//Initialises the basic parameters like board size,player count etc.
//Consists the getter functions basic variables

import java.util.Scanner;

public class GameSetup {
    private int boardSize = 10;
    private int playerCount = 2;
    private int diceCount = 1;

    GameSetup(){
        Scanner Sc = new Scanner(System.in);
        System.out.println("Welcome to Snake and Ladder Game");

        /*Input For Default Configuration*/
        char defaultConfig;
        do{
            System.out.println("Do you want to play with the default configurations(2 Player,10 X 10 Grid, 1 Dice) (Y/N) : ");
            defaultConfig = Sc.next().charAt(0);
            if(defaultConfig == 'Y' || defaultConfig == 'y'){
                return;
            }
            if(defaultConfig != 'N' && defaultConfig != 'n')
                System.out.println("Invalid Input!!");
        }while(defaultConfig != 'N' && defaultConfig != 'n');

        /*Input For Board size*/
        do{
            System.out.println("Enter custom board size (Minimum size is 5) : ");
            try{
                boardSize = Sc.nextInt();
                if(boardSize<2) System.out.println("Invalid board size !!");

            }catch (Exception e){
                System.out.println("Invalid board size !!");
                Sc.next();
                boardSize=0;
            }
        }while(boardSize<5);


        /*Input For Number of players*/
        do{
            System.out.println("Enter number of players (Minimum number of players is 2): ");
            try{
                playerCount = Sc.nextInt();
                if(playerCount<2) System.out.println("Invalid player count !!");
            }catch(Exception e){
                System.out.println("Invalid player count !!");
                Sc.next();
                playerCount=0;
            }
        }while(playerCount<2);


        /*Input For Dice count*/
        do{
            System.out.println("Enter number of dice (1,2 or 3) : ");
            try{
                diceCount = Sc.nextInt();
                if(diceCount<1 || diceCount>3) System.out.println("Invalid dice count !!");
            }catch(Exception e){
                System.out.println("Invalid dice count !!");
                Sc.next();
                diceCount=0;
            }
        }while(diceCount<1 || diceCount>3);
    }


    //Getter functions for private variables.

    int getBoardSize(){
        return boardSize;
    }
    int getPlayerCount(){
        return playerCount;
    }
    int getDiceCount(){
        return diceCount;
    }
}
