class ProductCostCalculator {
    companion object {
        // This function returns a function
        fun calculateCost(level: SubscriptionLevel): (Order) -> Double {
            return when (level) {
                SubscriptionLevel.STANDARD -> { order: Order -> SubscriptionLevel.STANDARD.getSurcharge() + (1.99 * order.quantity) }
                SubscriptionLevel.VIP -> { order: Order -> SubscriptionLevel.VIP.getSurcharge() + (1.99 * order.quantity) }
                else -> { order: Order -> SubscriptionLevel.FREE.getSurcharge() + (1.99 * order.quantity) }
            }
        }
    }
}