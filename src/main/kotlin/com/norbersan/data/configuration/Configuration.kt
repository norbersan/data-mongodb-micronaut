package com.norbersan.data.configuration

import io.micronaut.context.annotation.Factory

@Factory
class Configuration {
/*
    @Singleton
    fun registry(): CodecRegistry? {
        val vehicleShortClassModel = ClassModel
            .builder(MicronautDataBean::class.java)
            .conventions(mutableListOf(
                Conventions.CLASS_AND_PROPERTY_CONVENTION,
                Conventions.ANNOTATION_CONVENTION,
                Conventions.OBJECT_ID_GENERATORS
            )
            )
            .build()
        val pojoCodecProvider: CodecProvider = PojoCodecProvider.builder()
            .register(vehicleShortClassModel)
            .build()
        return CodecRegistries.fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            CodecRegistries.fromProviders(pojoCodecProvider)
        )
    }
*/
}