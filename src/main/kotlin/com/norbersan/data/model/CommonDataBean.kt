package com.norbersan.data.model

import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import org.bson.types.ObjectId
import java.time.LocalDateTime

@MappedEntity(value = "commonDataBean")
data class CommonDataBean(
    @Id @field:Id
    val id: ObjectId,
    val intNumber: Int,
    val doubleNumber: Double,
    val date: LocalDateTime
)