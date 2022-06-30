package com.norbersan.micronauttests

import com.norbersan.data.model.FullDataBean
import com.norbersan.data.model.PartialDataBean1
import com.norbersan.data.model.PartialDataBean2
import com.norbersan.data.model.PartialDataBean3
import com.norbersan.data.repository.FullDataBeanRepository
import com.norbersan.data.repository.MicronautDataBeanRepository
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.bson.types.ObjectId
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

@MicronautTest
class MultipleBeansMongoTest {
    @Inject
    lateinit var repository: FullDataBeanRepository

    @Test
    fun test(){
        val id = ObjectId()

        val fullDataBean1 = FullDataBean(id, 1, 1.1, LocalDateTime.parse("1975-01-01T00:00"))

        repository.save(fullDataBean1)

        val safeFullDataBean = repository.findById(id).get()
        val value = repository.getCommonIntNumberByIdValue(id)
        val partial1 = PartialDataBean1(id, 1, 1.1, LocalDateTime.parse("1900-01-01T00:00"))
        repository.save(partial1)

        val partial2 = PartialDataBean2(id, 2, 1.2, LocalDateTime.parse("1999-12-31T00:00"))
        repository.save(partial2)

        val partial3 = PartialDataBean3(id, 3, 1.3, LocalDateTime.parse("2055-01-01T00:00"))
        repository.save(partial3)

        val safeFullDataBean2 = repository.findById(id).get()
        val fullDataBean2 = repository.findById(id).get()
    }
}