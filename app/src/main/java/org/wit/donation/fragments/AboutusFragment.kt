package org.wit.donation.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import org.wit.donation.R
import org.wit.donation.databinding.FragmentAboutusBinding
import org.wit.donation.main.DonationApp

class AboutusFragment : Fragment(){

    lateinit var app: DonationApp
    private var _fragBinding: FragmentAboutusBinding? = null
    private val fragBinding get() = _fragBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = activity?.application as DonationApp
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _fragBinding = FragmentAboutusBinding.inflate(inflater, container, false)
        val root = fragBinding.root
        activity?.title = getString(R.string.action_about)

        return root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ReportFragment().apply {
                arguments = Bundle().apply { }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragBinding = null
    }
}

