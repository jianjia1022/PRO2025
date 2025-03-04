import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Slice_o_Heaven {
    private Scanner input;
    public String storeName;
    public String storeAddress;
    public String storeEmail;
    public long storePhone;
    public String storeMenu;
    public String pizzaIngredients;
    public double pizzaPrice;
    public String sides;
    public String drinks;
    private String orderID;
    public String orderDetail;
    private double orderTotal;
    private long cardNumber;
    private String expiryDate;
    private int cvv;
    private int firstCardDigit;
    private int lastFourDigits;
    public String cardNumberToDisplay;
    public String ing1;
    public String ing2;
    public String ing3;
    public String pizzaSize;
    public String extraCheese;
    public String sideDish;
    public String wantDiscount;
    public int whether;
    final long blackCardNumber=12345678987654L;
    final String DEF_ORDER_ID="DEF-SOH-099";
    final String DEF_PIZZA_INGREDIENTS="Mozzarella Cheese";
    final double DEF_ORDER_TOTAL=15.00;


    public Slice_o_Heaven(){
        orderID=DEF_ORDER_ID;
        pizzaIngredients=DEF_PIZZA_INGREDIENTS;
        orderTotal=DEF_ORDER_TOTAL;
        input=new Scanner(System.in);
    }
    public Slice_o_Heaven(String orderID,String pizzaIngredients,double orderTotal){
        this.orderID=orderID;
        this.pizzaIngredients=pizzaIngredients;
        this.orderTotal=orderTotal;
        input=new Scanner(System.in);
    }
    public String getOrderID(){
        return orderID;
    }
    public void setOrderID(String orderID){
        this.orderID=orderID;
    }
    public String getPizzaIngredients(){
        return pizzaIngredients;
    }
    public void setPizzaIngredients(String pizzaIngredients){
        this.pizzaIngredients=pizzaIngredients;
    }
    public double getOrderTotal(){
        return orderTotal;
    }
    public void setOrderTotal(double orderTotal){
        this.orderTotal=orderTotal;
    }
    public void takeOrder(){
        System.out.println("Enter three ingredients for your pizza(use spaces to separate ingredients): ");
        ing1=input.next();
        ing2=input.next();
        ing3=input.next();
        input.nextLine();
        System.out.println("Enter siza of pizza(Small, Medium, Large): ");
        pizzaSize=input.nextLine();

        System.out.println("Do you want extra cheese(Y/N): ");
        extraCheese=input.nextLine();

        System.out.println("Enter one side dish(Calzone, Garlic bread, None): ");
        sideDish=input.nextLine();

        System.out.println("Enter drinks(Cold Coffee, Cocoa drink, Coke, None): ");
        drinks=input.nextLine();

        System.out.println("Would you like the chance to pay only half for your order?(Y/N): ");
        String wantDiscount=input.nextLine();

        if(wantDiscount.equals("Y")||wantDiscount.equals("y")){
            isItyourBirthday();
        }
       
        makeCardPayment();
        makePizza();
        printReceipt();
        input.close();
    }

    public void isItyourBirthday(){
        System.out.println("Enter your birthdate(YYYY-MM-DD): ");
        String birthdate=input.nextLine();

        int year=Integer.parseInt(birthdate.substring(0,4));
        int month=Integer.parseInt(birthdate.substring(5, 7));
        int day=Integer.parseInt(birthdate.substring(8, 10));
        LocalDate dob=LocalDate.of(year, month, day);
        LocalDate now=LocalDate.now();

        Period diff=Period.between(dob, now);
        int age=diff.getYears();
        

        if(age<18 && dob.getDayOfYear()==now.getDayOfYear()){
            whether=1;
            System.out.println("Congratulations! You pay only half the price for your order.");
        }else{
            whether=0;
            System.out.println("Too bad! You do not meet the conditions to get our 50% discount.");
        }
    }

    public void makeCardPayment(){
        System.out.println("Enter your card number: ");
        cardNumber=input.nextLong();
        
        System.out.println("Enter your card expiry date: ");
        expiryDate=input.next();
        
        System.out.println("Enter your card cvv: ");
        cvv=input.nextInt();
        
        processCardPayment(cardNumber,expiryDate,cvv);
    }

    private void makePizza(){
        System.out.println("Your pizza is making!");
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            System.out.println("Pizza is ready for pickup!");
        }
    }
   
    public void processCardPayment(long cardNumber,String expiryDate,int cvv){
        String cardNumber1=Long.toString(cardNumber);
        if(cardNumber1.length()==14){
            System.out.println("\nCard accepted");
        }
        else{
            System.out.println("\nInvalid card");
        }
        firstCardDigit=Integer.parseInt(cardNumber1.substring(0, 1));
        if(cardNumber==blackCardNumber){
            System.out.println("\nCard is blacklisted. Please use another card.");
        }
        int year=Integer.parseInt(expiryDate.substring(0,4));
        int month=Integer.parseInt(expiryDate.substring(5, 7));
        int day=Integer.parseInt(expiryDate.substring(8, 10));
        LocalDate ed=LocalDate.of(year, month, day);
        LocalDate no=LocalDate.now();
        if(ed.isAfter(no)){
            System.out.println("Your card is availble");
        }else{
            System.out.println("Your card is inavailable");
        }
        lastFourDigits=Integer.parseInt(cardNumber1.substring(10, 14));
        String middle=cardNumber1.substring(1,cardNumber1.length()-4);
        String replace=middle.replaceAll("\\d","*");
        cardNumberToDisplay=firstCardDigit+replace+lastFourDigits;
        System.out.println(cardNumberToDisplay);

 
    }
    public void specialOfTheDay(String pizzaOfTheDay,String sideOftheDay,double specialPrice){
        System.out.println("Today's special pizza: "+pizzaOfTheDay);
        System.out.println("Today's special sides: "+sideOftheDay);
        System.out.println("Today's special price: "+specialPrice);
    }
     private void printReceipt(){
        
        System.out.println("Your order is ready!");
        System.out.println("******RECEIPT******");
        System.out.println("Order ID: "+orderID);
        System.out.println("Card number: "+cardNumberToDisplay);
        System.out.println("Pizza ingredients: "+ ing1 +","+ing2+","+ing3);
        System.out.println("Extra cheese: "+extraCheese);
        System.out.println("Side dish: "+sideDish);
        System.out.println("Drinks: "+drinks);
        if(whether==1){
            System.out.println("Order Total: "+orderTotal*0.5);  
        }else if(whether==0){
            System.out.println("Order Total: "+orderTotal);
        }

        }
    }
