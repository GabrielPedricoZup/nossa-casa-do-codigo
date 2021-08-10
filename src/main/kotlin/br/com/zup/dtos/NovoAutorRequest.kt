package br.com.zup.dtos

import br.com.zup.models.Autor
import br.com.zup.validators.NotExists
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
data class NovoAutorRequest (@field:NotBlank val nome: String,
                             @field:NotBlank @field:Email @field:NotExists(domainClass = "Autor",fieldName = "email") val email: String,
                             @field:NotBlank @field:Size(max = 400) val descricao: String) {
    fun paraAutor(): Autor {
            return Autor(nome, email, descricao)
    }
}