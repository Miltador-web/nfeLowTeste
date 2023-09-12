package com.nfe.low.nfelow.controller;

import com.nfe.low.nfelow.entity.Nfe;
import com.nfe.low.nfelow.service.NfeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nfe/")
public class NfeController {
    @Autowired
    NfeService nfeService;

    @GetMapping
    public Object consultaTodasNfe() {
        return nfeService.buscaTodasNfe();
    }

    @GetMapping("/{id}")
    public Object consultaNfeEspecifica(@PathVariable("id") Long id) {
        return nfeService.buscaNfeEspecifica(id);
    }

    @PostMapping
    public Object criarNfe(@RequestBody Nfe nfe) {
        return nfeService.cadastraNfe(nfe);
    }

    @PutMapping("/{id}")
    public Nfe editarNfe(@PathVariable Long id, @RequestBody Nfe nfe) {
        return nfeService.editarNfe(id, nfe);
    }

    @DeleteMapping("/{id}")
    public String deletarNfe(@PathVariable Long id) {
        return nfeService.deletarNfe(id);
    }
}
