package com.farydrop.onlinestoreapp.view

import android.graphics.Paint
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
            binding.ivProductImg.setImageResource(details.imgOne)
            binding.tvDescription.text = details.subtitle
            binding.tvPriceWithDiscount.text = details.price.priceWithDiscount
            binding.tvPriceWithoutDiscount.text = details.price.price
            binding.tvDiscount.text = "-${details.price.discount.toString()}%"
            binding.tvFullDescription.text = details.description
            binding.tvProductCode.text = details.info[0].value
            binding.tvAreaOfUse.text = details.info[1].value
            binding.tvCountryOfOrigin.text = details.info[2].value
            binding.tvAvailable.text = details.available.toString()
            binding.tvRating.text = details.feedback.rating.toString()
            binding.tvFeedback.text = "${details.feedback.count.toString()} отзывов"


        }

        binding.tvPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}