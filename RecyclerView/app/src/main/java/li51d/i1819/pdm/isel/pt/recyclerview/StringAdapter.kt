package li51d.i1819.pdm.isel.pt.recyclerview

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ViewGroup
import android.widget.TextView

class StringAdapter(private val data: Array<String>)
    : RecyclerView.Adapter<StringAdapter.TextViewHolder>() {

    private val TAG = StringAdapter::class.java.simpleName

    private var countViewHolderIntances = 0
    private var countBindViewHolder = 0

    class TextViewHolder(val textView: TextView)
        : RecyclerView.ViewHolder(textView)

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : TextViewHolder {
        // create a new view
        val textView = TextView(parent.context);
        textView.textSize = 30.0F
//            LayoutInflater.from(parent.context)
//            .inflate(R.layout.my_text_view, parent, false) as TextView
//      set the view's size, margins, paddings and layout parameters

        val textViewHolder = TextViewHolder(textView)
        Log.i(TAG,"ViewHolder created: ${++countViewHolderIntances} with hashcode ${textViewHolder.hashCode()} for type $viewType")
        return textViewHolder
    }


    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        Log.i(TAG,"onBindViewHolder called for position $position: ${++countBindViewHolder} with viewHolder ${holder.hashCode()}")
        holder.textView.text = data[position]
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount(): Int = data.size
}