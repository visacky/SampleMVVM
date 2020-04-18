package com.example.samplemvvm.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.samplemvvm.R
import com.example.samplemvvm.viewmodel.ArticleDetailViewModel
import kotlinx.android.synthetic.main.detail_layout.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class ArticleDetailActivity : AppCompatActivity() {
    private val articleDetailViewModel: ArticleDetailViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_layout)
        setSupportActionBar(toolbar)

        articleDetailViewModel.initAPIService(intent.getStringExtra("detailName"))

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        initProgressbar()

        save.setOnClickListener { finish() }
    }

    private fun initProgressbar() {
        articleDetailViewModel.isLoadingLiveData.observe(this, Observer {
            description.setText(articleDetailViewModel.articleDetail.text)
            supportActionBar?.title = articleDetailViewModel.articleDetail.title
            description.isEnabled = false


            Glide.with(this)
                .load(articleDetailViewModel.articleDetail.image)
                .apply(RequestOptions.circleCropTransform())
                .into(image)
        })
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {
                description.isEnabled = true
                save.visibility = View.VISIBLE
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}