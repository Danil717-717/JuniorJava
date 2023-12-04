package less3;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main1 {
    public static void main(String[] args) throws IOException {
        String str = "Всем привет";
        FileOutputStream fileOutputStream = new FileOutputStream("./src/main/java/less3/ser");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(str);
        outputStream.close();
    }
}
