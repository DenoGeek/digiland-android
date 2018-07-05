package neverest.ke.co.digiland

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import com.loopj.android.http.JsonHttpResponseHandler
import com.loopj.android.http.RequestParams
import cz.msebera.android.httpclient.Header
import kotlinx.android.synthetic.main.activity_main.*
import neverest.ke.co.digiland.utils.NetworkClient
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private var land_ref_no:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var toolbar=findViewById<Toolbar>(R.id.tool_bar)
        setSupportActionBar(toolbar)
        car_data?.visibility=View.GONE

        search_btn.setOnClickListener{

            land_ref_no=search_param.text.toString()
            var client=NetworkClient()
            var params=RequestParams()
            client.get("Land/"+land_ref_no,params,object :JsonHttpResponseHandler(){
                override fun onStart() {
                    pr.visibility=View.VISIBLE
                    car_data?.visibility=View.GONE
                    car_label?.text=""
                }

                override fun onFinish() {
                    super.onFinish()
                    pr.visibility=View.GONE
                }

                override fun onSuccess(statusCode: Int, headers: Array<out Header>?, response: JSONObject?) {
                    super.onSuccess(statusCode, headers, response)

                    var _resolved_owner=""
                    client.get("Member/"+_resolved_owner,params,object :JsonHttpResponseHandler(){
                        override fun onSuccess(statusCode: Int, headers: Array<out Header>?, response: JSONObject?) {
                            super.onSuccess(statusCode, headers, response)
                            //Display details of the owner
                        }
                    })
                }
            })

        }
    }

    
}
