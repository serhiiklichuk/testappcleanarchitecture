import com.example.core.Loading
import com.example.core.Result
import com.example.core.Success
import com.example.core.Error
import com.example.data.ISignUpRepository
import com.example.domain.model.SignUpModel
import com.example.domain.usecases.SignUpUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SignUpUseCaseTest {

    @get:Rule
    var coroutinesTestRule = CoroutineTestRule()

    @Test
    fun verifyResultIsSuccess() = coroutinesTestRule.testDispatcher.runBlockingTest {
        val useCase = SignUpUseCase(successRepo)
        val model = SignUpModel("", "")
        val result = useCase.signUpUser(model)
        assert(result is Success)
        result as Success
        assert(result.data is Unit)
    }

    @Test
    fun verifyResultIsLoading() = coroutinesTestRule.testDispatcher.runBlockingTest {
        val useCase = SignUpUseCase(loadingRepo)
        val model = SignUpModel("", "")
        val result = useCase.signUpUser(model)
        assert(result is Loading)
    }

    @Test
    fun verifyResultIsError() = coroutinesTestRule.testDispatcher.runBlockingTest {
        val useCase = SignUpUseCase(errorRepo)
        val model = SignUpModel("", "")
        val result = useCase.signUpUser(model)
        assert(result is Error)
    }

    private val loadingRepo = object : ISignUpRepository {
        override suspend fun signUpUser(model: com.example.data.models.SignUpModel): Result<Unit> {
            return Loading
        }
    }

    private val successRepo = object : ISignUpRepository {
        override suspend fun signUpUser(model: com.example.data.models.SignUpModel): Result<Unit> {
            return Success(Unit)
        }
    }

    private val errorRepo = object : ISignUpRepository {
        override suspend fun signUpUser(model: com.example.data.models.SignUpModel): Result<Unit> {
            return Error(Exception())
        }
    }

}