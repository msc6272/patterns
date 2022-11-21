package dio.quebec.patterns.service;

/*
 * @see <a href="https://spring.io/projects/spring-cloud-openfeign">Spring Cloud OpenFeigna</a>
 * @see <a href="https://viacep.com.br">Via CEP</a>
 */

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dio.quebec.patterns.model.Endereco;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
    @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")
    //@GetMapping("/{cep}/json/") // O RequestMapping poderia ser substituido por isso
    Endereco consultarCep(@PathVariable("cep") String cep);
}
