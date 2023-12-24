package less5;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample2 {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            Socket client = new Socket(address,1300);

            System.out.println(client.getInetAddress());
            System.out.println(client.getLocalPort());

            //возвращает поток ввода клиентского сервера
            InputStream inputStream = client.getInputStream();
            //соответственно поток вывода
            OutputStream outputStream = client.getOutputStream();
            //DataInputStream позволяет читать из потока любые
            // примитивные типы данных, массивы и строки
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            // класс PrintStream добавляет нам функционал, просто
            // печатает нам строки
            PrintStream printStream = new PrintStream(outputStream);


            //получаем по сети строку и сразу выводим ее
            printStream.println("Привет!");
            System.out.println(dataInputStream.readLine());
            //закрываем сокет освобождаем ресурсы сервера
            client.close();
        }catch (UnknownHostException e){
            throw new RuntimeException(e);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
