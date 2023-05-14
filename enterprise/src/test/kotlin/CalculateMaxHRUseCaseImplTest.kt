import com.klodian.kambo.enterprise.entities.UserGender
import com.klodian.kambo.enterprise.usecases.CalculateMaxHRUseCaseImpl
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test


class CalculateMaxHRUseCaseImplTest {

    private lateinit var calculateMaxHRUseCase: CalculateMaxHRUseCaseImpl

    @Before
    fun setup() {
        calculateMaxHRUseCase = CalculateMaxHRUseCaseImpl()
    }

    @Test
    fun `calculate max HR for male with age 25`() {
        // Given
        val age = 25
        val gender = UserGender.M

        // When
        val result = calculateMaxHRUseCase.invoke(age, gender)

        // Then
        assertEquals(194, result)
    }

    @Test
    fun `calculate max HR for male with age 70`() {
        // Given
        val age = 70
        val gender = UserGender.M

        // When
        val result = calculateMaxHRUseCase.invoke(age, gender)

        // Then
        assertEquals(158, result)
    }

    @Test
    fun `calculate max HR for female with age 25`() {
        // Given
        val age = 25
        val gender = UserGender.F

        // When
        val result = calculateMaxHRUseCase.invoke(age, gender)

        // Then
        assertEquals(192, result)
    }

    @Test
    fun `calculate max HR for female with age 70`() {
        // Given
        val age = 70
        val gender = UserGender.F

        // When
        val result = calculateMaxHRUseCase.invoke(age, gender)

        // Then
        assertEquals(160, result)
    }

    @Test
    fun `calculate max HR for negative age`() {
        // Given
        val age = -10
        val gender = UserGender.M

        // When
        val result = calculateMaxHRUseCase.invoke(age, gender)

        // Then
        assertNull(result)
    }
}