package br.com.JavaItau.ControleContatos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.JavaItau.ControleContatos.exception.ResourceNotFoundException;
import br.com.JavaItau.ControleContatos.model.ContatoModel;
import br.com.JavaItau.ControleContatos.model.PessoaModel;
import br.com.JavaItau.ControleContatos.repository.ContatoRepository;
import br.com.JavaItau.ControleContatos.repository.PessoaRepository;

@Service
public class ContatoService implements ContatoServiceInterface{

	private ContatoRepository _contatoRepository;
	private PessoaRepository _pessoaRepository;
	
	@Autowired
	public ContatoService(ContatoRepository contatoRepository, PessoaRepository pessoaRepository) {
		this._contatoRepository = contatoRepository;
		this._pessoaRepository = pessoaRepository;
	}

	@Override
	public Optional<ContatoModel> BuscarPorIdContato(Long id) {
		return _contatoRepository.findById(id);

	}
	
	@Override
	public List<ContatoModel> BuscarPorPessoa(Long idPessoa) {

		if(idPessoa != 0) {
			Optional<PessoaModel> findPessoa = _pessoaRepository.findById(idPessoa);
			if(findPessoa.isEmpty()) {
				throw new ResourceNotFoundException("Não foi possivel encontrar a pessoa");
			}else {

				return _contatoRepository.BuscarPorPessoa(findPessoa);
			}
		}else {
			throw new ResourceNotFoundException("Não foi possivel encontrar a pessoa");
		}
	}

	@Override
	public ContatoModel AtualizarContato(ContatoModel contato) {
		Optional<ContatoModel> findContato = _contatoRepository.findById((Long) contato.getId());
		if(findContato.isPresent()) {
			ContatoModel updateContato = findContato.get(); //setId
			updateContato.setTipoContato(contato.getTipoContato().intValue());
			updateContato.setIdPessoa(contato.getIdPessoa());
			return _contatoRepository.save(updateContato);
		}
		return contato;
	}

	@Override
	public ContatoModel CriarContato(ContatoModel contato) {
		if(contato.getIdPessoa() != null) {
			Optional<PessoaModel> findPessoa = _pessoaRepository.findById(contato.getIdPessoa().getId().longValue());
			if(findPessoa.isEmpty()) {

				throw new ResourceNotFoundException(" Não foi possivel encontrar a pessoa ");
	
			}else {
				contato.setIdPessoa(findPessoa.get());
				return _contatoRepository.save(contato);
			}
		}else {
			
			throw new ResourceNotFoundException("Não foi possivel encontrar a pessoa");
		}
	}
	
	@Override
	public void DeletarContato(Long id) {
		_contatoRepository.deleteById(id);;
	}
}
