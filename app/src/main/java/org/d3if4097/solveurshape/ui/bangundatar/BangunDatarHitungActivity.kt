package org.d3if4097.solveurshape.ui.bangundatar

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import org.d3if4097.solveurshape.R
import org.d3if4097.solveurshape.databinding.ActivityBangunDatarHitungBinding
import org.d3if4097.solveurshape.ui.HitungViewModel
import org.d3if4097.solveurshape.ui.ShapeViewModel
import java.text.DecimalFormat

class BangunDatarHitungActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBangunDatarHitungBinding
    private lateinit var viewModel: HitungViewModel


    val dec = DecimalFormat("#,###.00")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bangun_datar_hitung)

        val intent = intent
        if(intent != null){
            binding.judulHitung.setText(intent.getStringExtra("Name"))
            binding.kelilingHitung.setText(intent.getStringExtra("Keliling"))
            binding.luasHitung.setText(intent.getStringExtra("Luas"))
        }

        binding.backHitung.setOnClickListener{
            startActivity(Intent(this, BangunDatarDetailActivity::class.java))
        }

        viewModel = ViewModelProvider(this).get(HitungViewModel::class.java)

        binding.hitungViewModel = viewModel



        if (binding.judulHitung.text.equals("Persegi Panjang")) {
            binding.etHitung2.setVisibility(View.VISIBLE)
            binding.etHitung1.setHint("Masukkan Panjang")
            binding.etHitung2.setHint("Masukkan Lebar")
        } else if (binding.judulHitung.text.equals("Segitiga")){
            binding.etHitung2.setVisibility(View.VISIBLE)
            binding.etHitung3.setVisibility(View.VISIBLE)
            binding.etHitung3.setHint("Masukkan Alas")
        } else if (binding.judulHitung.text.equals("Trapesium")){
            binding.etHitung2.setVisibility(View.VISIBLE)
            binding.etHitung3.setVisibility(View.VISIBLE)
            binding.etHitung4.setVisibility(View.VISIBLE)
            binding.etHitung3.setHint("Masukkan Alas")
            binding.etHitung3.setHint("Masukkan Tinggi")
        } else if (binding.judulHitung.text.equals("Lingkaran")){
            binding.etHitung1.setHint("Masukkan Jari-jari")
        }  else if (binding.judulHitung.text.equals("Jajar Genjang")) {
            binding.etHitung2.setVisibility(View.VISIBLE)
            binding.etHitung1.setHint("Masukkan Alas")
            binding.etHitung2.setHint("Masukkan Sisi Miring")
        }

        binding.btnHitung.setOnClickListener {

            if (binding.judulHitung.text.equals("Persegi")) {
                persegi()

            } else if (binding.judulHitung.text.equals("Persegi Panjang")) {
                persegiPanjang()

            } else if (binding.judulHitung.text.equals("Segitiga")) {
                segitiga()

            } else if (binding.judulHitung.text.equals("Jajar Genjang")) {
                jajarGenjang()

            } else if (binding.judulHitung.text.equals("Trapesium")) {
                trapesium()

            } else if (binding.judulHitung.text.equals("Lingkaran")) {
                lingkaran()

            }

            binding.tvJudulHasil.setVisibility(View.VISIBLE)
            binding.tvTextKel.setVisibility(View.VISIBLE)
            binding.tvHasilKel.setVisibility(View.VISIBLE)
            binding.tvTextLuas.setVisibility(View.VISIBLE)
            binding.tvHasilLuas.setVisibility(View.VISIBLE)

        }

    }

    private fun updateData(){
        viewModel._inputSatu.value = binding.etHitung1.text.toString().toDouble()
        if (binding.judulHitung.text.equals("Persegi Panjang") || binding.judulHitung.text.equals("Jajar Genjang") ){
            viewModel._inputDua.value = binding.etHitung2.text.toString().toDouble()
        } else if (binding.judulHitung.text.equals("Segitiga")){
            viewModel._inputDua.value = binding.etHitung2.text.toString().toDouble()
            viewModel._inputTiga.value = binding.etHitung3.text.toString().toDouble()
        } else if (binding.judulHitung.text.equals("Trapesium")){
            viewModel._inputDua.value = binding.etHitung2.text.toString().toDouble()
            viewModel._inputTiga.value = binding.etHitung3.text.toString().toDouble()
            viewModel._inputEmpat.value = binding.etHitung4.text.toString().toDouble()
        }
    }

    private fun updateScore(){
        binding.tvHasilKel.text = viewModel.hasilKel.value?.toInt().toString()
        binding.tvHasilLuas.text = viewModel.hasilLuas.value?.toInt().toString()
        if (binding.judulHitung.text.equals("Lingkaran")){
            binding.tvHasilKel.text = viewModel.hasilKel.value?.toString()
            binding.tvHasilLuas.text = viewModel.hasilLuas.value?.toString()
        }
    }

    private fun persegi(){
        updateData()
        viewModel.kelPersegi()
        viewModel.luasPersegi()
        updateScore()
    }

    private fun persegiPanjang(){
        updateData()
        viewModel.kelPersegiPanjang()
        viewModel.luasPersegiPanjang()
        updateScore()
    }

    private fun segitiga(){
        updateData()
        viewModel.kelSegitiga()
        viewModel.luasSegitiga()
        updateScore()
    }

    private fun jajarGenjang(){
        updateData()
        viewModel.kelJajarGenjang()
        viewModel.luasJajarGenjang()
        updateScore()
    }

    private fun trapesium(){
        updateData()
        viewModel.kelTrapesium()
        viewModel.luasTrapesium()
        updateScore()
    }

    private fun lingkaran(){
        updateData()
        viewModel.kelLingkaran()
        viewModel.luasLingkaran()
        updateScore()
    }


}
