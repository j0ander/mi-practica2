package application.service.interceptors;

import java.time.LocalDate;
import java.time.LocalTime;

import domain.model.Libro;
import domain.model.Prestamo;
import infraestructure.repository.LibroRepositoryImpl;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@ValidarDisponibilidad
@Interceptor
@Priority(1)
public class ValidarDisponibilidadInterceptor {
    @Inject
    private LibroRepositoryImpl impl;
    @AroundInvoke
    public Object validar(InvocationContext context)throws Exception{
       Prestamo prestamo = (Prestamo) context.getParameters()[0];
       
       Integer idLibro = prestamo.getLibro().getId();
       
       Libro libro = this.impl.findById(idLibro);
       
       if(libro == null){
        throw new IllegalArgumentException("EL LIBRO NO EXISTE");
       }
       
       if(!libro.getDisponible()){
        throw new IllegalArgumentException("El libro no esta disponible para prestamo");
       }
       System.err.println("metodo: "+ context.getMethod().getName());
       System.err.println("Usuario: " + prestamo.getNombreEstudiante());
       System.err.println("Libro: " + prestamo.getLibro().getTitulo());
       System.err.println("hora: " + LocalTime.now());
       
       prestamo.setLibro(libro);
       return context.proceed();

    }
}
