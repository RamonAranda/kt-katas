package com.katas

sealed class Scale {
    abstract fun translate(number: Int): String
    abstract fun next(): Scale

    object Units : Scale() {
        override fun next(): Scale = Tens
        override fun translate(number: Int): String =
            when (number) {
                4 -> "IV"
                9 -> "IX"
                else -> "${if ((number / 5) >= 1) "V" else ""}${"I".repeat(number % 5)}"
            }
    }

    object Tens : Scale() {
        override fun next(): Scale = Hundreds
        override fun translate(number: Int): String =
            when (number) {
                4 -> "XL"
                9 -> "XC"
                else -> "${if ((number / 5) >= 1) "L" else ""}${"X".repeat(number % 5)}"
            }
    }

    object Hundreds : Scale() {
        override fun next(): Scale = Thousands
        override fun translate(number: Int): String =
            when (number) {
                4 -> "CD"
                9 -> "CM"
                else -> "${if ((number / 5) >= 1) "D" else ""}${"C".repeat(number % 5)}"
            }
    }

    object Thousands : Scale() {
        override fun next(): Scale = Thousands
        override fun translate(number: Int): String = "M".repeat(number)
    }
}
