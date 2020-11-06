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
import com.example.intento7.viewModel.SuperHeroesViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.fragment_second.textViewCode

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



    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model.liveDataFromLocal.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            model.getSuperHeroesByid(superheroesId).observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                if (it != null) {
                    textViewName.text = it.name
                    textViewCode.text = "Code :" + it.id.toString()
                    textViewFullName.text = "Full Name :" + it.fullName
                    textViewAlterEgos.text = "Alter Egos :" +  it.alterEgos
                    textViewFirstAppearance.text = "First Appearance :" +  it.firstAppearance
                    gender.text = "Gender :" +  it.gender
                    textViewAlignment.text = "Alignment :" +  it.alignment
                    textViewBase.text = "Base :" +  it.base
                    textViewEyeColor.text = "Eye Color :" +  it.eyeColor
                    textViewGroupAffiliation.text = "Group Affiliation :" +  it.groupAffiliation
                    textViewHairColor.text = "Hair Color :" +  it.hairColor
                    textViewOccupation.text = "Occupation :" +  it.occupation
                    textViewPlaceOfBith.text = "Place Of Birth :" +  it.placeOfBirth
                    textViewPublisher.text = "Publisher :" +  it.publisher
                    textViewRace.text = "Race :" +  it.race
                    textViewRelatives.text = "Relatives :" +  it.relatives
                    textViewSlug.text = "Slug :" +  it.slug
                    textViewXs.text = "Xs :" +  it.xs
                    textViewSm.text = "Sm :" +  it.sm
                    textViewMd.text = "Md :" +  it.md
                    textViewLg.text = "Lg :" +  it.lg

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

