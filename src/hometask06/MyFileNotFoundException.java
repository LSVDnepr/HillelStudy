package hometask06;

import java.io.FileNotFoundException;

public class MyFileNotFoundException extends FileNotFoundException {
   private Exception cause;


    MyFileNotFoundException(String message) {
        super(message);
    }

    MyFileNotFoundException(String message,Exception cause){
        super(message);
        this.cause=cause;

    }


    public Exception getCause(){
        return cause;
    }





}
