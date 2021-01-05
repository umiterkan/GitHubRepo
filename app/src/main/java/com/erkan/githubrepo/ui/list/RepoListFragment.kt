package com.erkan.githubrepo.ui.list

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.erkan.githubrepo.R
import com.erkan.githubrepo.adapter.RepoAdapter
import com.erkan.githubrepo.data.model.Repo
import com.erkan.githubrepo.databinding.FragmentRepoListBinding
import com.erkan.githubrepo.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class RepoListFragment : BaseFragment<FragmentRepoListBinding>(), RepoAdapter.RepoListener {

    val viewModel: RepoListViewModel by viewModels()
    override val layoutId: Int get() = R.layout.fragment_repo_list

    private lateinit var adapter: RepoAdapter

    override fun initialize() {
        binding?.viewModel = viewModel
    }

    override fun initUI() {
        adapter = RepoAdapter(this)
        binding?.repoAdapter = adapter
    }

    override fun listener() {
        binding?.btnSearch?.setOnClickListener {
            hideKeyboard(binding?.etSearch)
            viewModel.getRepoList(binding?.etSearch?.text.toString())
        }
        binding?.etSearch?.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                hideKeyboard(binding?.etSearch)
                viewModel.getRepoList(binding?.etSearch?.text.toString())
                return@OnEditorActionListener true
            }
            false
        })
    }

    override fun observe() {}

    override fun fetch() {}

    override fun onRepoItemClick(repo: Repo) {
        findNavController().navigate(
            RepoListFragmentDirections.actionRepoListFragmentToRepoDetailFragment(
                repo,
                repo.name ?: getString(R.string.repo_detail_title)
            )
        )
    }

    override fun onRepoAddFavorite(repo: Repo, position: Int) {
        viewModel.processFavorite(repo)
        repo.is_favorite = !repo.is_favorite
        adapter.notifyItemChanged(position)
    }
}


