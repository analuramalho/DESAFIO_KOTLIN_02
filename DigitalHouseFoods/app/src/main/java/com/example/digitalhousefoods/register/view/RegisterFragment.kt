package com.example.digitalhousefoods.register.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.digitalhousefoods.R
import com.google.android.material.textfield.TextInputLayout

class RegisterFragment : Fragment() {
    private var navController: NavController? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         navController = Navigation.findNavController(view)

        view.findViewById<Button>(R.id.btnRegister_registerFragment).setOnClickListener {
            redirecionaLogin()
        }
    }

    private fun redirecionaLogin() {
        if(validarCamposRegistro())navController!!.navigate(R.id.menuListFragment)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            RegisterFragment()
    }


    private fun validarCamposRegistro(): Boolean {

        val nome = view?.findViewById<TextInputLayout>(R.id.txtNameRegister)
        nome?.error = null
        val nomeText = nome?.editText?.text.toString()

        val email = view?.findViewById<TextInputLayout>(R.id.txtEmailRegister)
        email?.error = null
        val emailText = email?.editText?.text.toString()

        val senha = view?.findViewById<TextInputLayout>(R.id.txtPasswordRegister)
        senha?.error = null
        val senhaText = senha?.editText?.text.toString()

        val senhaConfirmacao = view?.findViewById<TextInputLayout>(R.id.txtPasswordRepeatRegister)
        senhaConfirmacao?.error = null
        val senhaConfirmacaoText = senha?.editText?.text.toString()

        if (nomeText.trim() == "") {
            nome?.error = getString(R.string.erro_nome)
            return false
        }

        if (emailText.trim() == "") {
            email?.error = getString(R.string.erro_email)
            return false
        }

        if (senhaText.trim() == "") {
            senha?.error = getString(R.string.erro_senha)
            return false
        }

        if (senhaConfirmacaoText.trim() == "") {
            senhaConfirmacao?.error = getString(R.string.erro_senha)
            return false
        }

        if (senhaText.trim().length < 6) {
            senha?.error = getString(R.string.minimo_senha)
            return false
        }

        if (senhaText != senhaConfirmacaoText) {
            senhaConfirmacao?.error = getString(R.string.senhas_diferentes)
            return false
        }

        return true
    }



}