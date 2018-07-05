package neverest.ke.co.digiland.utils

import android.app.Application
import com.raizlabs.android.dbflow.config.FlowManager

class DigilandApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        FlowManager.init(this)

    }
}