package com.example.intento7.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.intento7.R
import com.example.intento7.viewModel.PhonesViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private val model: PhonesViewModel by activityViewModels()
    private var superheroesId = 0
    var fullName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            superheroesId = it.getInt("Id")
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }



    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model.liveDataFromLocal.observe(viewLifecycleOwner, androidx.lifecycle.Observer
        {
            model.getSuperHeroesByid(superheroesId).observe(viewLifecycleOwner
                , androidx.lifecycle.Observer {
                if (it != null) {
                    textViewId.text =             it.Id.toString()
                    textViewName.text =             it.Name
                    textViewPrice.text =         it.Price.toString()
                    val im = Glide.with(this).load(it.Image).apply(RequestOptions
                        .circleCropTransform()).into(imageView2)

//                    textViewLg.text =               it.lg
//                    val xs = Glide.with(this).load(it.xs).
                //                    apply(RequestOptions.circleCropTransform()).into(imageView5)
                }
            })
        })
        floatingActionButton2.setOnClickListener {
            Snackbar.make(view, "Adquiriendo Super Poderes", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            buy()
        }
    }

    fun buy() {
        val intent = Intent(Intent.ACTION_SEND)
        val to = "info@novaera.cl"
        val addressees = arrayOf(to)
        val subject = "Consulata {PRODUCT_NAME} id {PRODUCT_ID}"
        val message = "Hola \nVi EL Telefono {PRODUCT_NAME} de código " +
                "{PRODUCT_ID} $fullName y me gustaría que me contactaran a este correo" +
                " o al siguiente numero _______"
        intent.putExtra(Intent.EXTRA_EMAIL, addressees)
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, message)
        intent.type = "text/plain"
        startActivity(Intent.createChooser(intent, "Contactar Area de Ventas:"))
    }
}

