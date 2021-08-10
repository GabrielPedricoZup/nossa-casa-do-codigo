package br.com.zup.validators

import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.transaction.Transactional
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext




 var domainClass:String? = null
 var fieldName:String? = null

@Singleton
 open class ExistsValidator(val em: EntityManager) : ConstraintValidator<Exists, Any> {
        override fun initialize(params: Exists?) {
            domainClass = params!!.domainClass
            fieldName = params!!.fieldName
        }

        @Transactional
        override fun isValid(value: Any?, context: ConstraintValidatorContext?): Boolean {
                return em.createQuery("select 1 from $domainClass where $fieldName = :pValue ")
                    .setParameter("pValue", value)
                    .resultList
                    .isNotEmpty()
        }
    }