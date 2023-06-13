package org.bmsk.mediaexplorer.repository

import io.reactivex.rxjava3.core.Observable
import org.bmsk.mediaexplorer.model.ListItem

interface SearchRepository {
    fun search(query: String): Observable<List<ListItem>>
}