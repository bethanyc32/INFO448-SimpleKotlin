package edu.uw.basickotlin

class Library {
    // This is just here as a placeholder, to make sure tests run and pass
    // before you add any code
    fun someLibraryMethod(): Boolean {
        return true
    }
}

// write a "whenFn" that takes an arg of type "Any" and returns a String

fun whenFn(arg: Any): String {
    when(arg) {
        "Hello" -> return("world")
        is String -> return("Say what?")
        0 -> return("zero")
        1 -> return("one")
        in 2..10 -> return("low number")
        is Int -> return("a number")
        else -> {
            return("I don't understand")
        }
    }
}

// write an "add" function that takes two Ints, returns an Int, and adds the values

fun add(val1: Int, val2: Int): Int {
    return(val1 + val2)
}

// write a "sub" function that takes two Ints, returns an Int, and subtracts the values

fun sub(val1: Int, val2: Int): Int {
    return(val1 - val2)
}

// write a "mathOp" function that takes two Ints and a function (that takes two Ints and returns an Int), returns an Int, and applies the passed-in-function to the arguments

fun mathOp(val1: Int, val2: Int, function: (Int, Int) -> Int): Int {
    return(function(val1, val2))
}

// write a class "Person" with first name, last name and age

class Person(var firstName: String, val lastName: String, var age: Int) {
    val debugString: String
    init {
        debugString = "[Person firstName:$firstName lastName:$lastName age:$age]"
    }
    fun createPerson(any: Person): String {
        return(debugString)
    }
}

// write a class "Money" with amount and currency, and define a convert() method and the "+" operator

class Money(var amount: Int, var currency: String) {
    init {
        if (currency != "USD" && currency != "EUR" && currency != "CAN" && currency != "GBP") {
            throw IllegalArgumentException("Currency not defined")
        } else if (amount < 0) {
            throw IllegalArgumentException("Invalid Amount")
        }
    }

    fun convert(newCurrency: String): Money {
        var newAmount = 0
        when (this.currency) {
            "USD" -> when (newCurrency) {
                "GBP" -> newAmount = 5
                "USD" -> newAmount = 10
                "EUR" -> newAmount = 15
                "CAN" -> newAmount = 15
            }

            "GBP" -> when (newCurrency) {
                "GBP" -> newAmount = 5
                "USD" -> newAmount = 10
                "EUR" -> newAmount = 15
            }

            "EUR" -> when (newCurrency) {
                "GBP" -> newAmount = 5
                "USD" -> newAmount = 10
                "EUR" -> newAmount = 15
            }

            "CAN" -> when(newCurrency) {
                "USD" -> newAmount = 12
            }
        }
        return Money(newAmount, newCurrency)
    }

    operator fun plus(other: Money): Money {
        var newMoney = other.convert(this.currency)
        return(Money(newMoney.amount + this.amount, this.currency))
    }
}