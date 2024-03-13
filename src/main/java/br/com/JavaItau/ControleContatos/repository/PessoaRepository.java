package br.com.JavaItau.ControleContatos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.JavaItau.ControleContatos.model.PessoaModel;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Long>{
	
	@Query(value = "SELECT p.id, p.nome, p.endereco, p.cep, p.cidade, p.uf FROM pessoa p WHERE p.id = :id ", nativeQuery = true)
	Optional<PessoaModel> findMalaDireta(Long id);

	
}
