package sem2HW;

public class Dog extends Animal {
    private String name;
    private int age;
    private String breed;
    private String gender;

    public Dog(String name, int age, String breed, String gender) {
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
        System.out.println("Wow-wow");
    }

    public void sit() {
        System.out.println("Dog sit");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
