package com.example.pokebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokebase.adapter.PokemonAdapter
import com.example.pokebase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    val adapter by lazy {
        PokemonAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.pokelista.layoutManager = LinearLayoutManager(this)
        binding.pokelista.adapter = adapter
        binding.pokelista.setHasFixedSize(true)

        binding.logoutBtn.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Cerrar sesión")
                .setMessage("¿Seguro que desea cerrar su sesión?")
                .setNegativeButton("NO") { dialog, view ->
                    dialog.dismiss()
                }.setPositiveButton("SI") { dialog, view ->
                    finish()
                    startActivity(
                        Intent(this@MainActivity, LoginActivity::class.java)
                    )
                }.show()
        }

    }
}