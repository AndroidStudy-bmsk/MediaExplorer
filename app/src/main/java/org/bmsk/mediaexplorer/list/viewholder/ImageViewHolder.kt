package org.bmsk.mediaexplorer.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import org.bmsk.mediaexplorer.databinding.ItemImageBinding
import org.bmsk.mediaexplorer.model.ImageItem
import org.bmsk.mediaexplorer.model.ListItem

class ImageViewHolder(
    private val binding: ItemImageBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ListItem) {
        item as ImageItem
        binding.item = item
    }
}