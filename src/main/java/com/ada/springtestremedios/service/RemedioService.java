package com.ada.springtestremedios.service;

import com.ada.springtestremedios.domain.Remedio;
import com.ada.springtestremedios.repository.RemedioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Beans - Feijões
@AllArgsConstructor // Responsável por criar um construtor para injetar a depedencia
public class RemedioService {

    private final RemedioRepository remedioRepository;

    public Remedio adicionaRemedio(Remedio remedio) {
        return remedioRepository.save(remedio);
    }

    public List<Remedio> listarRemedios() {
        return remedioRepository.findAll();
    }

    public Remedio buscaPorId(Long id) {
        Optional<Remedio> remedioOptional = remedioRepository.findById(id);
        if (remedioOptional.isEmpty()) {
            throw new IllegalArgumentException("Id não é valido");
        }
        return remedioOptional.get();
    }

    public Remedio removeRemedio(Long id) {
        Remedio remedio = this.buscaPorId(id);
        remedioRepository.delete(remedio);
        return remedio;
    }

    public Remedio atualizaRemedio(Remedio novoRemedio) {
        Remedio remedioBanco = this.buscaPorId(novoRemedio.getId());

        remedioBanco.setDescricao(novoRemedio.getDescricao());
        remedioBanco.setNome(novoRemedio.getNome());
        remedioBanco.setPreco(novoRemedio.getPreco());
        remedioBanco.setListaDeCompostos(novoRemedio.getListaDeCompostos());

        return this.adicionaRemedio(remedioBanco);
    }
}
