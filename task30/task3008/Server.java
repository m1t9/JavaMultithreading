package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {

        for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
            try {
                entry.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Оштбка при отправке сообщения.");
            }
        }

    }

    private static class Handler extends Thread {

        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake (Connection connection) throws IOException, ClassNotFoundException {

            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message unswer = connection.receive();
                if (unswer.getType() == MessageType.USER_NAME) {
                    if (unswer.getData() != null &&
                            unswer.getData() != "" &&
                            !connectionMap.containsKey(unswer.getData())) {
                        connectionMap.put(unswer.getData(), connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return unswer.getData();
                    }
                }
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                if (!entry.getKey().equals(userName))
                    connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {

            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    Message textMessage = new Message(MessageType.TEXT, userName + ": " + message.getData());
                    sendBroadcastMessage(textMessage);
                } else {
                    ConsoleHelper.writeMessage("Ошибка при отправке сообщения.");
                }
            }

        }

        @Override
        public void run() {
            try {
                ConsoleHelper.writeMessage("Установлено новое соединение с удаленным адресом " +
                        socket.getRemoteSocketAddress() + ".");

                Connection connection = new Connection(socket);
                SocketAddress socketAddress = connection.getRemoteSocketAddress();

                String userName = serverHandshake(connection);

                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));

                notifyUsers(connection, userName);

                serverMainLoop(connection, userName);

                if (userName != null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }

                ConsoleHelper.writeMessage("Соединение с удаленным сервером закрыто.");

            } catch (IOException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом.");
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом.");
                e.printStackTrace();
            } finally {

            }
        }

    }

    public static void main(String[] args) throws IOException {

        int port = ConsoleHelper.readInt();

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Сервер запущен.");
            while (true) {
                Socket socket = serverSocket.accept();
                try {
                    Handler handler = new Handler(socket);
                    handler.start();
                } catch (Exception e) {
                    serverSocket.close();
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
