package fm.finch.unitsample

import com.nhaarman.mockitokotlin2.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Test

class MainPresenterTest {

    private val view: MainView = mock()
    private val mapper: NewsMapper = mock()
    private val interactor: NewsInteractor = mock()

    private val presenter = MainPresenter(view, interactor, mapper).apply {
        scope = CoroutineScope(Dispatchers.Unconfined)
    }

    @Test
    fun onCreated() = runBlocking {
        whenever(interactor.getNews()).doReturn(emptyList())
        whenever(mapper.mapToNewsViewData(emptyList())).doReturn(emptyList())
        presenter.onCreated()

        verify(view, times(1)).setLoading(true)
        verify(interactor).getNews()
        verify(mapper).mapToNewsViewData(emptyList())
        verify(view).setLoading(false)
        verify(view).setNewsItems(emptyList())
    }
}