import java.util.Scanner;

public class Task_2_Grade_Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Total number of Subjects");

        int subject = sc.nextInt();
        int total=0;
        System.out.println("Enter Marks of Each Subject");
        for(int i=0;i<subject;i++){

            int marks = sc.nextInt();
            total = total + marks;
        }

        float Averageper =(float)total/subject;
        System.out.println("Total Marks : "+ total);
        System.out.println("Average Percentage : " +Averageper );
        System.out.print("Grade is : ");
        if(Averageper>=80){
            System.out.print("O");
        }
        else if(Averageper>=70 && Averageper<80){
            System.out.print("A+");
        }
        else if(Averageper>=60 && Averageper<70){
            System.out.print("A");
        }
        else if(Averageper>=55 && Averageper<60){
            System.out.print("B+");
        }
        else if(Averageper>=50 && Averageper<55){
            System.out.print("B");
        }
        else if(Averageper>=40 && Averageper<50){
            System.out.print("C");
        }
        else if(Averageper<40){
            System.out.print("F");
        }
    }
}
