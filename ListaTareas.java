package tareas;
public class ListaTareas {
    private Nodo inicio;

    public ListaTareas() {
        this.inicio = null;
    }

    public void agregar_tarea(Tarea tarea) {
        Nodo nuevo = new Nodo(tarea);

        if (inicio == null) {
            inicio = nuevo;
        } else if (tarea.getFecha_entrega_tarea().isBefore(inicio.getTarea().getFecha_entrega_tarea())) {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        } else if (tarea.getFecha_entrega_tarea().isEqual(inicio.getTarea().getFecha_entrega_tarea())
                && tarea.getPrioridad().getValor() > inicio.getTarea().getPrioridad().getValor()) {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        } else {
            Nodo actual = inicio;

            while (actual.getSiguiente() != null
                    && (actual.getSiguiente().getTarea().getFecha_entrega_tarea().isBefore(tarea.getFecha_entrega_tarea())
                    || (actual.getSiguiente().getTarea().getFecha_entrega_tarea().isEqual(tarea.getFecha_entrega_tarea())
                    && actual.getSiguiente().getTarea().getPrioridad().getValor() >= tarea.getPrioridad().getValor()))) {

                actual = actual.getSiguiente();
            }

            nuevo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevo);
        }
    }

    public Tarea eliminar_tarea(String titulo) {
        if (inicio == null) {
            System.out.println("No se encontró la tarea");
            return null;
        }

        if (inicio.getTarea().getTitulo_tarea().equalsIgnoreCase(titulo)) {
            Tarea tarea = inicio.getTarea();
            inicio = inicio.getSiguiente();
            System.out.println("La tarea " + titulo + " ha sido eliminado correctamente");
            return tarea;
        }

        Nodo actual = inicio;

        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getTarea().getTitulo_tarea().equalsIgnoreCase(titulo)) {
                Tarea tarea = actual.getSiguiente().getTarea();
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                System.out.println("La tarea " + titulo + " ha sido eliminado correctamente");
                return tarea;
            }

            actual = actual.getSiguiente();
        }

        System.out.println("No se encontró la tarea");
        return null;
    }

    public void mostrar_tareas() {
        if (inicio == null) {
            System.out.println("No hay tareas pendientes");
            return;
        }

        Nodo actual = inicio;

        while (actual != null) {
            Tarea tarea = actual.getTarea();

            System.out.println("Titulo: " + tarea.getTitulo_tarea());
            System.out.println("Descripcion: " + tarea.getDescripcion_tarea());
            System.out.println("Fecha de entrega: " + tarea.getFecha_entrega_tarea());
            System.out.println("Prioridad: " + tarea.getPrioridad().getNombre());
            System.out.println("Estado: " + tarea.getEstado());
            System.out.println("----------------------------");

            actual = actual.getSiguiente();
        }
    }

    public Tarea buscar_tarea(String titulo) {
        Nodo actual = inicio;

        while (actual != null) {
            if (actual.getTarea().getTitulo_tarea().equalsIgnoreCase(titulo)) {
                Tarea tarea = actual.getTarea();

                System.out.println("Titulo: " + tarea.getTitulo_tarea());
                System.out.println("Descripcion: " + tarea.getDescripcion_tarea());
                System.out.println("Fecha de entrega: " + tarea.getFecha_entrega_tarea());
                System.out.println("Prioridad: " + tarea.getPrioridad().getNombre());

                return tarea;
            }

            actual = actual.getSiguiente();
        }

        System.out.println("La tarea no fue encontrada");
        return null;
    }

    public void marcar_completa(String titulo) {
        Tarea tarea = buscar_tarea(titulo);

        if (tarea != null) {
            tarea.setEstado("Completa");
            eliminar_tarea(titulo);
        }
    }
}
