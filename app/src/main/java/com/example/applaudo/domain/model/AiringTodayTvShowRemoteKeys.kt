package com.example.applaudo.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "airing_today_tv_show_remote_keys")
data class AiringTodayTvShowRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?,
    val lastUpdated: Long?,
)
