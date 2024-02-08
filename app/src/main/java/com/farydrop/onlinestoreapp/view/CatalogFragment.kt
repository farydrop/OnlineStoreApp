package com.farydrop.onlinestoreapp.view

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridLayout
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.farydrop.onlinestoreapp.R
import com.farydrop.onlinestoreapp.data.entity.Catalog
import com.farydrop.onlinestoreapp.data.entity.Details
import com.farydrop.onlinestoreapp.data.entity.Item
import com.farydrop.onlinestoreapp.databinding.FragmentCatalogBinding
import com.farydrop.onlinestoreapp.view.adapter.CatalogAdapter
import com.farydrop.onlinestoreapp.viewmodel.CatalogFragmentViewModel
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
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
        binding = FragmentCatalogBinding.inflate(inflater, container, false)

        catalogAdapter = CatalogAdapter()
        binding.rvCatalog.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvCatalog.adapter = catalogAdapter
        //viewModel.getCatalog()
        /*viewModel.catalog.observe(viewLifecycleOwner){ list ->
            catalogAdapter?.submitList(list as MutableList<Item>?)
        }*/

        viewModel.catalog.observe(viewLifecycleOwner) { list ->
            catalogAdapter?.submitList(list)
        }

        catalogAdapter?.setOnClickListener(object : CatalogAdapter.CatalogActionListener {
            override fun onCatalogFavorites(position: Int, catalog: Catalog) {
                catalog.isFavorites = !catalog.isFavorites
                catalogAdapter?.notifyItemChanged(position)

                viewModel.insertFavorites(catalog)
            }

            override fun onCatalogDetails(position: Int, catalog: Catalog) {
                startActivity(Intent(requireContext(),ProductPageActivity::class.java))
                val details = Details(
                    // Используйте данные из объекта Catalog для создания объекта Details
                    imgOne = catalog.imgOne,
                    imgTwo = catalog.imgTwo,
                    available = catalog.available,
                    description = catalog.description,
                    feedback = catalog.feedback,
                    id = catalog.id,
                    ingredients = catalog.ingredients,
                    isFavorites = catalog.isFavorites,
                    price = catalog.price,
                    subtitle = catalog.subtitle,
                    title = catalog.title,
                    info = catalog.info,
                    tags = catalog.tags
                )
                viewModel.insertDetails(details)
            }
        })

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.sort_options,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spDropDown.adapter = adapter
        }

        binding.spDropDown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Осуществляем сортировку в зависимости от выбранного значения в спиннере
                when (position) {
                    0 -> sortItemsByPopularity()
                    1 -> sortItemsByPriceDescending()
                    2 -> sortItemsByPriceAscending()
                }
                // Скрываем выпадающий список после выбора значения
                //binding.spDropDown.visibility = View.GONE
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        setupChipListener(binding.chipAll, "")
        setupChipListener(binding.chipBody, "body")
        setupChipListener(binding.chipFace, "face")
        setupChipListener(binding.chipSuntan, "suntan")
        setupChipListener(binding.chipMask, "mask")

        return binding.root
    }
    private fun setupChipListener(chip: Chip, tag: String) {
        chip.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Фильтрация товаров по выбранному тегу
                filterItemsByTag(tag)
            } else {
                // Отмена выбора тега
                // Если нужно что-то выполнить при отмене выбора, добавьте соответствующий код здесь
            }
        }
    }
    private fun filterItemsByTag(tag: String) {
        viewModel.catalog.observe(viewLifecycleOwner){ list ->
            val filteredItems = list.filter {it.tags.contains(tag) }
            catalogAdapter?.submitList(filteredItems)
        }
    }

    private fun sortItemsByPopularity() {
        viewModel.catalog.observe(viewLifecycleOwner){ list ->
            catalogAdapter?.submitList(list.sortedByDescending {
                it.feedback.rating
            })
        }
    }

    private fun sortItemsByPriceDescending() {
        viewModel.catalog.observe(viewLifecycleOwner){ list ->
            catalogAdapter?.submitList(list.sortedByDescending { it.price.priceWithDiscount.toInt() })
        }
    }

    private fun sortItemsByPriceAscending() {
        viewModel.catalog.observe(viewLifecycleOwner){ list ->
            catalogAdapter?.submitList(list.sortedBy { it.price.priceWithDiscount.toInt() })
        }
    }
}