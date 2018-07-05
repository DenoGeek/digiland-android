package neverest.ke.co.digiland.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import neverest.ke.co.digiland.R
import neverest.ke.co.digiland.models.Listing
import neverest.ke.co.digiland.models.Offer

class ListingsAdapter(private val context: Context, private var mDataset: List<Listing>) : RecyclerView.Adapter<ListingsAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return mDataset.size
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
//        var date_generated: FontTextView? = null

        init {
//            date_generated = v.findViewById(R.id.date_generated)
        }
    }

    fun updateData(myDataset: List<Listing>) {
        mDataset = myDataset
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingsAdapter.ViewHolder {
        val rowView = LayoutInflater.from(parent.context).inflate(R.layout.listings_row, parent, false)
        return ViewHolder(rowView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }
}