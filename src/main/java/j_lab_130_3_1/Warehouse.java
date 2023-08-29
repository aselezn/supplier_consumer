package j_lab_130_3_1;

public class Warehouse {
    public Delivery delivery = new Delivery();
    private static Warehouse warehouse = new Warehouse();
    private Warehouse(){}
    public static Warehouse getWarehouse(){
        return warehouse;
    }
}
