import java.util.Scanner;
import java.util.Random;


public class Task_1_Guessing_game_with_point {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of Rounds You want to Play!");
        int round = sc.nextInt();
        int pointsum = 0;
        for(int i=0;i<round;i++){
            System.out.println("Round " + (i+1));
            Random random = new Random();
            int rannum = random.nextInt(99) + 1;
            System.out.println("Enter the Guess Number");
            int t=0;
            int point=0;
            System.out.println("No. of Attmepts are 8");
            int Attempt =8;
            while(rannum != t ){

                t=sc.nextInt();
                Attempt = Attempt-1;


                if(Attempt==0){
                    System.out.println("Attempts are over. Better luck Next Time");
                    break;
                }
                else if(t<rannum){
                    System.out.println("Guess Number is Too Low. Guess again! ");
                    point = point -10;
                }
                else if(t>rannum){
                    System.out.println("Guess Number is Too High. Guess again! ");
                    point = point -10;


                }
                else{
                    System.out.println("Guess Number is Equal to Random number.  ");
                    System.out.println("You Won! ");
                    point = point + 50;
                    break;
                }
                System.out.println("No. of Attempt left = " + Attempt);

            }
            System.out.println("No. of Point = " + point);
            pointsum = pointsum + point;
        }
        System.out.println("Total number of Points of " +round +" Rounds are = " +pointsum);
    }
}
