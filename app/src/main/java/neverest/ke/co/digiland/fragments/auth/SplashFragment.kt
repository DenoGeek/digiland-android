package neverest.ke.co.digiland.fragments.auth

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import neverest.ke.co.digiland.R

class SplashFragment: Fragment() {

    private var _splash_interface:SplashInterface?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.auth_splash_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            _splash_interface = activity as SplashInterface
        } catch (e: ClassCastException) {
            throw ClassCastException("Activity " + activity.toString() + " must implement SplashInterface")
        }

    }

    interface SplashInterface{
        public fun changePage(page:Int)
    }
}