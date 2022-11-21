package dio.quebec.patterns.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dio.quebec.patterns.model.Cliente;

//O CrudRepository é uma implementação do Strategy (Project Pattern)
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    ;
}
