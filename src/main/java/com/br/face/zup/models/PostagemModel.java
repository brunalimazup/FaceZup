package com.br.face.zup.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class PostagemModel implements Serializable {
	private static final long serialVersionUID = 1L;

		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		@NotNull (message = "Esse campo não pode ficar em branco")
		private String foto;
		@NotNull (message = "Esse campo não pode ficar em branco")
		private String usuario;
		@NotNull (message = "Esse campo não pode ficar em branco")
		private String postagem;

		public PostagemModel () {

		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getFoto() {
			return foto;
		}

		public void setFoto(String foto) {
			this.foto = foto;
		}

		public String getPostagem() {
			return postagem;
		}

		public void setPostagem(String postagem) {
			this.postagem = postagem;
		}

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		@Override
		public String toString() {
			StringBuilder modelo = new StringBuilder();

			modelo.append("Usuario: " + this.usuario);
			modelo.append("\n");
			modelo.append("Postou: " + this.postagem);

			return modelo.toString();
		}

	}

