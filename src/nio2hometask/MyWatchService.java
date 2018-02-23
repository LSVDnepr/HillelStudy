package nio2hometask;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

public class MyWatchService implements Runnable {

    //4. Применить сервис отслеживаний
    /*public static WatchService getWatchService() throws IOException {*/
    private Path watchAfter = Paths.get(".");
    //private Object[] events={ENTRY_MODIFY, ENTRY_CREATE, ENTRY_DELETE, OVERFLOW};

    public MyWatchService() {

    }




    public MyWatchService(String watchAfterPath) {
        //в закомментированном варианте мне не нравится то, что четко не понятно, то ли папка/файл не существует,
        // то ли вообще что-то левое передано в параметр конструктора

       /* if (watchAfterPath == null || watchAfterPath.length() == 0||!Files.exists(Paths.get(watchAfterPath))){
            throw new IllegalArgumentException("Illegal value: Passed path doesn't exist");
        }*/
        if (watchAfterPath == null || watchAfterPath.length() == 0){
            throw new IllegalArgumentException("Illegal value: passed watchAfterPath is null or empty");
        }
        if (!Files.exists(Paths.get(watchAfterPath))) {
            throw new IllegalArgumentException("Passed path doesn't exist");
        }

            watchAfter = Paths.get(watchAfterPath);

        }



    public void run() {
        {
            WatchService watchService = null;
            //Path dirToWatch = FileSystems.getDefault().getPath(".");
            try {
                watchService = FileSystems.getDefault().newWatchService();
                watchAfter.register(watchService, ENTRY_MODIFY, ENTRY_CREATE, ENTRY_DELETE, OVERFLOW);

                // WatchKey watchKey = dirToWatch.register(watchService, ENTRY_MODIFY,ENTRY_CREATE,ENTRY_DELETE,OVERFLOW);
                //while (!shutdown){// Что за shutdown  в примере?? зачем?
                //как решить с помощью алгоритма из примера в презентации?

                //}

            } catch (IOException io) {
                io.printStackTrace();
                // throw io;
            }

            for (; ; ) {     //Warning:(60, 13) 'for' statement cannot complete without throwing an exception
                WatchKey key = null;
                try {
                    key = watchService.take(); //Warning:(63, 40) Method invocation 'take' may produce 'java.lang.NullPointerException'
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }

                for (WatchEvent event : key.pollEvents()) { //Warning:(68, 45) Method invocation 'pollEvents' may produce 'java.lang.NullPointerException'
                    switch (event.kind().name()) {
                        case "ENTRY_CREATE":
                            System.out.println("File " + event.context() + " was created");
                            break;
                        case "ENTRY_MODIFY":
                            System.out.println("File " + event.context() + " was modified");
                            break;
                        case "ENTRY_DELETE":
                            System.out.println("File " + event.context() + " was deleted");
                            break;
                        case "ENTRY_OVERFLOW":
                            System.out.println("Some events were lost");
                            break;//этот по-моему не обязателен
                    }
                }
                key.reset();

            }
        }


    }

}



