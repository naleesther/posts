package com.nalenyi.myposts

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nalenyi.myposts.databinding.CommentListItemBinding
import com.nalenyi.myposts.databinding.PostListItemBinding

class CommentAdapter (var commentList: List<Comment>):RecyclerView.Adapter<CommentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var binding = CommentListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CommentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentComment=commentList.get(position)

        holder.bindingView.tvid.text= currentComment.id.toString()
        holder.bindingView.tvemail.text= currentComment.email
        holder.bindingView.tvname.text= currentComment.name
        holder.bindingView.tvpostid.text= currentComment.postId.toString()
        holder.bindingView.tvbody.text= currentComment.body

        val context=holder.itemView.context
        holder.bindingView.cvComments.setOnClickListener {
            val intent = Intent(context,CommentActivity::class.java)
            intent.putExtra("POST_ID",currentComment.id)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
      return commentList.size
    }

}
class CommentsViewHolder(var bindingView:CommentListItemBinding):
    RecyclerView.ViewHolder(bindingView.root)
