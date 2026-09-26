package tareas;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ListaTareas lista = new ListaTareas();

        int opcion = 0;

        while (opcion != 6) {
            System.out.println("\n--- GESTION DE TAREAS ---");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Eliminar tarea");
            System.out.println("3. Mostrar tareas");
            System.out.println("4. Buscar tarea");
            System.out.println("5. Marcar tarea como completa");
            System.out.println("6. Salir");
            System.out.println("Ingrese una opcion:");

            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Titulo:");
                    String titulo = leer.nextLine();

                    System.out.println("Descripcion:");
                    String descripcion = leer.nextLine();

                    System.out.println("Fecha de entrega (AAAA-MM-DD):");
                    LocalDate fecha = LocalDate.parse(leer.nextLine());

                    System.out.println("Prioridad:");
                    System.out.println("1. Urgente");
                    System.out.println("2. Alta");
                    System.out.println("3. Media");
                    System.out.println("4. Baja");

                    int opcionPrioridad = leer.nextInt();
                    leer.nextLine();

                    Prioridad prioridad;

                    if (opcionPrioridad == 1) {
                        prioridad = new Prioridad("Urgente", 4);
                    } else if (opcionPrioridad == 2) {
                        prioridad = new Prioridad("Alta", 3);
                    } else if (opcionPrioridad == 3) {
                        prioridad = new Prioridad("Media", 2);
                    } else {
                        prioridad = new Prioridad("Baja", 1);
                    }

                    Tarea tarea = new Tarea(titulo, descripcion, fecha, prioridad);
                    lista.agregar_tarea(tarea);

                    System.out.println("Tarea agregada correctamente");
                    break;

                case 2:
                    System.out.println("Ingrese el titulo de la tarea:");
                    String tituloEliminar = leer.nextLine();
                    lista.eliminar_tarea(tituloEliminar);
                    break;

                case 3:
                    lista.mostrar_tareas();
                    break;

                case 4:
                    System.out.println("Ingrese el titulo de la tarea:");
                    String tituloBuscar = leer.nextLine();
                    lista.buscar_tarea(tituloBuscar);
                    break;

                case 5:
                    System.out.println("Ingrese el titulo de la tarea:");
                    String tituloCompletar = leer.nextLine();
                    lista.marcar_completa(tituloCompletar);
                    break;

                case 6:
                    System.out.println("Programa finalizado");
                    break;

                default:
                    System.out.println("La opcion no es valida");
                    break;
            }
        }

        leer.close();
    }
}
