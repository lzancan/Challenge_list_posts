package life.league.challenge.kotlin.presentation.view

import androidx.recyclerview.widget.RecyclerView
import life.league.challenge.kotlin.databinding.PostLayoutBinding
import life.league.challenge.kotlin.domain.model.PostModel

class PostViewHolder(
    private val itemViewBinding: PostLayoutBinding,
) : RecyclerView.ViewHolder(itemViewBinding.root) {

    fun bind(post: PostModel) {
        itemViewBinding.post = post
    }
}