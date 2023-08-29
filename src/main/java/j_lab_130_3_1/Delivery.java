package j_lab_130_3_1;

import java.util.Random;

public class Delivery {
    private int stock;
    private volatile boolean isOpen;

    public Delivery() {
        stock = new Random().nextInt(100);
        isOpen = true;
    }
    public int getStock() {
        return stock;
    }

    public synchronized boolean getGoods (Consumer consumer, int goods) {
        if(isOpen) {
            if(stock<goods){
                System.out.println(consumer.name + ": ждет " + goods + " штук товара. На складе осталось " + getStock() + " штук товара.");
                isOpen = false;
                if(Supplier.getActive()==false) {
                    System.out.println("Поставщики закончили работу. Склад больше не выдает заказы.");
                    System.exit(0);
                }
            } else {
                stock -= goods;
                System.out.println("---" + consumer.name + ": забрал " + goods + " штук товара со склада. На складе осталось " + getStock() + " штук товара.");
            }
        }
        return isOpen;
    }
    public synchronized boolean addGoods(Supplier supplier, int goods) {
        stock += goods;
        System.out.println(supplier.name + " доставил " + goods + " штук товара. На складе сейчас " + getStock() + " штук товара.");
        isOpen = true;
        return isOpen;
    }


}
