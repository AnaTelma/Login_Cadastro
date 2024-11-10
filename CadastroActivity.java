package com.example.appone;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CadastroActivity extends AppCompatActivity {
    EditText nome_cadastro, email_cadastro, senha_cadastro, confirmar_senha;
    Button confirmar_cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nome_cadastro = (EditText) findViewById(R.id.et_nome_cadastro);
        email_cadastro = (EditText) findViewById(R.id.et_email_cadastro);
        senha_cadastro = (EditText) findViewById(R.id.et_senha_cadastro);
        confirmar_senha = (EditText) findViewById(R.id.et_senha_confirmacao);
        confirmar_cadastro = (Button) findViewById(R.id.btn_confirmar_cadastro);

        confirmar_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = nome_cadastro.getText().toString().trim();
                String email = email_cadastro.getText().toString().trim();
                String senha = senha_cadastro.getText().toString().trim();
                String senhaConfirmacao = confirmar_senha.getText().toString().trim();

                // Verificação dos campos
                if (TextUtils.isEmpty(nome)) {
                    nome_cadastro.setError("Campo obrigatório");
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    email_cadastro.setError("Campo obrigatório");
                    return;
                }

                if (TextUtils.isEmpty(senha)) {
                    senha_cadastro.setError("Campo obrigatório");
                    return;
                }

                if (TextUtils.isEmpty(senhaConfirmacao)) {
                    confirmar_senha.setError("Campo obrigatório");
                    return;
                }
                // Verifica se a senha e a confirmação de senha são iguais
                if (senha_cadastro.equals(confirmar_senha.getText().toString())) {
                    confirmar_senha.setError("As senhas não correspondem");
                    return;
                }

                // Exibe uma mensagem de sucesso se todas as validações passarem
                Toast.makeText(CadastroActivity.this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();

                // Aqui você pode adicionar a lógica para salvar os dados do usuário no banco de dados ou backend
            }
        });
    }
}