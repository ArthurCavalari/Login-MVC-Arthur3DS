package com.arthur.loginmvc.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.arthur.loginmvc.R;
import com.arthur.loginmvc.controller.UsuarioController;
import com.arthur.loginmvc.model.Usuario;

public class CadastroActivity extends AppCompatActivity {

    EditText edtNome, edtEmail, edtSenha;
    Button btnFinalizarCadastro;
    UsuarioController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        initComponents();

        btnFinalizarCadastro.setOnClickListener(v -> {
            if (validaCampos()) {
                Usuario novoUsuario = new Usuario();
                novoUsuario.setNome(edtNome.getText().toString());
                novoUsuario.setEmail(edtEmail.getText().toString());
                novoUsuario.setSenha(edtSenha.getText().toString());

                // Verifica se o email já está cadastrado
                if (controller.usuario(novoUsuario.getEmail())) {
                    Toast.makeText(this, "O email informado já está em uso.", Toast.LENGTH_LONG).show();
                } else {
                    // Inclui o novo usuário no banco de dados
                    if (controller.incluir(novoUsuario)) {
                        Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                        finish(); // Fecha a tela de cadastro
                    } else {
                        Toast.makeText(this, "Erro ao cadastrar usuário.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    private void initComponents() {
        edtNome = findViewById(R.id.edt_nome_cadastro);
        edtEmail = findViewById(R.id.edt_email_cadastro);
        edtSenha = findViewById(R.id.edt_senha_cadastro);
        btnFinalizarCadastro = findViewById(R.id.btn_finalizar_cadastro);
        controller = new UsuarioController(getApplicationContext());
    }

    private boolean validaCampos() {
        if (TextUtils.isEmpty(edtNome.getText().toString())) {
            edtNome.setError("Digite seu nome");
            edtNome.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(edtEmail.getText().toString())) {
            edtEmail.setError("Digite seu email");
            edtEmail.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(edtSenha.getText().toString())) {
            edtSenha.setError("Crie uma senha");
            edtSenha.requestFocus();
            return false;
        }
        return true;
    }
}