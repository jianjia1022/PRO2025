import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Grocery {
    String inputpath="c:\\Users\\USER\\Downloads\\Groceries.txt";
    String outputpath="GroceriesFormatted.txt";

    String[] groceryArray=new String[4];

    String delimeter=",";
    String scan="";

    int id;
    String item;
    String quantity;
    double price;
    double total=0;
    String head;
    String lines;

     public void grocery() {
    
    try{
        FileReader fileReader=new FileReader(inputpath);
        FileWriter fileWriter=new FileWriter(outputpath);

        BufferedReader bufferedReader=new BufferedReader(fileReader);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);

        scan=bufferedReader.readLine();
        head="ID#"+"\t"+"Item"+"\t"+"Quantity"+"\t\t"+"Price (€)"+".";
        String star="*".repeat(50);
        System.out.println(head);

        bufferedWriter.write(star);
        bufferedWriter.newLine();
        bufferedWriter.write(head);
        bufferedWriter.newLine();
        bufferedWriter.write(star);
        bufferedWriter.newLine();

        while(scan!=null){
            groceryArray=scan.split(delimeter);
            id=Integer.parseInt(groceryArray[0]);
            item=groceryArray[1];
            quantity=groceryArray[2];
            price=Double.parseDouble(groceryArray[3]);
            total+=price;

            lines=id+"\t"+item+"\t\t"+quantity+"\t\t"+price+".";
            System.out.println(lines);

            bufferedWriter.write(lines);
            bufferedWriter.newLine();
            scan=bufferedReader.readLine();
        }
        bufferedReader.close();
        bufferedWriter.write(star);
        bufferedWriter.newLine();
        bufferedWriter.write("The grocery shopping total is: €"+Math.round(total));
        bufferedWriter.newLine();
        System.out.println("The grocery shopping total is: €"+Math.round(total));
        bufferedWriter.write(star);

        bufferedWriter.flush();
        bufferedWriter.close();
    }catch(IOException e){
        System.out.println("File not found"); 
    }
}
}