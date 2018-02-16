package nio2hometask;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.LinkedList;
import java.util.ListIterator;

import static java.nio.file.StandardCopyOption.*;

public class Main {
    /*
    Задание:
    1. Создать и удалить файл.
    2. Записать данные в файл и считать данные из файла. Вывести считанное на консоль
    3. Применить методы копирования и перемещения файлов
    4. Применить сервис отслеживаний

//Устранить появление исключений!!!


     */


    public static void main(String[] args) throws IOException {


        //1. создаю файл
        Path novelDoc = Paths.get(".\\Stephen King.Novels.Main.txt");
        if (!Files.exists(novelDoc)){
            Files.createFile(novelDoc);
        }else{
            System.out.println("Файл по указанному пути уже существует\n Перезаписываю");

        }
        //Files.exists()
        /*try {
            Files.createFile(novelDoc);
        } catch (FileAlreadyExistsException e) {
            //   e.printStackTrace();
            System.out.println("Указанный файл уже существует");
        }*/




        //2. Записать данные в файл и считать данные из файла. Вывести считанное в консоль
        LinkedList<String> novels = new LinkedList<>();
        novels.add("Кэрри");
        novels.add("Сияние");
        novels.add("Кладбище домашних животных");
        novels.add("Мизери");
        novels.add("Темная половина");
        novels.add("Роза Марена");
        novels.add("Зеленая миля");
        novels.add("Ловец снов");
        novels.add("Под куполом");

        // Charset charset=Charset.forName("UTF-8");
        //записать данные в файл
        BufferedWriter writer = null;
        try {
            // BufferedWriter writer= Files.newBufferedWriter(novelDoc,charset);
           // writer = Files.newBufferedWriter(novelDoc, StandardCharsets.UTF_8, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
            writer = Files.newBufferedWriter(novelDoc, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
            ListIterator<String> li = novels.listIterator();
            while (li.hasNext()) {
                writer.write(li.next() + "\n");
            }


        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }


       // LinkedList<String> novelsFromFile=new LinkedList<>();
        //считать данные из файла:
        try (BufferedReader reader=Files.newBufferedReader(novelDoc,StandardCharsets.UTF_8)){
            String line;
            while ((line=reader.readLine())!=null){
         //       novelsFromFile.add(line);
                //вывести считанные данные в консоль
                System.out.println(line);

            }
        }catch (IOException io){
            io.printStackTrace();
        }

        //3 Применить методы копирования и перемещения файлов
        //создаю директорию. копирую в нее файл


        Path backupDir=Files.createDirectory(Paths.get(".\\KingBackupFiles"));
        Path backupFile=Paths.get(backupDir.toString(),"\\King Novels Backup.txt");
        Path backupFile2=Paths.get(backupDir.toString(),"\\King Novels Backup2.txt");
        Path backupFile3=Paths.get(backupDir.toString(),"\\King Novels Backup3.txt");
        //скопировать файл
        Files.copy(novelDoc,backupFile);
        Files.copy(novelDoc,backupFile2);
        Files.copy(novelDoc,backupFile3);


        //переместить файл
        Path mainDir=Files.createDirectory(Paths.get(".\\KingMainFiles"));
        Path nextMainFile=Files.createFile(Paths.get(".\\KingMainFiles\\King Novels Main.txt"));
        Files.move(novelDoc,nextMainFile,ATOMIC_MOVE);


        //1.удаляю файл
       Files.delete(backupFile2);

    }


}
