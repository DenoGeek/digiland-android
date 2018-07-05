package neverest.ke.co.digiland.fragments.dialogs

import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.loopj.android.http.JsonHttpResponseHandler
import com.loopj.android.http.RequestParams
import cz.msebera.android.httpclient.Header
import kotlinx.android.synthetic.main.offers_dialog.*
import neverest.ke.co.digiland.R
import neverest.ke.co.digiland.adapters.OffersAdapter
import neverest.ke.co.digiland.utils.NetworkClient
import org.json.JSONArray

class OffersDialog:DialogFragment(){
    private var oAdapt:OffersAdapter?=null
    private var _context:Context?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.offers_dialog, container, false)

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        _context=context
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        offers_recycler?.layoutManager= LinearLayoutManager(_context)
        oAdapt= OffersAdapter(_context!!, listOf())
        offers_recycler.adapter=oAdapt

        var client= NetworkClient()
        var params= RequestParams()
        client.get("",params,object : JsonHttpResponseHandler(){
            override fun onStart() {
                swipe_refresh?.isRefreshing=true
            }

            override fun onFinish() {
                swipe_refresh.isRefreshing=false
            }

            override fun onSuccess(statusCode: Int, headers: Array<out Header>?, response: JSONArray?) {
                super.onSuccess(statusCode, headers, response)
                //parse the offers and update the recyclerview
                //call oAdapt.update()
            }
        })
    }
    companion object {

        fun newInstance(): MakeOfferDialog {
            val frag = MakeOfferDialog()
            val args = Bundle()
            frag.arguments = args
            return frag
        }

    }
}