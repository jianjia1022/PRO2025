import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Slice_o_Heaven {
public enum PizzaSelection{
        PEPPERONI("Pepperoni","Lots of pepperoni and extra cheese",18),
        HAWAIIAN("Hawaiian","Pineapple, ham, and extra cheese",22),
        VEGGIE("Veggie","Green pepper, onion, tomatoes, mushroom, and black olives",25),
        BBQ_CHICKEN("BBQ Chicken","Chicken in BBQ sauce, bacon, onion, green pepper and cheddar cheese",35),
        EXTRAVAGANZA("Extravaganza","Pepperoni, ham, Italian sausage, beef, onions,green pepper, mushrooms, black olives, and extra cheese",45);
    
        private final String pizzaName;
        private final String pizzaToppings;
        private final int price;
        private PizzaSelection(String pizzaName,String pizzaToppings,int price){
            this.pizzaName=pizzaName;
            this.pizzaToppings=pizzaToppings;
            this.price=price;
        }
        public String getPizzaName(){
            return pizzaName;
        }
        public String getPizzaToppings(){
            return pizzaToppings;
        }
        public int getPrice(){
            return price;
        }
        @Override
        public String toString(){
            return pizzaName+" with "+pizzaToppings+", for €"+price;
        }
    }
    public enum PizzaToppings{
        HAM("Ham", 2), 
        PEPPERONI("Pepperoni", 2),
        BEEF("Beef", 2),
        CHICKEN("Chicken", 2), 
        SAUSAGE("Sausage", 2),
        PINEAPPLE("Pineapple", 1),
        ONION("Onion", 0.5), 
        TOMATOES("Tomatoes", 0.4), 
        GREEN_PEPPER("Green Pepper", 0.5), 
        BLACK_OLIVES("Black Olives", 0.5), 
        SPINACH("Spinach", 0.5), 
        CHEDDAR_CHEESE("Cheddar Cheese", 0.8), 
        MOZZARELLA_CHEESE("Mozzarella Cheese", 0.8), 
        FETA_CHEESE("Feta Cheese", 1), 
        PARMESAN_CHEESE("Parmesan Cheese", 1);
        private final String topping;
        private final double toppingPrice;
        private PizzaToppings(String topping,double toppingPrice){
            this.topping=topping;
            this.toppingPrice=toppingPrice;
        }
        public String getTopping(){
            return topping;
        }
        public double getToppingPrice(){
            return toppingPrice;
        }
        @Override
        public String toString(){
            return "Topping: "+topping+"\n"+"Price"+toppingPrice+"\n";
        }
    }
    public enum PizzaSize{
        LARGE("Large", 10), 
        MEDIUM("Medium", 5),
        SMALL("Small", 0);
        private final String pizzaSize;
        private final int addToPizzaPrice;
        private PizzaSize(String pizzaSize,int addToPizzaPrice){
            this.pizzaSize=pizzaSize;
            this.addToPizzaPrice=addToPizzaPrice;
        }
        public String getPizzaSize(){
            return pizzaSize;
        }
        public int getAddToPizzaPrice(){
            return addToPizzaPrice;
        }
        @Override
        public String toString(){
            return "Pizza size: "+pizzaSize+"\n"+"Add pizza price: "+addToPizzaPrice;
        }
    }
    public enum SideDish{
        CALZONE("Calzone", 15), 
        CHICKEN_PUFF("Chicken Puff", 20),
        MUFFIN("Muffin", 12),
        NOTHING("No side dish", 0);
        private final String sideDishName;
        private final int addToPizzaPrice;
        private SideDish(String sideDishName,int addToPizzaPrice){
            this.sideDishName=sideDishName;
            this.addToPizzaPrice=addToPizzaPrice;
        }
        public String getSideDishName(){
            return sideDishName;
        }
        public int getAddToPizzaPrice(){
            return addToPizzaPrice;
        }
        @Override
        public String toString(){
            return "Side dish: "+sideDishName+"\n"+"Add pizza price: "+addToPizzaPrice;
        }
    }
    public enum Drinks{
        COCA_COLA("Coca Cola", 8), 
        COCOA_DRINK("Cocoa Drink", 10),
        NOTHING("No drinks", 0);
        private final String drinkName;
        private final int addToPizzaPrice;
        private Drinks(String drinkName,int addToPizzaPrice){
            this.drinkName=drinkName;
            this.addToPizzaPrice=addToPizzaPrice;
        }
        public String getDrinkName(){
            return drinkName;
        }
        public int getAddToPizzaPrice(){
            return addToPizzaPrice;
        }
        @Override
        public String toString(){
            return "Drink: "+drinkName+"\n"+"Add pizza price: "+addToPizzaPrice;
        }
    }

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
    public int ingChoice4;
    public int sizeChoice;
    public int sideDishChoice;
    public int drinkChoice;
    public String pizzaSize;
    public String extraCheese;
    public String sideDish;
    public String wantDiscount;
    public int whether;
    final long blackCardNumber=12345678987654L;
    final String DEF_ORDER_ID="DEF-SOH-099";
    final String DEF_PIZZA_INGREDIENTS="Mozzarella Cheese";
    final double DEF_ORDER_TOTAL=15.00;
    final double PIZZA_BASE_PRICE=10.0;
    private static final String[] pizzaOrdered=new String[10];
    private static final String[] pizzaSizesOrdered=new String[10];
    private static final String[] sideDishesOrdered=new String[20];
    private static final String[] drinksOrdered=new String[20];
    private static int orderIndex=0;
    private static double totalorderPrice=0;
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
    
    public void takeOrder(){
        while (true){      
            System.out.println("Welcome to Slice-o-Heaven Pizzeria. Here's what we serve: ");
            PizzaSelection pizzaSelection[]=PizzaSelection.values();
            for(int i=0;i<PizzaSelection.values().length;i++){
                System.out.println((i+1)+". "+pizzaSelection[i]);
            }
            System.out.println((PizzaSelection.values().length+1)+". Custom Pizza with a maximum of 10 toppings that you choose.");
            System.out.println("Please enter your choose(1-6): ");
            do{
            ingChoice1=input.nextInt();
            if(ingChoice1<1||ingChoice1>6){
                System.out.println("Invalid choices. Please pick only from the given list: \n");
            } 
            }while(ingChoice1<1||ingChoice1>6);
    
            if(ingChoice1>=1&&ingChoice1<=PizzaSelection.values().length){
                PizzaSelection selectedPizza=PizzaSelection.values()[ingChoice1-1];
                pizzaOrdered[orderIndex]=selectedPizza.getPizzaName()+": €"+selectedPizza.getPrice();
                totalorderPrice+=selectedPizza.getPrice();
            }
            else if(ingChoice1==PizzaSelection.values().length+1){
                System.out.println("Availble toppings: ");
                PizzaToppings pizzatoppings[]=PizzaToppings.values();
                for(int j=0;j<PizzaToppings.values().length;j++){
                    System.out.println((j+1)+"."+pizzatoppings[j]);
                }
                StringBuilder customerToppingChoice=new StringBuilder("Custom Pizza with ");        
                double customPizzaPrice=PIZZA_BASE_PRICE;
                input.nextLine();
                String customTopping[];
                do{
                   System.out.println("Please enter a maimum of 10 choices (separated by commas): ");
                   customTopping=input.nextLine().split(",");
                   if(customTopping.length>10){
                    System.out.println("You entered more than 10 choices. Please try again: ");
                   } 
                }while(customTopping.length>10);
                    for(int a=0;a<customTopping.length;a++){
                    int toppingNumber=Integer.parseInt(customTopping[a]);
                    for(int b=0;b<pizzatoppings.length;b++){
                        if(toppingNumber==(b+1)){
                            customerToppingChoice.append(pizzatoppings[b].getTopping());
                            customPizzaPrice+=pizzatoppings[b].getToppingPrice();
                        }
                    }
                }
            
                customerToppingChoice.append(",");
                pizzaOrdered[orderIndex]=customerToppingChoice.toString()+": €"+customPizzaPrice;
                totalorderPrice+=customPizzaPrice;
            }
            
                System.out.println("Availble pizza size: ");
                PizzaSize pizzaSize[]=PizzaSize.values();
                for(int i=0;i<PizzaSize.values().length;i++){
                    System.out.println((i+1)+". "+pizzaSize[i]);
                }
                System.out.println("Please enter your pizza size: ");
                do{
                ingChoice2=input.nextInt();
                if(ingChoice2<1||ingChoice2>PizzaSize.values().length){
                    System.out.println("Invalid choices. Please pick only from the given list: " );
                }
                }while(ingChoice2<1||ingChoice2>PizzaSize.values().length);
                if(ingChoice2>=1&&ingChoice2<=PizzaSize.values().length){
                    PizzaSize selectedSize=PizzaSize.values()[ingChoice2-1];
                    pizzaSizesOrdered[orderIndex]=selectedSize.getPizzaSize()+": €"+selectedSize.getAddToPizzaPrice();
                    totalorderPrice+=selectedSize.getAddToPizzaPrice();
                }
    
                System.out.println("Available side dishes: ");
                SideDish sidedish[]=SideDish.values();
                for(int i=0;i<SideDish.values().length;i++){
                    System.out.println((i+1)+". "+sidedish[i]);
                }
                System.out.println("Please enter your side dishes: ");
                do{
                ingChoice3=input.nextInt();
                if(ingChoice3<1||ingChoice3>SideDish.values().length){
                    System.out.println("Invalid choices. Please pick only from the given list: ");
                }
                }while(ingChoice3<1||ingChoice3>SideDish.values().length);
                if(ingChoice3>=1&&ingChoice3<=SideDish.values().length){
                    SideDish selectedSideDish=SideDish.values()[ingChoice3-1];
                    sideDishesOrdered[orderIndex]=selectedSideDish.getSideDishName()+": €"+selectedSideDish.getAddToPizzaPrice();
                    totalorderPrice+=selectedSideDish.getAddToPizzaPrice();
                }
    
                System.out.println("Available drinks: ");
                Drinks drinks[]=Drinks.values();
                for(int i=0;i<Drinks.values().length;i++){
                    System.out.println((i+1)+". "+drinks[i]);
                }
                System.out.println("Please enter your drinks: ");
                do{
                    ingChoice4=input.nextInt();
                    if(ingChoice4<1||ingChoice4>Drinks.values().length){
                        System.out.println("Invalid choices. Please pick only from the given list: ");
                    }
                }while(ingChoice4<1||ingChoice4>Drinks.values().length);
                if(ingChoice4>=1&&ingChoice4<=Drinks.values().length){
                    Drinks selectedDrinks=Drinks.values()[ingChoice4-1];
                    drinksOrdered[orderIndex]=selectedDrinks.getDrinkName()+": €"+selectedDrinks.getAddToPizzaPrice();
                    totalorderPrice+=selectedDrinks.getAddToPizzaPrice();
                }
    
                orderIndex++;
            
            System.out.println("Do you want to place another order? (1 for Yes, any onther number for No): ");
            int continueChoice=input.nextInt();
            input.nextLine();
            if(continueChoice!=1){
                break;
                }   
        }
        
        System.out.println("Do you want to have a discount?");
        wantDiscount=input.nextLine();
        if(wantDiscount.equals("Y")||wantDiscount.equals("y")){
            isItyourBirthday();
        }
       
        makeCardPayment();
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
        while (cardNumber1.length()!=14||cardNumber==blackCardNumber){
            System.out.println("\nInvalid card");
            System.out.println("Enter your card number again: ");
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
        StringBuilder receipt=new StringBuilder("Thank you for dining with Slice-o-Heaven Pizzeria. Your order details are as follows: \n");
            for(int i=0;i<orderIndex;i++){
            receipt.append((i+1)+". "+pizzaOrdered[i]+"\n");
            receipt.append(pizzaSizesOrdered[i]+"\n");
            receipt.append(sideDishesOrdered[i]+"\n");
            receipt.append(drinksOrdered[i]+"\n"); 
        }
            if(whether==1){
            receipt.append("ORDER TOTAL: €"+totalorderPrice*0.5);
            }
            else{
                receipt.append("ORDER TOTAL: €"+totalorderPrice);
            }
   
        return receipt.toString();
        }
    }