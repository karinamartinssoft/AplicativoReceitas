package com.example.aplicativoreceitas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.aplicativoreceitas.ReceitasConstants.CARNE_PANELA
import com.example.aplicativoreceitas.ReceitasConstants.PANQUECA_LIQUI
import com.example.aplicativoreceitas.ReceitasConstants.PAO_CASEIRO
import com.example.aplicativoreceitas.ReceitasConstants.TORTA_FRANGO
import com.example.aplicativoreceitas.databinding.ActivityDescricaoReceitaBinding

class DescricaoReceitaActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityDescricaoReceitaBinding
    var mConstReceita: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDescricaoReceitaBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        getIntentExtra()
    }



    fun getIntentExtra(){
        if(intent.hasExtra("ConstReceita")){
            val lConst = intent.extras!!.getString("ConstReceita")
            if (lConst != null) {
                mConstReceita = lConst
            }

            populateReceita()

        }else{
            Toast.makeText(this, "Não foi possível carregar as informações.", Toast.LENGTH_SHORT).show()
        }
    }

    fun populateReceita(){
        when(mConstReceita){
            PANQUECA_LIQUI -> {
                mBinding.textViewTituloDescricao.text = "Panqueca de Liquidificador"
                mBinding.textViewDescricaoReceita.text = "Modo de Preparo Panqueca"
                mBinding.webViewFotoReceita.loadUrl("https://receitasculinarias.com.br/wp-content/uploads/2022/10/Massa-de-panqueca-super-macia-1024x576.png")
            }
            CARNE_PANELA -> {
                mBinding.textViewTituloDescricao.text = "Carne de Panela"
                mBinding.textViewDescricaoReceita.text = "Modo de Preparo Carne de Panela"
                mBinding.webViewFotoReceita.loadUrl("https://claudia.abril.com.br/wp-content/uploads/2020/02/receita-carne-panela-economica.jpg")

            }
            PAO_CASEIRO -> {
                mBinding.textViewTituloDescricao.text = "Pão Caseiro"
                mBinding.textViewDescricaoReceita.text = "Modo de Preparo Pão Caseiro"
                mBinding.webViewFotoReceita.loadUrl("https://receidelicia.com.br/wp-content/uploads/2021/02/maxresdefault.jpg")

            }
            TORTA_FRANGO ->{
                mBinding.textViewTituloDescricao.text = "Torta de Frango"
                mBinding.textViewDescricaoReceita.text = "Modo de Preparo Torta de Frango"
                mBinding.webViewFotoReceita.loadUrl("https://www.culinariapravaler.com/image/postagens/2020/05/deliciosa-torta-de-frango-com-massa-de-mandioquinha.html.png")

            }
        }
    }
}