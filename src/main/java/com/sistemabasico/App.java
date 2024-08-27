package com.sistemabasico;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        //Metricas a cambiar para cada caso especial...
        Db database = new Db("jdbc:mariadb://localhost:3306/sistemita","root", "isaac");
        String path = "Nombre del archivo generado.txt";
        String name;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Bienvenido al registro de nombres \n");
            System.out.println("Por favor ingresa tu nombre");
            System.out.println("Para salir solo presiona enter\n");
            name = sc.nextLine();
            
            if(!name.equals("")){
                System.out.println("\nPerfecto, iniciando el proceso de registro\n");

                process(database,name, path);

                System.out.println("\nIngresa solo enter para reiniciar, cualquier otro caracter para salir");

                if(!sc.nextLine().equals("")) break;
            }
            else{
                System.out.println("\nadiós");
                break;
            }
        }
    }

    private static void process(Db database, String name, String path){
        database.insertData(name);
        System.out.println("\nTu nombre aparece un total de " + database.ammountOfData(name) + " !\n");
        System.out.println("Generando archivo espejo de la base de datos...\n");
        Writer writer = new Writer(database.selectData(), path);
        System.out.println("\nExitoso!!");

        System.out.println("Por cierto, la base de datos tiene un total de " + database.ammountOfData() + " registros");
    }
}
