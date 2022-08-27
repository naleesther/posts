package com.nalenyi.myposts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nalenyi.myposts.databinding.PostListItemBinding

class PostRvAdapter(var postList: List<Post>):
    RecyclerView.Adapter<RetrofitViewHolder>() {

    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var currentItem = postList.get(position)

            holder.bindingView.tvId.text= currentItem.id.toString()
            holder.bindingView.tvUserId.text = currentItem.userId.toString()
            holder.bindingView.tvTitle.text= currentItem.title
            holder.bindingView.tvBody.text = currentItem.body
            val context=holder.itemView.context
            holder.bindingView.cvPosts.setOnClickListener {
                val intent = Intent(context,CommentActivity::class.java)
                intent.putExtra("POST_ID",currentItem.id)
                context.startActivity(intent)
            }
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var binding =PostListItemBinding .inflate(LayoutInflater.from(parent.context), parent, false)
        return RetrofitViewHolder(binding)
    }
}

class RetrofitViewHolder(var bindingView: PostListItemBinding) :
    RecyclerView.ViewHolder(bindingView.root)