package neverest.ke.co.digiland.models

import com.google.gson.annotations.SerializedName
import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel
import neverest.ke.co.digiland.utils.CoreUtils

@Table(database = DigilandDatabase::class)
class AuthUser:BaseModel() {

    @PrimaryKey
    @SerializedName("id")
    var id: Int=0

    @Column
    @SerializedName("email")
    var email: String? = null

    @Column
    @SerializedName("firstname")
    var firstname: String? = null

    @Column
    @SerializedName("lastname")
    var lastname: String? = null

    fun uniqueResover():String{
        return CoreUtils.network_package+"#"+this.email
    }
}