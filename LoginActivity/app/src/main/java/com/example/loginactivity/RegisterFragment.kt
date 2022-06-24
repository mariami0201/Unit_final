package com.example.loginactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.loginactivity.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var binding : FragmentRegisterBinding

    private lateinit var mAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        mAuth = FirebaseAuth.getInstance()


        binding.RegisterButton.setOnClickListener{
            val email = binding.EmailAddress.text.toString()
            val password = binding.Password.text.toString()
            val confirmPassword = binding.confirmPassword.text.toString()


            if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || password != confirmPassword){
                Toast.makeText(activity, "Please enter information correctly", Toast.LENGTH_SHORT).show()

            }
            else{
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(activity, "Account Created", Toast.LENGTH_SHORT).show()

                    } else {
                        Toast.makeText(activity, "Registration Failed.", Toast.LENGTH_SHORT).show()

                    }
                }



            }

        }
        return view

    }

}





