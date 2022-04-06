package com.dhbrasil.springboot.aula36.service;

import com.dhbrasil.springboot.aula36.model.Dentista;
import com.dhbrasil.springboot.aula36.repository.DentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DentistaService implements IService<Dentista> {

    @Autowired
    private DentistaRepository dentistaRepository;

    @Override
    public List<Dentista> buscarTodos() {
        return dentistaRepository.findAll();
    }

    @Override
    public Optional<Dentista> buscarPorId(Integer id) {
        return dentistaRepository.findById(id);
    }

    @Override
    public Dentista salvar(Dentista dentista) {
        return dentistaRepository.save(dentista);
    }

    @Override
    public Dentista atualizar(Dentista dentista) {
        return dentistaRepository.save(dentista);
    }

    @Override
    public void excluir(Integer id) {
        dentistaRepository.deleteById(id);
    }

}
