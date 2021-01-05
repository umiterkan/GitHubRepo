package com.erkan.githubrepo.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by umiterkan on 1/3/2021
 */

@Parcelize
data class Owner(val id: String?, val login: String?, val avatar_url: String?) : Parcelable