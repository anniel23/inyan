package com.example.uni_project.ui.out

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.uni_project.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_out.*

class OutFragment : Fragment() {

    private lateinit var outViewModel: OutViewModel
    var sumOut = 0.0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        outViewModel =
            ViewModelProviders.of(this).get(OutViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_out, container, false)
        val addAction: Button = root.findViewById(R.id.addAction)
        val clearAction: Button = root.findViewById(R.id.clearAction)
       addAction.setOnClickListener {
               v -> if (name_action.text.isEmpty()|| kkal_hour.text.isEmpty() || min.text.isEmpty()){
           Snackbar.make(v, "Заполните все поля", Snackbar.LENGTH_LONG).show()}
       else {
           var num1 = (kkal_hour.text.toString()).toDouble()
           var num2 = (min.text.toString()).toDouble()
           sumOut += (num1 *num2 / 60)
           textSumOut.text = sumOut.toString()
           kkal_hour.text.clear()
           min.text.clear()
           name_action.text.clear()
       }
       }
        clearAction.setOnClickListener { v ->
            if (textSumOut.text.isEmpty()) {
                Snackbar.make(v, "Поле пустое", Snackbar.LENGTH_LONG).show()
            } else {
                textSumOut.text = "0"
            }
        }

            return root
    }
}