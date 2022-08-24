package com.example.myapplication

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentZeroBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class  ZeroFragment : Fragment() {

    private var _binding:  FragmentZeroBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentZeroBinding.inflate(inflater, container, false)



        return binding.root
        // return inflater.inflate(R.layout.fragment_first, container, false)
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}