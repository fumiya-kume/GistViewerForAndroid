package com.example.kuxu.gistviewerforandroid.ui.gist.viewer.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.kuxu.gistviewerforandroid.databinding.FragmentGistDetailViewBinding
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class GistDetailViewFragment : Fragment() {

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {

    val binding = FragmentGistDetailViewBinding.inflate(
      inflater,
      container,
      false
    )

    val targetGistId = GistDetailViewFragmentArgs.fromBundle(arguments).gistId

    val viewModel: GistDetailViewFragmentViewModel by viewModel() { parametersOf(targetGistId) }

    val GistDetailFileViewAdapter = GistDetailFileViewAdapter(requireContext())

    binding.gistFileRecyclerView.adapter = GistDetailFileViewAdapter

    viewModel.gistDetailLiveData.observeForever {
      binding.bindingModel = it
      GlobalScope.launch(Dispatchers.Main) {
        if (it.ownerProfileImageUrl.isNotEmpty()) {
          Glide.with(requireContext())
            .load(it.ownerProfileImageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.gistOwnerImageView)
        }
      }
    }

    viewModel.gistDetailFileListLiveData.observeForever {
      GistDetailFileViewAdapter.submitList(it)
    }

    return binding.root
  }
}
