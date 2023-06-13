package org.bmsk.mediaexplorer.list

import org.bmsk.mediaexplorer.model.ListItem

interface ItemHandler {
    fun onClickFavorite(item: ListItem) {}
}