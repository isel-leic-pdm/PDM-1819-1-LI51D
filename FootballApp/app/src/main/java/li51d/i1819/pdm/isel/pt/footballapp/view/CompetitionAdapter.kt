package li51d.i1819.pdm.isel.pt.footballapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import li51d.i1819.pdm.isel.pt.footballapp.R
import li51d.i1819.pdm.isel.pt.footballapp.repository.domain.Competition

class CompetitionAdapter(owner: LifecycleOwner, private val data: LiveData<Array<Competition>>)
    : RecyclerView.Adapter<CompetitionAdapter.ItemViewHolder>() {

    private val TAG = CompetitionAdapter::class.java.simpleName

    private var itemListener: ((competition: Competition) -> Unit)? = null

    init {
        data.observe(owner, Observer {
            this.notifyDataSetChanged()
        })
    }


    class ItemViewHolder(itemView: View, private val clickListener: (position: Int) -> Unit)
        : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            clickListener(adapterPosition)
        }

        val code = itemView.findViewById<TextView>(R.id.code)
        val name = itemView.findViewById<TextView>(R.id.name)
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ItemViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)
        return ItemViewHolder(view, ::notifyListener)
    }

    private fun notifyListener(position: Int) {
        val competition: Competition = data.value!![position]
        itemListener?.invoke(competition)
    }


    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        val competition = data.value!![position]


        holder.code.text = competition.code ?: "   "
        holder.name.text = competition.name
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount(): Int = data.value?.size ?: 0



    fun setOnItemClickListener(listener: (competition: Competition) -> Unit) {
        this.itemListener = listener
    }
}