package br.com.JavaItau.ControleContatos.dto;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;

public class ContatoDTO {
	@NamedNativeQuery(
		    name = "build_pessoa_dto",
		    query = "SELECT c.id , c.tipoContato , c.Contato, p.idPessoa  FROM contato as c join pessoa as p on c.idPessoa = p.Id where p.id = ?1",
		    resultSetMapping = "pessoa_dto"
		)
		    
		@SqlResultSetMapping(
		    name = "contato_dto",
		    classes = @ConstructorResult(
		        targetClass = ContatoDto.class,
		        columns = {
		            @ColumnResult(name = "id", type = Long.class),
		            @ColumnResult(name = "tipoContato", type = Integer.class),
		            @ColumnResult(name = "Contato", type = String.class),
		            @ColumnResult(name = "idPessoa", type = Integer.class)
		        }
		    )
		)

		@Entity
		public record ContatoDto(@Id Long id, Integer tipoContato, String Contato) {
		    
		}
}
