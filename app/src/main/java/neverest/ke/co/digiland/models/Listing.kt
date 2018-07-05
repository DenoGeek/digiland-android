package neverest.ke.co.digiland.models

import com.google.gson.annotations.SerializedName

class Listing{
    @SerializedName("listingId")
    var listingId: String? = null

    @SerializedName("reservePrice")
    var reservePrice: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("state")
    var state: String? = null

    @SerializedName("email")
    var email: String? = null
}