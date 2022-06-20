package com.norbersan.micronauttests

import com.norbersan.data.model.MicronautDataBean
import com.norbersan.data.repository.MicronautDataBeanRepository
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.bson.types.ObjectId
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

@MicronautTest
class MicronautMongoTest {
    @Inject
    lateinit var repository: MicronautDataBeanRepository

    @Test
    fun `basic CRUD operations`(){
        val bean = MicronautDataBean(
            id= ObjectId(),
            intNumber = 12,
            doubleNumber = 12.3,
            date = LocalDateTime.now())

        repository.save(bean)
        val beans = repository.findAll()
    }
}