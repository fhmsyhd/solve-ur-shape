package org.d3if4097.solveurshape.ui.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import org.d3if4097.solveurshape.R
import org.d3if4097.solveurshape.databinding.ActivityMainBinding
import org.d3if4097.solveurshape.databinding.ActivityMenu2Binding
import org.d3if4097.solveurshape.ui.bangundatar.BangunDatarActivity

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenu2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_menu2)

        binding.btnDatar.setOnClickListener{
            startActivity(Intent(this, BangunDatarActivity::class.java))
        }
    }
}
