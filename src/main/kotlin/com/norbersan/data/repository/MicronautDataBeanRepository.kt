package com.norbersan.data.repository

import com.norbersan.data.model.MicronautDataBean
import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.repository.CrudRepository
import org.bson.types.ObjectId
import javax.transaction.Transactional

@MongoRepository
@Transactional(Transactional.TxType.NOT_SUPPORTED)
interface MicronautDataBeanRepository: CrudRepository<MicronautDataBean, ObjectId> {
}