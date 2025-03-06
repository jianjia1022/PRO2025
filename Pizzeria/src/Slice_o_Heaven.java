import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Slice_o_Heaven {
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
    public int ingChoice1;
    public int ingChoice2;
    public int ingChoice3;
    public int sizeChoice;
    public int sideDishChoice;
    public int drinkChoice;
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
    Scanner input=new Scanner(System.in);

    public Slice_o_Heaven(){
        orderID=DEF_ORDER_ID;
        pizzaIngredients=DEF_PIZZA_INGREDIENTS;
        orderTotal=DEF_ORDER_TOTAL;

    }
    public Slice_o_Heaven(String orderID,String pizzaIngredients,double orderTotal){
        this.orderID=orderID;
        this.pizzaIngredients=pizzaIngredients;
        this.orderTotal=orderTotal;
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
    public String ingredients(int num){
        String choice = null;
        switch (num) {
            case 1:
                choice="Mushroom";
                break;
            case 2:
                choice="Paprika";
                break;
            case 3:
                choice="Sun-dried tomatoes";
                break;
            case 4:
                choice="Chicken";
                break;
            case 5:
                choice="Pineapple";
                break;
            default:
                break;
        }
        return choice;
    }
    public String Size(int num1){
        String size=null;
        switch (num1) {
            case 1:
                size="Large";
                break;
            case 2:
                size="Medium";
                break;
            case 3:
              size="Small";
                break;
            default:
                break;
        }return size;
    }

    public String sides(int num2){
        String sides=null;
        switch (num2) {
            case 1:
                sides="Calzone";
                break;
            case 2:
                sides="Garlic bread";
                break;
            case 3:
                sides="Chicken puff";
                break;
            case 4:
                sides="Muffin";
                break;
            case 5:
                sides="Nothing for me";
                break;
            default:
                break;
        }return sides;
    }

    public String drinkss(int num3){
        String drinkss=null;
        switch (num3) {
            case 1:
                drinkss="Coca Cola";
                break;
            case 2:
                drinkss="Cold coffee";
                break;
            case 3:
                drinkss="Cocoa Drink";
                break;
            case 4:
                drinkss="No drinks for me";
                break;
            default:
                break;
        }return drinkss;
    }

    public void takeOrder(){
        do{
        System.out.println("Please pick any three of the following ingredients: ");
        System.out.println("1. Mushroom");
        System.out.println("2. Paprika");
        System.out.println("3. Sun-dired tomatoes");
        System.out.println("4. Chicken");
        System.out.println("5. Pineapple");
        System.out.println("Enter any three choices (1, 2, 3,...) separated by spaces: ");
        ingChoice1=input.nextInt();
        ingChoice2=input.nextInt();
        ingChoice3=input.nextInt();
        input.nextLine();
        if(ingChoice1<1||ingChoice1>5||ingChoice2<1||ingChoice2>5||ingChoice3<1||ingChoice3>5){
            System.out.println("Invalid choices. Please pick only from the given list: \n");
        } 
    }while(ingChoice1<1||ingChoice1>5||ingChoice2<1||ingChoice2>5||ingChoice3<1||ingChoice3>5);

    ing1=ingredients(ingChoice1);
    ing2=ingredients(ingChoice2);
    ing3=ingredients(ingChoice3);
    System.out.println("You choose "+ing1+", "+ing2+", "+ing3);

    do{
        System.out.println("What size should your pizza be?");
        System.out.println("1. Large");
        System.out.println("2. Medium");
        System.out.println("3. Small");
        System.out.println("Enter only one choice (1, 2, or 3): ");
        sizeChoice=input.nextInt();
        if(sizeChoice<1||sizeChoice>3){
            System.out.println("Invalid choices. Please pick only from the given list: \n");
        } 
    }while(sizeChoice<1||sizeChoice>3);
        pizzaSize=Size(sizeChoice);
        System.out.println("Your pizza size is "+pizzaSize+"\n");

        input.nextLine();
        System.out.println("Do you want extra cheese(Y/N): ");
        extraCheese=input.nextLine();
       
        do{
        System.out.println("\nFollowing are the side dish that go well with your pizza: ");
        System.out.println("1. Calzone");
        System.out.println("2. Garlic bread");
        System.out.println("3. Chicken puff");
        System.out.println("4. Muffin");
        System.out.println("5. Nothing for me");
        System.out.println("What would you like? Pick one(1, 2, 3,...): ");
        sideDishChoice=input.nextInt();
        if(sideDishChoice<1||sideDishChoice>5){
            System.out.println("Invalid choices. Please pick only from the given list: \n");
        } 
        }while(sideDishChoice<1||sideDishChoice>5);
        sideDish=sides(sideDishChoice);
        System.out.println("You choose "+sideDish);

        do{
        System.out.println("Choose from one of the drinks below. We recommend Coca Cola: ");
        System.out.println("1. Coca Cola");
        System.out.println("2. Cold coffee");
        System.out.println("3. Cocoa drink");
        System.out.println("4. No drinks");
        System.out.println("Enter your choice: ");
        drinkChoice=input.nextInt();
        if(drinkChoice<1||drinkChoice>4){
            System.out.println("Invalid choices. Please pick only from the given list: \n");
        } 
        }while(drinkChoice<1||drinkChoice>4);
        drinks=drinkss(drinkChoice);
        System.out.println("You choose "+drinks);

        input.nextLine();
        System.out.println("Would you like the chance to pay only half for your order?(Y/N): ");
        String wantDiscount=input.nextLine();

        if(wantDiscount.equals("Y")||wantDiscount.equals("y")){
            isItyourBirthday();
        }
       
        makeCardPayment();
        input.close();
    }

    public void isItyourBirthday(){
        int age;
        LocalDate dob=null;
        LocalDate now=LocalDate.now();
        
        System.out.println("Enter your birthdate(YYYY-MM-DD): ");
        do{
        String birthdate=input.nextLine();
        int year=Integer.parseInt(birthdate.substring(0,4));
        int month=Integer.parseInt(birthdate.substring(5, 7));
        int day=Integer.parseInt(birthdate.substring(8, 10));
        dob=LocalDate.of(year, month, day);
        Period diff=Period.between(dob, now);
        age=diff.getYears();
        if(age<5||age>120){
            System.out.println("Invalid date. You are either too young or too dead to order.");
            System.out.println("Please enter a valid date: ");
        }
    }while(age<5||age>120);
        if(age<18 && dob.getDayOfYear()==now.getDayOfYear()){
            whether=1;
            System.out.println("Congratulations! You pay only half the price for your order.");
        }else{
            whether=0;
            System.out.println("Too bad! You do not meet the conditions to get our 50% discount.");
        }
    }

    public void makeCardPayment(){
        
        LocalDate ed=null;
        LocalDate no=LocalDate.now();
        do{
        System.out.println("Enter your card number: ");
        cardNumber=input.nextLong();
        input.nextLine();
        System.out.println("Enter your card expiry date: ");
        expiryDate=input.next();
        int year=Integer.parseInt(expiryDate.substring(0,4));
        int month=Integer.parseInt(expiryDate.substring(5, 7));
        int day=Integer.parseInt(expiryDate.substring(8, 10));
        ed=LocalDate.of(year, month, day);
        if(no.isAfter(ed)){
            System.out.println("Your card is inavailble");
            System.out.println("Please enter another card");
        }
    }while(no.isAfter(ed));

        System.out.println("Enter your card cvv: ");
        cvv=input.nextInt();
        
        processCardPayment(cardNumber,expiryDate,cvv);
        makePizza();
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
        while (cardNumber1.length()!=14){
            System.out.println("\nInvalid card");
            makeCardPayment();
            cardNumber=input.nextLong();
            cardNumber1=Long.toString(cardNumber);       
        }

        if(cardNumber==blackCardNumber){
            System.out.println("\nCard is blacklisted. Please use another card.");
            makeCardPayment();
            cardNumber=input.nextLong();
            cardNumber1=Long.toString(cardNumber);
        }

        firstCardDigit=Integer.parseInt(cardNumber1.substring(0, 1));
        lastFourDigits=Integer.parseInt(cardNumber1.substring(cardNumber1.length()-4, cardNumber1.length()));
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
    @Override
    public String toString(){
        StringBuilder receipt=new StringBuilder();
            receipt.append("Your order is ready!");
            receipt.append("\n******RECEIPT******");
            receipt.append("\nOrder ID: "+orderID);
            receipt.append("\nCard number: "+cardNumberToDisplay);
            receipt.append("\nPizza ingredients: "+ ing1 +","+ing2+","+ing3);
            receipt.append("\nExtra cheese: "+extraCheese);
            receipt.append("\nSide dish: "+sideDish);
            receipt.append("\nDrinks: "+drinks);
        if(whether==1){
            receipt.append("\nOrder Total: "+orderTotal*0.5);  
        }else if(whether==0){
            receipt.append("\nOrder Total: "+orderTotal);
        }
        return receipt.toString();
        }
    }