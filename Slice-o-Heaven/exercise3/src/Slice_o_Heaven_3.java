public class Slice_o_Heaven_3 {
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
    
        public void takeOrder(String orderID,String pizzaIgredients,double orderTotal){
            this.orderID=orderID;
            this.pizzaIngredients=pizzaIgredients;
            this.orderTotal=orderTotal;
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
    }
    

