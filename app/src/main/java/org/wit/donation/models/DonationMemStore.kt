package org.wit.donation.models

import timber.log.Timber

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class DonationMemStore : DonationStore {

    private val donations = ArrayList<DonationModel>()

    override fun findAll(): List<DonationModel> {
        return donations
    }

    override fun findById(id: Long): DonationModel? {
        return donations.find { it.id == id }
    }

    override fun create(donation: DonationModel) {
        donation.id = getId()
        donations.add(donation)
        logAll()
    }

    fun logAll() {
        Timber.v("** Donations List **")
        donations.forEach { Timber.v("Donate $it") }
    }
}