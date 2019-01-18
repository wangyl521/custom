package com.innsmap.wyl.customviewproject

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.innsmap.wyl.customviewproject.adapter.MyAdapter
import kotlinx.android.synthetic.main.home_layout.*

class HomeActivity : AppCompatActivity() {
    private val string = arrayOf("viewpager+头部导航","可點擊的Toast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_layout)
        init()
    }

    fun init() {
        val adapter = MyAdapter(this, string)
        gridview.adapter = adapter
        gridview.setOnItemClickListener { parent, view, position, id -> when (position){
            0-> startActivity(Intent(this, ViewPagerActivity::class.java))
            1->ClickToast.showToast(this, Toast.LENGTH_LONG)
        } }
    }

}