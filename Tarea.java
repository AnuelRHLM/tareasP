package tareas;
import java.time.LocalDate;

public class Tarea {
    private String titulo_tarea;
    private String descripcion_tarea;
    private LocalDate fecha_entrega_tarea;
    private Prioridad prioridad;
    private String estado;

    public Tarea(String titulo_tarea, String descripcion_tarea, LocalDate fecha_entrega_tarea, Prioridad prioridad) {
        this.titulo_tarea = titulo_tarea;
        this.descripcion_tarea = descripcion_tarea;
        this.fecha_entrega_tarea = fecha_entrega_tarea;
        this.prioridad = prioridad;
        this.estado = "Pendiente";
    }

    public String getTitulo_tarea() {
        return titulo_tarea;
    }

    public void setTitulo_tarea(String titulo_tarea) {
        this.titulo_tarea = titulo_tarea;
    }

    public String getDescripcion_tarea() {
        return descripcion_tarea;
    }

    public void setDescripcion_tarea(String descripcion_tarea) {
        this.descripcion_tarea = descripcion_tarea;
    }

    public LocalDate getFecha_entrega_tarea() {
        return fecha_entrega_tarea;
    }

    public void setFecha_entrega_tarea(LocalDate fecha_entrega_tarea) {
        this.fecha_entrega_tarea = fecha_entrega_tarea;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
