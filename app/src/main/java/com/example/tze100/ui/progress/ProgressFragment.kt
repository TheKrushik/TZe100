package com.example.tze100.ui.progress

import android.os.Bundle
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.tze100.R
import kotlinx.android.synthetic.main.fragment_progress.*
import org.koin.android.viewmodel.ext.android.viewModel

class ProgressFragment : Fragment(R.layout.fragment_progress) {

    private val viewModel: ProgressViewModel by viewModel()
    private val args: ProgressFragmentArgs by navArgs()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(this) {
        }

        label.text = String.format(getString(R.string.text_progress), args.ARGPROCESSID)

        viewModel.postResultProcess(args.ARGPROCESSID)

        viewModel.resultProcess.observe(viewLifecycleOwner, Observer {
            openResult(it)
        })

    }

    private fun openResult(result: Boolean) {
        findNavController().navigate(ProgressFragmentDirections.actionProgressFragmentToResultFragment(result))
    }


}
