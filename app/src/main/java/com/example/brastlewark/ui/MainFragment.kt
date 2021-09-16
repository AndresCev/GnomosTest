package com.example.brastlewark.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.brastlewark.R
import com.example.brastlewark.data.model.DataSource
import com.example.brastlewark.data.model.Gnome
import com.example.brastlewark.domain.RepoImpl
import com.example.brastlewark.ui.viewmodel.MainViewModel
import com.example.brastlewark.ui.viewmodel.VMFactory
import com.example.brastlewark.vo.Resource
import kotlinx.android.synthetic.main.fragment_main.*




class MainFragment : Fragment(), MainAdapter.OnGnomeClickListener {

    private val viewModel by viewModels<MainViewModel> { VMFactory(RepoImpl(DataSource())) }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycleView()
        viewModel.fetchGnomesList.observe(
            viewLifecycleOwner,
            androidx.lifecycle.Observer { result ->
                when (result) {
                    is Resource.Loading -> {
                        progresBar.visibility = View.VISIBLE

                    }
                    is Resource.Success -> {
                        progresBar.visibility = View.GONE
                        rv_gnomes.adapter = MainAdapter(requireContext(),result.data,this)

                    }
                    is Resource.Failure -> {
                        progresBar.visibility = View.GONE
                        Toast.makeText(requireContext(), "error ${result.exception}", Toast.LENGTH_SHORT).show()
                    }
                }
            })


    }

    private fun setupRecycleView(){

        rv_gnomes.layoutManager = LinearLayoutManager(requireContext())
        rv_gnomes.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))
    }

    override fun onGnomeClick(gnome: Gnome) {
        val bundle = Bundle()
        bundle.putParcelable("gnome",gnome)
        findNavController().navigate(R.id.action_mainFragment_to_tragosDetallesFragment,bundle)
    }







}