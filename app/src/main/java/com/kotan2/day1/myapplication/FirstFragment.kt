package com.kotan2.day1.myapplication

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val red: TextView = view.findViewById(R.id.red)
        val blue: TextView = view.findViewById(R.id.blue)
        val green: TextView = view.findViewById(R.id.green)
        val yellow: TextView = view.findViewById(R.id.yellow)
        val cyan: TextView = view.findViewById(R.id.cyan)
        val magenta: TextView = view.findViewById(R.id.magenta)
        val grey: TextView = view.findViewById(R.id.grey)

        red.setOnClickListener { navigate(Color.RED, "RED") }
        blue.setOnClickListener { navigate(Color.BLUE, "BLUE") }
        green.setOnClickListener { navigate(Color.GREEN, "GREEN") }
        yellow.setOnClickListener { navigate(Color.YELLOW, "YELLOW") }
        cyan.setOnClickListener { navigate(Color.CYAN, "CYAN") }
        magenta.setOnClickListener { navigate(Color.MAGENTA, "MAGENTA") }
        grey.setOnClickListener { navigate(Color.GRAY, "GRAY") }

        return view
    }

    private fun navigate(color: Int, name: String) {
        activity?.supportFragmentManager?.let {
            val generic = GenericFragment.newInstance(color, name)
            val transaction = it.beginTransaction()
            transaction.replace(R.id.host, generic)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}