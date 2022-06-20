package com.norbersan.data.model

import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import org.bson.types.ObjectId
import java.time.LocalDateTime

//@Serdeable
//@Introspected
@MappedEntity(value = "micronautDataBean")
data class MicronautDataBean(
    @Id @field:Id
    val id: ObjectId,
    val intNumber: Int,
    val doubleNumber: Double,
    val date: LocalDateTime
)