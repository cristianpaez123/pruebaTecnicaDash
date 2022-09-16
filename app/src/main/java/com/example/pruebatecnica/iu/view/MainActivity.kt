package com.example.pruebatecnica.iu.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.pruebatecnica.R
import com.example.pruebatecnica.databinding.ActivityMainBinding
import com.example.pruebatecnica.iu.viewModel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    val homeFragment: HomeFragment = HomeFragment()
    val routesFragment: RoutesFragment = RoutesFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigationButtonOnClick()
    }

    fun navigationButtonOnClick() {
        binding.bottomNavigation.setOnItemSelectedListener{
            when (it.itemId){
                R.id.home -> {
                    setCurrentFragment(homeFragment)
                    true
                }
                R.id.routes -> {
                    setCurrentFragment(routesFragment)
                    true
                }
                else -> false
            }
        }
    }

    fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.containerView, fragment)
            commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }
}