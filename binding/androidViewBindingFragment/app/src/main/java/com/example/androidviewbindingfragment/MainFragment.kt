package com.example.androidviewbindingfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidviewbindingfragment.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main){

    private var _binding: FragmentMainBinding? = null
    //_binding can contain null item but binding can not contain null item due to !! done because
    //have not to write binding?.tvFragment?.text everywhere
    //can not do directly binding=_binding beacuse one is nullable other is not
    private val binding get() = _binding!!

    //if you write either onCreateView or onViewCraeted both give same output with individual and also
    //with together

   /* override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater,container,false)
        binding.tvFragment.text = "Hello from main fragment"
        return binding.root
    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        _binding = FragmentMainBinding.bind(view)

        binding.tvFragment.text = "Hello from main fragment"
    }

    //on destroying the fragment you should have it null in acordance to lifecycle of fragment
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
