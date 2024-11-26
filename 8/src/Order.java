

import java.text.SimpleDateFormat;
import java.util.*;

final class Order {

    private static int countID = 0;
    private final int ID;
    private final Shopper shopper;
    private final ArrayList<Product> products = new ArrayList<Product>();
    List<ListShops> listShops;

    private float amount;
    private final String date;
    private int countProduct = 1;



    public Order(Shopper shopper, List<ListShops> listShops) {
        this.shopper = shopper;
        this.listShops = listShops;
        this.ID = ++countID;
        this.amount = amount;
        this.date = new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime());
    }

    public int getID() {
        return ID;
    }

    public Shopper getShopper() {
        return shopper;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProducts(Product product) {
        if (products.isEmpty()) {
            products.add(product);
        } else {
            for (Product pr : products) {
                if (product != pr) {
                    products.add(product);
                    break;
                } else {
                    countProduct++;
                    System.out.println(countProduct);
                    return;
                }
            }
        }
    }


    public void setCountProduct(int p, int i) {
        countProduct = i;
    }


    public float sumShops() {
        float sumShops = 0;
        for (ListShops listShops1 : listShops) {
            sumShops = listShops1.getAmount(getShopper()) + sumShops;
        }
        return sumShops;
    }


    @Override
    public String toString() {
        return ID + ";" + shopper.getName() +
                ";" + date + ';' + listShops + ";" + sumShops();
    }

}
