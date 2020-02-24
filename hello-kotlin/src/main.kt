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
    q.Answer = "42"
    // The line below will generate a compiler error.  The class field "Question" is defined as a val and is therefore immutable
    // q.Question = "Where is my pizza?"
    q.display()
    // this won't work as expected
    println("The answer is $q.Answer")
    // the {} are required for any sort of expression evaluation
    println("The answer to ${q.Question}is ${q.Answer}")

    // Kotlin allows you to do direct == comparisons on Strings.  No need for .equals
    if(q.Answer == q.CorrectAnswer) {
        println("You were correct")
    } else {
        println("try again")
    }

    // This should produce the same result again, but we'll do something a little different
    // init a String variable
    var message: String
    // run the same code
    if (q.Answer == q.CorrectAnswer) {
        message = "You were correct"
    } else {
        message = "try again"
    }
    println(message)
    // this can be refactored, because "if" is an expression, not a statement; * it returns a value*
    // the value that's returned is the value in the block following the if expression
    // This will give us the same result.  Also, we can make "anotherMessage" a val as we don't do any reassignment in the
    // if / else code blocks.  Immutability is better.
    val anotherMessage = if(q.Answer == q.CorrectAnswer) "You were correct" else "try again"
    println(anotherMessage)





}



class Question {
    var Answer:String = ""
    val CorrectAnswer = "42"
    val Question: String = "What is the answer to life, the universe and everything? "

    // String templates for simple variable
    fun display() {
        println("You said $Answer")
    }
}
