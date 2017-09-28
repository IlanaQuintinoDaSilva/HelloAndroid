package br.com.livroandroid.helloandroid

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import br.com.livroandroid.helloandroid.extensions.getTextString
import br.com.livroandroid.helloandroid.extensions.onClick
import br.com.livroandroid.helloandroid.extensions.toast

class MainActivity : DebugActivity() {
    //Propriedade para acessar o contexto de qualquer lugar
    private val context: Context get() = this

    override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)
        //View
        setContentView(R.layout.activity_main)

        val btLogin = findViewById<Button>(R.id.btLogin)
        //Adiciona o evento no botão de login
        onClick(R.id.btLogin){onClickLogin()}
    }

    fun onClickLogin(){
        // Lê os textos digitados com a extension
        val login = getTextString(R.id.tLogin)
        val senha = getTextString(R.id.tSenha)
        if("ricardo" == login && "123" == senha){
            val intent = Intent(context, BemVindoActivity::class.java)
            val params = Bundle()
            params.putString("nome", "Ricardo Lecheta")
            intent.putExtras(params)
            startActivity(intent)
        }else{
            toast("Login e senha incorretos.")
        }
    }

}
