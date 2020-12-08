package org.d3if4097.solveurshape.ui.bangundatar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import org.d3if4097.solveurshape.R
import org.d3if4097.solveurshape.databinding.ActivityBangunDatarBinding
import org.d3if4097.solveurshape.databinding.ActivityBangunDatarDetailBinding

class BangunDatarDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBangunDatarDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bangun_datar_detail)

        val intent = intent
        if(intent != null){
            binding.judulDetail.setText(intent.getStringExtra("Name"))
            binding.descriptionDetail.setText(intent.getStringExtra("Desc"))
            binding.kelilingDetail.setText(intent.getStringExtra("Keliling"))
            binding.luasDetail.setText(intent.getStringExtra("Luas"))

            Glide.with(this)
                .load(intent.getStringExtra("Image"))
                .placeholder(R.drawable.kotak)
                .dontAnimate()
                .into(binding.gambarDetail)
        }


        binding.btnHitung.setOnClickListener {
            val name = binding.judulDetail.text
            val keliling = binding.kelilingDetail.text
            val luas = binding.luasDetail.text

            Toast.makeText(this,
                "Berhasil di klik",
                Toast.LENGTH_SHORT
            ).show()

            val intent = Intent(this@BangunDatarDetailActivity, BangunDatarHitungActivity::class.java)
            intent.putExtra("Name",name)
            intent.putExtra("Keliling",keliling)
            intent.putExtra("Luas",luas)

            startActivity(intent)

        }

        binding.backDetail.setOnClickListener{
            startActivity(Intent(this, BangunDatarActivity::class.java))
        }
    }
}
