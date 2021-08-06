package br.com.zup.controllers

import br.com.zup.dtos.NovoAutorRequest
import br.com.zup.repositories.AutorRepository
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/autor")
class NovoAutorController(
    val autorRepository: AutorRepository
) {

    @Post
    fun cadastraNovoAutor(@Body @Valid request : NovoAutorRequest){

        val autor  = request.paraAutor()
        autorRepository.save(autor)

        println(request)
    }
}