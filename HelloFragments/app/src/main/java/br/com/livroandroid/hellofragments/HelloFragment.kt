package br.com.livroandroid.hellofragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class HelloFragment : Fragment() {
    private val FRAG = "fragmentando"


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              icicle: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater?.inflate(R.layout.fragment_hello, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_frag_hello, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_hello_frag){
            toast("Hello ActionBar Frag")
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun toast(s:String){
        Toast.makeText(activity, s, Toast.LENGTH_SHORT).show()
    }

    fun hello(){
        Log.d(FRAG, "Botão TEST FRAGMENT foi clicado")

    }
}
