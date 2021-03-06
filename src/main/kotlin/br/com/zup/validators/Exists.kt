package br.com.zup.validators

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [ExistsValidator::class])
@MustBeDocumented
annotation class Exists(
    val message: String = "Não existe esse email",
    val fieldName: String,
    val domainClass: String,
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = []
)


