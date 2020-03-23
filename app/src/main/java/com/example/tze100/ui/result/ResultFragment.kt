package com.example.tze100.ui.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.tze100.R
import kotlinx.android.synthetic.main.fragment_result.*

class ResultFragment : Fragment(R.layout.fragment_result) {

    private val args: ResultFragmentArgs by navArgs()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        labelResult.text = String.format(getString(R.string.text_result), args.ARGPROCESSRESULT)
    }
}