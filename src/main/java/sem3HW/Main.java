package sem3HW;

/*
   1. Разработайте класс Student с полями String name, int age,
      transient double GPA (средний балл). Обеспечьте поддержку
      сериализации для этого класса. Создайте объект класса Student
      и инициализируйте его данными. Сериализуйте этот объект в файл.
      Десериализуйте объект обратно в программу из файла. Выведите все поля объекта,
      включая GPA, и обсудите, почему значение GPA не было сохранено/восстановлено.
   2. * Выполнить задачу 1 используя другие типы сериализаторов (в xml и json документы).
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


import java.io.*;
import java.util.Scanner;


public class Main {

    public static final String FILES_JSON = "./src/main/java/sem3HW/student.json";

    public static final String FILES_XML = "./src/main/java/sem3HW/student.xml";

    private static final ObjectMapper objectMapperS = new ObjectMapper();
    private static final XmlMapper xmlMapperS = new XmlMapper();


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("Vasiliy", 24, 3.5);


        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - сериализовать или 2 - десериализовать");
        Integer choice1 = scanner.nextInt();
        if (choice1 == 1) {

            System.out.println("Выберете как сериализовать файл:\n" +
                    " 1 - .json\n 2 - .bin\n 3 - .xml");

            Integer choice = scanner.nextInt();

            if (choice == 1) {
                objectMapperS.writeValue(new File(FILES_JSON), student);
                System.out.println("Объект student сериализован.");

            } else if (choice == 2) {
                try (FileOutputStream fileOutputStream = new FileOutputStream("./src/main/java/sem3HW/student.bin");
                     ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                    objectOutputStream.writeObject(student);
                    System.out.println("Объект student сериализован.");
                }

            } else if (choice == 3) {
                xmlMapperS.writeValue(new File(FILES_XML), student);

            } else {
                System.out.println("Некорректный выбор. Попробуйте снова.");

            }
        } else if (choice1 == 2) {

            System.out.println("Выберете какой формат десериализовать в файл:\n" +
                    " 1 - .json\n 2 - .bin\n 3 - .xml");

            Integer choice = scanner.nextInt();

            if (choice == 1) {
                File file = new File(FILES_JSON);
                Student studentDes = objectMapperS.readValue(file, Student.class);
                System.out.println("Объект student десериализован: " + studentDes);
            } else if (choice == 2) {
                try (FileInputStream fileInputStream = new FileInputStream("./src/main/java/sem3HW/student.bin");
                     ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                    Student studentDes = (Student) objectInputStream.readObject();
                    System.out.println(studentDes);
                    System.out.println("Объект student десериализован.");

                }
            } else if (choice == 3) {
                File file = new File(FILES_XML);
                Student studentDes = xmlMapperS.readValue(file, Student.class);
                System.out.println("Объект student десериализован: " + studentDes);
            } else {
                System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }


        scanner.close();
        System.exit(0);


    }
}
