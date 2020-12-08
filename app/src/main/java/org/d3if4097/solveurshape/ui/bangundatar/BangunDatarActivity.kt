package org.d3if4097.solveurshape.ui.bangundatar

import android.content.Intent
import android.graphics.drawable.shapes.Shape
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.d3if4097.solveurshape.R
import org.d3if4097.solveurshape.database.data.DataBangunDatar
import org.d3if4097.solveurshape.database.db.DataDatarDB
import org.d3if4097.solveurshape.databinding.ActivityBangunDatarBinding
import org.d3if4097.solveurshape.ui.RecyclerViewClickListener
import org.d3if4097.solveurshape.ui.ShapeViewModel
import org.d3if4097.solveurshape.ui.menu.MenuActivity

@Suppress("SpellCheckingInspection")
class BangunDatarActivity : AppCompatActivity(), RecyclerViewClickListener {

    // buat binding dan viewmodel
    private lateinit var binding: ActivityBangunDatarBinding
    private lateinit var viewModel: ShapeViewModel

    // adapter
    private val bangunDatarAdapter = BangunDatarAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bangun_datar)

        viewModel =ViewModelProvider(this).get(ShapeViewModel::class.java)

        val recyclerView = binding.rvBangunDatar
        recyclerView.apply {
            this.adapter = bangunDatarAdapter
            this.layoutManager = LinearLayoutManager(this@BangunDatarActivity)
        }

        // set click listener
        bangunDatarAdapter.listener = this

        initUI()


    }

    private fun initUI() {

        viewModel.dataBangunDatar.observe({lifecycle}, {
            Log.i("testingOffline", it.toString())
            if (it.isNotEmpty()){
                Log.i("testing", "pengguna lama")
                bangunDatarAdapter.addListBangunDatar(it.sortedByDescending { dataDatarDB -> dataDatarDB.id})
            } else  {
                Log.i("testing", "pengguna baru")
                bangunDatarAdapter.addListBangunDatar(it)
            }
        })

        viewModel.response.observe({lifecycle}, {
            if (it.isNotEmpty() && it != ""){
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })

        binding.back.setOnClickListener{
            startActivity(Intent(this, MenuActivity::class.java).addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TOP
            ))
        }
    }

    override fun onItemClicked(view: View, dataBangunDatar: DataDatarDB) {

        val name = dataBangunDatar.shapeName
        val desc = dataBangunDatar.shapeDescription
        val keliling = dataBangunDatar.rumusKeliling
        val luas = dataBangunDatar.rumusLuas
        val image = dataBangunDatar.image

        Toast.makeText(this,
            "Bangun datar $name berhasil di klik",
            Toast.LENGTH_SHORT
        ).show()



        val intent = Intent(this@BangunDatarActivity, BangunDatarDetailActivity::class.java)
        intent.putExtra("Name",name)
        intent.putExtra("Desc",desc)
        intent.putExtra("Keliling",keliling)
        intent.putExtra("Luas",luas)
        intent.putExtra("Image",image)

        startActivity(intent)

    }
}
