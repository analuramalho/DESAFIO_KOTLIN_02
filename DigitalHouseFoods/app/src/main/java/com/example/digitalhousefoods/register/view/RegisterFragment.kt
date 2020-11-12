package com.example.digitalhousefoods.register.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.digitalhousefoods.R

class RegisterFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController= Navigation.findNavController(view)

        view.findViewById<Button>(R.id.btnRegister_registerFragment).setOnClickListener{
            navController.navigate(R.id.menuListFragment)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            RegisterFragment()
    }
}