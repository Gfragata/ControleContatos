package br.com.JavaItau.ControleContatos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.JavaItau.ControleContatos.dto.MalaDiretaDTO;
import br.com.JavaItau.ControleContatos.exception.ResourceNotFoundException;
import br.com.JavaItau.ControleContatos.model.PessoaModel;
import br.com.JavaItau.ControleContatos.repository.PessoaRepository;

@Service
public class PessoaService implements PessoaServiceInterface {

	private PessoaRepository _pessoaRepository;

	@Autowired
	public PessoaService(PessoaRepository pessoaRepository) {
		this._pessoaRepository = pessoaRepository;
	}
	
	@Override	
	public Optional<MalaDiretaDTO> BuscarMalaDireta(Long id) {
		
		if(this._pessoaRepository.findById(id).isPresent())
		{
			Optional<PessoaModel> pessoa = _pessoaRepository.findMalaDireta(id);
		
			if(pessoa.isPresent())
			{
				MalaDiretaDTO malaDiretaDTO = new MalaDiretaDTO(pessoa.get());
				return Optional.ofNullable(malaDiretaDTO);
			}
			else
				throw new ResourceNotFoundException("[Pessoa] A Pessoa informada não foi encontrada "
						+ "para buscar a mala direta.");
		}
		else
		{
			throw new ResourceNotFoundException("[Pessoa] A Pessoa informada não foi encontrada "
					+ "para buscar a mala direta.");
		}
	}
	
	@Override
	public PessoaModel AtualizarPessoa(PessoaModel pessoa) {
		Optional<PessoaModel> pessoaModel = this._pessoaRepository.findById(pessoa.getId().longValue());

		if (pessoaModel.isPresent()) {
			PessoaModel pessoaUpdated = pessoaModel.get();
			pessoaUpdated.setCEP(pessoa.getCEP());
			pessoaUpdated.setCidade(pessoa.getCidade());
			pessoaUpdated.setEndereco(pessoa.getEndereco());
			pessoaUpdated.setNome(pessoa.getNome());
			pessoaUpdated.setUF(pessoa.getUF());

			return this._pessoaRepository.save(pessoaUpdated);
		} else {
			return pessoa;
		}
	}
	
	@Override
	public List<PessoaModel> BuscarPessoas() {
		return this._pessoaRepository.findAll();
	}

	@Override
	public Optional<PessoaModel> BuscarPorId(Long id) {

		return this._pessoaRepository.findById(id);
	}

	@Override
	public PessoaModel CriarPessoa(PessoaModel pessoa) {
		return this._pessoaRepository.save(pessoa);
	}
	
	@Override
	public void DeletaPessoa(Long id) {
		this._pessoaRepository.deleteById(id);
	}

}
