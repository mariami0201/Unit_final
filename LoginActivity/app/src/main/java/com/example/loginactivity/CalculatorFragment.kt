package com.example.loginactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.loginactivity.databinding.FragmentCalculatorBinding
import com.google.firebase.auth.FirebaseAuth
import java.lang.String
import kotlin.Exception
import kotlin.Int

class CalculatorFragment : Fragment() {


    private lateinit var binding: FragmentCalculatorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCalculatorBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        var text = ""
        var sum = 0.0
        var number1 = 0.0
        var number2 = 0.0
        val signs = "+-*/"




        binding.button0.setOnClickListener {
            if (!text.endsWith("0") || !signs.contains(Character.toString(text[(text.length - 2)]))) {
                binding.textField.setText(text + "0");
                text += "0";
            }
        }

            binding.button1.setOnClickListener {
                if (text.length > 1 && text.endsWith("0") && signs.contains(Character.toString(text[(text.length - 2)]))) {
                    text = text.substring(0, text.length - 1) + "1";
                    binding.textField.setText(text);
                } else if (text.length == 1 && text.contains("0")) {
                    text = "1";
                    binding.textField.setText(text);
                } else {
                    binding.textField.setText(text + "1");
                    text += "1";


                }

        }

        binding.button2.setOnClickListener {
            if (text.length > 1 && text.endsWith("0") && signs.contains(Character.toString(text[(text.length - 2)]))) {
                text = text.substring(0, text.length - 1) + "2";
                binding.textField.setText(text);
            } else if (text.length == 1 && text.contains("0")) {
                text = "2";
                binding.textField.setText(text);
            } else {
                binding.textField.setText(text + "2");
                text += "2";


            }
        }

        binding.button3.setOnClickListener {
            if (text.length > 1 && text.endsWith("0") && signs.contains(Character.toString(text[(text.length - 2)]))) {
                text = text.substring(0, text.length - 1) + "3";
                binding.textField.setText(text);
            } else if (text.length == 1 && text.contains("0")) {
                text = "3";
                binding.textField.setText(text);
            } else {
                binding.textField.setText(text + "3");
                text += "3";


            }
        }

        binding.button4.setOnClickListener {
            if (text.length > 1 && text.endsWith("0") && signs.contains(Character.toString(text[(text.length - 2)]))) {
                text = text.substring(0, text.length - 1) + "4";
                binding.textField.setText(text);
            } else if (text.length == 1 && text.contains("0")) {
                text = "4";
                binding.textField.setText(text);
            } else {
                binding.textField.setText(text + "4");
                text += "4";


            }
        }

        binding.button5.setOnClickListener {
            if (text.length > 1 && text.endsWith("0") && signs.contains(Character.toString(text[(text.length - 2)]))) {
                text = text.substring(0, text.length - 1) + "5";
                binding.textField.setText(text);
            } else if (text.length == 1 && text.contains("0")) {
                text = "5";
                binding.textField.setText(text);
            } else {
                binding.textField.setText(text + "5");
                text += "5";

            }
        }

        binding.button6.setOnClickListener {
            if (text.length > 1 && text.endsWith("0") && signs.contains(Character.toString(text[(text.length - 2)]))) {
                text = text.substring(0, text.length - 1) + "6";
                binding.textField.setText(text);
            } else if (text.length == 1 && text.contains("0")) {
                text = "6";
                binding.textField.setText(text);
            } else {
                binding.textField.setText(text + "6");
                text += "6";

            }
        }

        binding.button7.setOnClickListener {
            if (text.length > 1 && text.endsWith("0") && signs.contains(Character.toString(text[(text.length - 2)]))) {
                text = text.substring(0, text.length - 1) + "7";
                binding.textField.setText(text);
            } else if (text.length == 1 && text.contains("0")) {
                text = "7";
                binding.textField.setText(text);
            } else {
                binding.textField.setText(text + "7");
                text += "7";

            }
        }

        binding.button8.setOnClickListener {
            if (text.length > 1 && text.endsWith("0") && signs.contains(Character.toString(text[(text.length - 2)]))) {
                text = text.substring(0, text.length - 1) + "8";
                binding.textField.setText(text);
            } else if (text.length == 1 && text.contains("0")) {
                text = "8";
                binding.textField.setText(text);
            } else {
                binding.textField.setText(text + "8");
                text += "8";

            }
        }

        binding.button9.setOnClickListener {
            if (text.length > 1 && text.endsWith("0") && signs.contains(Character.toString(text[(text.length - 2)]))) {
                text = text.substring(0, text.length - 1) + "9";
                binding.textField.setText(text);
            } else if (text.length == 1 && text.contains("0")) {
                text = "9";
                binding.textField.setText(text);
            } else {
                binding.textField.setText(text + "9");
                text += "9";

            }
        }

        binding.clearButton.setOnClickListener {

            binding.textField.setText("");
            text = "";
            sum = 0.0;

        }

        binding.plusButton.setOnClickListener {

            if (text.length == 0) {

            } else if (text.endsWith("-") || text.endsWith("/") || text.endsWith("*") || text.endsWith(
                    "+"
                )
            ) {
                text = text.substring(0, text.length - 1) + "+"
                binding.textField.setText(text)
            } else if (text.contains("+")) {
                try {
                    number1 = text.substring(0, text.indexOf("+")).toDouble()
                    number2 = text.substring(text.indexOf("+") + 1).toDouble()
                    sum = number1 + number2
                    text = checkNumber(sum).toString() +"+"
                } catch (e: Exception) {
                }
            } else if (text.contains("-")) {
                try {
                    number1 = text.substring(0, text.indexOf("-")).toDouble()
                    number2 = text.substring(text.indexOf("-") + 1).toDouble()
                    sum = number1 - number2
                    text = checkNumber(sum).toString() +"+"
                } catch (e: Exception) {
                }
            } else if (text.contains("*")) {
                try {
                    number1 = text.substring(0, text.indexOf("*")).toDouble()
                    number2 = text.substring(text.indexOf("*") + 1).toDouble()
                    sum = number1 * number2
                    text = checkNumber(sum).toString() +"+"
                } catch (e: Exception) {
                }
            } else if (text.contains("/")) {
                try {
                    number1 = text.substring(0, text.indexOf("/")).toDouble()
                    number2 = text.substring(text.indexOf("/") + 1).toDouble()
                    sum = number1 / number2
                    text = checkNumber(sum).toString() +"+"
                } catch (e: Exception) {
                }
            } else {
                binding.textField.setText("$text+")
                text += "+"
            }
            binding.textField.setText(text)
            number1 = sum


        }


        binding.minusButton.setOnClickListener {

            if (text.endsWith("+") || text.endsWith("/") || text.endsWith("*") || text.endsWith("-")) {
                text = text.substring(0, text.length - 1) + "-"
                binding.textField.setText(text)
            } else if (text.contains("+")) {
                try {
                    number1 = text.substring(0, text.indexOf("+")).toDouble()
                    number2 = text.substring(text.indexOf("+") + 1).toDouble()
                    sum = number1 + number2
                    text = checkNumber(sum).toString() +"-"
                } catch (e: java.lang.Exception) {
                }
            } else if (text.contains("-")) {
                try {
                    number1 = text.substring(0, text.indexOf("-")).toDouble()
                    number2 = text.substring(text.indexOf("-") + 1).toDouble()
                    sum = number1 - number2
                    text = checkNumber(sum).toString() +"-"
                } catch (ignored: java.lang.Exception) {
                }
            } else if (text.contains("*")) {
                try {
                    number1 = text.substring(0, text.indexOf("*")).toDouble()
                    number2 = text.substring(text.indexOf("*") + 1).toDouble()
                    sum = number1 * number2
                    text = checkNumber(sum).toString() +"-"
                } catch (e: java.lang.Exception) {
                }
            } else if (text.contains("/")) {
                try {
                    number1 = text.substring(0, text.indexOf("/")).toDouble()
                    number2 = text.substring(text.indexOf("/") + 1).toDouble()
                    sum = number1 / number2
                    text = checkNumber(sum).toString() +"-"
                } catch (e: java.lang.Exception) {
                }
            } else {
                binding.textField.setText("$text-")
                text += "-"
            }
            binding.textField.setText(text)
            number1 = sum


        }

        binding.divideButton.setOnClickListener {

            if (text.length == 0) {

            } else if (text.endsWith("-") || text.endsWith("+") || text.endsWith("*") || text.endsWith(
                    "/"
                )
            ) {
                text = text.substring(0, text.length - 1) + "/"
                binding.textField.setText(text)
            } else if (text.contains("+")) {
                try {
                    number1 = text.substring(0, text.indexOf("+")).toDouble()
                    number2 = text.substring(text.indexOf("+") + 1).toDouble()
                    sum = number1 + number2
                    text = checkNumber(sum).toString() +"/"
                } catch (e: java.lang.Exception) {
                }
            } else if (text.contains("-")) {
                try {
                    number1 = text.substring(0, text.indexOf("-")).toDouble()
                    number2 = text.substring(text.indexOf("-") + 1).toDouble()
                    sum = number1 - number2
                    text = checkNumber(sum).toString() +"/"
                } catch (e: java.lang.Exception) {
                }
            } else if (text.contains("*")) {
                try {
                    number1 = text.substring(0, text.indexOf("*")).toDouble()
                    number2 = text.substring(text.indexOf("*") + 1).toDouble()
                    sum = number1 * number2
                    text = checkNumber(sum).toString() +"/"
                } catch (e: java.lang.Exception) {
                }
            } else if (text.contains("/")) {
                try {
                    number1 = text.substring(0, text.indexOf("/")).toDouble()
                    number2 = text.substring(text.indexOf("/") + 1).toDouble()
                    sum = number1 / number2
                    text = checkNumber(sum).toString() +"/"
                } catch (e: java.lang.Exception) {
                }
            } else {
                binding.textField.setText("$text/")
                text += "/"
            }
            binding.textField.setText(text)
            number1 = sum


        }

        binding.multiplyButton.setOnClickListener {

            if (text.length == 0) {

            } else if (text.endsWith("-") || text.endsWith("/") || text.endsWith("+") || text.endsWith(
                    "*"
                )
            ) {
                text = text.substring(0, text.length - 1) + "*"
                binding.textField.setText(text)
            } else if (text.contains("+")) {
                try {
                    number1 = text.substring(0, text.indexOf("+")).toDouble()
                    number2 = text.substring(text.indexOf("+") + 1).toDouble()
                    sum = number1 + number2
                    text = checkNumber(sum).toString() +"*"
                } catch (e: java.lang.Exception) {
                }
            } else if (text.contains("-")) {
                try {
                    number1 = text.substring(0, text.indexOf("-")).toDouble()
                    number2 = text.substring(text.indexOf("-") + 1).toDouble()
                    sum = number1 - number2
                    text = checkNumber(sum).toString() +"*"
                } catch (e: java.lang.Exception) {
                }
            } else if (text.contains("*")) {
                try {
                    number1 = text.substring(0, text.indexOf("*")).toDouble()
                    number2 = text.substring(text.indexOf("*") + 1).toDouble()
                    sum = number1 * number2
                    text = checkNumber(sum).toString() +"*"
                } catch (e: java.lang.Exception) {
                }
            } else if (text.contains("/")) {
                try {
                    number1 = text.substring(0, text.indexOf("/")).toDouble()
                    number2 = text.substring(text.indexOf("/") + 1).toDouble()
                    sum = number1 / number2
                    text = checkNumber(sum).toString() +"*"

                } catch (e: java.lang.Exception) {
                }
            } else {
                binding.textField.setText("$text*")
                text += "*"
            }
            binding.textField.setText(text)
            number1 = sum


        }

        binding.equalsButton.setOnClickListener {

            try {
                number1 = text.substring(0, text.indexOf("+")).toDouble()
                number2 = text.substring(text.indexOf("+") + 1).toDouble()
                sum = number1 + number2
            } catch (e: java.lang.Exception) {
            }
            try {
                number1 = text.substring(0, text.indexOf("-")).toDouble()
                number2 = text.substring(text.indexOf("-") + 1).toDouble()
                sum = number1 - number2
            } catch (e: java.lang.Exception) {
            }
            try {
                number1 = text.substring(0, text.indexOf("*")).toDouble()
                number2 = text.substring(text.indexOf("*") + 1).toDouble()
                sum = number1 * number2
            } catch (e: java.lang.Exception) {
            }
            try {
                number1 = text.substring(0, text.indexOf("/")).toDouble()
                number2 = text.substring(text.indexOf("/") + 1).toDouble()
                sum = number1 / number2
            } catch (e: java.lang.Exception) {
            }
            text = checkNumber(sum).toString()

            binding.textField.setText(text)
            number1 = sum



        }

        binding.deleteButton.setOnClickListener {

            if(text.length>0){
                text = text.substring(0,text.length-1);
                binding.textField.setText(text);
            }

        }

        binding.dotButton.setOnClickListener {

            if(text.length == 0){
                text = "0."
                binding.textField.setText(text)
            }else if(text.endsWith(".")){
                text = text.substring(0, text.length-1) + ".";
                binding.textField.setText(text);
            }
            else if(text.endsWith("-") || text.endsWith("/") || text.endsWith("*") || text.endsWith("+")){
            }
            else {
                binding.textField.setText(text + ".");
                text += ".";
            }


        }



        return view
    }

    private fun checkNumber(result: Double):Number {
        return if (result%1.0==0.0){
            result.toInt()
        }else{
            result
        }

    }
}
