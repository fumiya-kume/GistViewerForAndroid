package com.example.kuxu.gistviewerforandroid.ui.gist.viewer.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kuxu.gistviewerforandroid.databinding.FragmentGistDetailViewBinding
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

    viewModel.gistDetailLiveData.observeForever {
      binding.bindingModel = it
    }
    return binding.root
  }
}
