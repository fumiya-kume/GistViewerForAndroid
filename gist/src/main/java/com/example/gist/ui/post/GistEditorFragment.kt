package com.example.gist.ui.post


import android.annotation.SuppressLint
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ImageButton
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gist.R
import com.example.gist.databinding.FragmentGistEditorBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel


internal class GistEditorFragment : BottomSheetDialogFragment() {

  private val viewModel: GistEditorFragmentViewModel by viewModel()

  @SuppressLint("RestrictedApi")
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {

    val binding = FragmentGistEditorBinding.inflate(
      inflater,
      container,
      false
    )

    setHasOptionsMenu(true)
    binding.gistPostBottonAppBar.replaceMenu(R.menu.gist_edit_viewer_menu)

    val adapter = GistFileViewerAdapter(requireContext())

    binding.gistEditorFileRecyclerView.adapter = adapter
    binding.gistEditorFileRecyclerView.layoutManager = LinearLayoutManager(requireContext())

    viewModel.PostDone.observeForever {
      if (it) {
        Snackbar.make(container as View, "gist の投稿が完了しました", Snackbar.LENGTH_LONG).show()
        view?.let {
          Navigation.findNavController(it).popBackStack()
          val inputMethodManager = activity?.applicationContext?.getSystemService(INPUT_METHOD_SERVICE) as? InputMethodManager
          inputMethodManager!!.hideSoftInputFromWindow(it.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
      }
    }

    viewModel.gistFileLiveData.observeForever {
      adapter.submitList(it)
    }

    val addFileBottomSheetBehavior = BottomSheetBehavior.from(binding.addFileBottomSheet)

    fun SetVisibleNewFileBottomSheed(visible: Boolean) {
      addFileBottomSheetBehavior.state = if (visible) {
        BottomSheetBehavior.STATE_COLLAPSED
      } else {
        BottomSheetBehavior.STATE_HIDDEN
      }
    }

    fun SetVisibleAddNewFileFloatingActionButton(visible: Boolean) {
      binding.gistSaveFloatingActionButton.visibility = if (visible) ImageButton.VISIBLE else ImageButton.GONE
    }

    binding.addNewFileMaterialButton.setOnClickListener {
      SetVisibleAddNewFileFloatingActionButton(false)
      SetVisibleNewFileBottomSheed(true)
    }

    SetVisibleNewFileBottomSheed(false)

    addFileBottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
      override fun onSlide(p0: View, p1: Float) {

      }

      override fun onStateChanged(bottomSheet: View, newState: Int) {
        when (newState) {
          BottomSheetBehavior.STATE_DRAGGING -> {
          }
          BottomSheetBehavior.STATE_SETTLING -> {
          }
          BottomSheetBehavior.STATE_EXPANDED -> {
          }
          BottomSheetBehavior.STATE_COLLAPSED -> {
          }
          BottomSheetBehavior.STATE_HIDDEN -> {
            SetVisibleAddNewFileFloatingActionButton(true)
          }
          else -> {

          }
        }
      }
    })

    fun showSnackMessage(message: String) {
      Snackbar.make(binding.addFileBottomSheet, message, Snackbar.LENGTH_SHORT).show()
    }

    binding.saveNewFileMaterialButton.setOnClickListener {
      val fileName = binding.fileNameEditText.text?.toString() ?: ""
      val content = binding.fileContentEditText.text?.toString() ?: ""

      if (fileName.isEmpty()) {
        showSnackMessage("Require Filename")
      } else {
        SetVisibleNewFileBottomSheed(false)
        SetVisibleAddNewFileFloatingActionButton(true)

        viewModel.AddNewFile(fileName, content)

        binding.fileNameEditText.text?.clear()
        binding.fileContentEditText.text?.clear()
      }
    }

    binding.gistSaveFloatingActionButton.setOnClickListener {
      val gistTitle = binding.gistTitleTextInputEditText.text?.toString() ?: ""
      if (gistTitle.isEmpty()) {
        showSnackMessage("Gist のタイトルを入力してください")
      }

      viewModel.post(
        gistTitle
      )
    }
    return binding.root
  }
}
