package org.wit.donation.main

import android.app.Application
import org.wit.donation.models.DonationMemStore
import org.wit.donation.models.DonationStore
import timber.log.Timber

class DonationApp : Application() {

    lateinit var donationsStore: DonationStore

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        donationsStore = DonationMemStore()
        Timber.i("Starting Donation Application")
    }
}