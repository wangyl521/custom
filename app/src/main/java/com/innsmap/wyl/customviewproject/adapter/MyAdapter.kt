package com.innsmap.wyl.customviewproject.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.innsmap.wyl.customviewproject.R


class MyAdapter(private val context: Context, private val moduls: Array<String>) : BaseAdapter() {
    override fun getCount(): Int {
        return moduls.size
    }

    override fun getItem(position: Int): Any {
        return moduls[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        var viewHolder:ViewHolder?=null
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_layout, null)
            viewHolder = ViewHolder()
            viewHolder!!.tv = convertView!!.findViewById(R.id.tv)
            convertView!!.setTag(viewHolder)
        }else{
            viewHolder = convertView!!.getTag() as ViewHolder
        }

        viewHolder.tv!!.text = moduls[position]
        return convertView
    }
    inner class ViewHolder{
        var tv: TextView? = null
    }
}
