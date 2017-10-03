package br.com.livroandroid.carros.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.livroandroid.carros.R

class MainActivity : BaseActivity() {

    override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)
        setContentView(R.layout.activity_main)
    }
}
