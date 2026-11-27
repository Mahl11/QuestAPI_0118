package com.example.mydatasiswa

import com.example.mydatasiswa.modeldata.DataSiswa
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test

class DataSiswaSerializationTest {
    @Test
    fun decodePhpJsonArrayWithQuotedIdSucceeds() {
        val phpJson = """[{"id":"1","nama":"Ilham Saputra","alamat":"Yogyakarta","telpon":"081234567890"}]"""
        val parser = Json {
            ignoreUnknownKeys = true
            prettyPrint = true
            isLenient = true
        }
        val list = parser.decodeFromString<List<DataSiswa>>(phpJson)
        assertEquals(1, list.size)
        assertEquals(1, list[0].id)
        assertEquals("Ilham Saputra", list[0].nama)
    }
}
