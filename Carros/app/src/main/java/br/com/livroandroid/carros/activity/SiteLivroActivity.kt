package br.com.livroandroid.carros.activity

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import br.com.livroandroid.carros.R
import br.com.livroandroid.carros.activity.dialogs.AboutDialog
import br.com.livroandroid.carros.extensions.setupToolbar
import kotlinx.android.synthetic.main.activity_site_livro.*
import kotlinx.android.synthetic.main.progress.*

class SiteLivroActivity : BaseActivity() {
    private val URL_SOBRE = "http://www.livroandroid.com.br/sobre.htm"

    override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)
        setContentView(R.layout.activity_site_livro)
        //Toolbar
        val actionBar = setupToolbar(R.id.toolbar)
        actionBar.setDisplayHomeAsUpEnabled(true)
        //Carrega a página
        setWebViewClient(webview)
        webview.loadUrl(URL_SOBRE)
        //Swipe to Refresh
        swipeToRefresh.setOnRefreshListener {
            webview.reload()
        }
        //Cores da animação
        swipeToRefresh?.setColorSchemeResources(
                R.color.refresh_progress_1,
                R.color.refresh_progress_2,
                R.color.refresh_progress_3)
    }
    //Controla os eventos do WebView
    private fun setWebViewClient(webview: WebView){
        webview.setWebViewClient (object : WebViewClient(){
            override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                //Liga o progress
                progress?.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView, url: String) {
                //Desliga o progress
                progress?.visibility = View.INVISIBLE
                //Termina a animação do Swipe to Refresh
                swipeToRefresh?.isRefreshing = false
            }

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                val url = request?.url.toString()
                if (url.endsWith("sobre.htm")){
                    //Mostra o dialog
                    AboutDialog.showAbout(supportFragmentManager)
                    //Retorna true para informar que interceptamos o evento
                    return true
                }
                return super.shouldOverrideUrlLoading(view, request)
            }
        })
    }
}
