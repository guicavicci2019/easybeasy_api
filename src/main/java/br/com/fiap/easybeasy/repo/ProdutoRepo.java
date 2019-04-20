package br.com.fiap.easybeasy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.easybeasy.entity.Produto;

public interface ProdutoRepo  extends JpaRepository <Produto, Long> {

}
