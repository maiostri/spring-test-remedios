package com.ada.springtestremedios.controller;

import com.ada.springtestremedios.domain.Composto;
import com.ada.springtestremedios.service.CompostoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compostos")
@AllArgsConstructor
public class CompostoController {

    private final CompostoService compostoService;

    @PostMapping
    public ResponseEntity<Composto> adicionaComposto(@RequestBody Composto Composto) {
        compostoService.adicionaComposto(Composto);
        return new ResponseEntity<>(Composto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Composto> buscaCompostoPorId(@PathVariable Long id) {
        Composto Composto = compostoService.buscaPorId(id);
        return new ResponseEntity<>(Composto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Composto> atualizaComposto(@RequestBody Composto novoComposto) {
        Composto Composto = compostoService.atualizaComposto(novoComposto);
        return new ResponseEntity<>(Composto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Composto>> listarCompostos() {
        List<Composto> listaCompostos = compostoService.listarCompostos();
        return new ResponseEntity<>(listaCompostos, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Composto> removerComposto(@PathVariable Long id) {
        Composto Composto = compostoService.removeComposto(id);
        return new ResponseEntity<>(Composto, HttpStatus.OK);
    }
}
