package br.com.zup.controllers

import br.com.zup.dtos.NovoAutorRequest
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/autor")
class NovoAutorController {

    @Post
    fun cadastraNovoAutor(@Body request : NovoAutorRequest){
        println(request)
    }
}