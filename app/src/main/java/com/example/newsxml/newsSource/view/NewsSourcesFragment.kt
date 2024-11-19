package com.example.newsxml.newsSource.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.newsappxml.model.newsResponce.Article
import com.example.newsappxml.model.sourceResponnce.Source
import com.example.newsxml.articledetails.ArticlesDetailsFragment
import com.example.newsxml.main.MainActivity
import com.example.newsxml.newsSource.adapter.NewsAdapter
import com.example.newsxml.R
import com.example.newsxml.databinding.FragmentNewsSourcesBinding
import com.example.newsxml.newsSource.viewmodel.SourceViewModel
import com.example.newsxml.newsSource.viewmodel.ViewMessage
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NewsSourcesFragment : Fragment() {
    lateinit var binding: FragmentNewsSourcesBinding
    private val viewModel by viewModels<SourceViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsSourcesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeLiveData()
    }


    private fun observeLiveData() {
        viewModel.isLoadingLivedata.observe(viewLifecycleOwner){
            changeLoadingVisibility(it)
        }
        viewModel.sourceLiveData.observe(viewLifecycleOwner){
            showNewsSources(it)
        }
        viewModel.newsLiveData.observe(viewLifecycleOwner){
            showNews(it)
        }

    }

    private fun initView() {
        (activity as MainActivity).binding.openSearch.isVisible=true
          binding.newsRecycle.adapter = adapter
          viewModel.getNewsSources()
          adapter.setOnArticleListener({article->
            NavigateToArticaleDetails(article)
          })
    }

    private fun NavigateToArticaleDetails(article: Article) {
        val arguments=Bundle()
        arguments.putParcelable("passedArticle",article)
        val articlesDetailsFragment= ArticlesDetailsFragment()
        articlesDetailsFragment.arguments=arguments

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,articlesDetailsFragment)
            .addToBackStack("")
            .commit()
    }

    private fun showNewsSources(sources: List<Source?>?) {
        sources?.forEach {source ->
            var tab=binding.tabLayout.newTab()
            tab.text=source?.name
            tab.tag=source
            binding.tabLayout.addTab(tab) }

        binding.tabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            @SuppressLint("ResourceAsColor")
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val source = tab?.tag as Source
                changeSource(source)
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
            override fun onTabReselected(tab: TabLayout.Tab?) {
                val source = tab?.tag as Source
                changeSource(source) }

        })
        binding.tabLayout.getTabAt(0)?.select()

    }



    var source: Source? = null
    private fun changeSource(source: Source) {
       this.source = source
     viewModel.loadNews(source.id.toString())
    }

    val adapter = NewsAdapter(null)
    private fun showNews(articles: List<Article?>?) {
            adapter.changeData(articles)
        binding.progressBar.isVisible=false

    }
    private fun showError(message: ViewMessage) {
        binding.errorView.isVisible=true
        binding.errorMessage.text=message.message
        binding.tryAgin.text=message.posActionName
        binding.tryAgin.setOnClickListener({
            message.posAction?.invoke()
        })
    }
    private fun changeLoadingVisibility(isvisible: Boolean) {
       binding.progressBar.isVisible = isvisible

    }
}
