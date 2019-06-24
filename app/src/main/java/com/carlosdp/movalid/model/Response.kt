package com.carlosdp.movalid.model

data class Response(var page: Int?,
                    var total_results: Int?,
                    var total_pages: Int?,
                    var results: List<Movie>?)
