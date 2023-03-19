package com.dicoding.mbtiapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.jar.Attributes

class ListMbtiAdapter(private val listMbti: ArrayList<Mbti>) : RecyclerView.Adapter<ListMbtiAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_personalities, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        //val (name, type, generaldesc, description, photo) = listMbti[position]
        holder.tvName.text = "${listMbti[position].name}"
        holder.tvType.text = "${listMbti[position].type}"
        //holder.tvDescription.text = "${listMbti[position].description}"
        holder.tvGeneralDesc.text = "${listMbti[position].generaldesc}"
        holder.imgPhoto.setImageResource(listMbti[position].photo)

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_mbti", listMbti[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = listMbti.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvType: TextView = itemView.findViewById(R.id.tv_item_type)
        //val tvDescription: TextView = itemView.findViewById(R.id.tv_item_desc)
        val tvGeneralDesc: TextView = itemView.findViewById(R.id.tv_item_generaldesc)
    }
}