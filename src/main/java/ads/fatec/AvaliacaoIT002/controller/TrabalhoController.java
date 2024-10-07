package ads.fatec.AvaliacaoIT002.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ads.fatec.AvaliacaoIT002.entity.Trabalho;
import ads.fatec.AvaliacaoIT002.service.TrabalhoService;

@RestController
@RequestMapping(value = "/trabalho")
@CrossOrigin
public class TrabalhoController {
    
    @Autowired
    private TrabalhoService trabalhoService;

    // Rota para listar todos os trabalhos
    @GetMapping
    public List<Trabalho> listarTodosTrabalhos() {
        return trabalhoService.buscarTodos();
    }

    // Rota para cadastrar um novo trabalho
    @PostMapping
    public Trabalho cadastrarTrabalho(@RequestBody Trabalho trabalho) {
        return trabalhoService.novoTrabalho(trabalho);
    }

    // Rota para buscar trabalhos por título (palavra-chave) e nota maior que um valor específico
    @GetMapping("/buscar")
    public List<Trabalho> buscarPorTituloENota(
            @RequestParam String palavra, 
            @RequestParam Integer nota) {
        return trabalhoService.buscarPorPalavraNoTituloENotaMaiorQue(palavra, nota);
    }
}