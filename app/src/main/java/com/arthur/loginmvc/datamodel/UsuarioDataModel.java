package com.arthur.loginmvc.datamodel;

public class UsuarioDataModel {

    public static final String TABELA = "usuarios";

    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String EMAIL = "email";
    public static final String SENHA = "senha";

    private static String queryCriarTabela = "";

    public static String criarTabela() {

        queryCriarTabela = "CREATE TABLE " + TABELA + " ( " +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NOME + " TEXT, " +
                EMAIL + " TEXT, " +
                SENHA + " TEXT" +
                " ) ";

        return queryCriarTabela;
    }
}