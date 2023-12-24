package less5;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample1 {
    public static void main(String[] args) {
        try{
            //переменная класса InetAddress с методом getLocalHost()
            //получает адрес текущего ПК
            InetAddress address = InetAddress.getLocalHost();
            // создается Socket подключение с параметрами
            // адреса тек ПК и порта 1300
            Socket client = new Socket(address,1300);
            //будет ошибка тк нет серверной программы которая
            //слушает пор 1300
        }catch (UnknownHostException e){
            throw new RuntimeException(e);
        }catch (IOException e){
            throw  new RuntimeException(e);
        }
    }

}
