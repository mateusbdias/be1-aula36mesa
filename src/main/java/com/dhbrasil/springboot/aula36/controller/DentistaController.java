package com.dhbrasil.springboot.aula36.controller;

import com.dhbrasil.springboot.aula36.model.Dentista;
import com.dhbrasil.springboot.aula36.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    @Autowired
    private DentistaService dentistaService;

    @GetMapping
    public ResponseEntity<List<Dentista>> buscarTodos() {
        return ResponseEntity.ok(dentistaService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Dentista>> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(dentistaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<?> salvarDentista(@RequestBody Dentista dentista) {
        dentistaService.salvar(dentista);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> atualizarDentista(@RequestBody Dentista dentista) {
        ResponseEntity<Dentista> response = null;
        if (dentista.getId() != null && dentistaService.buscarPorId(dentista.getId()).isPresent()) {
            response = ResponseEntity.ok(dentistaService.atualizar(dentista));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirDentista(@PathVariable Integer id) {
        ResponseEntity<String> response = null;
        if (dentistaService.buscarPorId(id).isPresent()) {
            dentistaService.excluir(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                    "Dentista excluído com sucesso!");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

}
