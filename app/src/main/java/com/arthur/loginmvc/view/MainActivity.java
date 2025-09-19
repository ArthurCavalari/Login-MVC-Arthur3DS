package com.arthur.loginmvc.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.arthur.loginmvc.R;
import com.arthur.loginmvc.controller.UsuarioController;

public class MainActivity extends AppCompatActivity {

    EditText edtEmail, edtSenha;
    Button btnEntrar, btnCadastrar;

    UsuarioController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        btnEntrar.setOnClickListener(v -> {
            if (validaCampos()) {
                String email = edtEmail.getText().toString();
                String senha = edtSenha.getText().toString();

                if (controller.usuarioEsenha(email, senha)) {
                    Toast.makeText(this, "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(this, "Usuário ou senha incorretos.", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnCadastrar.setOnClickListener(v -> {
            Toast.makeText(this, "Abrir tela de cadastro...", Toast.LENGTH_SHORT).show();
        });
    }

    private void initComponents() {
        edtEmail = findViewById(R.id.edt_email);
        edtSenha = findViewById(R.id.edt_senha);
        btnEntrar = findViewById(R.id.btn_entrar);
        btnCadastrar = findViewById(R.id.btn_cadastrar);

        controller = new UsuarioController(getApplicationContext());
    }
    private boolean validaCampos() {
        boolean camposValidos = true;

        if (TextUtils.isEmpty(edtEmail.getText().toString())) {
            edtEmail.setError("Digite o email");
            edtEmail.requestFocus();
            camposValidos = false;
        } else if (TextUtils.isEmpty(edtSenha.getText().toString())) {
            edtSenha.setError("Digite a senha");
            edtSenha.requestFocus();
            camposValidos = false;
        }

        return camposValidos;
    }
}