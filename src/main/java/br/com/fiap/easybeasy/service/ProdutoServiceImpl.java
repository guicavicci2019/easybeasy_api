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
		
		Produto newProduto = new Produto();
		
		newProduto.setNome(produto.getNome());
		newProduto.setCategoria(produto.getCategoria());
		newProduto.setNomeLoja(produto.getNomeLoja());
		newProduto.setRuaLoja(produto.getRuaLoja());
		newProduto.setNumeroLoja(produto.getNumeroLoja());
		newProduto.setTelLoja(produto.getTelLoja());
		newProduto.setValor(produto.getValor());
		newProduto.setNota(produto.getNota());
		
		
		
		if (newProduto.isValid()) {
			
			produtoRepo.save(newProduto);
		}
		
		return newProduto;
	}
	
	public void delete(Long id) {
			
		Optional<Produto> opProduto = produtoRepo.findById(id);
		
		if(opProduto.isPresent()) {
			Produto produtoRecuperado = opProduto.get();
			produtoRepo.delete(produtoRecuperado);
		}
	}
	
	public Optional<Produto> findById(Long id) {
		
		return this.produtoRepo.findById(id);
		
	}
	
	
	
	
}
