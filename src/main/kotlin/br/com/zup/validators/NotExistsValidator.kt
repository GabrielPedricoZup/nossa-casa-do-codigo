package br.com.zup.validators


import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.transaction.Transactional
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

@Singleton
open class NotExistsValidator(val em: EntityManager) : ConstraintValidator<NotExists,Any> {
    override fun initialize(params: NotExists?) {
        domainClass = params!!.domainClass
        fieldName = params!!.fieldName
    }

    @Transactional
    override fun isValid(value: Any?, context: ConstraintValidatorContext?): Boolean {
        return em.createQuery("select 1 from $domainClass where $fieldName = :pValue ")
            .setParameter("pValue", value)
            .resultList
            .isEmpty()
    }
}