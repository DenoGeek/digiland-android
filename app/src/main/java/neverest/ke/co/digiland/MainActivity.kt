package neverest.ke.co.digiland

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.util.Log
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

        generate_button.setOnClickListener{
            val i= Intent(applicationContext,ListingsActivity::class.java)
            i.putExtra("lr",land_ref_no)
            startActivity(i)
        }

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
                    car_label?.text="LRno: "+response?.getString("landRefNo")
                    var _resolved_owner=response?.getString("owner")!!.split("#")[1]
                    client.get("Member/"+_resolved_owner,params,object :JsonHttpResponseHandler(){
                        override fun onSuccess(statusCode: Int, headers: Array<out Header>?, response: JSONObject?) {
                            super.onSuccess(statusCode, headers, response)
                            setUpOwner(response)
                        }
                    })
                }
            })

        }
    }


    private fun setUpOwner(car:JSONObject?){

        car_data?.visibility=View.VISIBLE
        generate_button?.visibility=View.VISIBLE

        mileage?.text=car?.getString("firstName")
        passengers?.text=car?.getString("lastName")
        year?.text=car?.getString("email")
    }

    
}
