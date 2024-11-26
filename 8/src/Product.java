
//
final class Product {
    private static int countID = 0;
    private final int ID;
    private final String name;
    private final int price;



    public Product(String name, int price) {
        this.ID = ++countID;
        this.name = name;
        this.price = price;

    }
    public Product(int ID, String name, int price) {
        this.ID = ID;
        this.name = name;
        this.price = price;
    }


    @Override
    public String toString() {
        return  ID + ";" +name +
                ";" + price ;
    }



    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }



}

