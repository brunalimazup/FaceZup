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

	public PostagemModel salvarPostagem(PostagemModel postagemModel) {
		return faceRepository.save(postagemModel);
	}
	public PostagemModel apagarPostagem(int id) {
		faceRepository.deleteById(id);
		return null;
	}
	public PostagemModel atualizarMensagem(int id, PostagemModel postagem) {
		postagem.setId(id);
	return faceRepository.save(postagem);
	}
}
