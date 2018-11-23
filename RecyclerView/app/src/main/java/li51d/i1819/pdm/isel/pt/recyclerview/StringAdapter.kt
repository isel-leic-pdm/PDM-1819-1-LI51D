package li51d.i1819.pdm.isel.pt.recyclerview

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class StringAdapter(private val data: Array<String>)
    : RecyclerView.Adapter<StringAdapter.ItemViewHolder>() {

    private val TAG = StringAdapter::class.java.simpleName

    private var countViewHolderIntances = 0
    private var countBindViewHolder = 0

    class ItemViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {
        val cityNameSize = itemView.findViewById<TextView>(R.id.cityNameSize)
        val cityName = itemView.findViewById<TextView>(R.id.cityName)

    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ItemViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.competition_view_item, parent, false)


        val textViewHolder = ItemViewHolder(view)
        Log.i(TAG,"ViewHolder created: ${++countViewHolderIntances} with hashcode ${textViewHolder.hashCode()} for type $viewType")
        return textViewHolder
    }


    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        Log.i(TAG,"onBindViewHolder called for position $position: ${++countBindViewHolder} with viewHolder ${holder.hashCode()}")
        val str = data[position]


        if(str.startsWith("B")) {
                holder.cityName.setTextColor(Color.RED)
        }
        holder.cityNameSize.text = str.length.toString()
        holder.cityName.text = str
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount(): Int = data.size
}