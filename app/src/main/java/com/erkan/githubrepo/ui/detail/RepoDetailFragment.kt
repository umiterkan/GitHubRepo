package com.erkan.githubrepo.ui.detail

import androidx.navigation.fragment.navArgs
import com.erkan.githubrepo.R
import com.erkan.githubrepo.databinding.FragmentRepoDetailBinding
import com.erkan.githubrepo.ui.BaseFragment

/**
 * Created by umiterkan on 1/3/2021
 */

class RepoDetailFragment : BaseFragment<FragmentRepoDetailBinding>() {

    private val args: RepoDetailFragmentArgs by navArgs()

    override val layoutId: Int get() = R.layout.fragment_repo_detail

    override fun initUI() {
        binding?.data=args.repo
    }

    override fun observe() {
    }

    override fun fetch() {
    }

    override fun listener() {
    }

    override fun initialize() {

    }

}