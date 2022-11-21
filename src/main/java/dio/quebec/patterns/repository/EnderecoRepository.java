package dio.quebec.patterns.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dio.quebec.patterns.model.Endereco;

//O CrudRepository é uma implementação do Strategy (Project Pattern)
@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
    ;
}
