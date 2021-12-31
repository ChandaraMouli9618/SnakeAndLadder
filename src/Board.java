// Initialises the board of given size.
// Takes input for snake and ladder positions.
// Consists the getter functions to check weather the current position is snake of a ladder.

import java.util.Scanner;

public class Board {
    static SnakeLadderPositions Positions = new SnakeLadderPositions();

    static void runBoardSetup(int size){
        int SnakeCount=0;
        int LadderCount=0;
        Scanner Sc = new Scanner(System.in);



        do{
            System.out.println("Enter Number of Snakes(Range 2->"+((size/2)*(size/2))+") :");
            try{
                SnakeCount = Sc.nextInt();
                if(SnakeCount<2 || SnakeCount>((size/2)*(size/2))) System.out.println("Invalid Snake count !!");
            }catch(Exception e){
                System.out.println("Invalid Snake count !!");
                Sc.next();
            }
        }while(SnakeCount<2 || SnakeCount>((size/2)*(size/2)));

        for(int i=0;i<SnakeCount;i++){
            int result = addSnake(size,i+1);
            if(result == 1){
                System.out.println("Values are out of range\nTry again.");
                i--;
            }else if(result == 2){
                System.out.println("Head should be greater than Tail\nTry again.");
                i--;
            }else if(result == 3){
                System.out.println("Two snakes cannot have same head\nTry again.");
                i--;
            }
        }

        do{
            System.out.println("Enter Number of Ladders(Range 2->"+((size/2)*(size/2))+") :");
            try{
                LadderCount = Sc.nextInt();
                if(LadderCount<2 || LadderCount>((size/2)*(size/2))) System.out.println("Invalid Ladder count !!");
            }catch(Exception e){
                System.out.println("Invalid Ladder count !!");
                Sc.next();
            }
        }while(LadderCount<2 || LadderCount>((size/2)*(size/2)));

        for(int i=0;i<LadderCount;i++){
            int result = addLadder(size,i+1);
            if(result == 1){
                System.out.println("Values are out of range\nTry again.");
                i--;
            }else if(result == 2){
                System.out.println("Head should be greater than Tail\nTry again.");
                i--;
            }else if(result == 3){
                System.out.println("Two Ladders cannot have same tail\nTry again.");
                i--;
            }else if(result == 4){
                System.out.println("Tail of ladder cannot exist at head of a snake\nTry again.");
                i--;
            }
        }


    }

    static int addLadder(int size,int ladderNumber){
        Scanner Sc = new Scanner(System.in);
        do{
            System.out.println("Enter Tail and Head of ladder "+ladderNumber+" respectively :");
            try{
                int tail = Sc.nextInt();
                int head = Sc.nextInt();
                if(head > (size*size) || head == 1)return 1;
                else if(tail >= head)return 2;
                else if(Positions.isItLadder(tail) != -1)return 3;
                else if(Positions.isItSnake(tail) != -1)return 4;
                Positions.setLadderPosition(tail,head);
                return 0;
            }catch(Exception e){
                System.out.println("Invalid Head or Tail !!");
                Sc.next();
            }
        }while(true);
    }



    static int addSnake(int size,int snakeNumber){
        Scanner Sc = new Scanner(System.in);
        do{
            System.out.println("Enter Head and Tail of snake "+snakeNumber+" respectively :");
            try{
                int head = Sc.nextInt();
                int tail = Sc.nextInt();
                if(head >= (size*size) || head == 1)return 1;
                else if(tail >= head)return 2;
                else if(Positions.isItSnake(head) != -1)return 3;
                Positions.setSnakePosition(head,tail);
                return 0;
            }catch(Exception e){
                System.out.println("Invalid Head or Tail !!");
                Sc.next();
            }
        }while(true);
    }
}



