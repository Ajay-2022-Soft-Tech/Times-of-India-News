package com.example.newsapplication

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

    lateinit var myListener : MyAdapter.onItemClickListener
class MyAdapter(var newsArrayList: ArrayList<News> ,var context : Activity) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    interface onItemClickListener{
        fun onItemClicking(position: Int)
    }
        fun setOnItemClickListener(listener: onItemClickListener){
        myListener = listener
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.eachitem,parent,false)
        return MyViewHolder(itemView, myListener)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem = newsArrayList[position]
        holder.headingTitle.text = currentItem.newsHeading
        holder.headingImage.setImageResource(currentItem.newsImage)
    }

    override fun getItemCount(): Int {
        return newsArrayList.size
    }


    class MyViewHolder (itemView: View , listener: onItemClickListener):RecyclerView.ViewHolder(itemView){

        val headingTitle= itemView.findViewById<TextView>(R.id.newsHeading)
        val headingImage = itemView.findViewById<ShapeableImageView>(R.id.newsImage)


        init {

            itemView.setOnClickListener {
                listener.onItemClicking(adapterPosition)
            }
        }
    }


}