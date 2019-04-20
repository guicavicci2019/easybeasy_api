package br.com.fiap.easybeasy.endpoint;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/produtos", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
		MediaType.APPLICATION_JSON_UTF8_VALUE })


public class ProdutoEndpoint extends ApplicationEndpoint {
	
	@PostMapping("/create/page")
	public ResponseEntity<?> createPage(@RequestBody @Valid Page page) {
		page = this.pageService.create(page);
		if (page.isValid()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(page);
		} else {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(page.getErrors());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> savePage(@RequestBody @Valid Page page, @PathVariable String id) {
		page.setId(UUID.fromString(id));
		page = this.pageService.save(page);
		if (page.isValid()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(page);
		} else {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(page.getErrors());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> show(@PathVariable UUID id) {
		Optional<PageEditResult> opPage = this.pageService.findByIdForEdit(id);
		if (opPage.isPresent()) {
			return ResponseEntity.ok(opPage.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}
