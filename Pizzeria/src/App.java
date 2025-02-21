public class App {
    public static void main(String[] args) throws Exception {
        Slice_o_Heaven pizza=new Slice_o_Heaven();
        pizza.takeOrder("123456789", "cheese pizza", 59.9);
        pizza.printReceipt();
    }
}
