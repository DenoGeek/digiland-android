package neverest.ke.co.digiland.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import neverest.ke.co.digiland.R
import neverest.ke.co.digiland.models.Listing
import neverest.ke.co.digiland.models.Offer
import neverest.ke.co.digiland.widget.FontTextView

class ListingsAdapter(private val context: Context, private var mDataset: Array<Listing>) : RecyclerView.Adapter<ListingsAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return mDataset.size
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var listing_id: FontTextView? = null
        var price: FontTextView? = null
        var description: FontTextView? = null
        var state: FontTextView? = null

        init {
            listing_id = v.findViewById(R.id.listing_id)
            price = v.findViewById(R.id.price)
            description = v.findViewById(R.id.description)
            state = v.findViewById(R.id.state)
        }
    }

    fun updateData(myDataset: Array<Listing>) {
        mDataset = myDataset
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingsAdapter.ViewHolder {
        val rowView = LayoutInflater.from(parent.context).inflate(R.layout.listings_row, parent, false)
        return ViewHolder(rowView)
    }

    fun getData():Array<Listing>{
        return mDataset
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var listing= mDataset[position]
        holder.listing_id?.text=listing.listingId
        holder.price?.text=listing.reservePrice
        holder.description?.text=listing.description
        holder.state?.text=listing.state



    }
}