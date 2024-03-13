package br.com.JavaItau.ControleContatos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.JavaItau.ControleContatos.model.ContatoModel;
import br.com.JavaItau.ControleContatos.model.PessoaModel;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoModel, Long>{

	List<ContatoModel> BuscarPorPessoa(Optional<PessoaModel> findPessoa);
}
