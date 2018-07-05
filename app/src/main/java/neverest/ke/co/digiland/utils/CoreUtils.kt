package neverest.ke.co.digiland.utils

import com.raizlabs.android.dbflow.sql.language.SQLite
import neverest.ke.co.digiland.models.AuthUser

class CoreUtils {

    companion object {
        var network_package:String = "com.digiland.org"
        var base_url:String = "http://192.168.100.18:3000/api/"


        fun hasAuthorization():Boolean{
            return basicAuthorization()===null
        }
        fun basicAuthorization(): AuthUser?{
            return SQLite.select().from(AuthUser::class.java).querySingle()
        }
    }
}