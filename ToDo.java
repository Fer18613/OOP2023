package List;
import java.util.*;

public class ToDo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);//Declarar elementos necesarios para establecer un loop de menú, un scanner y el array de eventos.
        int num;
        boolean isRunning = true;
        ArrayList<Tarea> eventos = new ArrayList<>();

        System.out.println("Hola, soy su administrador de quehaceres.");

        while (isRunning){//El programa seguirá corriendo hasta que se le indique lo contrario

            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Nuevo evento\n2. Marcar evento como realizado\n3. Enlistar eventos\n4. Cerrar el programa");
            num = scan.nextInt();//Preguntar al usuario por la acción que desea ejecutar y registrarla en la memoria
            
            switch (num) {//Acciones a tomar de acuerdo con la selección del usuario.
                case 1://Opción 1: agregar nuevo(s) evento(s)

                    System.out.print("Indique la cantidad de eventos a agregar a su lista: ");//Para evitar molestias al usuario,
                    //permitirle añadir cuantos elementos desee
                    int run = scan.nextInt();

                    if (run > 0){//No puede agregarse menos de un evento

                        for(int j = 1; j <= run; j++){//Agregar cuantos eventos definió el usuario
                            String name;//Definir el nombre del evento
                            System.out.print("Ingrese el nombre del evento: ");
                            name = scan.next().toString();

                            eventos.add(new Tarea(name));//Agregar el nuevo evento y pasar al siguiente
                        }
                        System.out.println("\nRegistrado con éxito.");
                    }
                    else{
                        System.out.println("ERROR. NO ES POSIBLE AGREGAR ESA CANTIDAD DE EVENTOS.");//Hacerle saber al usuario que necesita declarar por lo menos un evento
                    }
                break;
                case 2://Opción 2: completar un evento

                    System.out.print("Ingrese el número del evento que quiere completar: ");
                    int id = scan.nextInt();//El usuario seleccionará el evento que quiere completar
                    id--;//El número debe restarse por 1 para no caer en una excepción Out of Bounds

                    if (id < eventos.size() && id >= 0){//Proceder únicamente si el número de evento es válido.
                        eventos.get(id).isComplete = true;//Completar el evento
                        System.out.println("¡Evento completado!\n");
                    }
                    else{
                        System.out.println("El número de evento no es válido.");
                    }
                break;
                case 3://Opción 3: Enlistar eventos
                if(eventos.isEmpty() == false){//Sólamente enlistar eventos de un array con objetos.
                    int count = 1;//Enumerador

                    System.out.println("Sus quehaceres son:\n");
                        for(int i = 0; i < eventos.size(); i++){//Analizar cada objeto del array y determinar si se ha completado
                            boolean check = eventos.get(i).isComplete;
                            String estado;
                            
                            if (check){//Si se ha completado o no, asignarlo a un string.
                                estado = "- COMPLETO";
                            }
                            else{
                                estado = "- INCOMPLETO";
                            }

                            System.out.println(count+ ". " + eventos.get(i).name + " " + estado);
                            count++;//Formato: Número. Nombre - Completo/Incompleto
                        }
                    } else {
                        System.out.println("Usted no tiene eventos asignados aún...\n");//Si no hay eventos, avisarle al usuario.
                    }
                break;
                case 4://Opción 4: Cerrar el programa
                    isRunning = false;//While loop finaliza aquí
                break;
                default://Regresar al menú si se ingresa una opción no admitida
                System.out.println("ERROR: Opción no válida");
                break;
            }
        }
        System.out.println("SALIENDO DEL SISTEMA");//Finalizar con la interacción con el usuario.
        scan.close();//Cerrar el scanner.
    }
}
