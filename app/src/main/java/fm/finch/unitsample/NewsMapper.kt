package fm.finch.unitsample

import java.text.SimpleDateFormat
import java.util.*

class NewsMapper {

    fun mapToNewsViewData(news: List<News>): List<NewsViewData> {
        return mutableListOf<NewsViewData>().apply{
            news.forEach {
                val textSplits = it.text.split("\\.".toRegex())
                val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale("ru"))
                add(
                    NewsViewData(
                        id = it.date.toString(),
                        title = textSplits[0],
                        description = textSplits[1].trim(),
                        date = dateFormat.format(it.date)
                    )
                )
            }
        }
    }
}