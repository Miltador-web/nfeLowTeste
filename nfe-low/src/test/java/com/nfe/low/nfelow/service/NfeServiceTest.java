package com.nfe.low.nfelow.service;

import com.nfe.low.nfelow.entity.Nfe;
import com.nfe.low.nfelow.repository.NfeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
@SpringBootTest
@RunWith(SpringRunner.class)
class NfeServiceTest {


    @Autowired
    NfeService nfeService;

    @Autowired
    NfeRepository nfeRepository;

    private Nfe notaFiscal = new Nfe(1l, "Milton LTDA", "19.372.323/0001-34", "Rua dos Vicentinos n:1870", 1228.0, 111121L);


    @Test
    void buscaNfeEspecifica() {
        Long id = 1L;
        Optional<Nfe> dados;
        if (nfeRepository.existsById(notaFiscal.getNumeroNota()) != true){
            dados = (Optional<Nfe>) nfeService.cadastraNfe(notaFiscal);
        }else {
            dados = Optional.ofNullable(notaFiscal);
        }
        Object nfeResult = nfeService.buscaNfeEspecifica(id);
        Assertions.assertEquals(dados, nfeResult);
    }


    @Test
    void deletarNfe() {
        Long id = 1L;
        String dadoDeletado = nfeService.deletarNfe(id);
        Assertions.assertEquals(dadoDeletado,"NF-e deletada com sucesso!");
    }
}