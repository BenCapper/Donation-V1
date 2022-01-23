package org.wit.donation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.wit.donation.databinding.ActivityDonateBinding

class Donate : AppCompatActivity() {

    private lateinit var  donateLayout : ActivityDonateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        donateLayout = ActivityDonateBinding.inflate(layoutInflater)
        setContentView(donateLayout.root)
        donateLayout.progressBar.max = 10000
        donateLayout.amountPicker.minValue = 1
        donateLayout.amountPicker.maxValue = 1000
        donateLayout.amountPicker.setOnValueChangedListener{_, _, newVal ->
            donateLayout.paymentAmount.setText("$newVal")
        }

        var totalDonated = 0

        donateLayout.donateButton.setOnClickListener {
            val amount = if (donateLayout.paymentAmount.text.isNotEmpty())
                donateLayout.paymentAmount.text.toString().toInt() else donateLayout.amountPicker.value
            if(totalDonated >= donateLayout.progressBar.max)
                Toast.makeText(applicationContext,"Donate Amount Exceeded!",Toast.LENGTH_LONG).show()
            else {
                totalDonated += amount
                donateLayout.totalSoFar.text = "$$totalDonated"
                donateLayout.progressBar.progress = totalDonated
            }
        }
    }
}