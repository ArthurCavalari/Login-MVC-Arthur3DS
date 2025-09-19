package com.arthur.loginmvc.controller;

import java.util.List;

public interface iCRUD<T> {

    public boolean incluir(T obj);

    public boolean alterar(T obj);

    public boolean deletar(T obj);

    public List<T> listar();

}