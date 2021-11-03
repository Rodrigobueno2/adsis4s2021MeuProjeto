package com.unicesumar.adsis4s.Projeto.livro;

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
@RequestMapping("/api/livros")
public class LivroController {
   
	@Autowired
	private LivroService service;
	
	@GetMapping
	public List<Livro> obterLivros(){
		return service.obterTodosLivros();
	}
	
	@GetMapping("/{id}")
	public Livro obterLivroPorId(@PathVariable("id") String id) {
		return service.obterLivroPorId(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public String registrarLivro(@RequestBody Livro livro) {
		return service.registrarLivro(livro).getId();
	}
	
	@PutMapping("/{id}")
	public void atualizarLivro(@PathVariable("id") String id, @RequestBody Livro livro) {
		if(!id.equals(livro.getId())) {
			throw new IdentificadoresDiferentesAoAtualizar();
		}
		
		service.atualizarLivro(livro);
	}
	
	@DeleteMapping("/{id}")
	public void apagarLivro(@PathVariable("id") String id) {
		service.apagarLivro(id);
	}
	
	
}
