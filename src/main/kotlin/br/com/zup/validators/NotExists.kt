package br.com.zup.validators

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [NotExistsValidator::class])
@MustBeDocumented
annotation class NotExists(
    val message: String = "Já existe esse cadastro",
    val fieldName: String,
    val domainClass: String,
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = []
)
