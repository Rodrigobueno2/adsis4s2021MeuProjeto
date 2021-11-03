package com.unicesumar.adsis4s.Projeto.carro;

import java.util.List;
import com.unicesumar.adsis4s.Projeto.base.RegistroJaExistente;
import com.unicesumar.adsis4s.Projeto.base.RegistroNaoExiste;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class CarroService {
   @Autowired
   private CarroRepository repo;
   
   public List<Carro> obterTodos(){
	  return repo.findAll();
   }

	public Carro salvarCarro(Carro novo) {
		if(repo.findById(novo.getId()).isPresent()) {
			throw new RegistroJaExistente();
		}
		return repo.save(novo);
	}
	
	public void atualizarCarro(Carro carroAtualizar) {
		if(repo.findById(carroAtualizar.getId()).isEmpty()) {
			throw new RegistroNaoExiste();
		}
		
		repo.save(carroAtualizar);
	}
	
	public void deletarCarro(String id) {
		if(repo.findById(id).isEmpty()) {
			throw new RegistroNaoExiste();
		}
		
		repo.deleteById(id);
	}
	
	public Carro pesquisarCarro(String id) {
		if(repo.findById(id).isEmpty()) {
			throw new RegistroNaoExiste();
		}
		
		return repo.findById(id).get();
	}
   
   
}
