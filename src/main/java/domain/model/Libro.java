package domain.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @SequenceGenerator(name = "seq_libro_generador", sequenceName = "seq_libro", allocationSize = 1)
    @GeneratedValue(generator = "seq_libro_generador", strategy = GenerationType.SEQUENCE)
    @Column(name = "libr_id")
    private Integer id;
    @Column(name = "libr_titulo")
    private String titulo;
    @Column(name = "libr_categoria")
    private String categoria;
    @Column(name = "libr_disponible")
    private Boolean disponible;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

   

    @Override
    public String toString() {
        return "Libro [id=" + id + ", titulo=" + titulo + ", categoria=" + categoria + ", disponible=" + disponible
                + "]";
    }
    
}
