package br.com.livroandroid.hellofragments

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.livroandroid.helloandroid.extensions.onClick

class MainActivity : AppCompatActivity() {


    override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)
        setContentView(R.layout.activity_main)
        if(icicle == null){
            val ft = supportFragmentManager.beginTransaction()
            val frag1 = HelloFragment()
            ft.add(R.id.layoutFrag, frag1, "HelloFragment")
            ft.commit()
        }
       // onClick(R.id.btFragTest){onClickBtTest()}
    }

    fun onClickBtTest(){
        val fm = supportFragmentManager
        val frag = fm.findFragmentByTag("HelloFragment") as HelloFragment
        frag.hello()
    }
}
