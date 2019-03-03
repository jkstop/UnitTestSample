package fm.finch.unitsample

import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class NewsInteractor {

    suspend fun getNews(): List<News> {
        return suspendCoroutine {
            val fakeNews = listOf(
                News("Super News. Some description and bla bla bla", System.currentTimeMillis()),
                News("WOW. Some description and bla bla bla", System.currentTimeMillis()),
                News("Who is batman?. Some description and bla bla bla", System.currentTimeMillis()),
                News("Today news. Some description and bla bla bla", System.currentTimeMillis()),
                News("Just for fun. Some description and bla bla bla", System.currentTimeMillis()),
                News("Hey. Some description and bla bla bla", System.currentTimeMillis()),
                News("Listen. Some description and bla bla bla", System.currentTimeMillis())
            )

            it.resume(fakeNews)
        }
    }
}