package com.unicesumar.adsis4s.Projeto.carro;

import java.util.List;
import com.unicesumar.adsis4s.Projeto.base.RegistroJaExistente;

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
   
   
}
