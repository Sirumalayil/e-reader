package com.example.e_reader.model

import com.google.gson.annotations.SerializedName

/**
 * Create by Sirumalayil on 15-02-2023.
 */
data class Stories(
    @SerializedName("stories") val story: List<Story>
)