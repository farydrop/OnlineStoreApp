package com.farydrop.onlinestoreapp.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.farydrop.onlinestoreapp.data.entity.Catalog
import com.farydrop.onlinestoreapp.databinding.FragmentFavoritesBinding
import com.farydrop.onlinestoreapp.view.adapter.CatalogAdapter
import com.farydrop.onlinestoreapp.viewmodel.FavoritesFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoritesFragment : Fragment() {

    private lateinit var binding: FragmentFavoritesBinding
    private var catalogAdapter: CatalogAdapter? = null
    val viewModel: FavoritesFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater,container,false)

        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        catalogAdapter = CatalogAdapter()
        binding.rvCatalog.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvCatalog.adapter = catalogAdapter
        viewModel.getCatalog()

        viewModel.catalogListState.observe(viewLifecycleOwner) { list ->
            catalogAdapter?.submitList(list)
        }
        catalogAdapter?.setOnClickListener(object : CatalogAdapter.CatalogActionListener {
            override fun onCatalogFavorites(position: Int, catalog: Catalog) {
                catalog.isFavorites = !catalog.isFavorites
                catalogAdapter?.notifyItemChanged(position)

                viewModel.deleteItem(catalog)
            }

            override fun onCatalogDetails(position: Int, catalog: Catalog) {
                startActivity(Intent(requireContext(),ProductPageActivity::class.java))
            }
        })

        return binding.root
    }

}