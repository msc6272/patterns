package dio.quebec.patterns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.quebec.patterns.model.Cliente;
import dio.quebec.patterns.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/*
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integrações (Banco de Dados H2 e API do ViaCEP) em um
 * interface simples e coesa (API REST)
 */

/*
 * @see <a href="https://springdoc.org/#migrating-from-springfox">springdoc-openapi v1.6.13</a>
 */


@RestController
@RequestMapping("clientes")
@Tag(name = "Cliente Controller")
public class ClienteRestController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    @Operation(summary = "Buscar todos os clientes", description = "Lista todos os clientes")
    public ResponseEntity<Iterable<Cliente>> buscarTodos() {
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar cliente por ID", description = "Lista um cliente específico")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Inserir cliente", description = "Insere um único cliente")
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {
        clienteService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar cliente por ID", description = "Atualiza os dados de um determinado cliente")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        clienteService.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover cliente por ID", description = "Remove um cliente específico")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
