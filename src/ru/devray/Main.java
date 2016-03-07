package ru.devray;


import java.io.*;

public class Main {

    //ObjectInputStream & ObjectOutputStream for serialization
    public static final File dest=new File("c:\\users\\asus\\desktop\\java\\compressed.dat"); //default file for serialization

    public static void main(String[] args) {

        SDummy sd = new SDummy();
        System.out.println("Dummy prepared:");
        System.out.println(sd);

        flushSerializable(sd);
        sd=null; //Disposing of redundant exemplar...
        System.out.println(sd);

        sd=restoreSerializable();
        System.out.println(sd);

    }

    public static void flushSerializable(SDummy s){
        System.out.println("Starting serialization...");
        try(ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream(dest))){

            os.writeObject(s);

        }catch(IOException e){
            System.out.println("An error has occured.");
            e.printStackTrace();
            return;
        }

        System.out.println("\nTransfer to binary file complete.");
        s = null;
        System.out.println("Disposed.");

    }
    public static SDummy restoreSerializable(){
        System.out.println("Starting hardcopy restoration...");
        try(ObjectInputStream is=new ObjectInputStream(new FileInputStream(dest))){

            return (SDummy)is.readObject();

        }catch(Exception e){e.printStackTrace();}
        return null;
    }

}
