package br.com.JavaItau.ControleContatos.dto;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;

public class PessoaDTO {

	@NamedNativeQuery(
		    name = "build_pessoa_dto",
		    query = "SELECT p.id , p.nome ,format('CEP:',p.endereco, p.cep, p.cidade, p.uf) AS  malaDireta  FROM pessoa p where p.id = ?1",
		    resultSetMapping = "pessoa_dto"
		)

		    
		@SqlResultSetMapping(
		    name = "pessoa_dto",
		    classes = @ConstructorResult(
		        targetClass = PessoaDto.class,
		        columns = {
		            @ColumnResult(name = "id", type = Integer.class),
		            @ColumnResult(name = "nome", type = String.class),
		            @ColumnResult(name = "mala_direta", type = String.class)
		        }
		    )
		)

		@Entity
		public record PessoaDto(@Id Integer id, String nome, String malaDireta) {
		    
		}
}
