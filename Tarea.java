package List;

public class Tarea {
    final String name;//Nombre del evento
    boolean isComplete;//Determina si el evento ha sido completado

    public Tarea(String name){
        this.name = name;//Ingresar el nombre del evento.
        this.isComplete = false;//Por defecto, el evento está incompleto.
    }
}
