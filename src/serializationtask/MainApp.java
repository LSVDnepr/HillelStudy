package serializationtask;

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;


public class MainApp {
    /*
Задача
Создать класс, внутри которого будет статическое поле, transient поле, несколько обычных полей.
Записать этот объект.
Считать этот объект и проверить значения полей с помощью System.out.println
     */


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HashMap<Integer, Client> clientsData = new HashMap<>();

        Client client = new Client("John", "Smith", 5000);
        client.makePurchase(9250);
        clientsData.put(client.getClientID(), client);

        System.out.println();
        Client client2 = new Client("Marry", "Smith", LocalDate.of(1990, 2, 14));
        client2.makePurchase(2000);
        client2.makePurchase(17000);
        clientsData.put(client2.getClientID(), client2);
        client2.makePurchase(25000);
        client2.makePurchase(2500);

        System.out.println();
        Client client3 = new Client("Jack", "Sparrow", 7500);
        client3.makePurchase(20000);
        clientsData.put(client3.getClientID(), client3);

        System.out.println();
        Client client4 = new Client("John", "Jovi", LocalDate.of(1962, 3, 2));
        client4.makePurchase(27000);
        clientsData.put(client4.getClientID(), client4);


        Client client5 = new Client("Jane", "Smith");
        clientsData.put(client5.getClientID(), client5);


        System.out.println();
        System.out.println("Before serialization:");//DEBUG1
        printClientsData(clientsData);
        File destFile = new File("ClientData.txt");
        serializeMultipleData(clientsData, destFile);
        HashMap<Integer, Client> retrievedData = deserializeData(destFile);
        System.out.println();
        System.out.println("After deserialization: ");
        printClientsData(retrievedData);


    }


   /* public void serializeData(Client client, File clientData) throws IOException {
        if (client==null)throw new IllegalArgumentException("Illegal value: passed object argument="+client);
        FileOutputStream fos=new FileOutputStream(clientData);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(client);
        oos.flush();
        oos.close();
    }*/

    public static void serializeMultipleData(HashMap<Integer, Client> clientsData, File destFile) throws IOException {
        if (clientsData == null)
            throw new IllegalArgumentException("Illegal value: passed clients map arg=" + clientsData);
        if (destFile == null) throw new IllegalArgumentException("Illegal value: passed destFile file =" + destFile);
        FileOutputStream fos = new FileOutputStream(destFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for (Client client : clientsData.values()) {
            oos.writeObject(client);
        }
        oos.flush();
        oos.close();
    }

    public static HashMap<Integer, Client> deserializeData(File dataSource) throws IOException {
        HashMap<Integer, Client> clientsData = new HashMap<>();
        FileInputStream fis = new FileInputStream(dataSource);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            while (true) {
                Client c = (Client) ois.readObject();
                clientsData.put(c.getClientID(), c);
            }
        } catch (EOFException eof) {
            // eof.printStackTrace();
            // throw eof;
        } finally {
            ois.close();
            return clientsData;
        }

    }


    public static void printClientsData(HashMap<Integer, Client> clientData) {
        if (clientData == null) throw new IllegalArgumentException("Illegal value: clientsData map=" + clientData);
        for (Client c : clientData.values()) {
            System.out.println(c);
        }
    }


}
