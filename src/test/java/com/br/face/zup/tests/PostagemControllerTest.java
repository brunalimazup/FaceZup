package com.br.face.zup.tests;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.br.face.zup.models.PostagemModel;
import com.br.face.zup.services.PostagemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import com.br.face.zup.controllers.PostagemRestController;

@RunWith(SpringRunner.class)
@WebMvcTest(PostagemRestController.class)
public class PostagemControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PostagemService postagemService;

	private PostagemModel postagemModel;

	@Before
	public void preparar() {
		postagemModel = new PostagemModel();

		postagemModel.setId(1);
		postagemModel.setPostagem("2019 está sendo um ano dificil.");
		postagemModel.setUsuario("Milena");
		postagemModel.setFoto("foto");
	}

	@Test
	public void testarGetPostagem() throws Exception {
		List<PostagemModel> postagens = Arrays.asList(postagemModel);
		given(postagemService.retornarPostagens()).willReturn(postagens);
		this.mockMvc .perform(get("/postagem")).andExpect(status().isOk());

	}

	@Test
	public void testarAtualizarPostagem() throws Exception {
		List<PostagemModel> postagem = Arrays.asList(postagemModel);
		given(postagemService.atualizarMensagem(1, postagemModel)).willReturn(postagemModel);
		this.mockMvc .perform(put("/postagem/{id}", 1).content(transformarEmJson(postagemModel))
				     .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				     .andExpect(status().isOk()).andExpect(jsonPath("$.id").value(1));
	}

	@Test
	public void testarSalvarMensagem() throws Exception {
		postagemModel.setId(1);
		given(postagemService.salvarPostagem(postagemModel)).willReturn(postagemModel);
		this.mockMvc .perform(post("/postagem").content(transformarEmJson(postagemModel))
					 .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				     .andExpect(status().isCreated()).andExpect(jsonPath("$.id").value(1));
	}

	@Test
	public void testarDeletarPostagem() throws Exception {
		List<PostagemModel> postagem = Arrays.asList(postagemModel);
		given(postagemService.apagarPostagem(1)).willReturn(postagemModel);
		this.mockMvc .perform(delete("/postagem/{id}", 1).content(transformarEmJson(postagemModel))
				     .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
	}

	public static String transformarEmJson(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
