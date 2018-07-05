package neverest.ke.co.digiland.fragments.dialogs

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import neverest.ke.co.digiland.R

class AcceptDealDialog: DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.accept_deal_dialog, container, false)

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