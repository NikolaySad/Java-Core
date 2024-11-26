import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExportData {


    public void saveOrder(Order o) throws IOException {
        FileOutputStream file = new FileOutputStream("orders.txt", true);

        try {
            if (getIdOrder(o)) {
                file.write(String.format("%s;\n", o.toString()).replaceAll("\\[", "").replaceAll("]", "").replaceAll(", ", ";").getBytes());
                System.out.println("Экспорт завершен! Добавлен заказ №" + o.getID());
            }
            file.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveShopper(Shopper s) throws IOException {
        FileOutputStream file = new FileOutputStream("shoppers.txt", true);

        try {
            if (getIdShopper(s)) {
                file.write(String.format("%s;\n", s.toString()).replaceAll("\\[", "").replaceAll("]", "").replaceAll(", ", ";").getBytes());
                System.out.println("Экспорт завершен! Добавлен покупатель №" + s.getID() + s.getName());
            }
            file.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveProduct(Product p) throws IOException {
        FileOutputStream file = new FileOutputStream("products.txt", true);

        try {
            if (getIdProduct(p)) {
                file.write(String.format("%s;\n", p.toString()).replaceAll("\\[", "").replaceAll("]", "").replaceAll(", ", ";").getBytes());
                System.out.println("Экспорт завершен! Добавлен покупатель №" + p.getID() + p.getName());
            }
            file.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

//методы для проверки дубликатов по иду и названию.
    public boolean getIdOrder(Order o) throws IOException {
        boolean id = true;
        try {
            String[] elements = Files.readString(Paths.get("orders.txt")).split("\n");
            if (elements.length == 0 || elements.length == 1) {
                return true;
            } else {
                for (int i = 0; i < elements.length; i++) {
                    String[] ids = elements[i].split(";");
                    if (Integer.parseInt(ids[0]) == o.getID()) {
                        id = false;
                    }
                }
            }
            return id;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("Файл пуст");
        }
        return id;
    }

    public boolean getIdShopper(Shopper o) throws IOException {
        boolean id = true;
        try {
            String[] elements = Files.readString(Paths.get("shoppers.txt")).split("\n");
            if (elements.length == 0 || elements.length == 1) {
                return true;
            } else {
                for (int i = 0; i < elements.length; i++) {
                    String[] ids = elements[i].split(";");
                    if (ids[3].equals(o.getPhone())) {
                        id = false;
                    }
                }
            }
            return id;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("Файл пуст");
        }
        return id;
    }

    public boolean getIdProduct(Product p) throws IOException {
        boolean id = true;
        try {
            String[] elements = Files.readString(Paths.get("products.txt")).split("\n");
            if (elements.length == 0 || elements.length == 1) {
                return true;
            } else {
                for (int i = 0; i < elements.length; i++) {
                    String[] ids = elements[i].split(";");
                    if (Integer.parseInt(ids[0]) == p.getID()|| ids[1].equals(p.getName())) {
                        id = false;
                    }
                }
            }
            return id;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("Файл пуст");
        }
        return id;
    }


}
