package neverest.ke.co.digiland

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import com.loopj.android.http.JsonHttpResponseHandler
import com.loopj.android.http.RequestParams
import cz.msebera.android.httpclient.Header
import kotlinx.android.synthetic.main.activity_listings.*
import neverest.ke.co.digiland.adapters.ListingsAdapter
import neverest.ke.co.digiland.fragments.dialogs.OffersDialog
import neverest.ke.co.digiland.utils.NetworkClient
import org.json.JSONArray

class ListingsActivity : AppCompatActivity() {

    private var lAdapt:ListingsAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listings)

        listings_recycler?.layoutManager=LinearLayoutManager(applicationContext)
        lAdapt= ListingsAdapter(applicationContext, listOf())
        listings_recycler.adapter=lAdapt

        var client=NetworkClient()
        var params=RequestParams()
        client.get("",params,object :JsonHttpResponseHandler(){
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
        }else super.onOptionsItemSelected(item)
    }


}
