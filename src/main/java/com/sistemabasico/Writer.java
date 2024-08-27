package com.sistemabasico;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {


    public Writer (ArrayList<String> content, String path){
        try{
            FileWriter escritor = new FileWriter(path);
            
            for (String cont : content){
                escritor.write(cont);
                escritor.write("\n");
            }
            
            escritor.close();

            System.out.println("Archivo escrito con exito");
        }
        catch (IOException e){
            System.out.println("error al escribir");
        }
    }
}
