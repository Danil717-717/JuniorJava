package less5.chat;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientManager implements Runnable {

    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String name;
    public static ArrayList<ClientManager> clients = new ArrayList<>();

    //конструктор принимает сокет
    public ClientManager(Socket socket) {
        try {
            this.socket = socket;
            //создаются переменные чтения передачи данных
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //получаем имя клиента
            name = bufferedReader.readLine();
            //добавляем его в список всех клиентов
            clients.add(this);
            broadcastMessage("Server: " + name + "подключился к чату");

        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }

    }

    @Override
    public void run() {
        // переменная с сообщением от клиента
        String massageFromClient;

        //пока сокет подключен считываем эту строку
        while (socket.isConnected()) {
            try {
                //отправляем это сообщение всем
                massageFromClient = bufferedReader.readLine();
                broadcastMessage(massageFromClient);
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    //итерируется по всем клиентам
    private void broadcastMessage(String massageToSend) {
        for (ClientManager client : clients) {
            try {
                //тк сообщение самому себе не отправляется проверка
                if (!client.name.equals(name)) {
                    //то мы всем остальным отсылаем сообщение
                    client.bufferedWriter.write(massageToSend);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();

                }
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }


    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        removeClient();
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //удаление клиента из списка и вывод сообщения об этом
    public void removeClient() {
        clients.remove(this);
        broadcastMessage("Server: " + name + " покинул чат");
    }
}
