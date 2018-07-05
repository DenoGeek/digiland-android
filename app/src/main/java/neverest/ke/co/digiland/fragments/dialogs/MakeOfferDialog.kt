package neverest.ke.co.digiland.fragments.dialogs

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.loopj.android.http.JsonHttpResponseHandler
import com.loopj.android.http.RequestParams
import kotlinx.android.synthetic.main.make_offer_dialog.*
import neverest.ke.co.digiland.R
import neverest.ke.co.digiland.utils.NetworkClient

class MakeOfferDialog: DialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.make_offer_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        place_offer?.setOnClickListener{
            var offer=offer_value.text.toString()
            var client=NetworkClient()
            var params=RequestParams()
            client.post("",params,object :JsonHttpResponseHandler(){
                override fun onStart() {
                    pr?.visibility=View.VISIBLE
                }

                override fun onFinish() {
                    pr?.visibility=View.GONE
                }
            })

        }
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