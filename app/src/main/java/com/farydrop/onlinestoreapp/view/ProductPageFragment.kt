package com.farydrop.onlinestoreapp.view

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.farydrop.onlinestoreapp.R
import com.farydrop.onlinestoreapp.data.entity.Catalog
import com.farydrop.onlinestoreapp.databinding.FragmentProductPageBinding
import com.farydrop.onlinestoreapp.viewmodel.FavoritesFragmentViewModel
import com.farydrop.onlinestoreapp.viewmodel.ProductPageFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductPageFragment : Fragment() {

    private lateinit var binding: FragmentProductPageBinding
    val viewModel: ProductPageFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductPageBinding.inflate(inflater,container,false)

        viewModel.getCatalog()
        viewModel.catalogListState.observe(viewLifecycleOwner){details ->
            binding.ivBack.setOnClickListener {
                requireActivity().onBackPressedDispatcher.onBackPressed()
                viewModel.deleteDetails(details)
            }
            binding.tvBrandTitle.text = details.title
            binding.tvProductTitle.text = details.title
        }

        return binding.root
    }
}