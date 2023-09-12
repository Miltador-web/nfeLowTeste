package com.nfe.low.nfelow.service;

import com.nfe.low.nfelow.entity.Nfe;
import com.nfe.low.nfelow.repository.NfeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class NfeService {

    @Autowired
    NfeRepository nfeRepository;

    private static final Logger logger = LoggerFactory.getLogger(NfeService.class);


    public Object buscaTodasNfe() {
        List<Nfe> nfes;
        try {
            nfes = nfeRepository.findAll();
        } catch (Exception e) {
            logger.error("Falha ao retornar todas NF-e " + e.getMessage(), e);
            return "Falha ao retornar todas NF-e";
        }

        return nfes;
    }

    public Object buscaNfeEspecifica(Long id) {
        Optional<Nfe> nfe;
        try {
            nfe = nfeRepository.findById(id);
            ;
        } catch (Exception e) {
            logger.error("Falha ao retornar a NF-e de numero nota" + id + " " + e.getMessage(), e);
            return "Falha ao retornar a NF-e de numero nota " + id + " ";
        }
        return nfe;
    }

    @Transactional
    public Object cadastraNfe(Nfe nfe) {
        try {
            nfeRepository.saveAndFlush(nfe);
            logger.info("NF-e salva com sucesso.");
            return nfeRepository.findByNumeroNota(nfe.getNumeroNota());
        } catch (Exception e) {
            logger.error("Erro ao salvar NF-e: " + e.getMessage(), e);
            return "Erro durante o cadastro da NF-e";
        }

    }

    public Nfe editarNfe(Long id, Nfe newNfe) {
        return nfeRepository.findById(id).map(nfe -> {
                    nfe.setRazaoSocial(newNfe.getRazaoSocial());
                    nfe.setCnpj(newNfe.getCnpj());
                    nfe.setEndereco(newNfe.getEndereco());
                    nfe.setValor(newNfe.getValor());
                    nfe.setNumeroSerie(newNfe.getNumeroSerie());
                    return nfeRepository.save(nfe);
                })
                .orElseGet(() -> {
                    newNfe.setNumeroNota(id);
                    return nfeRepository.save(newNfe);
                });
    }

    public String deletarNfe(Long id) {
        try {
            nfeRepository.deleteById(id);
            logger.info("NF-e deletada com sucesso.");
            return "NF-e deletada com sucesso!";
        } catch (Exception e) {
            logger.error("Falha ao deletar NF-e " + e.getMessage(), e);
            return "Falha ao deletar NF-e";
        }

    }
}
