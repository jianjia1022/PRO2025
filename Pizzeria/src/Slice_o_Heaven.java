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
    private int firstCardDigit;
    private int lastFourDigits;
    public String cardNumberToDisplay;
    final String blackCardNumber="12345678987654";
    final String DEF_ORDER_ID="DEF-SOH-099";
    final String DEF_PIZZA_INGREDIENTS="Mozzarella Cheese";
    final double DEF_ORDER_TOTAL=15.00;


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
        System.out.println("Oreder accepted!");
        System.out.println("Oreder is being prepared!");
        makePizza();
        printReceipt();
    }
    private void makePizza(){
        System.out.println("Your pizza is making!");
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            System.out.println("Pizza is ready for pickup!");
        }
    }
    private void printReceipt(){
        
        System.out.println("Your order is ready!");
        System.out.println("******RECEIPT******");
        System.out.println("Order ID: "+orderID);
        System.out.println("Order detail: "+pizzaIngredients);
        System.out.println("Order Total: "+orderTotal);
    }

    public void processCardPayment(String cardNumber,String expiryDate,int cvv){
        if(cardNumber.length()==14){
            System.out.println("\nCard accepted");
        }
        else{
            System.out.println("\nInvalid card");
        }
        firstCardDigit=Integer.parseInt(cardNumber.substring(0, 1));
        if(cardNumber.equals(blackCardNumber)){
            System.out.println("\nCard is blacklisted. Please use another card.");
        }
        lastFourDigits=Integer.parseInt(cardNumber.substring(10, 14));
        String middle=cardNumber.substring(1,cardNumber.length()-4);
        String replace=middle.replaceAll("\\d","*");
        cardNumberToDisplay=firstCardDigit+replace+lastFourDigits;
        System.out.println(cardNumberToDisplay);
    }
    public void specialOfTheDay(String pizzaOfTheDay,String sideOftheDay,double specialPrice){
        System.out.println("Today's special pizza: "+pizzaOfTheDay);
        System.out.println("Today's special sides: "+sideOftheDay);
        System.out.println("Today's special price: "+specialPrice);
    }




}