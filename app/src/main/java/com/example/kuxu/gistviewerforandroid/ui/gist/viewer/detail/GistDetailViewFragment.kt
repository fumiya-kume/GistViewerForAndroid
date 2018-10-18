package com.example.kuxu.gistviewerforandroid.ui.gist.viewer.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kuxu.gistviewerforandroid.databinding.FragmentGistDetailViewBinding
import com.example.kuxu.gistviewerforandroid.ui.gist.viewer.detail.bindingModel.GistDetailBindingModel


class GistDetailViewFragment : Fragment() {

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {

    val binding = FragmentGistDetailViewBinding.inflate(
      inflater,
      container,
      false
    )

    val gistId = GistDetailViewFragmentArgs.fromBundle(arguments).gistId

    binding.bindingModel = GistDetailBindingModel(gistId, gistId)

    return binding.root
  }
}
