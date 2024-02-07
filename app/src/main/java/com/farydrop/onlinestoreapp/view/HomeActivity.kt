package com.farydrop.onlinestoreapp.view

import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.farydrop.onlinestoreapp.R
import com.farydrop.onlinestoreapp.databinding.ActivityHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentList = listOf(HomeFragment(), CatalogFragment(),BagFragment(), DiscountFragment(), AccountFragment())

        val adapter = ViewPagerAdapter(this, fragmentList)
        binding.viewPager2.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->

            when(position){
                0 -> {
                    tab.text = "Главная"
                    val tabIcon = ContextCompat.getDrawable(this, R.drawable.ic_home)
                    tabIcon?.setColorFilter(ContextCompat.getColor(this, R.color.pink), PorterDuff.Mode.SRC_IN)
                    tab.setIcon(tabIcon)
                    tab.tabLabelVisibility = TabLayout.TAB_LABEL_VISIBILITY_LABELED
                }
                1 -> {
                    tab.text = "Каталог"
                    tab.setIcon(R.drawable.ic_catalog)
                    tab.tabLabelVisibility = TabLayout.TAB_LABEL_VISIBILITY_LABELED
                }
                2 -> {
                    tab.text = "Корзина"
                    tab.setIcon(R.drawable.ic_bag)
                    tab.tabLabelVisibility = TabLayout.TAB_LABEL_VISIBILITY_LABELED
                }
                3 -> {
                    tab.text = "Акции"
                    tab.setIcon(R.drawable.ic_discount)
                    tab.tabLabelVisibility = TabLayout.TAB_LABEL_VISIBILITY_LABELED
                }
                4 -> {
                    tab.text = "Профиль"
                    tab.setIcon(R.drawable.ic_account)
                    tab.tabLabelVisibility = TabLayout.TAB_LABEL_VISIBILITY_LABELED
                }
            }

            /*if (position == 0) {
                    tab.text = "Каталог"
                    tab.setIcon(R.drawable.ic_catalog)
                    tab.tabLabelVisibility = TabLayout.TAB_LABEL_VISIBILITY_LABELED

            } else if (position == 1) {
                    tab.text = "Аккаунт"
                    tab.setIcon(R.drawable.ic_account)
                    tab.tabLabelVisibility = TabLayout.TAB_LABEL_VISIBILITY_LABELED
            }*/

        }.attach()

        //binding.viewPager2.currentItem = defaultPosition
        binding.viewPager2.isUserInputEnabled = false

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.viewPager2.currentItem = tab.position

                val tabIconColor = ContextCompat.getColor(applicationContext, R.color.pink)
                tab.icon!!.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                val tabIconColor = ContextCompat.getColor(applicationContext, R.color.dark_grey)
                tab.icon!!.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // Optional: Handle tab reselected events
            }
        })
    }
}