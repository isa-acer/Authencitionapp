package com.isaacer.authencitionapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.isaacer.authencitionapp.databinding.FragmentBasariliBinding
import com.isaacer.authencitionapp.databinding.FragmentGirisBinding
import com.isaacer.authencitionapp.databinding.FragmentRegisterBinding


class BasariliFragment : Fragment() {
    /*BURADA FRAGMENTLERDE BİNDİNGİMİ TANIMLADIM*/
    private var _binding: FragmentBasariliBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBasariliBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}