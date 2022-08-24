package com.example.myapplication

import com.google.gson.annotations.SerializedName



data class SibillaModel(
    var request: List<Request>
)

data class Request(
    var name: String,
    var from: String,
    var parameters: Parameters
)
data class Parameters(
    var email: String,
    var keyCode1: String,
    var query: String
)


/*

val ciccio1 = Request(
    "asd","sd",Parameter("wer","wer","sdf")
)

val ciccio2 = Request(
    "asd","sd",Parameter("wer","wer","sdf")
)

var pasticcio : SibillaModel? = null

var pass : List<Request>? = listOf(ciccio1, ciccio2)

*/


data class SibillaModel_rca(
    var ownerBirthday: String,
    var drivingType: String,
    var licensePlate: String

)

data class SibillaMode_origl (
    @SerializedName("user_id") val userId: Int?,
    @SerializedName("user_name") val userName: String?,
    @SerializedName("user_email") val userEmail: String?,
    @SerializedName("user_age") val userAge: String?,
    @SerializedName("user_uid") val userUid: String?,
    @SerializedName("response") val response: String?
)