package j_lab_130_3_1;

import java.util.Random;

public class Supplier extends Thread{
    public String name;
    private int goods;
    public static Boolean active = true;

    public static Boolean getActive() {
        return active;
    }
    public Supplier(String name) {
        this.name = name;
        this.goods = (new Random().nextInt(3)+1)*10;
    }

    public void delivering() {
        while (!Warehouse.getWarehouse().delivery.addGoods(this,goods)) {
            try {
                Thread.sleep((new Random().nextInt(2)*1000));
            } catch (InterruptedException ex) {}
        }
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            delivering();
            try {
                Thread.sleep((new Random().nextInt(2)*1000));
            } catch (InterruptedException ex) {}
        }
        active = false;
    }
}
