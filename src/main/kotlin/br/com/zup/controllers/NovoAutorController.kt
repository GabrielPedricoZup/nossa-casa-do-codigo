package br.com.zup.controllers

import br.com.zup.dtos.NovoAutorRequest
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/autor")
class NovoAutorController {

    @Post
    fun cadastraNovoAutor(@Body @Valid request : NovoAutorRequest){
        println(request)
    }
}