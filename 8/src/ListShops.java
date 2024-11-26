import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ListShops {
    public final String dateYear = new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
    public final String dateNewYear = "31.12." + dateYear;
    public final String date8March = "08.03." + dateYear;
    public final String date23Feb = "23.02." + dateYear;
    private final Product product;
    private int countProduct;
    private float amount;
    private final String date;
    public ListShops(Product product, int countProduct) {
        this.product = product;
        this.countProduct = countProduct;
        this.date = new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime());
    }


    public int getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(int countProduct) {
        this.countProduct = countProduct;
    }

    public float getAmount(Shopper shopper) {
        if (date.equals(dateNewYear)) {
            return amount = (float) (0.80 * product.getPrice() * countProduct) + amount;

        }
        if (date.equals(date8March) && shopper.getGender() == Gender.FEMALE ||
                date.equals(date23Feb) && shopper.getGender() == Gender.MALE) {
            return amount = (float) (0.85 * product.getPrice() * countProduct) + amount;

        }
        return product.getPrice() * countProduct;
    }

    @Override
    public String toString() {
        return product + ";"+ countProduct ;
    }
}
