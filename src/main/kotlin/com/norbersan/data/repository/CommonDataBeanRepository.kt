package com.norbersan.data.repository

import io.micronaut.data.mongodb.annotation.MongoRepository
import com.norbersan.data.model.CommonDataBean
import io.micronaut.data.repository.CrudRepository
import javax.transaction.Transactional

//@MongoRepository
//@Transactional(Transactional.TxType.NOT_SUPPORTED)
interface CommonDataBeanRepository: CrudRepository<CommonDataBean, String> {
}