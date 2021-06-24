package com.qualitestudios.qualitehttp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.qualitestudios.qualitehttp.R
import com.qualitestudios.qualitehttp.data.remote.postData

class RecyclerView(


    private val dataList:List<postData>,

    ):RecyclerView.Adapter<com.qualitestudios.qualitehttp.ui.RecyclerView.itemViewHolder> (){





        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
            val itemView=
                LayoutInflater.from(parent.context).inflate(R.layout.each_data,parent,false)
            return itemViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
            val currentItem=dataList[position]
            holder.holderdate.text=currentItem.title
            holder.holdermessage.text=currentItem.body
        }

        override fun getItemCount(): Int {
            return dataList.size
        }

        inner class itemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener
        {
            var holderdate:TextView=itemView.findViewById(R.id.tv_title)
            var holdermessage: TextView =itemView.findViewById(R.id.tv_message)
            init{
                itemView.setOnClickListener(this)

            }

            override fun onClick(v: View?) {
                val position=adapterPosition
                if(position!= RecyclerView.NO_POSITION)
                {

                }


            }

        }

    }