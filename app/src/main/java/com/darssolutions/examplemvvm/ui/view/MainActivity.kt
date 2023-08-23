package com.darssolutions.examplemvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.darssolutions.examplemvvm.R
import com.darssolutions.examplemvvm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Actividad principal que aloja el fragmento de navegación.
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener el fragmento de navegación y cargar el NavHostFragment
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_container)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
