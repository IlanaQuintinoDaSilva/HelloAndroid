package br.com.livroandroid.helloandroid

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import br.com.livroandroid.helloandroid.DebugActivity
import br.com.livroandroid.helloandroid.extensions.getTextString
import br.com.livroandroid.helloandroid.extensions.onClick
import br.com.livroandroid.helloandroid.extensions.toast

class BemVindoActivity : DebugActivity() {
    //Propriedade para acessar o contexto de qualquer lugar
    private val context: Context get() = this

    override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)
        //Views
        setContentView(R.layout.activity_bem_vindo)

        val textview = findViewById<TextView>(R.id.text)
        //Recupera parâmetro da tela anterior.
        val nome = intent.getStringExtra("nome")
        textview.text = "$nome, seja bem vindo."
        //Ativa o "up navigation" na action bar
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val btExLinearLayoutPeso = findViewById<Button>(R.id.btExLinearLayoutPeso)
        //Adiciona o evento no botão de login
        onClick(R.id.btExLinearLayoutPeso){onClickExLinearLayoutPeso()}
        onClick(R.id.btExLinearLayoutPeso2){onClickExLinearLayoutPeso2()}
        onClick(R.id.btFrameLayoutProgressBar){onClickFrameLayoutProgressBar()}
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == android.R.id.home){
            //Trata o clique no botão voltar (<--)
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun onClickExLinearLayoutPeso(){
        val intent = Intent(context, ExemploLinearLayoutPesoActivity::class.java)
        startActivity(intent)
    }

    fun onClickExLinearLayoutPeso2(){
        val intent = Intent(context, ExemploLinearLayoutPeso2Activity::class.java)
        startActivity(intent)
    }

    fun onClickFrameLayoutProgressBar(){
        val intent = Intent(context, FrameLayoutProgressBarActivity::class.java)
        startActivity(intent)
    }
}
