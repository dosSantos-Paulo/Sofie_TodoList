object Versions {
    const val sdk_version = 28

    val retrofit = getRetrofitVersion()
    val okHttp = getOkHttpVersion()
}

fun getRetrofitVersion() = if (Versions.sdk_version <= 21) {"2.3.0"} else {"2.9.0"}

fun getOkHttpVersion() = if (Versions.sdk_version <= 21) {"3.12.12"} else {"3.8.0"}

object Deps {
    val okhttp = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofit_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
}