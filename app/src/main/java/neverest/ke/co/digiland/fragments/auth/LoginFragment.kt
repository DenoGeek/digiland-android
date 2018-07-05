package neverest.ke.co.digiland.fragments.auth

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import com.loopj.android.http.RequestParams
import cz.msebera.android.httpclient.Header
import kotlinx.android.synthetic.main.auth_login_fragment.*
import neverest.ke.co.digiland.R
import neverest.ke.co.digiland.utils.CoreUtils
import neverest.ke.co.digiland.utils.NetworkClient
import org.json.JSONObject


class LoginFragment:Fragment(){

    private var _login_interface:LoginInterface?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.auth_login_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        try {
            _login_interface = activity as LoginInterface
        } catch (e: ClassCastException) {
            throw ClassCastException("Activity " + activity.toString() + " must implement Logininterface")
        }

        login_btn.setOnClickListener{

            var email=email_address.text.toString()
            var client=NetworkClient()
            var params=RequestParams();
            client[CoreUtils.base_url+"api/Member/"+email, params, object :JsonHttpResponseHandler(){
                override fun onStart() {
                    pr.visibility=View.VISIBLE
                }

                override fun onFinish() {
                    pr.visibility=View.GONE
                }

                override fun onSuccess(statusCode: Int, headers: Array<out Header>?, response: JSONObject?) {
                    super.onSuccess(statusCode, headers, response)
                }

                override fun onFailure(statusCode: Int, headers: Array<out Header>?, throwable: Throwable?, errorResponse: JSONObject?) {
                    super.onFailure(statusCode, headers, throwable, errorResponse)
                }

            }]


        }



    }

    interface LoginInterface{
        public fun changePage(page:Int)

    }
}