package com.example.muvi.ui.upcoming

import com.example.muvi.R
import com.example.muvi.base.BaseFragment
import com.example.muvi.databinding.FragmentUpcomingBinding
import com.example.muvi.ui.adpater.UpComingAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class UpComingFragment : BaseFragment<FragmentUpcomingBinding>() {

    override val layoutResource: Int
        get() = R.layout.fragment_upcoming

    override val viewModel by viewModel<UpComingViewModel>()

    private val upComingAdapter = UpComingAdapter({}){
        viewModel.getUpComingMovie()
    }

    override fun initData() {
        binding.lifecycleOwner = this
        binding.recyclerUpComing.adapter = upComingAdapter
        binding.upComingViewModel = viewModel
        initListener()
    }

    private fun initListener(){}

}
