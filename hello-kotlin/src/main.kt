import java.lang.NumberFormatException
import java.util.*

// Getting started with Kotlin:
// immutability, string templates, if blocks, error handling

fun main(args: Array<String>) {
    println("Hello World")

    // Due to 'q' being set as a var, it is mutable.
    var q = Question()
    // we can reassign here
    q = Question()
    // but we cannot change the type once assigned. The next line is commented out
    // because the class won't compile as written
    // q: String = "some question"

    // val will set the property "anotherQuestion" to be immutable
    val anotherQuestion = Question()
    // The line below ill generate a compiler error:
  //    anotherQuestion = Question()
    q.answer = "42"
    // The line below will generate a compiler error.  The class field "Question" is defined as a val and is therefore immutable
    // q.Question = "Where is my pizza?"
    q.display()
    // this won't work as expected
    println("The answer is $q.answer")
    // the {} are required for any sort of expression evaluation
    println("The answer to '${q.question}' is ${q.answer}")

    // Kotlin allows you to do direct == comparisons on Strings.  No need for .equals
    if(q.answer == q.correctAnswer) {
        println("You were correct")
    } else {
        println("try again")
    }

    // This should produce the same result again, but we'll do something a little different
    // init a String variable
    var message: String
    // run the same code
    if (q.answer == q.correctAnswer) {
        message = "You were correct"
    } else {
        message = "try again"
    }
    println(message)
    // this can be refactored, because "if" is an expression, not a statement; * it returns a value*
    // the value that's returned is the value in the block following the if expression
    // This will give us the same result.  Also, we can make "anotherMessage" a val as we don't do any reassignment in the
    // if / else code blocks.  Immutability is better.
    val anotherMessage = if(q.answer == q.correctAnswer) "You were correct" else "try again"
    println(anotherMessage)

    // The 'when' statement in Kotlin.  See method body for the implementation
     q.printResult()

    // Using 'try' in Kotlin. If we tried to parse a non-parseable value, the application would exit
    // So we want to catch any parse errors and handle it properly.  Try/Catch is also an expression and
    // we can assign a value to it.  To test this out just swap the value of number to something like "four"
    val number:Int = try {
        Integer.parseInt(q.answer)
    } catch (e: NumberFormatException) {
        -1
    }
    println("The number is $number")

    // Kotlin's looping Constructs

    // use the range operator:
    for (intValue in 1..10) {
        print("$intValue, ")
    }
    println()
    // can also look like this:
    val myRange:IntRange = 1..10
    for (intValue in myRange) {
        print("$intValue, ")
    }
    println()

    // Change the step value
    for (intValue in myRange step 2) {
        print("$intValue, ")
    }
    println()

    // reverse the range
    for (intValue in 10 downTo 1) {
        print("$intValue, ")
    }
    println()

    // "While intValue is less than 10"
    for (intValue in 1 until 10) {
        print("$intValue, ")
    }
    println()

    //  lets try these with maps
    var ages = TreeMap<String, Int>()
    ages["Kevin"] = 55
    ages["Same"] = 43
    ages["Henry"] = 87
    ages["Joe"] = 17

    for ((name, age) in ages) {
        println("$name is $age")
    }

    // use the index:
    var someNumbers = listOf<Int>(1,2,3,4,5)
    for((index, element) in someNumbers.withIndex()) {
        print("$element is at index $index, ")
    }
    println()




}

class Question {
    var answer:String = ""
    val correctAnswer = "42"
    val question: String = "What is the answer to life, the universe and everything? "

    // String templates for simple variable
    fun display() {
        println("You said $answer")
    }

    // 'when' statement
    fun printResult() {
        when (answer) {
            correctAnswer -> {
                println ("You were correct")
            }
            else -> {
                println("Try again?")
            }
        }
    }
}
