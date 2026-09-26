package tareas;
public class Nodo {
    private Tarea tarea;
    private Nodo siguiente;

    public Nodo(Tarea tarea) {
        this.tarea = tarea;
        this.siguiente = null;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
