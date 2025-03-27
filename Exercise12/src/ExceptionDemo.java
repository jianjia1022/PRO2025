import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo {
    private double divisor;
    private double dividend;
    private double result;

    Scanner input=new Scanner(System.in);
    public void divide() throws InputMismatchException,ArithmeticException{
        System.out.println("Enter the divisor: ");
        divisor=input.nextDouble();
        input.nextLine();
        System.out.println("Enter the dividend: ");
        dividend=input.nextDouble();
        input.nextLine();
        result=divisor/dividend;
    }

    public void goToDivideMethod() throws InputMismatchException, ArithmeticException{
        divide();
    }

    public void readAFile() throws InputMismatchException,MissingExtensionException{
        System.out.println("Enter the file name: ");
        String fileName=input.nextLine();
        if(!fileName.contains(".")){
            throw new MissingExtensionException("The file name is missing an extension!");
        }
        
    }

    public void displayChoices(){
        while(true){
            System.out.println("1. Divide");
            System.out.println("2. Read from a file");
            System.out.println("3. Exit");

            try {
                int choice=input.nextInt(); 
                if(choice==1){
                    try {
                        goToDivideMethod();
                        System.out.println("The result is: "+result);
                    } catch (Exception e) {
                        System.out.println("Calculate Error!"+e);
                    }
                    input.close();
                }else if(choice==2){
                    try {
                        readAFile();
                    } catch (IOException e) {
                        System.out.println("Read Error!"+e);
                    } catch (MissingExtensionException e) {
                        System.out.println("Extension Error!"+e);
                    }
                    input.close();
                }else if(choice==3){
                    System.out.println("Goodbye!");
                    break;
                }else{
                    System.out.println("Invalid choice!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!"+e);
                input.nextLine();
            }
        }
        input.close();
    }
}
