package com.algaworks.algafood.cozinhas;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.EntidadeEmUsoException;
import com.algaworks.algafood.EntidadeNaoEncontradaException;


@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	
	@Autowired
	private CadastroCozinhaService cadastroCozinha;
	
	@GetMapping
	public List<Cozinha> listar() {
		return cozinhaRepository.listar();
	}
	
	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
		Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);	
	
		if(cozinha != null) {
			return ResponseEntity.ok(cozinha);
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@PostMapping
	public void adicionar(@RequestBody Cozinha cozinha) {
		cadastroCozinha.salvar(cozinha);
	}
	
	//Put ( atualizar alguma cozinha)
	//Busca a cozinha atual no banco pelo seu id
	// vamos colocar essa Cozinha atual com os mesmos atributos da cozinha que estou passando nomeu body
	//cozinhaAtual.setNome(cozinha.getNome());
	//mais facil usar BeanUtils para copiar esses atributos
	//o terceiro parametro no BeanUtils eh o que vc nao quer que seja copiado....que seria o id
	
	@PutMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId, @RequestBody Cozinha cozinha){
		Cozinha cozinhaAtual = cozinhaRepository.buscar(cozinhaId);
		BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
		cozinhaRepository.salvar(cozinhaAtual);
		return ResponseEntity.ok(cozinhaAtual);
	}
	
	
	//Vamos ter um try catch pq se tentar deletar uma cozinha vinculada a restaurante, pode dar conflito
	@DeleteMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId){
		
		try {
			cadastroCozinha.excluir(cozinhaId);	
			return ResponseEntity.noContent().build();
			
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
			
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}


		
		
	
	
	
	
