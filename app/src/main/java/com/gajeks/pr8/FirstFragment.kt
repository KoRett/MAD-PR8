package com.gajeks.pr8

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gajeks.pr8.databinding.FirstFragmentBinding
import java.util.Date

class FirstFragment : Fragment() {

    private var _binding: FirstFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FirstFragmentBinding.inflate(inflater, container, false)

        binding.updateButton.setOnClickListener {
            binding.dateTextView.text = Date().toString()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}