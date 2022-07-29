package com.nalenyi.myposts

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nalenyi.myposts.databinding.PostListItemBinding

class PostRvAdapter(var context:Context, var postList: List<Post>): RecyclerView.Adapter<RetrofitViewHolder>() {



    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var currentItem = postList.get(position)
        with(holder.bindingView) {
            tvId.text= currentItem.id.toString()
            tvUserId.text = currentItem.userId.toString()
            tvTitle.text= currentItem.title
            tvBody.text = currentItem.body

        }

    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var binding =PostListItemBinding .inflate(LayoutInflater.from(context), parent, false)
        return RetrofitViewHolder(binding)
    }
}

class RetrofitViewHolder(var bindingView: PostListItemBinding) :
    RecyclerView.ViewHolder(bindingView.root)