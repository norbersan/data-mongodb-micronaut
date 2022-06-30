package com.norbersan.data.model

import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import org.bson.types.ObjectId
import java.time.LocalDateTime

@MappedEntity(value = "fullDataBean")
data class FullDataBean(
    @Id @field:Id
    val id: ObjectId,
    val commonIntNumber: Int,
    val commonDoubleNumber: Double,
    val commonDate: LocalDateTime,
    val intNumber1: Int? = null,
    val intNumber2: Int? = null,
    val intNumber3: Int? = null,
    val doubleNumber1: Double? = null,
    val doubleNumber2: Double? = null,
    val doubleNumber3: Double? = null,
    val date1: LocalDateTime? = null,
    val date2: LocalDateTime? = null,
    val date3: LocalDateTime? = null
)

@MappedEntity(value = "fullDataBean")
data class SafeFullDataBean(
    @Id @field:Id
    val id: ObjectId,
    val commonIntNumber: Int,
    val commonDoubleNumber: Double,
    val commonDate: LocalDateTime
)

@MappedEntity(value = "fullDataBean")
data class PartialDataBean1(
    @Id @field:Id
    val id: ObjectId,
    val intNumber1: Int,
    val doubleNumber1: Double,
    val date1: LocalDateTime
)

@MappedEntity(value = "fullDataBean")
data class PartialDataBean2(
    @Id @field:Id
    val id: ObjectId,
    val intNumber2: Int,
    val doubleNumber2: Double,
    val date2: LocalDateTime
)

@MappedEntity(value = "fullDataBean")
data class PartialDataBean3(
    @Id @field:Id
    val id: ObjectId,
    val intNumber3: Int,
    val doubleNumber3: Double,
    val date3: LocalDateTime
)