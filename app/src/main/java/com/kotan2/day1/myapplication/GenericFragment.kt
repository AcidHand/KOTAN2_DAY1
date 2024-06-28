package com.kotan2.day1.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class GenericFragment : Fragment() {

    private var colorRes: Int = 0
    private var colorName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(COLOR_RES)) colorRes = it.getInt(COLOR_RES)
            if (it.containsKey(COLOR_NAME)) colorName = it.getString(COLOR_NAME).orEmpty()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_generic, container, false)
        val colorView = view.findViewById<TextView>(R.id.color_name)

        colorView.apply {
            text = colorName
            setBackgroundColor(colorRes)
        }
        return view
    }

    companion object {
        private const val COLOR_RES = "COLOR_RES"
        private const val COLOR_NAME = "COLOR_NAME"

        fun newInstance(colorRes: Int, colorName: String): GenericFragment {
            val fragment = GenericFragment()
            fragment.arguments = bundleOf(COLOR_NAME to colorName, COLOR_RES to colorRes)
            return fragment
        }
    }
}