package com.dhbrasil.springboot.aula36.service;

import java.util.List;
import java.util.Optional;

public interface IService<T> {

    List<T> buscarTodos();
    Optional<T> buscarPorId(Integer id);
    T salvar(T t);
    T atualizar(T t);
    void excluir(Integer id);

}
