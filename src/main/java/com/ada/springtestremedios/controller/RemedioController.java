package com.ada.springtestremedios.controller;

import com.ada.springtestremedios.domain.Remedio;
import com.ada.springtestremedios.service.RemedioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remedios")
@AllArgsConstructor
public class RemedioController {

    private final RemedioService remedioService;

    @PostMapping
    public ResponseEntity<Remedio> adicionaRemedio(@RequestBody Remedio remedio) {
        remedioService.adicionaRemedio(remedio);
        return new ResponseEntity<>(remedio, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Remedio> buscaRemedioPorId(@PathVariable Long id) {
        Remedio remedio = remedioService.buscaPorId(id);
        return new ResponseEntity<>(remedio, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Remedio>> listarRemedios() {
        List<Remedio> listaRemedios = remedioService.listarRemedios();
        return new ResponseEntity<>(listaRemedios, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Remedio> removerRemedio(@PathVariable Long id) {
        Remedio remedio = remedioService.removeRemedio(id);
        return new ResponseEntity<>(remedio, HttpStatus.OK);
    }
}
