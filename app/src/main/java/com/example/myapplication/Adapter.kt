package com.example.myapplication

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class Adapter(private val context: Context,
              private val list: ArrayList<Model>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    var movieList : List<Model> = listOf()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
      //  val iconIV: ImageView = view.findViewById(R.id.iconIV)
        val titleTV: TextView = view.findViewById(R.id.titleTV)
        val subtitleTV: TextView = view.findViewById(R.id.subtitleTV)
        val imageView: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cell_view,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }



    fun setListItems(list: List<Model>){
        this.movieList = list;
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
       // holder.iconIV.setImageDrawable(ContextCompat.getDrawable(context, data.icon))
        holder.titleTV.text = data.title
        holder.subtitleTV.text = data.subtitle
        var link = data.imageLink
        if(link != null && link !=""){
        Log.d("sibilla", "link is my link " + link);
     //   holder.imageView.setImageDrawable(ContextCompat.getDrawable(context, data.imageLink))
        Glide.with(context).load(link).centerCrop().into(holder.imageView) }
        else
        {
            holder.imageView.setImageDrawable(ContextCompat.getDrawable(context, data.icon))
        }

    }
}