package br.com.fiap.easybeasy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.easybeasy.entity.Produto;
import br.com.fiap.easybeasy.repo.ProdutoRepo;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	@Autowired
	private ProdutoRepo produtoRepo;
	
	public Produto create(Produto produto) {
		produtoRepo.save(produto);
		
		return produto;
	}
	
	public void delete(Long id) {
			
		Optional<Produto> opProduto = produtoRepo.findById(id);
		
		if(opProduto.isPresent()) {
			Produto produtoRecuperado = opProduto.get();
			produtoRepo.delete(produtoRecuperado);
		}
	}
	
	public Optional<Produto> findById (Long id) {
		
		return this.produtoRepo.findById(id);
		
	}
	
	
	
	
}
