package com.example.digitalhousefoods.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.digitalhousefoods.R
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {
    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()

        val btnRegister = view.findViewById<Button>(R.id.btnRegister_loginFragment)
        btnRegister.setOnClickListener {
           redirecionaRegister()
        }

        val btnLogin = view.findViewById<Button>(R.id.btnLogin_loginFragment)
        btnLogin.setOnClickListener {
           redirecionaMenuList()
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }


    private fun validarCampos(): Boolean {
        val email = view?.findViewById<TextInputLayout>(R.id.txtEmail_loginFragment)
        email?.error = null
        val emailText = email?.editText?.text.toString()

        val senha = view?.findViewById<TextInputLayout>(R.id.txtPassword_loginFragment)
        senha?.error = null
        val senhaText = senha?.editText?.text.toString()

        if (emailText.trim() == "") {
            email?.error = getString(R.string.erro_email)
            return false
        }

        if (senhaText.trim() == "") {
            senha?.error = getString(R.string.erro_senha)
            return false
        }

        return true
    }

    private fun redirecionaMenuList() {
        if (validarCampos()) navController!!.navigate(R.id.action_loginFragment_to_menuListFragment)
    }

    private fun redirecionaRegister() {
        navController!!.navigate(R.id.action_loginFragment_to_registerFragment)
    }


}



