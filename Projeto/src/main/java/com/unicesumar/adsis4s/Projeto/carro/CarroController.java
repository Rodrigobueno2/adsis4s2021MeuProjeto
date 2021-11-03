package com.unicesumar.adsis4s.Projeto.carro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unicesumar.adsis4s.Projeto.base.IdentificadoresDiferentesAoAtualizar;

@RestController
@RequestMapping("/api/carros")
public class CarroController {
   @Autowired
   private CarroService service;
   
   @GetMapping
   public List<Carro> obterTodos(){
	   return service.obterTodos();
   }
   
   @PostMapping
   @ResponseStatus(code = HttpStatus.CREATED)
   public String salvarCarro(@RequestBody Carro novo) {
	   return service.salvarCarro(novo).getId();
   }
   
   @PutMapping("/{id}")
   public void atualizarCarro(@PathVariable("id") String id, @RequestBody Carro carroAtualizado){
	   if(!id.equals(carroAtualizado.getId())) {
		   throw new IdentificadoresDiferentesAoAtualizar(); 
	   }
	   service.atualizarCarro(carroAtualizado);
   }
   
   @DeleteMapping("/{id}")
   public void deletarCarro(@PathVariable("id") String id) {
	   service.deletarCarro(id);
   }
   
   @GetMapping("/{id}")
   public Carro obterPorId(@PathVariable("id") String id) {
	   return service.pesquisarCarro(id);
   }
}
