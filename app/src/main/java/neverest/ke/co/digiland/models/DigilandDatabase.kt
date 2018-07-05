package neverest.ke.co.digiland.models

import com.raizlabs.android.dbflow.annotation.Database

@Database(name = DigilandDatabase.NAME, version = DigilandDatabase.VERSION)
object DigilandDatabase {
    const val NAME = "digiland"

    const val VERSION = 1
}