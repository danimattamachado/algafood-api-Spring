package com.algaworks.algafood.restaurantes;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository {
	List<Restaurante> listar();
	Restaurante buscar(Long id);
	Restaurante salvar(Restaurante restaurante);
	void remover(Restaurante restaurante);
}
