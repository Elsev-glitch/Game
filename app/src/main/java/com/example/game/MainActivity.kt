package com.example.game

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel
    lateinit var recycleView: RecyclerView
    lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleView = recycle_view
        adapter = MainAdapter()
        recycleView.adapter = adapter

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getPopularGame()

        viewModel.popularGameLiveData.observe(this, Observer {
            adapter.submitList(it)
        })

    }
}