package com.ada.springtestremedios.service;


import com.ada.springtestremedios.domain.Composto;
import com.ada.springtestremedios.repository.CompostoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Beans - Feijões
@AllArgsConstructor // Responsável por criar um construtor para injetar a depedencia
public class CompostoService {

    private CompostoRepository compostoRepository;

    public Composto adicionaComposto(Composto Composto) {
        return compostoRepository.save(Composto);
    }

    public List<Composto> listarCompostos() {
        return compostoRepository.findAll();
    }

    public Composto buscaPorId(Long id) {
        Optional<Composto> CompostoOptional = compostoRepository.findById(id);
        if (CompostoOptional.isEmpty()) {
            throw new IllegalArgumentException("Id não é valido");
        }
        return CompostoOptional.get();
    }

    public Composto removeComposto(Long id) {
        Composto Composto = this.buscaPorId(id);
        compostoRepository.delete(Composto);
        return Composto;
    }

    public Composto atualizaComposto(Composto novoComposto) {
        Composto compostoBanco = this.buscaPorId(novoComposto.getId());

        compostoBanco.setNome(novoComposto.getNome());
        compostoBanco.setQuantidade(novoComposto.getQuantidade());

        return this.adicionaComposto(compostoBanco);
    }
}
