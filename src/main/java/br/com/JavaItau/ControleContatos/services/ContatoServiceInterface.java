package br.com.JavaItau.ControleContatos.services;

import java.util.List;
import java.util.Optional;

import br.com.JavaItau.ControleContatos.model.ContatoModel;

public interface ContatoServiceInterface {

	void DeletarContato(Long id);

	ContatoModel AtualizarContato(ContatoModel contato);

	Optional<ContatoModel> BuscarPorIdContato(Long id);

	List<ContatoModel> BuscarPorPessoa(Long idPessoa);

	ContatoModel CriarContato(ContatoModel contato);

}
