package sem2HW;

public class Cat extends Animal{
    private String name;
    private int age;
    private String breed;
    private String gender;

    public Cat(String name, int age, String breed, String gender) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void say() {
        System.out.println("Myau");
    }

    public void jump() {
        System.out.println("Cat jump");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
