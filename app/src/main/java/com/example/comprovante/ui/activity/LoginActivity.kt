package com.example.comprovante.ui.activity

import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.comprovante.R
import com.example.comprovante.utils.isValidEmailAdress
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                var selectedTabPosition = tabLayout.selectedTabPosition.toString()

                if (selectedTabPosition.equals("0")) {
//                    Toast.makeText(this@LoginActivity, "Clicou no Login", Toast.LENGTH_LONG).show()
                    layout_entrar.visibility = View.VISIBLE
                    layout_cadastro.visibility = View.GONE
                } else {
//                    Toast.makeText(this@LoginActivity, "Clicou no cadastro", Toast.LENGTH_LONG).show()
                    layout_entrar.visibility = View.GONE
                    layout_cadastro.visibility = View.VISIBLE
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
//                Toast.makeText(this@LoginActivity, "eita, nao sei", Toast.LENGTH_LONG).show()
            }
        })


        btn_login.setOnClickListener {
            var usuario = edit_usuario.text.toString()
            var senha = edit_senha.text.toString()

            //verificaCampos(usuario, senha)

            val i = Intent(baseContext, MainActivity::class.java)
            startActivity(i)
            finish()
        }

        btn_cadastro.setOnClickListener {
            val nome = edit_cadastro_nome.text.toString()
            val sobrenome = edit_cadastro_sobrenome.text.toString()
            val email = edit_cadastro_email.text.toString()
            val emailConfirmacao = edit_cadastro_email_confirmar.text.toString()
            val senha = edit_cadastro_senha.text.toString()
            val senhaConfirmacao = edit_cadastro_senha_novamente.text.toString()

            verficaCadastro(nome, sobrenome, email, emailConfirmacao, senha, senhaConfirmacao)

        }

    }

    private fun verficaCadastro(nome: String, sobrenome: String, email: String, emailConfirmacao: String, senha: String, senhaConfirmacao: String) {

        if (!email.equals("") && !emailConfirmacao.equals("") && !nome.equals("") && !sobrenome.equals("") && !senha.equals("") && !senhaConfirmacao.equals("")) {

            var emailOK = isValidEmailAdress(email)

            if(email == emailConfirmacao && emailOK){

                if(senha != senhaConfirmacao)
                    Toast.makeText(this, "Verifique se a senha digitado está correto.", Toast.LENGTH_SHORT).show()

                else
                    Toast.makeText(this, "Cadastro finalizado com sucesso!", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "Verifique se o e-mail digitado está correto.", Toast.LENGTH_SHORT).show()
            }

        } else
            Toast.makeText(this, "Todos os campos são obrigatorios.", Toast.LENGTH_SHORT).show()

    }





    private fun verificaCampos(usuario: String, senha: String) {
        if (!usuario.equals("")) {

            var emailOK = isValidEmailAdress(usuario)

            if (emailOK) {
                //Abrir a Activity fragment
            } else {
                Toast.makeText(
                    this,
                    "Verifique se o e-mail digitado está correto.",
                    Toast.LENGTH_LONG
                ).show()
            }

        } else
            Toast.makeText(this, "Para continuar digite o e-mail.", Toast.LENGTH_LONG).show()

    }
}