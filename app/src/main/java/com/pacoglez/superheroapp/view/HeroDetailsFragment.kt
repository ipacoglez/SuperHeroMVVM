package com.pacoglez.superheroapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.pacoglez.superheroapp.databinding.FragmentHeroDetailsBinding
import com.pacoglez.superheroapp.viewmodel.HeroViewModel

class HeroDetailsFragment : Fragment() {

    private var _binding: FragmentHeroDetailsBinding? = null
    private val binding get() = _binding

    lateinit var viewModel: HeroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = activity?.let {
            ViewModelProvider(it)[HeroViewModel::class.java]
        }!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentHeroDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel.getHeroById(1)

//        viewModel.hero.observe(requireActivity(), Observer { data ->
//            _binding!!.textViewName.text = data.name
//
//            Glide.with(binding!!.root.context)
//                .load(data.images.lg)
//                .into(binding!!.imageViewPicture)
//        })

        viewModel.itemDataSelected?.let { data ->

            _binding!!.textViewName.text = data.name

            _binding!!.textViewIntelligence.text = data.powerStats.intelligence.toString()
            _binding!!.circularProgressIndicatorIntelligence.progress = data.powerStats.intelligence

            _binding!!.textViewStrength.text = data.powerStats.strength.toString()
            _binding!!.circularProgressIndicatorIntelligence.progress = data.powerStats.strength

            _binding!!.textViewSpeed.text = data.powerStats.speed.toString()
            _binding!!.circularProgressIndicatorSpeed.progress = data.powerStats.intelligence

            _binding!!.textViewFullName.text = "Nombre completo: " + data.biography.fullName
            _binding!!.textViewAliases.text = "Alias: " + data.biography.aliases[0]
            _binding!!.textViewPublisher.text = "Publicador: " + data.biography.publisher

            _binding!!.textViewPublisher.text = "Publicador: " + data.biography.publisher
            _binding!!.textViewOccupation.text = "Ocupación: " + data.work.occupation

            _binding!!.textViewOccupation.text = "Ocupación: " + data.work.occupation

            _binding!!.textViewGroupAffiliation.text = "Grupo de afilación: " + data.connections.groupAffiliation

            _binding!!.textViewGroupGender.text = "Género: " + data.appearance.gender
            _binding!!.textViewGroupRace.text = "Raza: " + data.appearance.race

            Glide.with(binding!!.root.context)
                .load(data.images.lg)
                .into(binding!!.imageViewPicture)

        }
    }

    companion object {
        fun newInstance() = HeroDetailsFragment()
    }
}