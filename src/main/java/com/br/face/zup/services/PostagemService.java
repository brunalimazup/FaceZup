package com.br.face.zup.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.face.zup.models.PostagemModel;
import com.br.face.zup.repositories.FaceRepository;

@Service
public class PostagemService {

	@Autowired
	public FaceRepository faceRepository;

	public Iterable <PostagemModel> retornarPostagens() {
		return faceRepository.findAll();
	}

	public void salvarPostagem(PostagemModel postagemModel) {
		faceRepository.save(postagemModel);
	}
	public void apagarPostagem(int id) {
		faceRepository.deleteById(id);
	}
	public void atualizarMensagem(int id, PostagemModel postagem) {
		postagem.setId(id);
	faceRepository.save(postagem);
	}
}
