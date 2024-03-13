package br.com.JavaItau.ControleContatos.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.JavaItau.ControleContatos.dto.MalaDiretaDTO;
import br.com.JavaItau.ControleContatos.model.PessoaModel;
import br.com.JavaItau.ControleContatos.services.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Pessoa")
@RequestMapping("/api/pessoa")
public class PessoaController {
	private PessoaService _pessoaService;

	public PessoaController(PessoaService pessoaService) {
		this._pessoaService = pessoaService;
	}

	@Operation(summary = "Busca uma pessoa pelo id.")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<PessoaModel>> BuscarPorId(@PathVariable Long id) {
		Optional<PessoaModel> pessoa = _pessoaService.BuscarPorId(id);
		if (pessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(pessoa);
	}

	@Operation(summary = "Busca todas as pessoas cadastradas.")
	@GetMapping
	public ResponseEntity<List<PessoaModel>> BuscarPessoas() {
		List<PessoaModel> pessoa = _pessoaService.BuscarPessoas();
		if (pessoa == null)
			return ResponseEntity.notFound().build();
		if (pessoa.size() == 0)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(pessoa);
	}

	@Operation(summary = "Busca a mala direta de uma pessoa.")
	@GetMapping("/maladireta/{id}")
	public ResponseEntity<Optional<MalaDiretaDTO>> BuscarMalaDireta(@PathVariable Long id) {
		Optional<MalaDiretaDTO> malaDireta = _pessoaService.BuscarMalaDireta(id);

		if (!malaDireta.isPresent())
			return ResponseEntity.notFound().build();
		else {
			return ResponseEntity.ok(malaDireta);
		}
	}

	@Operation(summary = "Cadastra uma pessoa.")
	@PostMapping
	public ResponseEntity<PessoaModel> CriarPessoa(@RequestBody PessoaModel pessoa) {
		PessoaModel newPessoa = _pessoaService.CriarPessoa(pessoa);
		if (newPessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(newPessoa);
	}

	@Operation(summary = "Atualiza uma pessoa.")
	@PutMapping
	public ResponseEntity<PessoaModel> AtualizarPessoa(@RequestBody PessoaModel pessoa) {
		PessoaModel upPessoa = _pessoaService.AtualizarPessoa(pessoa);
		if (upPessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(upPessoa);
	}

	@Operation(summary = "Exclui uma pessoa.")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> DeletaPessoa(@PathVariable Long id) {
		_pessoaService.DeletaPessoa(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}