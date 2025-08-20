package com.isaacer.authencitionapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.isaacer.authencitionapp.databinding.FragmentGirisBinding
import com.isaacer.authencitionapp.databinding.FragmentRegisterBinding


class GirisFragment : Fragment() {
    /*BURADA FRAGMENTLERDE BİNDİNGİMİ TANIMLADIM*/
    private var _binding: FragmentGirisBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth:FirebaseAuth





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth= Firebase.auth

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGirisBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textViewRegister.setOnClickListener { registeratiklandi(it) }
        binding.LOGNBUTONU.setOnClickListener { loginetiklandi(it) }
    }


    fun registeratiklandi(view:View){
      val action=GirisFragmentDirections.actionGirisFragmentToRegisterFragment()
        Navigation.findNavController(view).navigate(action)
    }

    fun loginetiklandi(view:View){

        val kullanicininmaili=binding.emailigir.text.toString()
        val kullanicininsifresi=binding.passwordugir.text.toString()
        auth.signInWithEmailAndPassword(kullanicininmaili,kullanicininsifresi).addOnSuccessListener {
            val action=GirisFragmentDirections.actionGirisFragmentToBasariliFragment2()
            Navigation.findNavController(view).navigate(action)
        }.addOnFailureListener { exception->

            Toast.makeText(requireContext(),exception.localizedMessage,Toast.LENGTH_LONG).show()
            //aktivitenin içinde olsaydık require context yerine this derdik.
        }


    }

}