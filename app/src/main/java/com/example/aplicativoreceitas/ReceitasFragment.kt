package com.example.aplicativoreceitas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.example.aplicativoreceitas.ReceitasConstants.CARNE_PANELA
import com.example.aplicativoreceitas.ReceitasConstants.PANQUECA_LIQUI
import com.example.aplicativoreceitas.ReceitasConstants.PAO_CASEIRO
import com.example.aplicativoreceitas.ReceitasConstants.TORTA_FRANGO
import com.example.aplicativoreceitas.databinding.FragmentReceitasBinding


class ReceitasFragment : Fragment() {

    lateinit var mBinding: FragmentReceitasBinding
    var mConstReceita: String = " "
    lateinit var mParent: MainActivity


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentReceitasBinding.inflate(layoutInflater, container, false)
        return mBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setWebViewReceitas()
        clickOpenDescricaoReceita()



    }

    override fun onAttach(aContext: Context) {
        super.onAttach(aContext)
        if (aContext is MainActivity) this.mParent = aContext
    }

    fun setWebViewReceitas() {
        try {
            mBinding.webViewMassaPanqueca.webViewClient = WebViewClient()
            mBinding.webViewCarnePanela.webViewClient = WebViewClient()
            mBinding.webViewPaoCaseiro.webViewClient = WebViewClient()
            mBinding.webViewTortaFrango.webViewClient = WebViewClient()

            val setClientWebView = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    request: WebResourceRequest?
                ): Boolean {
                    return super.shouldOverrideUrlLoading(view, request)
                }

                override fun onReceivedError(
                    view: WebView?,
                    errorCode: Int,
                    description: String?,
                    failingUrl: String?
                ) {
                    Toast.makeText(requireContext(), description, Toast.LENGTH_SHORT).show()
                }


            }
            mBinding.webViewCarnePanela.settings.allowContentAccess = true
            mBinding.webViewCarnePanela.settings.allowFileAccess = true

            mBinding.webViewCarnePanela.webViewClient = setClientWebView
            mBinding.webViewMassaPanqueca.webViewClient = setClientWebView
            mBinding.webViewPaoCaseiro.webViewClient = setClientWebView
            mBinding.webViewTortaFrango.webViewClient = setClientWebView



            mBinding.webViewCarnePanela.loadUrl("https://claudia.abril.com.br/wp-content/uploads/2020/02/receita-carne-panela-economica.jpg")
            mBinding.webViewMassaPanqueca.loadUrl("https://receitasculinarias.com.br/wp-content/uploads/2022/10/Massa-de-panqueca-super-macia-1024x576.png")
            mBinding.webViewPaoCaseiro.loadUrl("https://receidelicia.com.br/wp-content/uploads/2021/02/maxresdefault.jpg")
            mBinding.webViewTortaFrango.loadUrl("https://www.culinariapravaler.com/image/postagens/2020/05/deliciosa-torta-de-frango-com-massa-de-mandioquinha.html.png")


        } catch (e: Exception) {
            Toast.makeText(requireContext(), e.message.toString(), Toast.LENGTH_SHORT).show()

        }


    }

    fun clickOpenDescricaoReceita(){
        mBinding.cardViewPanquecaLiqui.setOnClickListener{
            mConstReceita = PANQUECA_LIQUI
            startActivityDescricao()
        }
        mBinding.cardViewCarnePanela.setOnClickListener {
            mConstReceita = CARNE_PANELA
            startActivityDescricao()
        }
        mBinding.cardViewPaoCaseiro.setOnClickListener {
            mConstReceita = PAO_CASEIRO
            startActivityDescricao()
        }
        mBinding.cardViewTortaFrango.setOnClickListener {
            mConstReceita = TORTA_FRANGO
            startActivityDescricao()
        }
    }

    fun startActivityDescricao(){
        val lIntent = Intent(mParent, DescricaoReceitaActivity::class.java)
        lIntent.putExtra("ConstReceita", mConstReceita)
        mParent.startActivity(lIntent)
    }


}

