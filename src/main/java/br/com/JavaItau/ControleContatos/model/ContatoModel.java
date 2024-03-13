package br.com.JavaItau.ControleContatos.model;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "CONTATOS")
public class ContatoModel {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Number Id;
	
	@Column(name = "tipoContato", nullable = false)
	private Integer TipoContato;
	
	@Column(name = "contato", nullable = false)
	private String Contato;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pessoa", referencedColumnName="id")
	private PessoaModel Pessoa;
	
	
	public ContatoModel(Number id, Integer tipoContato, String contato) {
		super();
		Id = id;
		TipoContato = tipoContato;
		Contato = contato;
	}
	public Number getId() {
		return Id;
	}
	public void setId(Number id) {
		Id = id;
	}
	public Number getTipoContato() {
		return TipoContato;
	}
	public void setTipoContato(Integer tipoContato) {
		TipoContato = tipoContato;
	}
	public String getContato() {
		return Contato;
	}
	public void setContato(String contato) {
		Contato = contato;
	}
	public PessoaModel getIdPessoa() {
		return Pessoa;
	}
	public void setIdPessoa(PessoaModel pessoa) {
		this.Pessoa = pessoa;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContatoModel other = (ContatoModel) obj;
		return Objects.equals(Id, other.Id);
	}
	
	@Override
	public String toString() {
		return "Contato [id=" + Id + ", tipoContato=" + TipoContato + ", contato=" + Contato + ", pessoa=" + Pessoa
				+ "]";
	}
}
