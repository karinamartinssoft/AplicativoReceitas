package com.example.aplicativoreceitas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.example.aplicativoreceitas.databinding.FragmentReceitasBinding


class ReceitasFragment : Fragment() {

    lateinit var mBinding: FragmentReceitasBinding


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
    }

    fun setWebViewReceitas() {
        try {
            mBinding.WebViewMassaPanqueca.webViewClient = WebViewClient()
            mBinding.WebViewCarnePanela.webViewClient = WebViewClient()
            mBinding.WebViewPaoCaseiro.webViewClient = WebViewClient()
            mBinding.WebViewTortaFrango.webViewClient = WebViewClient()

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
            mBinding.WebViewCarnePanela.settings.allowContentAccess = true
            mBinding.WebViewCarnePanela.settings.allowFileAccess = true

            mBinding.WebViewCarnePanela.webViewClient = setClientWebView
            mBinding.WebViewMassaPanqueca.webViewClient = setClientWebView



            mBinding.WebViewCarnePanela.loadUrl("https://w7.pngwing.com/pngs/1012/933/png-transparent-pot-roast-roast-beef-leftovers-roasting-slow-cookers-pot-roast-food-beef-roast-beef.png")
            mBinding.WebViewMassaPanqueca.loadUrl("https://w7.pngwing.com/pngs/1012/933/png-transparent-pot-roast-roast-beef-leftovers-roasting-slow-cookers-pot-roast-food-beef-roast-beef.png")


        } catch (e: Exception) {
            Toast.makeText(requireContext(), e.message.toString(), Toast.LENGTH_SHORT).show()

        }

    }
}