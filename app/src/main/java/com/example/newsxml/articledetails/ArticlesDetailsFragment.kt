package com.example.newsxml.articledetails

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.newsappxml.model.newsResponce.Article
import com.example.newsxml.databinding.FragmentArticleDetailsBinding

class ArticlesDetailsFragment:Fragment() {
    lateinit var binding:FragmentArticleDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentArticleDetailsBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {it->
            getParcelaple(it)?.let { it1 -> bindArgument(it1) }
        }
    }
    fun bindArgument(article: Article){
        binding.author.text=article.author
        binding.date.text=article.publishedAt
        binding.title.text=article.title
        binding.articleBody.text=article.content
        Glide.with(binding.root).load(article.urlToImage).into(binding.img)


    }

   fun  getParcelaple(arguments:Bundle): Article? {
       return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
           arguments?.getParcelable("passedArticle", Article::class.java)
       }
       else {
           arguments?.getParcelable("passedArticle")
       }

   }
}