package com.example.draweranimation.data

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("rating")
	val rating: Double? = null,

	@field:SerializedName("en")
	val en: String? = null
)