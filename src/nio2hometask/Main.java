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


     */


    public static void main(String[] args) throws IOException {
        Path taskDir = Paths.get(".\\NioTask");
        if (!Files.exists(taskDir)) {
            Files.createDirectory(taskDir);
        } else {
            System.out.println("Папка " + taskDir.toRealPath() + " уже существует");
        }
        Thread th = new Thread(new MyWatchService(".\\NioTask"));
        th.start();


        //1. создаю файл

        Path novelDoc = Paths.get(".\\NioTask\\Stephen King.Novels.Main.txt");
        if (!Files.exists(novelDoc)) {
            Files.createFile(novelDoc);
        } else {
            System.out.println("Файл по указанному пути уже существует\n Перезаписываю существующий файл");
        }


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

        //записать данные в файл
        try (BufferedWriter writer = Files.newBufferedWriter(novelDoc, StandardCharsets.UTF_8, StandardOpenOption.WRITE)) {
            ListIterator<String> li = novels.listIterator();
            while (li.hasNext()) {
                writer.write(li.next());
                writer.newLine();
            }
        } catch (IOException io) {
            io.printStackTrace();
        }


        // LinkedList<String> novelsFromFile=new LinkedList<>();
        //считать данные из файла:
        try (BufferedReader reader = Files.newBufferedReader(novelDoc, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                //       novelsFromFile.add(line);
                //вывести считанные данные в консоль
                System.out.println(line);
            }
        } catch (IOException io) {
            io.printStackTrace();
        }

        //3 Применить методы копирования и перемещения файлов
        //создаю директорию. копирую в нее файл
        Path backupDir = Paths.get(".\\NioTask\\KingBackupFiles");
        if (!Files.exists(backupDir)) {
            Files.createDirectory(backupDir);
        } else {
            System.out.println("Папка " + backupDir.toRealPath() + " уже существует");
        }


        Path backupFile = Paths.get(backupDir.toString(), "\\Novels Backup.txt");
        Path backupFile2 = Paths.get(".\\NioTask\\KingBackupFiles\\Novels Backup2.txt");
        Path backupFile3 = Paths.get(".\\NioTask\\KingBackupFiles", "\\Novels Backup3.txt");

        //МЕТОД RESOLVE почему-то не работает. Никаких исключений не возникает, но файлы не рзздаются




        /*//Path backupFile2 = Paths.get(".\\KingBackupFiles","\\Novels Backup2.txt");
        // Path backupFile2=Paths.get("\\Novels Backup.txt").resolve(backupDir);*/
        /*Path backupFile = backupDir.resolve(Paths.get("\\Novels Backup.txt"));
        Path backupFile2 = backupDir.resolve("\\Novels Backup2.txt");
        Path backupFile3 = backupDir.resolve("\\Novels Backup3.txt");*/



        //скопировать файл
        /*if (!Files.exists(backupFile)) {
            Files.copy(novelDoc, backupFile);// Заменила этот и подобные if на REPLACE EXISTING
            System.out.println("Копирую backupFile1");
        }*/
        /*if (!Files.exists(backupFile2)) {
            Files.copy(novelDoc, backupFile2);
        }*/
        /*if (!Files.exists(backupFile3)) {
            Files.copy(novelDoc, backupFile3);
        }*/

        Files.copy(novelDoc, backupFile, REPLACE_EXISTING);
        Files.copy(novelDoc, backupFile2, REPLACE_EXISTING);
        Files.copy(novelDoc, backupFile3, REPLACE_EXISTING);


        //переместить файл
        Path mainDir = Paths.get(".\\NioTask\\KingMainFiles");
        if (!Files.exists(mainDir)) {
            Files.createDirectory(mainDir);
        }
        Path nextMainFile = Paths.get(".\\NioTask\\KingMainFiles\\Novels Main.txt");
        if (!Files.exists(nextMainFile)) {
            Files.createFile(nextMainFile);
        }
        Files.move(novelDoc, nextMainFile, ATOMIC_MOVE);

        //1.удаляю файл
        Files.delete(backupFile2);


    }


}
