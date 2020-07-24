package com.Raspberry.helloworld;

import java.net.StandardSocketOptions;
import java.util.Scanner;

public class HelloWorld {
    private static boolean estadoled = false;
    public static void main (String[] args){
        while(true){
            borrapantalla();
            menuled();
            leerOpcion();
        }
    }

    private static void leerOpcion() {
        String opcion;
        Scanner teclado = new Scanner(System.in);
        opcion = teclado.nextLine();
        if (validaOpcion(opcion)) {
          switch (Integer.parseInt(opcion)) {
              case 0:
                  System.exit(-1);
                  break;
              case 1:
                  cambiaLed();
                  break;
          }
        }else{
           System.out.print("Opción incorrecta, introduzca opcion correcta: ");
           leerOpcion();
        }
    }

    private static void cambiaLed() {
        if (estadoled==false){
            estadoled=true;
        }else{
            estadoled=false;
        }
    }

    private static boolean validaOpcion(String opcion) {
        int op;
        boolean valida= false;
        try {
                op= Integer.parseInt(opcion);
                if((op==0)||(op==1)){
                    valida=true;
            }
        } catch(Exception ex){
            valida=false;
        }
        return valida;
    }

    private static void menuled() {
        System.out.println("   Menu de led   ");
        System.out.println("-----------------");
        System.out.println("Estado actual " + estadoled);
        System.out.println("1.Cambiar estado ");
        System.out.println("0. Salir         ");
        System.out.println("");
        System.out.print("Introduzca opción: ");
    }

    private static void borrapantalla() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }
}
