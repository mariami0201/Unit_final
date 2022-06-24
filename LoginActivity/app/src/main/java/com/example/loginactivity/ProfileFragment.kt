package com.example.loginactivity

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.loginactivity.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var mAuth: FirebaseAuth
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mAuth = FirebaseAuth.getInstance()
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        binding.textView.setText(mAuth.uid.toString())



        binding.button.setOnClickListener {

            mAuth.signOut()
            findNavController().navigate(R.id.action_profileFragment_to_loginFragment)

        }



        return if (!mAuth.uid.isNullOrBlank()) {
            view
        } else {
            findNavController().navigate(R.id.action_profileFragment_to_loginFragment)
            view
        }
    }


}