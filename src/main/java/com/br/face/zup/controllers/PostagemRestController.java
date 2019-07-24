package com.br.face.zup.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.face.zup.models.PostagemModel;
import com.br.face.zup.services.PostagemService;

@RestController
@RequestMapping("/postagem")
public class PostagemRestController {

	@Autowired
	PostagemService postagemService;

	@GetMapping
	public ResponseEntity<?> getPostagem() {
		List<PostagemModel> postagens = new ArrayList<PostagemModel>();
		Iterable<PostagemModel> post = postagemService.retornarPostagens();

		for (PostagemModel posti : post) {
			postagens.add(posti);
		}

		return ResponseEntity.ok(postagens);
	}

	@PostMapping
	public ResponseEntity<PostagemModel> criarPostagem(@RequestBody PostagemModel postagem) {
		postagemService.salvarPostagem(postagem);
		return ResponseEntity.status(HttpStatus.CREATED).body(postagem);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PostagemModel> atualizarPostagem (@PathVariable int id,@Valid @RequestBody PostagemModel postagem) {
		postagemService.atualizarMensagem(id, postagem);
		return ResponseEntity.ok(postagem);
}
	@DeleteMapping ("/{id}")
	public ResponseEntity apagarPostagem(@PathVariable int id) {
		postagemService.apagarPostagem(id);
		return ResponseEntity.ok().build();
	}
	
}