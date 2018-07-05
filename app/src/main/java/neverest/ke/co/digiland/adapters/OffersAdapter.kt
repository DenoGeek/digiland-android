package neverest.ke.co.digiland.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import neverest.ke.co.digiland.models.Offer
import android.content.Context
import android.view.View
import neverest.ke.co.digiland.R;

class OffersAdapter(private val context: Context, private var mDataset: List<Offer>) : RecyclerView.Adapter<OffersAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return mDataset.size
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
//        var date_generated: FontTextView? = null

        init {
//            date_generated = v.findViewById(R.id.date_generated)
        }
    }

    fun updateData(myDataset: List<Offer>) {
        mDataset = myDataset
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OffersAdapter.ViewHolder {
        val rowView = LayoutInflater.from(parent.context).inflate(R.layout.offers_row, parent, false)
        return ViewHolder(rowView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


    }
}