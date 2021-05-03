import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class HigherOrderFunctionAndLambdaTest {

    // This is a higher-order function
    private fun format(str: String, formatter: (String) -> String): String = formatter(str)

    @Test
    fun `test a higher-order function that uppercases a string that utilizes a reference to a lambda`() {
        val expected = "HELLO, WORLD"
        val initial = "hello, world"

        // This is a lambda - function literal
        val formatter: (String) -> String = { it.toUpperCase() }

        assertEquals(expected, format(initial, formatter))
    }

    @Test
    fun `test a higher-order function that lowercases a string that utilizes an anonymous function`() {
        val expected = "hello, world"
        val initial = "Hello, World"

        // This is an anonymous function - function literal
        val formatter = fun(value: String): String = value.toLowerCase()

        assertEquals(expected, format(initial, formatter))
    }

    @Test
    fun `test a higher-order function that returns a function`() {
        val order = Order(5)
        val expectedFreeCost = SubscriptionLevel.FREE.getSurcharge() + (1.99 * order.quantity)
        val expectedStandardCost = SubscriptionLevel.STANDARD.getSurcharge() + (1.99 * order.quantity)
        val expectedVipCost = SubscriptionLevel.VIP.getSurcharge() + (1.99 * order.quantity)

        // These calculators are functions
        val freeMembershipCalculator = ProductCostCalculator.calculateCost(SubscriptionLevel.FREE)
        val standardMembershipCalculator = ProductCostCalculator.calculateCost(SubscriptionLevel.STANDARD)
        val vipMembershipCalculator = ProductCostCalculator.calculateCost(SubscriptionLevel.VIP)

        assertEquals(expectedFreeCost, freeMembershipCalculator(order))
        assertEquals(expectedStandardCost, standardMembershipCalculator(order))
        assertEquals(expectedVipCost, vipMembershipCalculator(order))
    }

    @Test
    fun `test a lambda as a class extension`() {
        val initial = "Hello, World"
        val expected = "Hello, World!"
        val exclaimer: String.() -> String = { this.plus("!") }

        assertEquals(expected, initial.exclaimer())
    }
}

