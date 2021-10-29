package com.unicesumar.adsis4s.Projeto.carro;

import java.util.List;

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
}
