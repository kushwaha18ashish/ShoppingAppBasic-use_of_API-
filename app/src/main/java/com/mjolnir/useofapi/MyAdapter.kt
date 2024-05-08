package com.mjolnir.useofapi

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(val context:Activity,val productArraylist:List<Product>):
RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
         var title:TextView
         var image:ShapeableImageView
         var rating:TextView

         init {
             title=itemView.findViewById(R.id.tvHeading)
             image=itemView.findViewById(R.id.ivHeadingImage)
             rating=itemView.findViewById(R.id.tvRating)
         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(context).inflate(R.layout.each_row,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productArraylist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=productArraylist[position]
        holder.title.text=currentItem.title
        Picasso.get().load(currentItem.thumbnail).into(holder.image)
        holder.rating.text=currentItem.rating.toString()
    }
}