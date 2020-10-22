package com.example.intento7.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.intento7.R
import com.example.intento7.viewModel.SuperHeroesViewModel
import kotlinx.android.synthetic.main.fragment_second.*
import java.util.Observer

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private val model: SuperHeroesViewModel by activityViewModels()
    private var superheroesId= 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            superheroesId= it.getInt("id")
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model.liveDataFromLocal.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            model.getSuperHeroesByid(superheroesId).observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                if (it != null) {
                    textView2.text= it.name + " N° "+it.id.toString()
                    textView3.text= "Verdadera personaidad: "+it.alterEgos
                    textView4.text= "Altura: "+it.height.toString()

                    val SuperHeroesSelectImg= Glide.with(this).load(it.imageLg).apply(RequestOptions.circleCropTransform()).into(imageView2)
                }
            })
        })
    }
}

