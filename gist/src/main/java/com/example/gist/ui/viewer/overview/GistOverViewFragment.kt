package com.example.gist.ui.viewer.overview


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gist.R
import com.example.gist.databinding.FragmentGistOverViewBinding
import com.example.gist.ui.viewer.overview.bindingModel.GistOverViewItemBindingModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class GistOverViewFragment : Fragment() {


  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val adapter = GistOverViewAdapter(requireContext())

    val binding = FragmentGistOverViewBinding.inflate(
      inflater,
      container,
      false
    )

    binding.gistPostFloatingActionButton.setOnClickListener {
      Navigation.findNavController(it).navigate(R.id.action_gistOverViewFragment_to_gistEditorFragment)
    }

    binding.gistOverviewRecyclerView.adapter = adapter
    binding.gistOverviewRecyclerView.layoutManager = LinearLayoutManager(requireContext())

    adapter.onClickGistListener = object : OnClickGistListener {
      override fun onClick(gistOverViewItemBindingModel: GistOverViewItemBindingModel) {
        view?.findNavController()?.navigate(GistOverViewFragmentDirections.actionGistOverViewFragmentToGistDetailViewFragment(gistOverViewItemBindingModel.id))
      }
    }

    val itemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
    binding.gistOverviewRecyclerView.addItemDecoration(itemDecoration)



    val viewModel: GistOverViewViewModel = getViewModel()

    viewModel.gistOverViewLiveData.observeForever {
      adapter.submitList(it)
    }

    return binding.root
  }
}