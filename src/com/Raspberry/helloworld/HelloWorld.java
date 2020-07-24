package com.Raspberry.helloworld;

import java.util.Scanner;
import com.pi4j.io.gpio.*;
public class HelloWorld {
    private static boolean estadoled = false;

    public static void main(String[] args) {
        while (true) {
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
        } else {
            System.out.print("Opción incorrecta, introduzca opcion correcta: ");
            leerOpcion();
        }
    }

    private static void cambiaLed() {
        estadoled = !estadoled;
    }

    private static boolean validaOpcion(String opcion) {
        int op;
        boolean valida = false;
        try {
            op = Integer.parseInt(opcion);
            if ((op == 0) || (op == 1)) {
                valida = true;
            }
        } catch (Exception ex) {
            valida = false;
        }
        return valida;
    }

    private static void apagaLed() {
        final GpioController gpio = GpioFactory.getInstance();
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22);
        pin.low();
        gpio.shutdown();
}

    private static void enciendeLed() {
        final GpioController gpio = GpioFactory.getInstance();
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22);
        pin.high();
        gpio.shutdown();
    }

    private static void menuled() {
        System.out.println("   Menu de led   ");
        System.out.println("-----------------");
        System.out.println("Estado actual " + estadoled);
        System.out.println("1. Cambiar estado ");
        System.out.println("0. Salir          ");
        System.out.println();
        System.out.print("Introduzca opción: ");
    }

    private static void borrapantalla() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }
}
