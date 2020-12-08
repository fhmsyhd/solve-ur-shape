package org.d3if4097.solveurshape.ui.bangundatar

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.d3if4097.solveurshape.R
import org.d3if4097.solveurshape.database.db.DataDatarDB
import org.d3if4097.solveurshape.databinding.ItemBangunDatarBinding
import org.d3if4097.solveurshape.ui.RecyclerViewClickListener
import java.util.*

@Suppress("SpellCheckingInspection")
class BangunDatarAdapter : RecyclerView.Adapter<BangunDatarAdapter.BangunDatarViewHolder>(), Filterable {

    var listener: RecyclerViewClickListener? = null

    private var listBangunDatar : MutableList<DataDatarDB> = mutableListOf<DataDatarDB>()

    private var currentList : MutableList<DataDatarDB> = mutableListOf<DataDatarDB>()

    inner class BangunDatarViewHolder(
        val itemBangunDatarBinding: ItemBangunDatarBinding
    ) : RecyclerView.ViewHolder(itemBangunDatarBinding.root)

    override fun getItemCount() =currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= BangunDatarViewHolder (
        DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item_bangun_datar, parent, false)
    )

    override fun onBindViewHolder(holder: BangunDatarViewHolder, position: Int) {
        holder.itemBangunDatarBinding.tvItemName.text = currentList[position].shapeName
        holder.itemBangunDatarBinding.tvItemDetail.text = currentList[position].shapeDescription

        Glide.with(holder.itemView.context)
            .load(currentList[position].image)
            .apply(RequestOptions().override(55, 55))
            .into(holder.itemBangunDatarBinding.imgItemPhoto)

        holder.itemBangunDatarBinding.listItem.setOnClickListener{
            listener?.onItemClicked(it, currentList[position])
        }
    }

    fun addListBangunDatar(bangunDatar : List<DataDatarDB>){
        listBangunDatar = bangunDatar as MutableList<DataDatarDB>

        currentList = listBangunDatar
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {

                val cari = constraint.toString()

                cari?.let {
                    val resultList = mutableListOf<DataDatarDB>()
                    for (row in listBangunDatar) {
                        if (row.shapeName.toLowerCase(Locale.ROOT).contains(cari.toLowerCase(Locale.ROOT))){
                            resultList.add(row)
                        }
                    }

                    currentList = resultList
                } ?: run { // jika variabel cari = null
                    currentList = listBangunDatar
                }

                val filterResult = FilterResults()
                filterResult.values = currentList

                return filterResult
            }

            @Suppress("SpellCheckingInspection", "UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                currentList = results?.values as MutableList<DataDatarDB>
                notifyDataSetChanged()
            }


        }
    }
}