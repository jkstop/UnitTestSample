package fm.finch.unitsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_news.view.*

class MainActivity : AppCompatActivity(), MainView {

    private val presenter = MainPresenter(this, NewsInteractor(), NewsMapper())

    private val newsAdapter = NewsAdapter { id ->
        presenter.onNewsItemClicked(id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vNewsList.adapter = newsAdapter

        presenter.onCreated()
    }

    override fun setNewsItems(items: List<NewsViewData>) {
        newsAdapter.update(items)
    }

    override fun setLoading(loading: Boolean) {
        vProgress.visibility = if (loading) VISIBLE else GONE
    }

    inner class NewsAdapter(
        private val onItemClick: (id: String) -> Unit
    ) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

        private val items = mutableListOf<NewsViewData>()

        fun update(newItems: List<NewsViewData>) {
            items.clear()
            items.addAll(newItems)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
            return NewsViewHolder(parent, onItemClick)
        }

        override fun getItemCount(): Int {
            return items.size
        }

        override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
            holder.bind(items[position])
        }

        inner class NewsViewHolder(
            parent: ViewGroup,
            private val onItemClick: (id: String) -> Unit
        ) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_news, parent, false)) {

            fun bind(data: NewsViewData) = itemView.run {
                vNewsTitle.text = data.title
                vNewsDescription.text = data.description
                vNewsDate.text = data.date
                setOnClickListener { onItemClick.invoke(data.id) }
            }
        }

    }
}
