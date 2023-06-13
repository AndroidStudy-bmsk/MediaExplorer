package org.bmsk.mediaexplorer

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import io.reactivex.rxjava3.core.Observable
import org.bmsk.mediaexplorer.model.ImageItem
import org.bmsk.mediaexplorer.model.ListItem
import org.bmsk.mediaexplorer.model.VideoItem
import org.bmsk.mediaexplorer.repository.SearchRepository
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import java.util.Date

@RunWith(MockitoJUnitRunner::class)
class SearchViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var searchRepository: SearchRepository

    @Mock
    lateinit var mockLoadingObserve: Observer<Boolean>

    @Mock
    lateinit var mockListObserver: Observer<List<ListItem>>

    private lateinit var viewModel: SearchViewModel

    @Before
    fun setup() {
        viewModel = SearchViewModel(searchRepository)
        viewModel.showLoading.observeForever(mockLoadingObserve)
        viewModel.listLiveData.observeForever(mockListObserver)
    }

    @Test
    fun searchNotEmpty() {
        Mockito.`when`(searchRepository.search(Mockito.anyString())).thenReturn(Observable.just(mockList()))
        viewModel.search("query")

        Mockito.verify(mockLoadingObserve, Mockito.times(1)).onChanged(true)
        Mockito.verify(mockListObserver, Mockito.times(1)).onChanged(Mockito.anyList())
        assertTrue(!viewModel.listLiveData.value.isNullOrEmpty())
    }

    @Test
    fun searchEmpty() {
        Mockito.`when`(searchRepository.search(Mockito.anyString())).thenReturn(Observable.just(
            emptyList()
        ))
        viewModel.search("query")

        Mockito.verify(mockLoadingObserve, Mockito.times(1)).onChanged(true)
        Mockito.verify(mockListObserver, Mockito.times(1)).onChanged(Mockito.anyList())
        assertTrue(viewModel.listLiveData.value.isNullOrEmpty())
    }

    private fun mockList() = listOf(
        ImageItem("thumbnailUrl", "collection", "siteName", "docUrl", Date(), false),
        ImageItem("thumbnailUrl1", "collection1", "siteName", "docUrl", Date(), false),
        VideoItem("thumbnailUrl2", "title", 3, "author", Date(), false),
    )
}