package br.com.JavaItau.ControleContatos.dto;

import br.com.JavaItau.ControleContatos.model.PessoaModel;

public class MalaDiretaDTO {

	private String Endereco;
	private String CEP;
	private String Cidade;
	private String UF;
	private String EnderecoMala;

	public MalaDiretaDTO(PessoaModel pessoa) {
		Endereco = pessoa.getEndereco();
		CEP = pessoa.getCEP();
		Cidade = pessoa.getCidade();
		UF = pessoa.getUF();
	}

	public String getEnderecoMala() {
		return EnderecoMala;
	}
	
	public void setEnderecoMala(PessoaModel pessoa) {
		this.EnderecoMala = pessoa.getEndereco() + " - " + pessoa.getCEP() + " - " + pessoa.getCidade() + " - " + 
				pessoa.getUF();
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
}
