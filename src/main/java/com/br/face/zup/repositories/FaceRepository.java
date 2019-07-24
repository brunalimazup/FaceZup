package com.br.face.zup.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.face.zup.models.PostagemModel;
@Repository
public interface FaceRepository extends CrudRepository<PostagemModel, Integer>{

}
