package com.erkan.githubrepo.data.datasource

import com.erkan.githubrepo.di.ApiServices
import javax.inject.Inject

/**
 * Created by umiterkan on 1/2/2021
 */

class RepoDataSource @Inject constructor(val apiServices: ApiServices) : BaseDataSource() {
    suspend fun getRepoList(username:String) = getResult { apiServices.getRepoList(username) }
}