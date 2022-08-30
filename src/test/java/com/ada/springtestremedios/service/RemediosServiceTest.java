package com.ada.springtestremedios.service;

import com.ada.springtestremedios.domain.Remedio;
import com.ada.springtestremedios.repository.RemedioRepository;
import com.ada.springtestremedios.service.RemedioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;


@SpringBootTest
class RemediosServiceTest {

    @Autowired
    private RemedioService remedioService;

    @Autowired
    private RemedioRepository remedioRepository;

    @BeforeEach
    public void limpaBanco() {
        remedioRepository.deleteAll();
    }

    @Test
    public void testaInsereNoBanco() {
        Remedio remedio = Remedio.builder()
                .nome("Paracetamol")
                .descricao("Analgésico")
                .preco(new BigDecimal(10))
                .build();

        remedioService.adicionaRemedio(remedio);

        List<Remedio> remedios = remedioService.listarRemedios();

        // Inseriu mesmo?
        Assertions.assertEquals(1, remedios.size());
        // Inseriu certo?
        Assertions.assertEquals("Paracetamol", remedios.get(0).getNome());
        Assertions.assertEquals("Analgésico", remedios.get(0).getDescricao());
    }

    @Test
    public void testBuscaPorId() {
        remedioService.buscaPorId(1L);

        // Pelo @BeforeEach que não vamos ter nada no banco.
    }

}
