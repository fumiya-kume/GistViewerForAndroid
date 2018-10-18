package com.example.kuxu.gistviewerforandroid.ui.gist.viewer.overview


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuxu.gistviewerforandroid.databinding.FragmentGistOverViewBinding
import com.example.kuxu.gistviewerforandroid.ui.gist.post.GistPostActivity
import com.example.kuxu.gistviewerforandroid.ui.gist.viewer.overview.bindingModel.GistOverViewItemBindingModel
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

    binding.gistPostFloatingActionButton.setOnClickListener {
      val intent = Intent(requireContext(), GistPostActivity::class.java)
      startActivity(intent)
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

    viewModel.gistOverViewLiveData.observeForever {
      adapter.submitList(it)
    }

    return binding.root
  }
}