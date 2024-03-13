package br.com.JavaItau.ControleContatos.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.JavaItau.ControleContatos.configuration.JwtTokenUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name="TOKEN")
public class AuthController {
    @Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Operation(summary = "Gerador de Tokens para a Sessão")
	@GetMapping("/token") 
	public ResponseEntity<?> createToken(@RequestParam String username){
		String token = jwtTokenUtil.createToken(username);
		return ResponseEntity.ok(token);
	}
}
