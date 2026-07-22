package web.resource;

import java.util.List;

import application.service.LibroService;
import domain.model.Libro;
import domain.model.Prestamo;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/libro")
public class LibroResource {
    @Inject
    private LibroService libroService;

    @Path("/guardar")
    @POST
    public void guardar(Libro libro) {
        this.libroService.guardar(libro);
        ;
    }

    @Path("/buscarPorId/{id}")
    @GET
    public Libro buscarPorId(@PathParam("id") Integer id) {
        return this.libroService.buscarPorId(id);
    }

    @Path("/buscarTodos")
    @GET
    public List<Libro> buscarTodos() {
        return this.libroService.buscarTodos();
    }

    @Path("/actualizar/{id}")
    @PUT
    public void actualizar(Libro libro, @PathParam("id") Integer id) {
        this.libroService.actualizar(libro, id);
     }

    @Path("/librosPorCategoria/{categoria}")
    @GET
    public List<Libro> librosPorCategoria(@PathParam("categoria") String categoria) {
        return this.libroService.librosPorCategoria(categoria);
    }

    @Path("/consultarLibrosPorTexto/{txt}")
    @GET
    public List<Libro> consultarLibrosPorTexto(@PathParam("txt")String txt) {
        return this.libroService.consultarLibrosPorTexto(txt);
    }

    @Path("/contarPrestamosPorLibro/{idLibro}")
    @GET
    public Long contarPrestamosPorLibro(@PathParam("idLibro") Integer idLibro) {
        return this.libroService.contarPrestamosPorLibro(idLibro);
    }

    @Path("/consultarPrestamosNombreEstudiante/{nombreEstudiante}")
    @GET
    public List<Prestamo> consultarPrestamosNombreEstudiante(@PathParam("nombreEstudiante") String nombreEstudiante) {
        return this.libroService.consultarPrestamosNombreEstudiante(nombreEstudiante);
    }

    @Path("/consultarLibrosDisponibles")
    @GET
    public List<Libro> consultarLibrosDisponibles() {
        return this.libroService.consultarLibrosDisponibles();
    }

}
