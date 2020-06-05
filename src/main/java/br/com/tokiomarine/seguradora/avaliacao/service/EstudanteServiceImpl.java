package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;

// TODO Efetue a implementação dos métodos da classe service
@Service
public class EstudanteServiceImpl implements EstudandeService {

	@Autowired
	EstudanteRepository repository;

	@Override
	public void cadastrarEstudante(@Valid Estudante estudante) {
		repository.save(estudante);
	}

	@Override
	public void atualizarEstudante(@Valid Estudante estudante) {
		repository.save(estudante);
	}

	@Override
	public List<Estudante> buscarEstudantes() {
		Iterable<Estudante> it = repository.findAll();

		List<Estudante> estudantes = new ArrayList<Estudante>();

		for (Estudante e : it) {
			estudantes.add(e);
		}

		return estudantes;
	}

	@Override
	public Estudante buscarEstudante(long id) {
		if (id == 0) {
			throw new IllegalArgumentException("Identificador inválido:" + id);
		}

		if(repository.findById(id).isPresent()) {
			return repository.findById(id).get();
		}
		return null;
	}
	
	public Boolean apagarEstudante(Long id) {
		if(repository.findById(id).isPresent()) {
			repository.deleteById(id);
			return Boolean.TRUE;
		}
		
		return Boolean.FALSE;
		
	}

}
