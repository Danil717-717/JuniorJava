package less5.chat;

import less5cCientServer.ClientExample2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket){
        this.serverSocket=serverSocket;
    }

    //метод запуска сервера
    public void runServer(){
        try{
            while (! serverSocket.isClosed()){
                //приложение ждет пока к нему подключатся
                //как только подключение появляется в обьект
                //socket сохраняется вся информация
                Socket socket = serverSocket.accept();
                //вывод в консоль сообщения
                System.out.println("Подключен новый клиент!");
                //создается переменная клиента куда записывается
                // информация
                ClientManager client = new ClientManager(socket);
                //создается новый поток
                Thread thread = new Thread(client);
                //старт потока
                thread.start();
            }
        }catch (IOException e){
            //при исключении вызов метода закрытия сокета
            closeSocket();
        }
    }

    public void closeSocket(){
        try {
            if(serverSocket!=null) serverSocket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        //инициализируем сервер с портом 1300
        ServerSocket serverSocket = new ServerSocket(1300);
        //создаем экземпляр нашего класса сервер
        //передаем ему серверсокет с портом 1300
        Server server = new Server(serverSocket);
        //стартуем
        server.runServer();
    }
}
