package fm.finch.unitsample

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainPresenter(
    private val view: MainView,
    private val interactor: NewsInteractor,
    private val mapper: NewsMapper
) {

    var scope = CoroutineScope(Dispatchers.Main)

    fun onCreated() {
        view.setLoading(true)

        scope.launch {
            val news = interactor.getNews()
            val newsData = mapper.mapToNewsViewData(news)
            view.setLoading(false)
            view.setNewsItems(newsData)
        }
    }

    fun onNewsItemClicked(id: String) {

    }
}