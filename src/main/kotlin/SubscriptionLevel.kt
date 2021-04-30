enum class SubscriptionLevel {
    FREE {
        override fun getSurcharge(): Double = 10.99
    },
    STANDARD {
        override fun getSurcharge(): Double = 5.99
    },
    VIP {
        override fun getSurcharge(): Double = 0.99
    };

    abstract fun getSurcharge(): Double
}