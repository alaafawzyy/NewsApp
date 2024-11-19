package com.example.newsxml.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.newsxml.R
import com.example.newsxml.databinding.ActivityMainBinding
import com.example.newsxml.newsSource.view.NewsSourcesFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment()
        binding.openSearch.setOnClickListener({ showSearchView(true) })
        binding.closeSearch.setOnClickListener({ showSearchView(false) })
        binding.edTv.setOnEditorActionListener({view,_,_ -> onSearchClickListener?.OnSearchClick(view.text.toString())
           true })

    }

    private fun replaceFragment() {
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container, NewsSourcesFragment()

        ).commit()
    }

    fun showSearchView(isVisable:Boolean){
                binding.openSearch.isVisible=!isVisable
                    binding.closeSearch.isVisible=isVisable
                    binding.edTv.isVisible=isVisable
                    binding.toolbarTitle.isVisible=!isVisable

            }


    private var onSearchClickListener: OnSearchClickListener?=null
    fun setOnSearchClickListener(listener: OnSearchClickListener){
      onSearchClickListener=listener
    }
    fun interface OnSearchClickListener{
        fun OnSearchClick(query: String)
    }
}