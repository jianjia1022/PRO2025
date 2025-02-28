public class App {
    public static void main(String[] args) throws Exception {
        Slice_o_Heaven special=new Slice_o_Heaven();
        special.specialOfTheDay("Cheese Pizza", "Fired chips", 30.00);
        Slice_o_Heaven pizza1=new Slice_o_Heaven();
        pizza1.takeOrder();
        pizza1.processCardPayment("12345678987653","2025/02/28",123);
        
}
}
