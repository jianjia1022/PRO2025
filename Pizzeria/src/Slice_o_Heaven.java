public class Slice_o_Heaven {
    public String storeName;
    public String storeAddress;
    public String storeEmail;
    public long storePhone;
    public String storeMenu;
    public String pizzaIngredients;
    public double pizzaPrice;
    public int sides;
    public String drinks;
    public String orderID;
    public String orderDetail;
    public double orderTotal;



    public void takeOrder(String id,String detail,double total){
        orderID=id;
        orderDetail=detail;
        orderTotal=total;
        System.out.println("Oreder accepted!");
        System.out.println("Oreder is being prepared!");
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
    public void printReceipt(){
        System.out.println("Your order is ready!");
        System.out.println("******RECEIPT******");
        System.out.println("Order ID："+orderID);
        System.out.println("Order detail："+orderDetail);
        System.out.println("Order Total："+orderTotal);
    }
}
