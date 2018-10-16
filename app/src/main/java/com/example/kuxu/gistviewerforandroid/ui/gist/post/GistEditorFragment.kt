package com.example.kuxu.gistviewerforandroid.ui.gist.post


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kuxu.gistviewerforandroid.databinding.FragmentGistEditorBinding
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
public class GistEditorFragment : Fragment() {

  private val viewModel: GistEditorFragmentViewModel by viewModel()

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    val binding = FragmentGistEditorBinding.inflate(
      inflater,
      container,
      false
    )

    binding.gistPostFloatingActionButton.setOnClickListener {
      viewModel.post(
        binding.gistTitleTextInputEditText.text.toString(),
        binding.gistContentTextInputEditText.text.toString()
      )
    }

    viewModel.PostDone.observeForever {
      if (it) {
        Snackbar.make(container as View, "gist の投稿が完了しました", Snackbar.LENGTH_LONG).show()
      }
    }

    return binding.root
  }
}
