package br.com.fiap.easybeasy.service;

import java.util.Optional;

import br.com.fiap.easybeasy.entity.Produto;

public interface ProdutoService {
	
	Produto create(Produto produto);
	
	void delete(Long id);
	
	Optional<Produto> findById(Long id);
	
	

}
