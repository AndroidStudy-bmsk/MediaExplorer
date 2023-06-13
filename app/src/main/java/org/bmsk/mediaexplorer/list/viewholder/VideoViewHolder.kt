package org.bmsk.mediaexplorer.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import org.bmsk.mediaexplorer.databinding.ItemVideoBinding
import org.bmsk.mediaexplorer.model.ListItem
import org.bmsk.mediaexplorer.model.VideoItem

class VideoViewHolder(
    private val binding: ItemVideoBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ListItem) {
        item as VideoItem
        binding.item = item
    }
}