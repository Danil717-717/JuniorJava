package less3;


import java.io.*;

public class Main5 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //сериализация обьекта
        MyFCS myFCS = new MyFCS("Ivanov", "Ivan", "Ivanovich");
        serialObject(myFCS, "./src/main/java/less3/ser2");

        //десеариализация
        MyFCS myFCS1 = (MyFCS) deserialObject("./src/main/java/less3/ser2");
        System.out.println(myFCS1);


    }



    public static void serialObject(Object o, String file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(o);
        objectOutputStream.close();
    }

    public static Object deserialObject(String file) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return objectInputStream.readObject();
    }

    static class MyFCS implements Serializable {

        private static final long serialVersionUID = 1L;
        public String lName;
        public String fName;
        public String patronymic;

        public MyFCS(String lName, String fName, String patronymic) {
            this.lName = lName;
            this.fName = fName;
            this.patronymic = patronymic;
        }

        @Override
        public String toString() {
            return String.format("%s %s.%s.",
                    fName,
                    lName.toUpperCase().charAt(0),
                    patronymic.toUpperCase().charAt(0));

        }
    }

}
