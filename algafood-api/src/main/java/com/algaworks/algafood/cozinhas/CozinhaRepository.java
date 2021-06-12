package com.algaworks.algafood.cozinhas;

import java.util.List;


public interface CozinhaRepository {

	List<Cozinha> listar();
	Cozinha buscar(Long id);
	Cozinha salvar(Cozinha cozinha);
	
	void remover(Long id);
}
