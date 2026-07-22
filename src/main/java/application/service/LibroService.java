package application.service;

import java.util.List;

import domain.model.Libro;
import domain.model.Prestamo;
import infraestructure.repository.LibroRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class LibroService {
    @Inject
    private LibroRepositoryImpl impl;

    public void guardar(Libro libro){
        this.impl.persist(libro);
    }

    public Libro buscarPorId(Integer id){
        return this.impl.findById(id);
    }

    public List<Libro> buscarTodos(){
        return this.impl.findAll().list();
    }
    public void actualizar(Libro libro, Integer id){
        Libro libroBase = buscarPorId(id);
        libroBase.setTitulo(libro.getTitulo());
        libroBase.setDisponible(libro.getDisponible());
        libroBase.setCategoria(libro.getCategoria());
    }

    public List<Libro> librosPorCategoria(String categoria){
        return this.impl.librosPorCategoria(categoria);
    }

    public List<Libro> consultarLibrosPorTexto(String txt){
        return this.impl.consultarLibrosPorTexto(txt);
    }

    public Long contarPrestamosPorLibro(Integer idLibro){
        return this.impl.contarPrestamosPorLibro(idLibro);
    }

    public List<Prestamo> consultarPrestamosNombreEstudiante(String nombreEstudiante){
        return this.impl.consultarPrestamosNombreEstudiante(nombreEstudiante);
    }

    public List<Libro> consultarLibrosDisponibles(){
        return this.impl.consultarLibrosDisponibles();
    }


}
