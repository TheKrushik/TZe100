package com.example.tze100.ui.start

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.tze100.R
import com.example.tze100.api.NetworkState
import kotlinx.android.synthetic.main.fragment_start.*
import org.koin.android.viewmodel.ext.android.viewModel


class StartFragment : Fragment(R.layout.fragment_start) {

    private val viewModel: StartViewModel by viewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        buttonStart.setOnClickListener {
            viewModel.postBackendId()
        }

        viewModel.backendId.observe(viewLifecycleOwner, Observer {
            openProgress(it)
        })

        viewModel.status.observe(viewLifecycleOwner, Observer {
            updateUILoading(it)
        })

    }

    private fun updateUILoading(networkState: NetworkState) {
        when (networkState){
            NetworkState.RUNNING -> {
                progressStart.visibility = View.VISIBLE
                labelStart.text = ""
            }
            NetworkState.FAILED -> {
                progressStart.visibility = View.INVISIBLE
                labelStart.text = NetworkState.FAILED.name
            }
            NetworkState.SUCCESS -> {
                progressStart.visibility = View.INVISIBLE
            }
        }
    }

    private fun openProgress(id: String) {
        findNavController().navigate(StartFragmentDirections.actionStartFragmentToProgressFragment(id))
    }

}
