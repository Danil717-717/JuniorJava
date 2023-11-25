package less2;

public class Car {
    public String name;
    private String price;
    private String engType;
    private String engPower;
    public int maxSpeed;


    public Car(String name) {
        this.name = name;
        this.price = "10000";
        this.engType = "V8";
        this.engPower = "123";
        this.maxSpeed = 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getEngType() {
        return engType;
    }

    public void setEngType(String engType) {
        this.engType = engType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", engType='" + engType + '\'' +
                ", engPower='" + engPower + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
