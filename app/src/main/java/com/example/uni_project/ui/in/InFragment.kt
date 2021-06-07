package com.example.uni_project.ui.`in`

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.uni_project.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_in.*

class InFragment : Fragment() {

    private lateinit var inViewModel: InViewModel
    var sumIn = 0.0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inViewModel =
            ViewModelProviders.of(this).get(InViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_in, container, false)
        val addFood: Button = root.findViewById(R.id.addFood)
        val clearFood: Button = root.findViewById(R.id.clearFood)
        addFood.setOnClickListener{ v -> if (name.text.isEmpty()|| kkal_100.text.isEmpty() || kolvo.text.isEmpty()){
            Snackbar.make(v, "Заполните все поля", Snackbar.LENGTH_LONG).show()}
        else {
            var num1 = (kkal_100.text.toString()).toDouble()
            var num2 = (kolvo.text.toString()).toDouble()
            sumIn += (num1 *num2 / 100)
            textSumIn.text = sumIn.toString()
            kkal_100.text.clear()
            kolvo.text.clear()
            name.text.clear()
            }
        }
        clearFood.setOnClickListener { v -> if (textSumIn.text.isEmpty()){
            Snackbar.make(v, "Поле пустое", Snackbar.LENGTH_LONG).show()}
        else {
            textSumIn.text = "0"
        }

        }
        return root
    }



}
