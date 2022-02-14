package com.pacoglez.superheroapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pacoglez.superheroapp.databinding.FragmentHeroListBinding
import com.pacoglez.superheroapp.model.HeroModel
import com.pacoglez.superheroapp.viewmodel.HeroViewModel

class HeroListFragment : Fragment(), ClickListener {

    private lateinit var binding: FragmentHeroListBinding
    lateinit var viewModel: HeroViewModel
    private var adapter: HeroRecyclerViewAdapter? = null

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
        binding = FragmentHeroListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = HeroRecyclerViewAdapter(this)
        binding.recyclerViewList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewList.adapter = adapter

        binding.recyclerViewList.adapter = HeroRecyclerViewAdapter(this).apply {
            viewModel.heroes.observe(viewLifecycleOwner){
                this.heroes = it
            }
        }

        viewModel.message.observe(viewLifecycleOwner){
            binding.textViewMessage.text = it
        }
    }

    override fun itemSelect(data: HeroModel){
        viewModel.setItemSelection(data)

        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(android.R.id.content, HeroDetailsFragment.newInstance())
            ?.addToBackStack(null)
            ?.commit()
    }

}

interface ClickListener {
    fun itemSelect(data: HeroModel)
}