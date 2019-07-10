package bru.oliveir.master

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bru.oliveir.common.BaseFragment
import bru.oliveir.common.BaseViewModel
import bru.oliveir.master.databinding.FragmentMasterBinding
import bru.oliveir.master.views.MasterAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class MasterFragment : BaseFragment() {

    private val viewModel: MasterViewModel by viewModel()
    private lateinit var binding: FragmentMasterBinding

    override fun getViewModel(): BaseViewModel = viewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMasterBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        configureRecyclerView()
    }

    private fun configureRecyclerView() {
        binding.rvMaster.adapter = MasterAdapter(viewModel)
    }
}