package web.resource;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import application.service.PrestamoService;
import application.service.interceptors.ValidarDisponibilidad;
import domain.model.Prestamo;
import infraestructure.repository.PrestamoRepositoryImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/prestamo")
public class PrestamoResource {
    @Inject
    private PrestamoService ps;

    @Path("/guardar")
    @POST
    public void guardar(Prestamo prestamo) {
        this.ps.guardar(prestamo);
    }

    @Path("/guardarParaleloCompletable")
    @POST
    public void guardarParaleloCompletable(Prestamo prestamo) {
        this.ps.guardarParaleloCompletable(prestamo);
    }

    @Path("/guardarExecutor")
    @POST
    public void guardarExecutor(Prestamo prestamo) {
        this.ps.guardarExecutor(prestamo);

    }
    @Path("/buscarTodos")
    @GET
    public List<Prestamo> buscarTodos(){
        return this.ps.buscarTodos();
    }
}
