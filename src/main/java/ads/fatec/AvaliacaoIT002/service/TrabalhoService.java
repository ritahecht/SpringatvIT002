package ads.fatec.AvaliacaoIT002.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import ads.fatec.AvaliacaoIT002.entity.Trabalho;
import ads.fatec.AvaliacaoIT002.repository.TrabalhoRepository;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepo;

    // Método para cadastro de um novo trabalho
    public Trabalho novoTrabalho(Trabalho trabalho) {
        // Valida se o título e o grupo estão preenchidos
        if (trabalho == null || !StringUtils.hasText(trabalho.getTitulo()) || !StringUtils.hasText(trabalho.getGrupo())) {
            throw new IllegalArgumentException("Título e grupo são obrigatórios!");
        }

        // Define a data/hora de entrega atual se não estiver preenchida
        if (trabalho.getDataHoraEntrega() == null) {
            trabalho.setDataHoraEntrega(LocalDateTime.now());
        }

        // Salva o trabalho no repositório
        return trabalhoRepo.save(trabalho);
    }

    // Método para listar todos os registros da tabela Trabalho
    public List<Trabalho> buscarTodos() {
        return (List<Trabalho>) trabalhoRepo.findAll();
    }

    // Método para buscar trabalhos que contenham uma palavra no título e nota maior que um valor específico
    public List<Trabalho> buscarPorPalavraNoTituloENotaMaiorQue(String palavra, Integer nota) {
        if (palavra == null || nota == null) {
            throw new IllegalArgumentException("Parâmetros inválidos!");
        }
        return trabalhoRepo.buscarPorPalavraNoTituloENotaMaiorQue(palavra, nota);
    }
}
