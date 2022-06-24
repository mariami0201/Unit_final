package com.example.loginactivity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.loginactivity.databinding.FragmentCalculatorBinding
import com.example.loginactivity.databinding.FragmentConverterBinding
import com.google.firebase.auth.FirebaseAuth
import java.lang.String
import kotlin.Exception
import kotlin.Int

class ConverterFragment : Fragment() {


    private lateinit var binding: FragmentConverterBinding

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentConverterBinding.inflate(layoutInflater, container, false)
        val view = binding.root


        var text = ""

        binding.button1.setOnClickListener {

            text = binding.GEL1.text.toString()
            binding.USD1.setText((text.toDouble() * 0.34).toString() + " USD")

        }

        binding.button2.setOnClickListener {

            text = binding.USD2.text.toString()
            binding.GEL2.setText((text.toDouble() * 2.92).toString() + " GEL")

        }

        binding.button3.setOnClickListener {

            text = binding.KG1.text.toString()
            binding.LBS1.setText((text.toDouble() * 2.2).toString() + " LBS")
        }

        binding.button4.setOnClickListener {

            text = binding.LBS2.text.toString()
            binding.KG2.setText((text.toDouble() * 0.45).toString() + " KGs")

        }

        binding.button5.setOnClickListener {

            text = binding.KM1.text.toString()
            binding.MILE1.setText((text.toDouble() * 0.62).toString() + " Miles")

        }

        binding.button6.setOnClickListener {

            text = binding.MILE2.text.toString()
            binding.KM2.setText((text.toDouble() * 1.6).toString() + " KMs")

        }

        binding.button7.setOnClickListener {

            text = binding.Celsius1.text.toString()
            binding.Fahrenheit1.setText(((text.toDouble() * 1.8)+32).toString() + " Fahrenheits")

        }

        binding.button8.setOnClickListener {

            text = binding.Fahrenheit2.text.toString()
            binding.Celsius2.setText(((text.toDouble() - 32)*0.5556).toString() + " Celsius")

        }



        return view
    }
}

