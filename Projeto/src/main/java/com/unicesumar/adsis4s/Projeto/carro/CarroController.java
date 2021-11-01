package com.unicesumar.adsis4s.Projeto.carro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
   public String salvarCarro(@RequestBody Carro novo) {
	   return service.salvarCarro(novo).getId();
   }
}
