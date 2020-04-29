@file:DependsOn("com.squareup.moshi:moshi-adapters:1.9.2", "com.squareup.moshi:moshi-kotlin:1.9.2")

import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi

data class MyData(val id: Int, val value: String)
val adapter = moshi.adapter(MyData::class.java)

val json = adapter.toJson(MyData(123, "value"))
