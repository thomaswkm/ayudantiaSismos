package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double[][] sismos = new double[7][10];
        menu(sismos);

    }

    public static void menu(double[][] sismos){

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa una opción.");
        System.out.println("1. Ingresar datos");
        System.out.println("2. Mostrar sismo de mayor magnitud");
        System.out.println("3. Contar sismos mayores o iguales a 5.0");
        System.out.println("4. Enviar sms por cada sismo mayor o igual a 7.0");
        System.out.println("5. Salir");

        int ans = sc.nextInt();

        respuesta(sismos, ans);
        menu(sismos);
    }


    public static void respuesta(double[][] sismos, int ans){
        switch (ans) {
            case 1:
                llenarArreglo(sismos);
                break;
            case 2:
                System.out.println("El sismo de mayor magnitud fue de: "+buscarMayorSismo(sismos));
                break;
            case 3:
                System.out.println("La cantidad de sismos mayores a 5.0 fue de : "+contarSismosMayoresA(sismos,5));
                break;
            case 4:
                enviarSms(sismos);
                break;
            case 5:
                System.out.println("Salida");
                System.exit(0);
        }
    }


    public static double[][] llenarArreglo(double[][] sismos){

        Random rd = new Random();

        for (int i = 0; i < sismos.length; i++) {
            for (int j = 0; j < sismos[i].length; j++) {
                sismos[i][j] = Math.random()*10;
            }
        }
        return sismos;
    }

    public static double buscarMayorSismo(double[][] sismos){

        double s = 0;

        for (int i = 0; i < sismos.length; i++) {
            for (int j = 0; j < sismos[i].length; j++) {
                if (sismos[i][j]>s){
                    s=sismos[i][j];
                }
            }
        }
        return s;
    }


    public static int contarSismosMayoresA(double[][] sismos, double magnitud){
        int n = 0;

        for (int i = 0; i < sismos.length; i++) {
            for (int j = 0; j < sismos[i].length; j++) {
                if (sismos[i][j]>magnitud){
                    n++;
                }
            }
        }
        return n;
    }

    public static void enviarSms(double[][] sismos){

        for (int i = 0; i < contarSismosMayoresA(sismos,7); i++) {
            System.out.println("Alerta!!! se debe evacuar zona costera!");
        }
    }
}