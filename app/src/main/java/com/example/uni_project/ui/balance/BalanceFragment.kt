package com.example.uni_project.ui.balance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.uni_project.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_balance.*
import kotlinx.android.synthetic.main.fragment_in.*
import kotlinx.android.synthetic.main.fragment_out.*

class BalanceFragment : Fragment() {

    private lateinit var balanceViewModel: BalanceViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        balanceViewModel =
            ViewModelProviders.of(this).get(BalanceViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_balance, container, false)

        val buttonOst: Button = root.findViewById(R.id.buttonOst)

        buttonOst.setOnClickListener {v ->
             if (textSumIn.text.isEmpty() || textSumOut.text.isEmpty()) {
                 Snackbar.make(
                     v,
                     "Заполните информацию в разделах еда и упражнения",
                     Snackbar.LENGTH_LONG
                 ).show()
             } else {
                 var ost = (norma.text.toString()).toDouble() -
                         (textSumIn.text.toString()).toDouble() + (textSumOut.text.toString()).toDouble()
                 ostatok.text = ost.toString()
             }
        }
        return root
    }
}