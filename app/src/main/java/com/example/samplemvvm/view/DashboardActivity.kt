package com.example.samplemvvm.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samplemvvm.R
import com.example.samplemvvm.adapter.ItemAdapter
import com.example.samplemvvm.viewmodel.DashboardViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardActivity : AppCompatActivity() {

    private val dashboardViewModel: DashboardViewModel by viewModel()
    private var isLoading: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initProgressbar()
    }

    private fun initProgressbar() {
        dashboardViewModel.isLoadingLiveData.observe(this, Observer {
            isLoading = it
            if (isLoading) {
                progressBar.visibility = View.VISIBLE
            } else {
                progressBar.visibility = View.GONE
                prepareRecyclerView()
            }
        })
    }

    private fun prepareRecyclerView() {
        // Creates a vertical Layout Manager
        recyclerView_dataList.layoutManager = LinearLayoutManager(this)

        // Access the RecyclerView Adapter and load the data into it
        recyclerView_dataList.adapter = ItemAdapter(dashboardViewModel.articleList, this)
    }
}
