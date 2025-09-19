package com.arthur.loginmvc.controller;

import android.content.ContentValues;
import android.content.Context;

import com.arthur.loginmvc.datamodel.UsuarioDataModel;
import com.arthur.loginmvc.datasource.AppDataBase;
import com.arthur.loginmvc.model.Usuario;

import java.util.Collections;
import java.util.List;

public class UsuarioController extends AppDataBase implements iCRUD<Usuario> {

    ContentValues dadosDoObjeto;

    public UsuarioController(Context context) {
        super(context);
    }

    @Override
    public boolean incluir(Usuario obj) {
        dadosDoObjeto = new ContentValues();
        dadosDoObjeto.put(UsuarioDataModel.NOME, obj.getNome());
        dadosDoObjeto.put(UsuarioDataModel.EMAIL, obj.getEmail());
        dadosDoObjeto.put(UsuarioDataModel.SENHA, obj.getSenha());
        return insert(UsuarioDataModel.TABELA, dadosDoObjeto);
    }

    @Override
    public boolean alterar(Usuario obj) {
        // Lógica para alterar um usuário (não implementada neste exemplo)
        return false;
    }

    @Override
    public boolean deletar(Usuario obj) {
        // Lógica para deletar um usuário (não implementada neste exemplo)
        return false;
    }

    @Override
    public List<Usuario> listar() {
        // Lógica para listar todos os usuários (não implementada neste exemplo)
        return Collections.emptyList();
    }

    // Métodos específicos para o login
    public boolean usuarioEsenha(String email, String password) {
        return super.checkUserPassword(email, password);
    }

    public boolean usuario(String email) {
        return super.checkUser(email);
    }
}