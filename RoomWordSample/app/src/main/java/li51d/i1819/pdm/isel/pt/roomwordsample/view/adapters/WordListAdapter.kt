package li51d.i1819.pdm.isel.pt.roomwordsample.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import li51d.i1819.pdm.isel.pt.roomwordsample.R
import li51d.i1819.pdm.isel.pt.roomwordsample.repository.dataAccess.database.Word


class WordListAdapter constructor(owner: LifecycleOwner, val words: LiveData<List<Word>>) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    inner class WordViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItemView: TextView

        init {
            wordItemView = itemView.findViewById(R.id.textView)
        }
    }

    init {
        words.observe(owner, Observer {
            this.notifyDataSetChanged()
        })
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = words.value!![position]
        holder.wordItemView.text = current.word
    }


    // getItemCount() is called many times, and when it is first called,
    // words has not been updated (means initially, it's null, and we can't return null).
    override fun getItemCount(): Int {
        return words.value?.size ?: 0
    }
}