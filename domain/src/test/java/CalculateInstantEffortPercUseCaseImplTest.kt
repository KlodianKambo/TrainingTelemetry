import com.klodian.kambo.domain.usecases.CalculateInstantEffortPercUseCaseImpl
import org.junit.Assert.assertEquals
import org.junit.Test

class CalculateInstantEffortPercUseCaseImplTest {

    private val calculateInstantEffortPercUseCaseImpl = CalculateInstantEffortPercUseCaseImpl()

    @Test
    fun `instant heart rate is less than 1`() {
        val instantHr = 0
        val maxHr = 150
        val expected = null

        val actual = calculateInstantEffortPercUseCaseImpl(instantHr, maxHr)

        assertEquals(expected, actual)
    }

    @Test
    fun `max heart rate is less than 1`() {
        val instantHr = 100
        val maxHr = 0
        val expected = null

        val actual = calculateInstantEffortPercUseCaseImpl(instantHr, maxHr)

        assertEquals(expected, actual)
    }

    @Test
    fun `instant and max heart rates are both 1`() {
        val instantHr = 1
        val maxHr = 1
        val expected = 1.0

        val actual = calculateInstantEffortPercUseCaseImpl(instantHr, maxHr)

        assertEquals(expected, actual!!, 0.0)
    }

    @Test
    fun `instant heart rate is greater than max heart rate`() {
        val instantHr = 200
        val maxHr = 150
        val expected = 1.3333333333333333

        val actual = calculateInstantEffortPercUseCaseImpl(instantHr, maxHr)

        assertEquals(expected, actual!!, 0.0)
    }

    @Test
    fun `instant heart rate is less than max heart rate`() {
        val instantHr = 100
        val maxHr = 150
        val expected = 0.6666666666666666

        val actual = calculateInstantEffortPercUseCaseImpl(instantHr, maxHr)

        assertEquals(expected, actual!!, 0.0)
    }
}