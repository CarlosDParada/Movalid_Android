package com.carlosdp.movalid.model

data class ResponseApi(var page: Int?,
                    var total_results: Int?,
                    var total_pages: Int?,
                    var results: List<Movie>?)
