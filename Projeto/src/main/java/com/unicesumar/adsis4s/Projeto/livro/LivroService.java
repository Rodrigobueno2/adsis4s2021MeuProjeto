package com.unicesumar.adsis4s.Projeto.livro;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicesumar.adsis4s.Projeto.base.RegistroJaExistente;
import com.unicesumar.adsis4s.Projeto.base.RegistroNaoExiste;

@Service
@Transactional
public class LivroService {
   @Autowired
   private LivroRepository repoLivro;
   
   public List<Livro> obterTodosLivros(){
	   return repoLivro.findAll();
   }
   
   public Livro obterLivroPorId(String id) {
	   return repoLivro.findById(id).get();
   }
   
   public Livro registrarLivro(Livro novoLivro) {
	   if(repoLivro.findById(novoLivro.getId()).isPresent()){
		   throw new RegistroJaExistente();
	   }
	   
	   return repoLivro.save(novoLivro);
   }
   
   public void atualizarLivro(Livro livro) {
	   if(repoLivro.findById(livro.getId()).isEmpty()) {
		   throw new RegistroNaoExiste();
	   }
	   
	   repoLivro.save(livro);
   }
   
   public void apagarLivro(String id) {
	   if(repoLivro.findById(id).isEmpty()) {
		   throw new RegistroNaoExiste();
	   }
	   
	   repoLivro.deleteById(id);
   }
}
