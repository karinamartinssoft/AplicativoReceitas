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
        when(mConstReceita.toString()){
            PANQUECA_LIQUI -> {
                mBinding.textViewTituloDescricao.text = "Panqueca de Liquidificador"
                mBinding.textViewDescricaoReceita.text = "Modo de Preparo Panqueca"
                mBinding.webViewFotoReceita.loadUrl("https://receitasculinarias.com.br/wp-content/uploads/2022/10/Massa-de-panqueca-super-macia-1024x576.png")
            }
            CARNE_PANELA -> {

            }
            PAO_CASEIRO -> {

            }
            TORTA_FRANGO ->{

            }
        }
    }
}