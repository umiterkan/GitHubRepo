package com.erkan.githubrepo.data.datasource

import com.erkan.githubrepo.di.ApiServices
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by umiterkan on 1/2/2021
 */

class RepoDataSource @Inject constructor(val apiServices: ApiServices) : BaseDataSource() {
    init {
        Timber.d("init RepoDataSource")
    }

    suspend fun getRepoList(username:String) = getResult { apiServices.getRepoList(username) }
}