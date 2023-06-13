package org.bmsk.mediaexplorer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import org.bmsk.mediaexplorer.databinding.FragmentFavoritesBinding
import org.bmsk.mediaexplorer.list.ListAdapter

class FavoritesFragment : Fragment() {
    private var binding: FragmentFavoritesBinding? = null
    private val adapter by lazy { ListAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentFavoritesBinding.inflate(inflater, container, false).apply {
            binding = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            recyclerView.adapter = adapter
        }
    }

    override fun onResume() {
        super.onResume()
        binding?.apply {
            if (Common.favoriteList.isEmpty()) {
                emptyTextView.isVisible = true
                recyclerView.isVisible = false
            } else {
                emptyTextView.isVisible = false
                recyclerView.isVisible = true
            }
        }
        adapter.submitList(Common.favoriteList.sortedBy { it.dateTime })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}