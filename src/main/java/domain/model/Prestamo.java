package domain.model;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "prestamo")
public class Prestamo {
    @Id
    @SequenceGenerator(name = "seq_prestamo_generador", sequenceName = "seq_prestamo", allocationSize = 1)
    @GeneratedValue(generator = "seq_prestamo_generador", strategy = GenerationType.SEQUENCE)
    @Column(name = "pres_id")
    private Integer id;
    @Column(name = "pres_fecha_prestamo")
    private LocalDate fechaPrestamo;
    @Column(name = "pres_fecha_devolucion")
    private LocalDate fechaDevolucion;
    @Column(name = "pres_nombre_prestamo")
    private String nombreEstudiante;
    @ManyToOne
    @JoinColumn(name = "pres_libro")
    private Libro libro;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }
    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }
    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    public String getNombreEstudiante() {
        return nombreEstudiante;
    }
    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }
    public Libro getLibro() {
        return libro;
    }
    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    @Override
    public String toString() {
        return "Prestamo [id=" + id + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion
                + ", nombreEstudiante=" + nombreEstudiante + ", libro=" + libro.getTitulo() + "]";
    }
    
}
