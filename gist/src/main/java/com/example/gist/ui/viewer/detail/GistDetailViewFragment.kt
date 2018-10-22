package com.example.gist.ui.viewer.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.gist.databinding.FragmentGistDetailViewBinding
import com.example.gist.ui.viewer.detail.bindingModel.GistDetailFileBindingModel
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

    val viewModel: GistDetailViewFragmentViewModel by viewModel { parametersOf(targetGistId) }

    val adapter = GistDetailFileViewAdapter(requireContext())

    adapter.gistDetailClickListener = object : OnGistDetailClickListener {
      override fun OnClick(bindingModel: GistDetailFileBindingModel) {
        if (bindingModel.fileUrl.isEmpty()) return
        viewModel.OpenGistFileOnBrowser(bindingModel.fileUrl)
      }
    }

    binding.gistFileRecyclerView.adapter = adapter

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

    binding.gistFavoriteFloatingActionButton.setOnClickListener { item ->
      binding.bindingModel?.let {
        if (it.favorite) {
          viewModel.removeFavorite(it.id
          )
        } else {
          viewModel.addFavorite(it.id)
        }
      }
    }

    viewModel.gistDetailFileListLiveData.observeForever {
      adapter.submitList(it)
    }

    return binding.root
  }
}
