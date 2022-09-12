package com.ada.springtestremedios.mockito;

import com.ada.springtestremedios.domain.Composto;
import com.ada.springtestremedios.domain.Remedio;
import com.ada.springtestremedios.repository.RemedioRepository;
import com.ada.springtestremedios.service.RemedioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AtualizaRemedioTest {

    @Mock
    private RemedioRepository remedioRepository;

    @InjectMocks
    private RemedioService remedioService;

    @Test
    public void deveAtualizarRemedio() {
        Remedio remedioAntigo = Remedio.builder()
                .descricao("Descrição antiga")
                .preco(BigDecimal.ONE)
                .id(1L)
                .nome("Nome antigo!")
                .listaDeCompostos(List.of(Composto.builder().quantidade(1D).nome("cafeina").build()
                )).build();


        Remedio remedioNovo = Remedio.builder()
                .descricao("Descrição nova")
                .preco(BigDecimal.TEN)
                .id(1L)
                .nome("Nome novo!")
                .listaDeCompostos(Collections.emptyList())
                .build();

        Mockito.when(remedioRepository.findById(1L)).thenReturn(Optional.of(remedioAntigo));
        Mockito.when(remedioRepository.save(remedioNovo)).thenReturn(remedioNovo);

        Remedio remedioRetornado = remedioService.atualizaRemedio(remedioNovo);
        Mockito.verify(remedioRepository, Mockito.times(1)).save(remedioNovo);

        Assertions.assertEquals(remedioRetornado, remedioNovo);
    }

    @Test
    public void naoDeveAtualizarRemedio() {
        Remedio remedioNovo = Remedio.builder()
                .descricao("Descrição nova")
                .preco(BigDecimal.TEN)
                .id(1L)
                .nome("Nome novo!")
                .listaDeCompostos(Collections.emptyList())
                .build();

        Mockito.when(remedioRepository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> remedioService.atualizaRemedio(remedioNovo));

    }
}
