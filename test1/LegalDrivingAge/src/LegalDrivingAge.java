import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class LegalDrivingAge {
    private int age;
    public int calculateAge(){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter your birthdate(YYYY-MM-DD): ");
        String birthdate=input.nextLine();

        int year=Integer.parseInt(birthdate.substring(0,4));
        int month=Integer.parseInt(birthdate.substring(5, 7));
        int day=Integer.parseInt(birthdate.substring(8, 10));
        //int year=input.nextInt();
        //int month=input.nextInt();
        //int day=input.nextInt();
        //separate with spaces

        LocalDate dob=LocalDate.of(year, month, day);
        LocalDate now=LocalDate.now();

        Period diff=Period.between(dob, now);

        System.out.println("You are "+diff.getYears()+" years old");
        input.close();
        return diff.getYears();
    }
    public void isLegalAge(){
        age=calculateAge();
        if(age<18){
            System.out.println("You are illegal age to drive");
        }
        else{
            System.out.println("You are legal age to drive");
        }
    }
}

