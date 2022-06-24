package com.example.loginactivity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.loginactivity.databinding.ActivityMainBinding.bind
import com.example.loginactivity.databinding.ActivityMainBinding.inflate
import com.example.loginactivity.databinding.FragmentLoginBinding

import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var mAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        mAuth = FirebaseAuth.getInstance()


        binding.RegisterButton.setOnClickListener {

            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)

        }
        binding.LoginButton.setOnClickListener {

            val email = binding.EmailAddress.text.toString()
            val password = binding.Password.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(activity, "Please, fill out both fields", Toast.LENGTH_SHORT).show()
            } else {
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        findNavController().navigate(R.id.action_loginFragment_to_profileFragment)
                    }else{
                        Toast.makeText(activity, "Incorrect Email or Password", Toast.LENGTH_SHORT).show()
                    }

                }

            }


        }
        if (mAuth.uid.isNullOrBlank()){
            return view
        }else{
            findNavController().navigate(R.id.action_loginFragment_to_profileFragment)
            return view
        }


    }
}