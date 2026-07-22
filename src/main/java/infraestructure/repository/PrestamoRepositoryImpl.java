package infraestructure.repository;

import domain.model.Prestamo;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class PrestamoRepositoryImpl implements PanacheRepositoryBase<Prestamo, Integer> {

}
