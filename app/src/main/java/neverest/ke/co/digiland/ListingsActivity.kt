package neverest.ke.co.digiland

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import com.loopj.android.http.RequestParams
import cz.msebera.android.httpclient.Header
import kotlinx.android.synthetic.main.activity_listings.*
import neverest.ke.co.digiland.adapters.ListingsAdapter
import neverest.ke.co.digiland.fragments.dialogs.MakeOfferDialog
import neverest.ke.co.digiland.fragments.dialogs.OffersDialog
import neverest.ke.co.digiland.models.Listing
import neverest.ke.co.digiland.utils.NetworkClient
import neverest.ke.co.digiland.utils.RecyclerItemClickListener
import org.json.JSONArray
import org.json.JSONObject
import java.net.URLEncoder

class ListingsActivity : AppCompatActivity() {

    private var lAdapt:ListingsAdapter?=null

    private var lr:String?=null

    private var listing:Listing?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listings)
        if (supportActionBar != null){
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }

        swipe_refresh.setOnRefreshListener { loadListings() }

        lr=intent.extras.getString("lr")

        listings_recycler?.layoutManager=LinearLayoutManager(applicationContext)
        lAdapt= ListingsAdapter(applicationContext, arrayOf())
        listings_recycler.adapter=lAdapt

        listings_recycler.addOnItemTouchListener(
                 RecyclerItemClickListener(
                         applicationContext,
                         listings_recycler ,object :RecyclerItemClickListener.OnItemClickListener{
                             override fun onLongItemClick(view: View?, position: Int) {
                             }

                             override fun onItemClick(view: View?, position: Int) {
                                 listing=lAdapt!!.getData()[position]
                             }

                 })
        )

       loadListings()

        make_offer_buttom.setOnClickListener{
            val mpesa_dialog = MakeOfferDialog.newInstance()
            mpesa_dialog.show(supportFragmentManager,"Offers placed By Members")
        }

    }

    fun loadListings(){
        var client=NetworkClient()
        var params=RequestParams()
        var quer="{\"land\":\"com.digiland.org.Land#$lr\"}"
        params.put("filter",quer)
        client.get("LandListing",params,object :JsonHttpResponseHandler(){
            override fun onStart() {
                swipe_refresh?.isRefreshing=true
            }

            override fun onFinish() {
                swipe_refresh.isRefreshing=false
            }

            override fun onSuccess(statusCode: Int, headers: Array<out Header>?, response: JSONArray?) {
                super.onSuccess(statusCode, headers, response)
                //parse the listings and update the recyclerview
                //call lAdapt.update()
                var listings=Gson().fromJson(response.toString(),Array<Listing>::class.java)
                lAdapt?.updateData(listings)
            }

            override fun onFailure(statusCode: Int, headers: Array<out Header>?, throwable: Throwable?, errorResponse: JSONObject?) {
                super.onFailure(statusCode, headers, throwable, errorResponse)
                Log.e("Error",errorResponse.toString())

            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.listing, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return if (id == R.id.action_offers) {
            val mpesa_dialog = OffersDialog.newInstance()
            mpesa_dialog.show(supportFragmentManager,"Offers placed By Members")

            true
        }else if (id == android.R.id.home) {
            finish()
            true
        }else super.onOptionsItemSelected(item)
    }



}
