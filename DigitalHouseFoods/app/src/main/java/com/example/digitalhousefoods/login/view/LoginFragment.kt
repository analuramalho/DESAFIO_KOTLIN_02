package com.example.digitalhousefoods.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.digitalhousefoods.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {
    lateinit var loginView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginView = inflater.inflate(R.layout.fragment_login, container, false)
        return loginView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)

        view.findViewById<Button>(R.id.btnRegister_loginFragment).setOnClickListener {
            navController.navigate(R.id.registerFragment)
        }

        view.findViewById<Button>(R.id.btnLogin_loginFragment).setOnClickListener {
                navController.navigate(R.id.menuListFragment)
            }
    }


    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}



