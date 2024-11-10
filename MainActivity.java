package com.example.appone;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText email, senha;
    TextView msgcadastrar;
    Button entrar, cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.et_email);
        senha = (EditText) findViewById(R.id.et_senha);
        entrar = (Button) findViewById(R.id.btn_entrar);
        cadastrar = (Button) findViewById(R.id.btn_cadastrar);
        msgcadastrar = (TextView) findViewById(R.id.tv_msgcadastrar);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(email.getText().toString())){
                    email.setError("Campo obrigatório");
                    return;
                }
                if(TextUtils.isEmpty(senha.getText().toString())){
                    senha.setError("Campo obrigatório");
                    return;
                }
                Toast.makeText(MainActivity.this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarTelaCadastro();
            }
        });
    }
    public void mostrarTelaCadastro(){
        Intent intent = new Intent(this,CadastroActivity.class);
        startActivity(intent);
    }
}