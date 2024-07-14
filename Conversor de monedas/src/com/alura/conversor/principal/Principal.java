package com.alura.conversor.principal;

import com.alura.conversor.model.ConversorMoneda;
import com.alura.conversor.model.Moneda;
import java.util.Scanner;

public class Principal {
    private static final ConversorMoneda conversor = new ConversorMoneda();
    public static void main(String args[]) {
        Scanner escritura = new Scanner(System.in);
        int opcion;
        double valorAConvertir = 0;
        String menu = """
                      Elija la opción de cambio de divisa que desea:
                      1) Dolar =>> Peso argentino
                      2) Peso argentino =>> Dolar
                      3) Dolar =>> Real brasileño
                      4) Real brasileño =>> Dolar
                      5) Dolar =>> Sol
                      6) Sol =>> Dolar
                      7) Salir
                      ************************************************
                      """;
        System.out.println("Bienvenido al Conversor de moneda =]");
        System.out.println("***************************************");
        do{
            System.out.println(menu);
            try{
                opcion = Integer.parseInt(escritura.nextLine());
                Moneda nuevaMoneda = null;
                switch (opcion) {
                    case 1:
                        System.out.println("Indique el valor que desea convertir: ");
                        valorAConvertir = Double.parseDouble(escritura.nextLine());
                        nuevaMoneda = conversor.buscarCambioDivisa("USD", "ARS", valorAConvertir);
                        break;

                    case 2:
                        System.out.println("Indique el valor que desea convertir: ");
                        valorAConvertir = Double.parseDouble(escritura.nextLine());
                        nuevaMoneda = conversor.buscarCambioDivisa("ARS", "USD", valorAConvertir);
                        break;
                    case 3:
                        System.out.println("Indique el valor que desea convertir: ");
                        valorAConvertir = Double.parseDouble(escritura.nextLine());
                        nuevaMoneda = conversor.buscarCambioDivisa("USD", "BRL", valorAConvertir);
                        break;
                    case 4:
                        System.out.println("Indique el valor que desea convertir: ");
                        valorAConvertir = Double.parseDouble(escritura.nextLine());
                        nuevaMoneda = conversor.buscarCambioDivisa("BRL", "USD", valorAConvertir);
                        break;
                    case 5:
                        System.out.println("Indique el valor que desea convertir: ");
                        valorAConvertir = Double.parseDouble(escritura.nextLine());
                        nuevaMoneda = conversor.buscarCambioDivisa("USD", "PEN", valorAConvertir);
                        break;
                    case 6:
                        System.out.println("Indique el valor que desea convertir: ");
                        valorAConvertir = Double.parseDouble(escritura.nextLine());
                        nuevaMoneda = conversor.buscarCambioDivisa("PEN", "USD", valorAConvertir);
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("Opción inválida. Intente de nuevo");
                }
                if (nuevaMoneda != null)
                    System.out.println("El valor de "+valorAConvertir+" "+nuevaMoneda.base_code()+" a "+nuevaMoneda.target_code()+" es "+nuevaMoneda.conversion_result());
            }catch(NumberFormatException ex){
                System.out.println("Ocurrió un error al leer el número: "+ex.getMessage());
                opcion = 7;
            }catch(RuntimeException ex){
                System.out.println(ex.getMessage());
                opcion = 7;
            }
        }while(opcion!=7);
    }
}
