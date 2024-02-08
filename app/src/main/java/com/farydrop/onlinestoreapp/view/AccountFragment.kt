package com.farydrop.onlinestoreapp.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.farydrop.onlinestoreapp.R
import com.farydrop.onlinestoreapp.databinding.FragmentAccountBinding
class AccountFragment : Fragment() {

    private lateinit var binding: FragmentAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccountBinding.inflate(inflater, container,false)

        binding.clFavorites.setOnClickListener {
            startActivity(Intent(requireContext(),FavoritesActivity::class.java))
            requireActivity().supportFragmentManager.beginTransaction().addToBackStack(null)
        }

        return binding.root
    }
}