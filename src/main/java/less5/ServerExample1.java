package less5;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerExample1 {
    //пример написания сервера
    public static void main(String[] args) {
        try {
            // используем переменную класса ServerSocket с одним из
            // конструкторов, эта переменная будет слушать указанный
            // порт- 1300
            ServerSocket serverSocket = new ServerSocket(1300);
            // методом accept() начинаем слушать этот порт
            Socket socket = serverSocket.accept();


            //с помощью этих переменных передаем строки через сервер
            OutputStream outputStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            printStream.println("Hello!");

            //закрываем и обычный сокет и серверный
            socket.close();
            serverSocket.close();
            // клиент серверное приложение чувствительно
            // к соединению, в любой момент может быть ошибка
            // ее нужно обработать

        }catch (UnknownHostException e){
            throw new RuntimeException(e);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
