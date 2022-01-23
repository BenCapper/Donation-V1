package org.wit.donation.main

import android.app.Application
import timber.log.Timber

class DonationApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.i("Starting Donation Application")
    }
}