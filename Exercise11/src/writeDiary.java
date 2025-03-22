import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.util.Scanner;

public class writeDiary {
    public static void main(String[] args) {
        String filepath="Diary.txt";
        try  {
            FileWriter fileWriter=new FileWriter(filepath);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);

            Scanner input=new Scanner(System.in);
            System.out.println("Enter the date: ");
            while (true) {
                String diary=input.nextLine();
                    if ("END".equalsIgnoreCase(diary)) {
                        break;
                    } 
                bufferedWriter.write(diary);
                bufferedWriter.newLine();   
            }
            System.out.println("Diary saved successfully!");
            input.close();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
