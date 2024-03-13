package br.com.JavaItau.ControleContatos.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.JavaItau.ControleContatos.model.ContatoModel;
import br.com.JavaItau.ControleContatos.services.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Contatos")
@RequestMapping("/api/contatos")
public class ContatoController {

	private ContatoService _contatoService;

	public ContatoController(ContatoService contatoService) {
		this._contatoService = contatoService;
	}

	@Operation(summary = "Busca registros de pessoas por ID")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ContatoModel>> BuscarPorIdContato(@PathVariable Long id){
		Optional<ContatoModel> contato = _contatoService.BuscarPorIdContato(id);
		if(contato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(contato);
	}
	
	@Operation(summary = "Busca todos contato cadastrados para um pessoa.")
	@GetMapping("{idPessoa}/contatos") 
	public ResponseEntity<List<ContatoModel>> BuscarPorPessoa(@PathVariable Long idPessoa){
		List<ContatoModel> contato = _contatoService.BuscarPorPessoa(idPessoa);
		if(contato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(contato);
	}
	
	@Operation(summary = "Cria um contato.")
	@PostMapping
	public ResponseEntity<ContatoModel> CriarContato(@RequestBody ContatoModel contato){
		ContatoModel newContato = _contatoService.CriarContato(contato);
		if(newContato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(newContato);
	}

	@Operation(summary = "Atualiza o contato.")
	@PutMapping
	public ResponseEntity<ContatoModel> AtualizarContato(@RequestBody ContatoModel contato){
		ContatoModel upContato = _contatoService.AtualizarContato(contato);
		if(upContato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(upContato);
	}

	@Operation(summary = "Exclui um contato.")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		_contatoService.DeletarContato(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
