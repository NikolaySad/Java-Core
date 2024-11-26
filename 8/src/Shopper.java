final class Shopper extends NullPointerException {

    private static int countID = 0;
    private final int ID;
    private final String name;
    private final int age;
    private final String phone;
    private final Gender gender;

    public Shopper(String name, int age, String phone, Gender gender) {

        this.ID = ++countID;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
    }




    public Shopper(int ID, String name, int age, String phone, Gender gender) {

        this.ID = ++countID;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.gender = gender;

    }


    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public Gender getGender() {
        return gender;



    }


    @Override
    public String toString() {
        return ID + ";" + name + ";" + age +
                ";" + phone + ";" + gender;
    }
}
