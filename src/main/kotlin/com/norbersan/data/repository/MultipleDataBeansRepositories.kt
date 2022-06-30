package com.norbersan.data.repository

import com.norbersan.data.model.*
import io.micronaut.data.annotation.Query
import io.micronaut.data.mongodb.annotation.MongoFindQuery
import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.mongodb.annotation.MongoUpdateQuery
import io.micronaut.data.repository.CrudRepository
import jakarta.inject.Inject
import org.bson.Document
import org.bson.types.ObjectId
import java.util.Optional
import javax.transaction.Transactional

@MongoRepository
@Transactional(Transactional.TxType.NOT_SUPPORTED)
abstract class FullDataBeanRepository(
    var safeFullDataBeanRepository: SafeFullDataBeanRepository,
    var partialDataBean1Repository: PartialDataBean1Repository,
    var partialDataBean2Repository: PartialDataBean2Repository,
    var partialDataBean3Repository: PartialDataBean3Repository
): CrudRepository<FullDataBean, ObjectId> {
    // from https://micronaut-projects.github.io/micronaut-data/latest/guide/#mongoCustomQueries
    @MongoUpdateQuery(filter = "{ '_id' : :id }", update = "{ '\$set': { 'commonIntNumber' : :number } }")
    abstract fun setCommonIntNumberById(id: ObjectId, number: Int)

    @MongoFindQuery(filter = "{ '_id' : :id }", project = "{ '_id' : 0 , 'commonIntNumber' : 1 }")
    protected abstract fun getCommonIntNumberById(id: ObjectId): Document?
    final fun getCommonIntNumberByIdValue(id: ObjectId): Int? = getCommonIntNumberById(id)?.get("commonIntNumber") as Int?

    //not working, removes all other properties
    fun save(safeFullDataBean: SafeFullDataBean): SafeFullDataBean = safeFullDataBeanRepository.update(safeFullDataBean)
    //not working, removes all other properties
    fun save(partialDataBean1: PartialDataBean1): PartialDataBean1 = partialDataBean1Repository.update(partialDataBean1)
    //not working, removes all other properties
    fun save(partialDataBean2: PartialDataBean2): PartialDataBean2 = partialDataBean2Repository.update(partialDataBean2)
    //not working, removes all other properties
    fun save(partialDataBean3: PartialDataBean3): PartialDataBean3 = partialDataBean3Repository.update(partialDataBean3)

    fun findSafeFullDataBeanById(id: ObjectId): Optional<SafeFullDataBean> = safeFullDataBeanRepository.findById(id)
    fun findPartialDataBean1ById(id: ObjectId): Optional<PartialDataBean1> = partialDataBean1Repository.findById(id)
    fun findPartialDataBean2ById(id: ObjectId): Optional<PartialDataBean2> = partialDataBean2Repository.findById(id)
    fun findPartialDataBean3ById(id: ObjectId): Optional<PartialDataBean3> = partialDataBean3Repository.findById(id)
}

@MongoRepository
@Transactional(Transactional.TxType.NOT_SUPPORTED)
interface SafeFullDataBeanRepository: CrudRepository<SafeFullDataBean, ObjectId> {
}

@MongoRepository
@Transactional(Transactional.TxType.NOT_SUPPORTED)
interface PartialDataBean1Repository: CrudRepository<PartialDataBean1, ObjectId> {
}

@MongoRepository
@Transactional(Transactional.TxType.NOT_SUPPORTED)
interface PartialDataBean2Repository: CrudRepository<PartialDataBean2, ObjectId> {
}

@MongoRepository
@Transactional(Transactional.TxType.NOT_SUPPORTED)
interface PartialDataBean3Repository: CrudRepository<PartialDataBean3, ObjectId> {
}
