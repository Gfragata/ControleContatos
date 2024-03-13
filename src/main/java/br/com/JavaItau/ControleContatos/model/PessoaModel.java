package br.com.JavaItau.ControleContatos.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PESSOA")
public class PessoaModel {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Number Id;
	
	@Column(name = "nome", nullable = false)
	private String Nome;
	
	@Column(name = "logradouro", nullable = true)
	private String Endereco;
	
	@Column(name = "cep", nullable = true, length = 10) //
	private String CEP;
	
	@Column(name = "municipio", nullable = true)
	private String Cidade;
	
	@Column(name = "uf", nullable = true, length = 2)
	private String UF;

	@OneToMany(cascade = CascadeType.ALL,
			mappedBy="contato",
			targetEntity = ContatoModel.class)
	private List<ContatoModel> contatos;
	
	public PessoaModel() {
	}

	public PessoaModel(Number id, String nome, String endereco, String cEP, String cidade, String uF) {
		this.Id = id;
		this.Nome = nome;
		this.Endereco = endereco;
		this.CEP = cEP;
		this.Cidade = cidade;
		this.UF = uF;
	}

	public Number getId() {
		return Id;
	}

	public void setId(Number id) {
		Id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getCidade() {
		return Cidade;
	}

	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
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
		PessoaModel other = (PessoaModel) obj;
		return Objects.equals(Id, other.Id);
	}
	
	@Override
	public String toString() {
		return "[id = " + this.Id +
				", nome = " + this.Nome +
				", endereco = " + this.Endereco +
				", cep = " + this.CEP +
				", cidade = " + this.Cidade +
				", uf = " + this.UF + "]";
	}
}