package sem3HW;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    String name;
    int age;
    /*
        transient — это модификатор, указываемый перед полем класса
        (подобно другим модификаторам, таким как public, final и т.д.)
        для обозначения того, что данное поле не должно быть сериализовано.

        Поля, помеченные ключевым словом transient, не сериализуются.
     */
    @JsonIgnore

    transient double gPA;

    public Student() {
    }

    public Student(String name, int age, double gPA) {
        this.name = name;
        this.age = age;
        this.gPA = gPA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getgPA() {
        return gPA;
    }

    public void setgPA(double gPA) {
        this.gPA = gPA;
    }



    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gPA=" + gPA +
                '}';
    }
}
