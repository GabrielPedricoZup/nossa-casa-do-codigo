package br.com.zup.controllers
import br.com.zup.dtos.NovoAutorRequest
import org.junit.jupiter.api.Assertions.*
import br.com.zup.dtos.NovoAutorResponse
import br.com.zup.models.Autor
import br.com.zup.repositories.AutorRepository
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.TransactionMode
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest(
    rollback = false, // default = true
    transactionMode = TransactionMode.SINGLE_TRANSACTION // default = TransactionMode.SEPARATE_TRANSACTIONS
)
internal class NovoAutorControllerTest {

    @field:Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @field:Inject
    lateinit var repository: AutorRepository

    @BeforeEach
    fun setup(){
        repository.deleteAll()
    }

    @AfterEach
    fun cleanUp(){
        repository.deleteAll()
    }

    @Test
    internal fun deveCadastrarAutor() {

        val novoAutorRequest = NovoAutorRequest("Rafael Ponte","rafael.ponte.god@zup.com","Maraja dos legados")

        val request = HttpRequest.POST("autor",novoAutorRequest)

        val response = client.toBlocking().exchange(request,Any::class.java)

        assertEquals(HttpStatus.OK,response.status)
        assertNotNull(response.body())

    }
}