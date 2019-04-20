package br.com.fiap.easybeasy.endpoint;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.easybeasy.entity.Produto;
import br.com.fiap.easybeasy.service.ProdutoService;

@RestController
@RequestMapping(path = "/v1/produtos", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
		MediaType.APPLICATION_JSON_UTF8_VALUE })


public class ProdutoEndpoint extends ApplicationEndpoint {
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping("/create/page")
	public ResponseEntity<?> createProduto(@RequestBody @Valid Produto produto) {
		produto = this.produtoService.create(produto);
		if (produto.isValid()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(produto);
		} else {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(produto.getErrors());
		}
	}
	
//	@PutMapping("/{id}")
//	public ResponseEntity<?> saveProduto(@RequestBody @Valid Produto produto, @PathVariable String id) {
//		produto.setId(Long.fromString(id));
//		produto = this.produtoService.save(Produto);
//		if (page.isValid()) {
//			return ResponseEntity.status(HttpStatus.CREATED).body(produto);
//		} else {
//			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(produto.getErrors());
//		}
//	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Optional<Produto> opProduto = this.produtoService.findById(id);
		if (opProduto.isPresent()) {
			return ResponseEntity.ok(opProduto.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}
