package com.example.intento7.ui

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
import com.example.intento7.viewModel.SuperHeroesViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.fragment_second.textView1

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private val model: SuperHeroesViewModel by activityViewModels()
    private var superheroesId = 0
    var fullName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            superheroesId = it.getInt("id")
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
                    textView.text = it.name
                    textView1.text = "Code " + it.id.toString()
                    textView2.text = "Full Name " + it.fullName
                    textView3.text = "Alter Egos " +  it.alterEgos
                    textView4.text = "First Appearance " +  it.firstAppearance
                    textView5.text = "Gender " +  it.gender
                    textView6.text = "Full Name " +  it.alignment
                    textView7.text = "Alignment " +  it.base
                    textView8.text = "Eye Color " +  it.eyeColor
                    textView9.text = "Group Affiliation " +  it.groupAffiliation
                    textView10.text = "Hair Color " +  it.hairColor
                    textView11.text = "Occupation " +  it.occupation
                    textView12.text = "Place Of Birth " +  it.placeOfBirth
                    textView13.text = "Publisher " +  it.publisher
                    textView14.text = "Race " +  it.race
                    textView15.text = "Relatives " +  it.relatives
                    textView16.text = "Slug " +  it.slug
                    textView17.text = "Xs " +  it.xs
                    textView18.text = "Sm " +  it.sm
                    textView19.text = "Md " +  it.md
                    textView20.text = "Lg " +  it.lg

//                    val xs = Glide.with(this).load(it.xs).apply(RequestOptions.circleCropTransform()).into(imageView2)
//                    val sm = Glide.with(this).load(it.sm).apply(RequestOptions.circleCropTransform()).into(imageView2)
//                    val md = Glide.with(this).load(it.md).apply(RequestOptions.circleCropTransform()).into(imageView2)
                    val lg = Glide.with(this).load(it.lg).apply(RequestOptions.circleCropTransform()).into(imageView2)
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
        val to = "info@plaplix.cl"
        val addressees = arrayOf(to)
        val subject = "Super Heroe $superheroesId"
        val message = "Hola \nVi este super Heroe llamado $fullName y quiero comprarlo llámame al _________"
        intent.putExtra(Intent.EXTRA_EMAIL, addressees)
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, message)
        intent.type = "text/plain"
        startActivity(Intent.createChooser(intent, "Contactar Area de Ventas:"))
    }
}

