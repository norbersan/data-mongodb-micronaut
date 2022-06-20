package com.norbersan.data.model

import io.micronaut.data.annotation.Id
import java.time.LocalDateTime

data class CommonDataBean(
    @Id @field:Id
    val id :String,
    val intNumber: Int,
    val doubleNumber: Double,
    val date: LocalDateTime
)