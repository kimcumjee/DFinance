package com.study.dfinance.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.study.dfinance.R
import com.study.dfinance.viewModel.NasdaqViewModel

class NasdaqFragment : Fragment() {

    private lateinit var dashboardViewModel: NasdaqViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(NasdaqViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_nasdaq, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}