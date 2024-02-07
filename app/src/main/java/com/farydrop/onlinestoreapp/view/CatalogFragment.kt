package com.farydrop.onlinestoreapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.farydrop.onlinestoreapp.R
import com.farydrop.onlinestoreapp.data.entity.Catalog
import com.farydrop.onlinestoreapp.data.entity.Item
import com.farydrop.onlinestoreapp.databinding.FragmentCatalogBinding
import com.farydrop.onlinestoreapp.view.adapter.CatalogAdapter
import com.farydrop.onlinestoreapp.viewmodel.CatalogFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import retrofit2.awaitResponse


class CatalogFragment : Fragment() {

    private lateinit var binding: FragmentCatalogBinding
    private var catalogAdapter: CatalogAdapter? = null
    val viewModel: CatalogFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatalogBinding.inflate(inflater,container,false)

        catalogAdapter = CatalogAdapter()
        binding.rvCatalog.layoutManager = GridLayoutManager(requireContext(),2)
        binding.rvCatalog.adapter = catalogAdapter
        //viewModel.getCatalog()
        /*viewModel.catalog.observe(viewLifecycleOwner){ list ->
            catalogAdapter?.submitList(list as MutableList<Item>?)
        }*/

        viewModel.catalog.observe(viewLifecycleOwner) { list ->
            catalogAdapter?.submitList(list)
        }

        catalogAdapter?.setOnClickListener(object : CatalogAdapter.CatalogActionListener{
            override fun onCatalogFavorites(position: Int, catalog: Catalog) {
                catalog.isFavorites = true
            }

        })

        return binding.root
    }
}