package com.isaacer.authencitionapp

import android.os.Bundle
import android.text.Layout.Directions
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.isaacer.authencitionapp.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {
    /*BURADA FRAGMENTLERDE BİNDİNGİMİ TANIMLADIM*/
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

   //FirebaseAuth servisine bağlanmak için gerekli olan bağlantı nesnesini oluşturdum.
   //Yani Auth firebase bağlanna köprü
   //Bu değişken sayesinde Firebase'in authentication özelliklerine erişebileceksin
   //Kullanıcı giriş-çıkışı, kayıt olma, şifre sıfırlama gibi tüm işlemler bu nesne üzerinden olacak
    private lateinit var auth:FirebaseAuth
    //on creatin içinde bu nesneyi başlatacam.

    //*onCreate() = Activity'nin ilk doğduğu yer
    // Uygulama açılır açılmaz Firebase bağlantısı hazır olsun istiyoruz
    // Kullanıcı herhangi bir butona basmadan önce auth hazır beklesin*/
    //Bir kez çalışır, hep hazır bekler
    //Activity tamamen yüklendiğinde çalışır







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     auth= Firebase.auth

    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.REGSTER.setOnClickListener { registeratiklandi(it) }
        binding.textViewLogin.setOnClickListener{loginetiklandi(it)}

    }

    fun registeratiklandi(view:View){

      val kullanicinemali=binding.email.text.toString()
      val kullanicininsifresi=binding.password.text.toString()

      auth.createUserWithEmailAndPassword(kullanicinemali,kullanicininsifresi)
          .addOnCompleteListener { task->
              if(task.isSuccessful){
                  Toast.makeText(requireContext(),"kaaydınız başarılı bir şekilde gerçekleşti",Toast.LENGTH_LONG).show()
                  //diğer fragmnette geçirecem.
                  val action=RegisterFragmentDirections.actionRegisterFragmentToGirisFragment()
                  Navigation.findNavController(view).navigate(action)

              }
          }.addOnFailureListener { exception->
              Toast.makeText(requireContext(),exception.localizedMessage,Toast.LENGTH_LONG).show()
          }


    }

    fun loginetiklandi(view: View){
           val action=RegisterFragmentDirections.actionRegisterFragmentToGirisFragment()
        Navigation.findNavController(view).navigate(action)
    }



}