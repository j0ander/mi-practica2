package application.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import application.service.interceptors.ValidarDisponibilidad;
import domain.model.Prestamo;
import infraestructure.repository.PrestamoRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class PrestamoService {
    @Inject
    private PrestamoRepositoryImpl impl;

    @ValidarDisponibilidad
    public void guardar(Prestamo prestamo) {
        this.impl.persist(prestamo);
    }
    @ValidarDisponibilidad
    public void guardarParaleloCompletable(Prestamo prestamo){
        this.guardar(prestamo);
        CompletableFuture<Void> completableComprobante = CompletableFuture.runAsync(() -> this.generarComprobantePdf());
        CompletableFuture<Void> completableCorreo = CompletableFuture.runAsync(() -> this.envioCorreoElectronico());
        CompletableFuture.allOf(completableComprobante, completableCorreo).join();
    }

    @ValidarDisponibilidad
    public void guardarExecutor(Prestamo prestamo){
        this.guardar(prestamo);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<?> pdf = executor.submit(() -> this.generarComprobantePdf());
        Future<?> correo = executor.submit(() -> this.envioCorreoElectronico());
        try {
            pdf.get();
            correo.get();
        } catch (Exception e) {
            // TODO: handle exception
        }
        executor.shutdown();

    }

    public void generarComprobantePdf(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void envioCorreoElectronico(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<Prestamo> buscarTodos(){
        return this.impl.findAll().list();
    }
}
