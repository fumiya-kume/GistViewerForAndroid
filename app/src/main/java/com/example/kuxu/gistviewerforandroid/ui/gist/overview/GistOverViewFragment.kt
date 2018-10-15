package com.example.kuxu.gistviewerforandroid.ui.gist.overview


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuxu.gistviewerforandroid.databinding.FragmentGistOverViewBinding
import com.example.kuxu.gistviewerforandroid.ui.gist.bindingModel.GistOverViewItemBindingModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class GistOverViewFragment : Fragment() {

  private val viewModel: GistOverViewViewModel by viewModel()

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val adapter = GistOverViewAdapter(requireContext())

    val binding = FragmentGistOverViewBinding.inflate(
      inflater,
      container,
      false
    )

    binding.gistOverviewRecyclerView.adapter = adapter
    binding.gistOverviewRecyclerView.layoutManager = LinearLayoutManager(requireContext())

    adapter.onClickGistListener = object : OnClickGistListener {
      override fun onClick(gistOverViewItemBindingModel: GistOverViewItemBindingModel) {
        viewModel.onclickGistItem(gistOverViewItemBindingModel)
      }
    }

    viewModel.gistOverViewLiveData.observeForever {
      adapter.submitList(it)
    }

    return binding.root
  }
}