import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main extends NullPointerException {
    public static final String date = new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime());

    public static void main(String[] args) {
        System.out.println("Сегодня " + date);


        try {
            //Создание класса магазин
            final Market market = new Market();
           // System.out.println("Список покупателей");
            //Вывод списка всех зарегистрированных покупателей из файла shoppers.txt
           // System.out.println(DataStorage.shoppers.toString().replaceAll("\\[", "").replaceAll("\\]",""));

            //Создание списка покупок с указание ID товара их файла products.txt и его количества.
            ListShops listShop1 = new ListShops(DataStorage.products.get(0), 2);
            ListShops listShop2 = new ListShops(DataStorage.products.get(3), 3);
            ListShops listShop3 = new ListShops(DataStorage.products.get(3), 1);
            ListShops listShop4 = new ListShops(DataStorage.products.get(5), 3);

            //Создание общего спика  покупок и их наполнение .
            List<ListShops> listShops1 =new ArrayList<>();
            List<ListShops> listShops2 = new ArrayList<>();
            listShops1.add(listShop1);
            listShops1.add(listShop2);
            listShops2.add(listShop3);
            listShops2.add(listShop3);
            listShops2.add(listShop4);

            //Создание заказа , соединение покупателя со списком покупок
            Order order1 = new Order(DataStorage.shoppers.get(1), listShops1);
            Order order2 = new Order(DataStorage.shoppers.get(2), listShops2);
            Order order3 = new Order(DataStorage.shoppers.get(2), listShops2);


            ExportData exportData = new ExportData();
            exportData.saveOrder(order1);
            exportData.saveOrder(order2);
            exportData.saveOrder(order3);
            exportData.saveShopper(new Shopper("Скоробоков Олег",19,"+7-922-123-54-95", Gender.MALE));
            exportData.saveProduct(new Product("Циркуль", 15));
            exportData.saveProduct(new Product("Циркуль", 45));


        } catch (NullPointerException e) {
            System.out.println("Ошибка при создании заказа.!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка при создании заказа. Запрошенный индекc не существует. Повторите попытку");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



