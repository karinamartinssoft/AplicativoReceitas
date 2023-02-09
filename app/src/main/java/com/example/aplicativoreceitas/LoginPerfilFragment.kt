package com.example.aplicativoreceitas

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aplicativoreceitas.databinding.FragmentLoginPerfilBinding


class LoginPerfilFragment : Fragment() {

    lateinit var mBinding: FragmentLoginPerfilBinding
    lateinit var mParent: MainActivity


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentLoginPerfilBinding.inflate(layoutInflater, container, false)
       return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickButtom()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is MainActivity) this.mParent = context
    }

    fun clickButtom(){
        mBinding.buttonAvancar.setOnClickListener {
        ReceitasBO.validateLogin(
            mBinding.editTextUsuarioLogin.text.toString(),
            mBinding.editTextSenhaLogin.text.toString()
        )
         mParent.goToPage(1)

        }

    }
}