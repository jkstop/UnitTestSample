package fm.finch.unitsample

interface MainView {
    fun setLoading(loading: Boolean)
    fun setNewsItems(items: List<NewsViewData>)
}