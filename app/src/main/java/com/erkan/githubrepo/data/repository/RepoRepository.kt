package com.erkan.githubrepo.data.repository

import com.erkan.githubrepo.data.Resource
import com.erkan.githubrepo.data.database.dao.FavoriteDao
import com.erkan.githubrepo.data.datasource.RepoDataSource
import com.erkan.githubrepo.data.model.Repo
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by umiterkan on 1/2/2021
 */

class RepoRepository @Inject constructor(val repoDataSource: RepoDataSource,val favoriteDao: FavoriteDao) {
    init {
        Timber.d("init RepoRepository")
    }
    suspend fun getRepoList(username: String): Resource<List<Repo>> {
        val repoList=repoDataSource.getRepoList(username)
        if (!favoriteDao.getFavorites().isEmpty())
            repoList.data?.forEach { repo: Repo ->
                if (favoriteDao.getFavorite(repo.id!!.toInt()) != null) repo.is_favorite = true
            }
        return repoList
    }

}