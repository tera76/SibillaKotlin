package com.example.myapplication


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RestApi {
    @Headers(
        "Content-Type: application/json"
    )
    @POST("sibilla/api/post.php")
    fun addUser(@Body requestBody: SibillaModel ): Call<SibillaResponse>


}


interface RestApi_Rca {
    @Headers(
        "Content-Type: application/json",
        "Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJvdGhlcl9jdXN0b21lcl9jb2RlIjpbXSwicHJvZmlsZV90eXBlIjoiVExQIiwiY29sbF9jb250cmFjdF9saXN0IjpbXSwidXNlcl9uYW1lIjoiVGVzdEdMMTgiLCJzY29wZSI6WyJwcm9maWxlVGxwIl0sImNvbnRyYWN0X2xpc3QiOlt7ImNvbnRyYWN0Q29kZSI6MzAwMjU3NjUsImFzc29jaWF0ZWRDb250cmFjdENvZGUiOm51bGwsInRlbXBsYXRlQ29kZSI6IkRJUkZBIiwicHJvZHVjdENvZGUiOiJGQSIsImN1c3RvbWVyQ29kZSI6MjYwMTM0MzIsImNvbnRyYWN0U3RhdHVzQ29kZSI6IjAxIiwiaXNUTFAiOnRydWV9XSwiZXhwIjoxNjYwODI1MzcwLCJjdXN0b21lcl9jb2RlIjoyNjAxMzQzMiwianRpIjoiNjk1Nzc1YzgtZjI3NS00NTM0LWJjNjMtZTA5ZTk2YmI2Njg5IiwiY2xpZW50X2lkIjoidHBheS1hcHAifQ.HESriQIF-nKWbPRXxP4YpULKSI1Vaq55J-9Nqto8nf-8PtezedCF730pQRvqUCQR_heH-UbRa4hDnYVM2jEkPSlMEWJVSx0NJaQ0yua084-UIJA7E3-Bq9L3bJMabXfQlxba-gOk9UYTYu5PnL6MIGywIDddxxyBMZunaUJP6XaFdGeeCUHHlnM68_VB5cgEyZ0C5quPu7H_OwY9MFMcl9j9p3SxJNumMTpqu8z8rcjaB5cxvbMGulur2ubqWpqnTg2jzxwnqxNPjh_vc9guzbORYD93XS2I7jNayUYkTWoOsmxYOu5n0HYCs0e8aVJ6FKpEK0Qxnqk3lTsalNzX-A",
        "x-channel: mobile",
        "x-app-name: KTH"
    )
    @POST("api/v2/quotation/mga?customerCode=26013432")
    fun addUser(@Body requestBody: SibillaModel ): Call<SibillaResponse>


}