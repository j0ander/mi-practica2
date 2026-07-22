package infraestructure.repository;

import java.util.List;

import domain.model.Libro;
import domain.model.Prestamo;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@ApplicationScoped
@Transactional
public class LibroRepositoryImpl implements PanacheRepositoryBase<Libro, Integer> {
    @Inject
    private EntityManager em;


    public List<Libro> librosPorCategoria(String categoria){
        TypedQuery<Libro> query = this.em.createQuery(
            "SELECT l FROM Libro l WHERE l.categoria LIKE :categoria", Libro.class
        );
        query.setParameter("categoria", categoria);
        return query.getResultList();
    }

    public List<Libro> consultarLibrosPorTexto(String txt){
        TypedQuery<Libro> query = this.em.createQuery(
            "SELECT l From Libro l Where l.titulo LIKE :txt", Libro.class
        );
        query.setParameter("txt", "%" +txt + "%");
        return query.getResultList();
    }

    public Long contarPrestamosPorLibro(Integer idLibro){
        TypedQuery<Long> query = this.em.createQuery(
            "SELECT COUNT(p) From Prestamo p where p.libro.id = :id ", Long.class
        );
        query.setParameter("id", idLibro);
        return query.getSingleResult();
    }

    public List<Prestamo> consultarPrestamosNombreEstudiante(String nombreEstudiante){
        TypedQuery<Prestamo> query = this.em.createQuery(
          "Select p from Prestamo p where p.nombreEstudiante LIKE :nombreEstudiante", Prestamo.class  
        );
        query.setParameter("nombreEstudiante", nombreEstudiante);
        return query.getResultList();
    }

    public List<Libro> consultarLibrosDisponibles(){
        TypedQuery<Libro> query = this.em.createQuery(
            "Select l from Libro l where l.disponible = true", Libro.class
        );
        return query.getResultList();
    }
}
    
