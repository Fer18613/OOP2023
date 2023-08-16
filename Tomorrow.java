package Tomorrowland;
import java.util.Scanner;

public class Tomorrow {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);//Inicializando variables universales
        final int MAX = 60;
        int sales = MAX;
        int a = 0; int b = 0; int c = 0;

        int num;//Input del menú
        boolean isRunning = true;//El programa correrá hasta que se le indique lo contrario

        while (isRunning){ //Menú de compra de boletos
            System.out.println("Bienvenido a la venta de boletos de Tomorrowland.\n\nSeleccione una opción:");
            System.out.println("1. Nuevo cliente\n2. Consultar disponibilidad\n3. Cerrar el programa");
            num = scan.nextInt();

            int salesA = MAX/3 - a;//Número de boletos disponible
            int salesB = MAX/3 - b;
            int salesC = MAX/3 - c;
            switch (num) {
                case 1:
                    System.out.println("\nIngrese su nombre: ");
                    String name = scan.next();
                    System.out.println("\nIngrese su número de DPI:");
                    int dpi = scan.nextInt();
                    System.out.println("\nIngrese el número de boletos a comprar:");
                    int ticket = scan.nextInt();
                    System.out.println("\nIngrese su presupuesto máximo:");
                    double budg = scan.nextDouble();

                    Client cliente = new Client(name, dpi, ticket, budg);//Inicializar cliente y asignarle los boletos comprados

                    System.out.println("Cliente creado con éxito");

                    if (sales - cliente.ticket >= 0){//Verificar si la compra es posible
                        for (int i = 0; i < cliente.ticket; i ++){
                            int random = (int)(Math.random() * 33000) + 1;
                            int x = (int)(Math.random() * 15000) + 1;
                            int y = (int)(Math.random() * 15000) + 1;
                            if ((random+x+y)%2 == 0){
                                int loc = (int)(Math.random() * 3) + 1;//Asignar localización al azar

                                switch(loc){
                                    case 1:
                                        System.out.println
                                        ("\nSe le asignará la localidad 1, tiene un precio de $400.\nVerificando disponibilidad...");
                                        if (salesA > 0 && cliente.budg - 400 >= 0){
                                            System.out.println("\nBoleto comprado con éxito");
                                            a++; cliente.budg = cliente.budg - 400;
                                        }
                                        else{
                                            fail();
                                        }
                                    break;

                                    case 2:
                                        System.out.println
                                        ("\nSe le asignará la localidad 5, tiene un precio de $695.\nVerificando disponibilidad...");
                                        if (salesB > 0 && cliente.budg - 695 >= 0){
                                            System.out.println("\nBoleto comprado con éxito");
                                            b++; cliente.budg = cliente.budg - 695;
                                        }
                                        else{
                                            fail();
                                        }
                                    break;

                                    case 3:
                                        System.out.println
                                        ("\nSe le asignará la localidad 10, tiene un precio de $2350.\nVerificando disponibilidad...");
                                        if (salesC > 0 && cliente.budg - 2350 >= 0){
                                            System.out.println("\nBoleto comprado con éxito");
                                            c++; cliente.budg = cliente.budg - 2350;
                                        }
                                        else{
                                            fail();
                                        }
                                    break;
                                }
                            }
                            else{
                                fail();
                            }
                        }

                        sales = sales - cliente.ticket;//Actualizar ventas disponibles
                    }else{
                        fail();
                    }


                    break;
                case 2://Informar al usuario de la cantidad de boletos disponible
                    System.out.println("Disponibilidad de boletos:\n\nLocalidad 1:\nVendidos: "+ a + "\nDisponibles: "+ salesA
                    + "\n\nLocalidad 5:\nVendidos: "+ b + "\nDisponibles: "+ salesB +
                    "\n\nLocalidad 10:\nVendidos: "+ c + "\nDisponibles: "+ salesC + "\n");
                break;
                case 3://Cerrar el programa
                    isRunning = false;
                break;
            
                default://Regresar al menú si se ingresa una opción no admitida
                System.out.println("ERROR: Opción no válida\n");
                    break;
            }
        }
        System.out.println("SALIENDO DEL SISTEMA");
        scan.close();
        
    }

    public static void fail(){
        System.out.println("\nLamentablemente, la compra del boleto no pudo concretarse");//Mensaje de compra fallida
    }
}
