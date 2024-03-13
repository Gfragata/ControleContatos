package br.com.JavaItau.ControleContatos.services;

import java.util.List;
import java.util.Optional;

import br.com.JavaItau.ControleContatos.dto.MalaDiretaDTO;
import br.com.JavaItau.ControleContatos.model.PessoaModel;

public interface PessoaServiceInterface {


	PessoaModel AtualizarPessoa(PessoaModel pessoa);

	Optional<PessoaModel> BuscarPorId(Long id);

	PessoaModel CriarPessoa(PessoaModel pessoa);

	List<PessoaModel> BuscarPessoas();

	void DeletaPessoa(Long id);

	Optional<MalaDiretaDTO> BuscarMalaDireta(Long id);
	
}
