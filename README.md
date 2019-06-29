# Kotlin in Action

- Kotlin is a statically typed language like Java.

# Want to Test your Kotlin Knowledge ?
[Click Me](https://git.target.com/DilipSundaraj/learn-kotlin/blob/master/learn-kotlin/kotlin-test.md)

## How Kotlin Differs from Java ?

Refer to the below bulletin which has the summary of how Kotlin is different from Java.

- **new** Keyword is redundant in Kotlin

```
//Java
Person person1 = new Person("Dilip", 123,"Engineer");

//Kotlin
 val person = Person("Dilip", 123,"Engineer")
```

- Kotlin supports **type-inference** which is a concept of automatically determining the type based on the value.

## Chapter 2 - Kotlin Basics

### Nutshell
- functions and variables
  - Functions declared in a kotlin file (not inside a Kotlin class) are called top-level functions.
- classes and Properties
- enums and when
  - when is an expression like **if**. It always returns a value.
- **is**
  - This is equivalent to **instanceOf** in Java.
- **as**
    - This is a **explicit** typecast.
    ```
    val n = e as Num
    ```
- **for** loop is different in kotlin. Check the example **LoopExample.kt** file.
- Map iterationa and manipulation
- Using “in” to check collection and range membership.
- Exception handling in kotlin        

- Kotlin has the concept of top level function where the function need not have to be in a **class**.

  - Check the **FunctionsExample.kt** file.

- Functions as expression Body using the **=**.

```
fun max2(a: Int, b: Int) = if (a>b) a else b
```  

**type inference**

- The ability of the compiler to determine types from context is called type inference.

- The below code determines does not declare the return type explicitly. But Kotlin does a good job of automatically determining the type.

```
fun max2(a: Int, b: Int) = if (a>b) a else b // type Inference. Kotlin determines the type based on the expression body
```

## Variables

**val**
- val (from value)—Immutable reference. A variable declared with val can’t be reassigned after it’s initialized.
- It corresponds to a final variable in Java.
- val properties are compiled into final fields that must be initialized in the constructor

**var**
- var (from variable)—Mutable reference. The value of such a variable can be changed.
- This declaration corresponds to a regular (non-final) Java variable.

### string templates

**Example 1**

- Use the **$** to access a variable.

```
val str ="Dilip";

//Invoke
println("str :  $str")
```

**Example 2**

- Use the **${}** to evaluate an expression and get the result.

```
fun returnStr(flag: Boolean): String {
    val message: String
    if (flag) {
        message = "Success"
        // ... perform the operation
    }
    else {
        message = "Failed"
    }
    return message;
}

//Invoke
println("returnStr: ${returnStr(true)}")

```

**Example 3**

- Escape a character using **\**.

```
var str2: String = "S\$abc"
println("str2 :  $str2")
```

## 2.2 Classes and Properties

### Access Modifiers

- In **Kotlin**, public is the default visibility.

- The below is the representation of a Value Object class.

```
class Person(val name: String)
```

### Functions

- You have the option to just import functions inside a class using the import keyword.

  - The below code just imports a function **max1**.
  ```
  import com.learnkotlin.functions.max1

  ```
-  **when** is the equivalent in Kotlin for **switch** in Java. (Check - 2.3.1 <-> 2.3.4 )

- **is** keyword is equivalent to **instanceOf**. (Check - 2.3.5)

  - Below is a **smartcast** which takes care of cheking the type and perform the case and gets you the value.

```
fun eval(e: Expr): Int {
    if(e is Num){ // check the type and performs the classcast to read the value.
        return  e.value;
    } else if(e is Sum){
        val n = eval(e.left) + eval(e.right);
        return  n
    }
    else
    throw IllegalArgumentException("Unknown Expression")
}
```

- Refactoring: replacing “if” with “when” (Check 2.3.6)
  - **if** always returns a value in kotlin.
  ```
  fun eval1(e: Expr): Int =
    if(e is Num)
        e.value
     else if(e is Sum)
        eval(e.left) + eval(e.right)
    else
        throw IllegalArgumentException("Unknown Expression")
  ```

  - Replacing **if** with **when**
  ```
  fun eval_refacrtored_if_with_when(e: Expr): Int =
          when(e){
              is Num -> e.value
              is Sum ->  eval_refacrtored_if_with_when(e.left) + eval(e.right)
              else -> throw IllegalArgumentException("Unknown Expression")
          }

  ```  
  - Adding Code Blocks in using the **{}** in the **is** check.
  ```
  fun eval_refacrtored_if_with_when_logging(e: Expr): Int =
        when(e){
            is Num -> {
                println("${e.value}")
                e.value
            }
            is Sum -> {
                println("${eval_refacrtored_if_with_when_logging(e.left)}")
                println("${eval_refacrtored_if_with_when_logging(e.right)}")
                eval_refacrtored_if_with_when(e.left) + eval(e.right)
            }
            else -> throw IllegalArgumentException("Unknown Expression")
        }

  ```
- A function can have either an expression body that can’t be a block or a block body with explicit return statements inside.

### While Loops and Ranges: (2.4.2)

- This is identical to Java.

- Iterating over a range of elements.
  - The syntax for that one is **..**
```
val oneToTen = 1..10
```
- Ranges in Kotlin are closed or inclusive, meaning the second value is always a part of the range.
- If you can iterate over all the values in a range, such a range is called a **progression**.

**FIZZBUZZ**

```
fun fizzBuzz(i : Int) = when {
    i%15 == 0 -> "FizzBuzz "
    i%3 == 0 -> "Fizz "
    i%5 == 0 -> "Buzz "
    else -> "$i "
}

fun main(args: Array<String>) {
    for (i in 1..100){
        println("${fizzBuzz(i)}")
    }
}
```

**Iterate Forward**

```
fun iterateForward(){
    for (i in 1..100){
        print("${fizzBuzz(i)}")
    }
}
```

**Iterate Backward**

```
fun iterateReverse(){
    for (i in 100 downTo 1){
        print("${fizzBuzz(i)}")
    }
    println()
    for (i in 100 downTo 1 step 2){ // step 2 here considers only the even numbers
        print("${fizzBuzz(i)}")
    }
}
```
### Iterating over maps (2.4.3)

- **TreeMaps** are sorted.
```
fun iterateOverMap() {
    val binaryReps = TreeMap<Char, String>()

    for (c in 'A'..'F') {
        binaryReps[c] = Integer.toBinaryString(c.toInt()) // populate a map with key and value
       // binaryReps.put(c, Integer.toBinaryString(c.toInt())) //Java Equivalent
    }
    for ((letter, binary) in binaryReps) { // accessing the key and value.
        println("$letter - $binary")
    }
}
```
### Iterating over List (2.4.3)

- **arrayListOf** takes elements as input and this gives you the output as list.

```
fun iterateOverList() {
    val list = arrayListOf("10","11","12") // creates a list of elements.
    for(element in list){
        println("$element")
    }
    for((index, element) in list.withIndex()){ // withIndex willl give you access to the index and actual value
        println("$index - $element")
    }
}
```

###  Using “in” to check collection and range membership (2.4.4)

 -  Using the **..** we can generate a range of elemets.
 -  Ranges aren’t restricted to characters, either. If you have any class that supports comparing instances (by implementing the java.lang.Comparable interface), you can create ranges of objects of that type

**Kotlin Implementation**

```
fun isValueAvailable(input: String) = input in "A".."C"

fun isNotDigit(c: Char) = c !in '0'..'9' // Under the hood it checks c<=0 amd c<=9

fun isLanguageAvailable(input: String) = input in arrayListOf("JAVA", "SCALA","GROOVY") // You can check Strings which has multiple characters too as part of this.

```

**Java Implementation**

```
static List<String> referenceList = Arrays.asList("A", "B", "C");

static Function<String, Boolean> isAvailable = (input) -> {
       return referenceList.contains(input);
   };
```

### Exception in kotlin (2.5.1)

- Exceptions are treated the same way in Kotlin.
- But in Kotlin you don't need to attach the throws after the function declaration.

```
fun isValuePresent(x: Int): Int{
    if(x !in 1..100)
        throw IllegalArgumentException("Value not present")
    else
        return x;
}

fun main(args: Array<String>) {

    println("${isValuePresent(100)}")
    println("${isValuePresent(101)}")
}
```

**try-catch**

- Below is the handle of tryCatch in Kotlin
```
fun tryCatch(x: String): Int {
    try {
        return x.toInt();
    }catch (e: NumberFormatException){
        throw e
    }finally {
        println("Method execution completed")
    }
}
```
## Chapter 3. Defining and calling functions

### Nutshell
- Kotlin doesn’t have its own set of collection classes.
  - Kotlin added lot of functionalities to play with the collections.
- **joinToString** is a handy method that performs string manipulations from the collection.
- **Named arguments** - Kotlin has the concept of named arguments where you can pass the name of the argument as part of the function call.
  ```
  println(list.joinToString( separator = ";", prefix = "(",postfix =  ")"))
  ```
- Kotlin has the concept of default parameters, if a value is not passed.
- All the top level functions when its compiled to byte code it takes of putting the function inside the kotlin file.
- Constants in kotlin are named using **const**.  
- The **extension function** is a simple thing: it’s a function that can be called as a member of a class but is defined outside of it.
- The **extension properties** are a similar concept to functions.
- **vararg**, **infix** and collection classes.
- Spread operator used to unpack the array elements.
```
val list = listOf("args", *args) //unpacks the args array and assign it to the list.
println(list)
```
- **infix** call is a method invocation of special kind.
- Strings and Regular Expressions.
  - split, regular expressions(regex) and triple quoted method.
- **triple quoted string**:  
  - The can help avoid the need to use escape characters.
  - This can handle the line breaks without having to provide the **\n** character.
  - You are not allowed to have the \n as part of the triple quoted string.
- Local function to avoid duplicating the code. Having a function inside a function.
```
fun validateUser(user : User): User{

    fun validateBeforeSave(value: String, fieldName : String){
        if(value.isEmpty())
            throw IllegalArgumentException("$fieldName is not present for the $user.id")
    }

    validateBeforeSave(user.firstName, "firstName")
    validateBeforeSave(user.lastName, "lastName")

    return user
}
```




### Create Collection in Kotlin (3.1)

```
val set = hashSetOf(1, 7, 53,7) //creates a Set
val list = arrayListOf(1, 7, 53) //creates a List
val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three") //creates a Map
val linkedMap = linkedMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

```


- Kotlin uses Java Collection classes.
- Kotlin doesn’t have its own set of collection classes.

```
println(set.javaClass)
```
- You can do much more with the collections that are created in kotlin. Check the below examples.

```
println("${list.last()}") // retrieves the last element from the list. This method is not available in Java.
println("${list.max()}") // returns the max element from the list. This is not available in java.
```

### MAKING FUNCTIONS EASIER TO CALL (3.2)

**joinToString**

- This is a method which can be used to override the default way of printing the list in the console.

```
println(list.joinToString(";", "(", ")"))
```

- In Kotlin, you can often **avoid creating overloads** because you can specify default values for parameters in a function declaration.

```
fun getName(name: String = "default") = name
println("${getName()}")
```
**OverLoaded Methods**

- In this below example Kotlin can understand that only age is being passed. Because if you take a look at it while invoking we are passing the parameter too so that can understand that it will just use the default value for the other variable.
- The default values of the parameters are encoded in the function being called, not at the call site.

```
fun getNameAndAge(name: String = "default" , age: Int = 0) = name +"-"+ age
println("${getNameAndAge(age = 10)}");

```

### Getting rid of static utility classes: top-level functions and properties(3.2.3)
- We all know that Java, as an object-oriented language, requires all code to be written as methods of classes.

- In Kotlin, you don’t need to create all those meaningless classes. Instead, you can place functions directly at the top level of a source file, outside of any class. Such functions are still members of the package declared at the top of the file, and you still need to import them if you want to call them from other packages

- When the **class** is not part of the file then JVM still creates a Kotlin class file after compilation.
- The **top-level** functions are compiled to static functions of that class.

**How to change the Kotlin File Name?**

- Using the **@file** option we get some options to override it. Using the below syntax we can change the **Kotlin** file name.

```
@file:JvmName("Collections")
package com.learnkotlin.collection
```

- Just like **functions**, properties can also be placed at the top of the file. The value of such a property will be stored in a static field.

```
package com.learnkotlin.collection
var count=0 // top level variable.
```

- Declaring a constant final variable in **Kotlin**.

```
const val finalCount = 10;
```

### ADDING METHODS TO OTHER PEOPLE’S CLASSES: EXTENSION FUNCTIONS AND PROPERTIES (3.3)

**extension function**

- It’s a function that can be called as a member of a class but is defined outside of it.

```
fun String.lastChar(): Char = this.get(this.length - 1)
println("The Last Char is : ${"Dilip".lastChar()}");
```
- The above declaration can be simplified with **this**.

```
fun String.lastCharSimple(): Char = get(length - 1)
println("The Last Char is : ${"Dilip".lastCharSimple()}")
```

- In the extension function, you can directly access the methods and properties of the class you’re extending, as in methods defined in the class itself.

**Imports and extension functions** (3.3.1)

- When you define an extension function, it doesn’t automatically become available across your entire project.

```
import com.learnkotlin.functions.lastChar as last // you can do this if you have multiple with the same name.

fun main(args: Array<String>) {

    println("${"Dilip".last()}")
}
```
-  For regular classes or functions, you have another choice in this situation: You can use a fully qualified name to refer to the class or function.

**Calling extension functions from Java (3.3.2)**

- Under the hood, an extension function is a static method that accepts the receiver object as its first argument

**Utility functions as extensions (3.3.3)**

- An Extension functions are effectively syntactic sugar over static method calls

**No overriding for extension functions**

- Method overriding in Kotlin works as usual for member functions, but **you can’t override an extension function**.

- Extension functions aren’t a part of the class; they’re declared externally to it. Even though you can define extension functions with the same name and parameter types for a base class and its subclass, the function that’s called depends on the declared static type of the variable, not on the runtime type of the value stored in that variable.

- If the class has a member function with the same signature as an extension function, the member function always takes precedence.

**Extension properties (3.3.5)**
- Even though they’re called properties, they can’t have any state, because there’s no proper place to store it

```
val String.lastChar1: Char
    get() = get(length - 1) // This is how you add a getter method to a property.

var StringBuilder.lastChar2: Char
  get() = get(length - 1)
  set(value: Char){  // This is how you add a getter method to a property.
    this.setCharAt(length-1, value)
    }

//client
import com.learnkotlin.functions.lastChar1 as last1
import com.learnkotlin.functions.lastChar2 as last2

println("The Last Char is : ${"Dilip".last1}")
    var sb: StringBuilder = StringBuilder("Dilip")
    sb.last2 = 'A' // setting a new value
    println("The Last Char is : ${sb.last2}")    
```

###  WORKING WITH COLLECTIONS: VARARGS, INFIX CALLS, AND LIBRARY SUPPORT (3.4)

- The **vararg** keyword, which allows you to declare a function taking an arbitrary number of arguments
- An infix notation that lets you call some one-argument functions without ceremony
- Destructuring declarations that allow you to unpack a single composite value into multiple variables

**Extending the Java Collections API(3.4.1)**

-  All the new functionalities we saw like the below one are **extension functions**.

```
println("${list.last()}")
```
**Varargs (3.4.2)**

- Kotlin syntax is slightly different: instead of **three dots after the type**, Kotlin uses the **vararg** modifier on the parameter.

- **spread operator**
  - To construct an array from a list we need to unpack the elements and build a list.
  - This can be achieved by using the * operator which can be otherwise called as **spread operator**. Check the example below.

```
var arrayElements = arrayOf("A","B","C")
var list = listOf(*arrayElements) // converts the array to list.
println("List :  $list")
```
**Working with pairs: infix calls and destructuring declarations (3.4.3)**

- In an **infix call**, the method name is placed immediately between the target object name and the parameter, with no extra separators.

```
val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
```

- Creating a custom infix call.

```
infix fun String.stringConcat(str: String) = this+"-"+str

var output = "dilip" stringConcat "aish"
println("output is : $output")

```

### WORKING WITH STRINGS AND REGULAR EXPRESSIONS (3.5)

**Splitting Strings(3.5.1)**

- In java to split a string by **.** we have to provide the regex expression. But is not called out clearly.

```
String[] result = "di.lip".split("\\.");
```
- In Kotlin it is called out clearly. This is more readable.

```
println("di.lip".split("\\.".toRegex()))
println("di.lip".split(".")) // for simple expressions you dont need regex. This works only in kotlin not in Java.

```

**Regular Expressions and Triple Quoted Strings(3.5.2)**

- **Kotlin** has lot of handy new extension functions that got introduced as part Kotlin. Some new methods are used in the below example.

```
fun parsepath(str: String): String {
    var filePath = str.substringBeforeLast("/")
    var fullName = str.substringAfterLast("/")
    var fileName = fullName.substringBeforeLast(".")
    var extension = fullName.substringAfterLast(".")
    println("The values are filePath $filePath , fileName $fileName and the extension is $extension")
    return filePath+fileName+extension
}
```

**triple quoted Strings**

- The regex expression below uses **"""**. Using this we can encode the dot symbol using the **\.** instead of a **\\.**.
- The triple quoted string is basically used to avoid the escape character in the expression.

```
fun parsePathRegex(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        println("Dir: $directory, name: $filename, ext: $extension")
    }
}

```

**Multiline triple-quoted strings (3.5.3)**

- Triple quoted strings is not only used to avoid escape character. This also helps to avoid the the line breaks.

```
val kotlinLogo = """| //
                     .|//
                     .|/ \"""

  println(kotlinLogo.trimMargin("."))
```

- **trim-Margin** is used to remove the white spaces to represent the String better.

- You can also use **string templates** in triple quoted strings.

- **Extension Functions** are the way to extend the existing libraires.
- **Kotlin** heavily uses the extension functions and the standard library is made up of extension functions.

###  MAKING YOUR CODE TIDY: LOCAL FUNCTIONS AND EXTENSIONS (3.6)

**local functions**
- This is the approach kotlin uses to avoid the code duplication. **Don't Repeat Yourself(DRY)**.

```
fun validateUser(user : User): User{
    fun validateBeforeSave(value: String, fieldName : String){
        if(value.isEmpty())
            throw IllegalArgumentException("$fieldName is not present for the $user.id")
    }
    validateBeforeSave(user.firstName, "firstName")
    validateBeforeSave(user.lastName, "lastName")

    return user
}

val user = validateUser(User(1, "Dilip","Sundarraj"))
println("User is ${user.id} - ${user.firstName} - ${user.lastName}")
val user1 = validateUser(User(1, "",""))
println("User is ${user1.id} - ${user1.firstName} - ${user1.lastName}")

```

## Chapter 4. Classes, objects, and interfaces

### 4.1. DEFINING CLASS HIERARCHIES

**4.1.1. Interfaces in Kotlin**

-  Kotlin interfaces are similar to those of Java 8: they can contain definitions of abstract methods as well as implementations of non-abstract methods (similar to the Java 8 default methods), but they can’t contain any state.

- Kotlin uses the colon after the class name to replace both the extends and implements keywords used in Java.

**Interface**

```
package com.learnkotlin.interfaces

interface Clickable {

    fun click()
    fun click1() = println("Inside click1 Clickable")
}  
```
**Implementation Class**

```
package com.learnkotlin.interfaces

class Button : Clickable {

    override fun click() {
        println("Button got clicked ")
    }

    override fun click1() = println("Inside click1 Button") //  You can override the default implementation.
}

fun main(args: Array<String>) {
    Button().click()
}
```

- Unlike Java, using the override modifier is mandatory in Kotlin.

**Implementing interfaces with method bodies in Java**

- Kotlin 1.0 has been designed to target Java 6, which doesn’t support default methods in interfaces.
- Therefore, it compiles each interface with default methods to a combination of a regular interface and a class containing the method bodies as static methods.

**4.1.2. Open, final, and abstract modifiers: final by default**
- Java allows you to create subclasses of any class, and to override any method, unless it has been explicitly marked with the final keyword.

- If you want to allow the creation of subclasses of a class, you need to mark the class with the **open** modifier.

**Base Class**
```
open class InputBox { // open keyword allows this class to be extended.

    open fun input(){ // open keyword allows this method to be overriden.
        println("input method in InputBox")
    }

    fun type(){
        println("input method in InputBox")
    }
}
```
**Sub Class**
```
open class RichInputBox : InputBox() {

    override fun input(){
        println("input method in InputBox")
    }

}
```

**Open classes and smart casts**

- Smart casts can only be used with a class property that is a val and that doesn’t have a custom accessor. This requirement means the property has to be final, because otherwise a subclass could override the property and define a custom accessor, breaking the key requirement of smart casts.

**Abstract Classes**

- An abstract class usually contains abstract members that don’t have implementations and must be overridden in subclasses.
- Abstract members are always **open**, so you don’t need to use an explicit open modifier.

```
package com.learnkotlin.classes

abstract class Animated {

    abstract fun animate() // the class that extends this abstract should implement this method.

    open fun animating(){ // Feel free to override this method
        println("Inside animating")

    }

    fun animateTwice(){ // methods in kotlin is final by default. This cant be overridden.

        println("Inside animateTwice")
    }
}
```

**4.1.3. Visibility modifiers: public by default**

- You have the same **public**, **protected**, and **private** modifiers.
- But the default visibility is different: if you omit a modifier, the declaration becomes **public**.
-  Kotlin offers a new visibility modifier, **internal**, which means “visible inside a module.” A module is a set of Kotlin files compiled together. It may be an IntelliJ IDEA module, an Eclipse project, a Maven or Gradle project, or a set of files compiled with an invocation of the Ant task.
- Another difference is that Kotlin allows the use of **private** visibility for top-level declarations, including classes, functions, and properties. Such declarations are visible only in the file where they are declared.
- Check this table **Table 4.2. Kotlin visibility modifiers** in the book.

```
internal open class Talkative {
    private fun yell() = println("YELL")
    protected fun whisper() = println("WHISPER")
    fun speak() = println("SPEAK")
}
```

- Any class that trying to extend the behavior should be internal too. Check the example below.
```
internal class TalkativeExtend : Talkative() {
}
val talkative = Talkative();
   println(talkative.speak())

```

**Kotlin’s visibility modifiers and Java**

- public, protected, and private modifiers in Kotlin are preserved when compiling to Java bytecode. You use such Kotlin declarations from Java code as if they were declared with the same visibility in Java.
-

**4.1.4. Inner and nested classes: nested by default**

- The difference is that Kotlin nested classes don’t have access to the outer class instance, unless you specifically request that.

- Please read this section in this book.

**4.1.5. Sealed classes: defining restricted class hierarchies**

- In the below code it is mandatory by default to have the else block. The compiler will complain if you remove the **else** block from the below code.
```
interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right:  Expr) : Expr

fun eval_refacrtored_if_with_when(e: Expr): Int =
        when(e){
            is Num -> e.value
            is Sum ->  eval_refacrtored_if_with_when(e.left) + eval(e.right)
            else -> throw IllegalArgumentException("Unknown Expression")
        }
```
- There are some issues with the above code. If you have a new class for the interface **Expr** then there is no way for the above code to realise that a new check needs to added in the **when** block.

- The above problem can be solved using the concept of **sealed** classes.

```
sealed class Expr { // sealed keyword makes sure that all the subclasses should sit in the

    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}
```

- Kotlin provides a solution to this problem: sealed classes. You mark a superclass with the sealed modifier, and that restricts the possibility of creating subclasses. All the direct subclasses must be nested in the superclasses.

- With sealed classes you don't need the mandatory default block while using the **when** clause.

```
package com.learnkotlin.classes

import com.learnkotlin.classes.Expr
import com.learnkotlin.classes.Expr.Num
import com.learnkotlin.classes.Expr.Sum

sealed class Expr { // sealed keyword makes sure that all the subclasses should sit in the

    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}

fun eval(e: Expr): Int {
    if(e is Num){
        return  e.value;
    } else if(e is Sum){
        val n = eval(e.left) + eval(e.right);
        return  n
    }
    else
        throw IllegalArgumentException("Unknown Expression")
}


fun eval_refacrtored_if_with_when(e: Expr): Int =
        when(e){
            is com.learnkotlin.classes.Expr.Num -> e.value
            is Sum ->  eval_refacrtored_if_with_when(e.left) + eval(e.right)
        }
```

**Client Code**
```
package com.learnkotlin.classes

import com.learnkotlin.classes.Expr.Num
import com.learnkotlin.classes.Expr.Sum

fun main(args: Array<String>) {

    println("Actual Result : ${com.learnkotlin.classes.eval(Sum(Sum(Num(1), Num(2)), Num(4)))}");

}

```

### 4.2. DECLARING A CLASS WITH NONTRIVIAL CONSTRUCTORS OR PROPERTIES

- **primary constructor** (which is usually the main, concise way to initialize a class and is declared outside of the class body) and a **secondary constructor** (which is declared in the class body).

```
class User(val nickname: String)
```
- The above single line declaration make creates an object and initialized the property with the value passed to the class.

**approach 1**
```
val user = User("Dilip")
println("user ${user}")

```
**approach 2**
```
class Person (_name: String){
    val name = _name
}

```

**4.2.2. Secondary constructors: initializing the superclass in different ways**
```
class Student {
     var age: Int
    var name: String

    constructor(_age: Int) : this (_age, "default"){
        age = _age
    }
    constructor(_age: Int, _name: String){
        age = _age
        name = _name
    }
}
```

**4.2.3. Implementing properties declared in interfaces**

- Interfaces in kotlin are allowed to have property declaration.

```
interface User {
    val nickname: String
}

class PrivateUser(override val nickname: String) : User // setting the interface property

class SubscribeUser(val _name : String) : User {

    override val nickname : String //// setting the interface property using a different syntax
        get() = _name
}
```
- It is the responsibility of the implementing class to override and set the property defined in the interface.

**4.2.4. Accessing a backing field from a getter or setter**

- The below code has different ways of writing custom accessors.
- **field** which is backing field is the only way to that a custom accessor can use.
```
class User(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println("""Address was changed from $name: "$field" -> "$value".""".trimIndent()); // the field gives you the access of the previous value.
                    field = value
            //println("Address was changed from $name: $field -> $value"); // the field gives you the access of the previous value.
            field = value
        }
        get() = field.plus("dilip") // field is the only way to access the getter and setter methods of Kotlin.

    var age : Int =0

}

fun main(args: Array<String>) {

    val user = User("dilip")
    user.age = 32
    user.address = "Apple Valley"
    println("User is $user , ${user.age} , ${user.address}" )
    user.address = "Eagan"
}
```

**4.2.5. Changing accessor visibility**

- Read the comments in the code to understand about **private** access modifier for a set method.
```
class LemgthCounter {
    var counter: Int =0
        private  set // this will block this value to be set from any other class.

    fun addCounter(word: String){
        counter += word.length // this is allowed because we are modifying the value from the class itself
    }

}

fun main(args: Array<String>) {
    val lemgthCounter = LemgthCounter()
//    lemgthCounter.counter = 3 // compilation issue
    lemgthCounter.addCounter("dilip")
    lemgthCounter.addCounter("dilip")
    println(lemgthCounter.counter)
}
```
### 4.3. COMPILER-GENERATED METHODS: DATA CLASSES AND CLASS DELEGATION

**4.3.1. Universal object methods**

- In Kotlin, the **==** operator is the default way to compare two objects: it compares their values by calling equals under the hood.Thus, if equals is overridden in your class, you can safely compare its instances using **==**.

**Example - Overriding Equals**
```
class Client(val name: String, val postalCode: Int){
    override fun toString(): String = "Client (name : ${name} - Postal Code : ${postalCode})"
    override fun equals(client2: Any?): Boolean {
        if(client2!=null && client2 is Client) //is check in Kotlin is the analogue of instanceof in Java
            return client2.name == name && client2.postalCode==postalCode
        else if (client2 !is Client) // takes care of handling null check too
           return false
        else
            return false
    }
}

fun main(args: Array<String>) {

    var client = Client("dilip", 55124)
    var client1 = Client("dilip", 55124)
    println("Client is : ${client}")
    println("Are these clients equal : ${client == client1}")
}
```

**Example - Overriding HashCode**

- This is mandatory when you are doing complex comparisons like below.

```
fun hashCodeComparisonUsingHashset(client1 : Client, client2:Client) : Boolean {
    val hashSet = hashSetOf<Client>(client1)
    return hashSet.contains(client2);
}

fun main(args: Array<String>) {

    var client = Client("dilip", 55124)
    var client1 = Client("dilip", 55124)
    println("hashCodeComparisonUsingHashset : ${hashCodeComparisonUsingHashset(client,client1)}") // returns false by default. We need to override the hashcode and equals method to make it work.

}
```

**4.3.2. Data classes: autogenerated implementations of universal methods**

```
data class User(val name: String, val age: Int)
```

- equals for comparing instances.
- hashCode for using them as keys in hash-based containers such as HashMap.
- toString for generating string representations showing all the fields in declaration order.

```
data class User(val name: String, val age: Int)

fun hashCodeComparisonUsingHashset(user1 : User, user2 :User) : Boolean {
    val hashSet = hashSetOf<User>(user1)
    return hashSet.contains(user2);
}

fun main(args: Array<String>) {

    val user1 = User("dilip", 32)
    val user2 = User("dilip", 32)
    val result = user1 == user2

    println("Comparing two objects using Hashset : ${hashCodeComparisonUsingHashset(user1,user2)}")
    println("Comparing two objects using the == :  $result ")
}
```
**copy() method**

- The copy method that comes with the data class takes care of creating without affecting the original object.

```
val user3  = user1.copy(age = 40);
   println("The new object is $user3")
```

**4.3.3. Class delegation: using the “by” keyword**

-  All classes in kotlin are **final** by default.
- If you have an interface thats already implemented by the one of the class.
- But often you need to add behavior to another class, even if it wasn’t designed to be extended. A commonly used way to implement         this is known as the **Decorator** pattern.
- If the other class implements the interface then all the methods needs to be implemented and its not required.
- Kotlin has the way to handle it by using the **by** operator.   

```
open class Button : Clickable, Focusable {
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }

    override fun focus() {
       println("Focus is correct")
    }

    override fun click() {
        println("Button got clicked ")
    }

    override fun click1() = println("Inside click1 Button") //  You can override the default implementation.
}

class ClickableImpl(val button : Button = Button()) : Clickable by button { // Button is the other implementation class.
    override fun click() {
        println("Inside ClickableImpl click")
    }
}

fun main(args: Array<String>) {

    val clickable = ClickableImpl()
    println(clickable.click())
    println(clickable.click1())

}
```

### 4.4.THE “OBJECT” KEYWORD: DECLARING A CLASS AND CREATING AN INSTANCE, COMBINED

- The **object** keyword defines a class and creates an instance (in other words, an object) of that class at the same time.
  - Object declaration is a way to define a **singleton**.
  - Companion objects can contain factory methods and other methods that are related to this class but don’t require a class instance to be called.Their members can be accessed via class name.                                       
  - Object expression is used instead of Java’s anonymous inner class.

**4.4.1. Object declarations: singletons made easy**

- The object declaration combines a class declaration and a declaration of a single instance of that class.
- Object declarations are introduced with the object keyword. An object declaration effectively defines a class and a variable of that class in a single statement.

```
object Payroll {
    val allEmployees = arrayListOf<User>()

    fun addUser(user: User) = allEmployees.add(user)

    fun printAllEmployees() {
        for (person in allEmployees) {
            println("${person}")
        }
    }
}

fun main(args: Array<String>) {

    Payroll.addUser(User(1, "Dilip", "Sundarraj"))
    Payroll.addUser(User(1, "Aish", "Gurudev"))
    Payroll.printAllEmployees()

}
```
- The only things that aren’t allowed are constructors (either primary or secondary).
- Unlike instances of regular classes, object declarations are created immediately at the point of definition, not through constructor calls from other places in the code.
- Object declarations can also inherit from classes and interfaces.
- In this example we have used the object keyword for implementing the interface Comparator. This makes sense here to behave like a singleton because its not going to hold on to any state in it.

```
data class Person(val name: String) {
    object NameComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int =
                p1.name.compareTo(p2.name)
    }
}
```
- Any classes are allowed to have the object class declaration inside it.
- An object declaration in Kotlin is compiled as a class with a static field holding its single instance, which is always named INSTANCE.

**4.4.2. Companion objects: a place for factory methods and static members**

- Classes in Kotlin can’t have **static** members; Java’s **static** keyword isn’t part of the Kotlin language.
- In most cases, it’s recommended that you use top-level functions. But top-level functions can’t access private members of a class.
- You cannot have more than one companion object in a class.
```
class CompanionExample{
    companion object {
        fun bar(){
            println("inside bar")
        }
    }
}
fun main(args: Array<String>) {

    CompanionExample.bar()
}
```
- The companion object has access to all private members of the class, including the private constructor, and it’s an ideal candidate to implement the Factory pattern.
- Companion objects are used to behave as a factory method in Kotlin.

- Companion objects can access all the private members of the class.
```
class Car private constructor(val model : String){

    companion object  {
        fun newCar( cmodel: String) : Car{
            return Car(cmodel)
        }
    }
}
```

**4.4.3. Companion objects as regular objects**

- A companion object is a regular object that is declared in a class. It can be named, implement an interface, or have extension functions or properties.

- Companion Object with a **name**.
```
class Employee {

    companion object Payroll {
        val allEmployees = arrayListOf<User>()

        fun addUser(user: User) = allEmployees.add(user)
    }
}

```
- But you may need to work with Java code that requires a member of your class to be static. You can achieve this with the @JvmStatic annotation on the corresponding member. If you want to declare a static field, use the @JvmField annotation on a top-level property or a property declared in an object.

- You can write extension functions on the companion object also.

```
fun Employee.Payroll.size(users : ArrayList<User> ) = users.size

println("Extension Function size ${Employee.size(Employee.allEmployees)}")
```

**4.4.4. Object expressions: anonymous inner classes rephrased**

- The object keyword can be used not only for declaring named singleton-like objects, but also for declaring anonymous object
- Check the book for this one to learn more about it.

## Chapter 5. Programming with lambdas

- Lambda expressions, or simply lambdas, are essentially small chunks of code that can be passed to other functions

### 5.1. LAMBDA EXPRESSIONS AND MEMBER REFERENCES

- Functional programming offers you another approach to solve this problem: the ability to treat functions as values.
- Instead of declaring a class and passing an instance of that class to a function, you can pass a function directly.

### 5.1.2. Lambdas and collections

- Find a User with bigger id.

```
val users = listOf(User(1,"dilip","sundarraj"), User(2,"scooby","dilip"))
println(users.maxBy { it.id }) // it is value to access each element separately.
```
- The same code can be written like below with a much verbose syntax like below .

### 5.1.3. Syntax for lambda expressions

```
val sum = { x: Int, y: Int -> x + y }

fun main(args: Array<String>) {
    println(sum(1, 2))
}
```
- Kotlin's type inference takes care of avoiding the need to mention the type.

```
println(users.maxBy({ u: User -> u.id})) // approach 2 without syntax shortcuts
```

- In Kotlin, a syntactic convention lets you move a lambda expression out of parentheses if it’s the last argument in a function call

```
people.maxBy() { p: Person -> p.age }
```

- In Kotlin, a syntactic convention lets you move a lambda expression out of parentheses if it’s the last argument in a function call

```
people.maxBy { p: Person -> p.age }
```
**inline LAMBDA function**

```
run { println(42)} //
```

**Lambda with named parameters**

##### Approach 1

```
println(people.joinToString(" ", transform = {p: Person -> p.name})) // names are separated by a space.
```

##### Approach 2
```
println(people.joinToString(" ")  {p -> p.name}) // type need not have to be mentioned.
```

- The last simplification you can make in this example is to replace a parameter with the default parameter name: **it**.
- This name is generated if the context expects a lambda with only one argument.

##### Approach 3
```
println(people.joinToString(" ")  {it.name})
```

**Lambdas with multiple Parameters**

- Comparing the below code with Java.
  -  **return** keyword is not needed.
  - You dont need curly braces for multiline code in a lambda expression.

```
val sum = { x: Int, y: Int ->
    println("input values are $x and $y")
    x + y
}
```

### 5.1.4. Accessing variables in scope

```
fun printMessagesWithPrefix(messages: Collection<String>, prefix: String){
    messages.forEach {
        println("$prefix : $it ")
    }
}
```

**Capturing a mutable variable: implementation details**

```
var counter = 0
val inc = { counter++ }

println(inc()) // access the lamda like a funciton call.

```

### 5.1.5. Member references

```
println(users.maxBy(User::id))
```

- Below call is the way we use the run method to invoke a method.
```
fun hello() = println("hello")
run(::hello)
run({ hello()})

```

**constructor reference**

```
val createUser = ::User
val user = createUser(1 , "dilip", "sundarraj")
```

**Bound References**

-

## 5.2. FUNCTIONAL APIS FOR COLLECTIONS

**filter**
```
fun filter(){
    println(numberList.filter { i -> i %2 ==0 })
}
```

**map**

**maxAge**
```
val maxAge = employees.maxBy(Employee::age)?.age
println(employees.filter { it.age == maxAge})
```

### 5.2.2. “all”, “any”, “count”, and “find”: applying a predicate to a collection

```
val employees = listOf(Employee("scooby",2),Employee("dilip",32),Employee("aish",28))
val employeeAboveAge2 = { e:Employee -> e.age>2}

println(employees.all(employeeAboveAge2))
println("Employees above age 2 : !${employees.find(employeeAboveAge2)}") // returns the first element that matches it.
println(employees.any(employeeAboveAge2))
println(employees.find(employeeAboveAge2))
println(employees.count(employeeAboveAge2))
```

### 5.2.3. groupBy: converting a list to a map of groups

```
fun groupBy(){

    println(employees.groupBy(Employee::age))
}
```

### 5.2.4. flatMap and flatten: processing elements in nested collections

```
fun flatmap(){

    println(students.flatMap { it.activities.toList() })
    println("distinct activities are ${students.flatMap { it.activities}
            .distinct()
            .toList()
    }")
}
```

### 5.3. LAZY COLLECTION OPERATIONS: SEQUENCES

- The below code is one of the common pattern of applying filter, map operation.
- The intermediate operations are eagerly and it creates a list. This is one of the key difference between **Java** and **Kotlin**. In Java nothing starts without invoking the terminal operation.
- The filter and map operation creates an intermediate result which worls great for list of smaller elements.
- If the number of elements are million then it wont perform really well for the below code.

```
fun collectionWithoutSequence(){
    val namewithPList = employees.map(Employee::name) // creates an intermediate list
            .filter { it.contains("p") } // creates an intermediate list
    println(namewithPList)
}
```

- We can make it better by applying the **Sequences**

```
fun collectionWithSequence(){
    val namewithPList = employees.asSequence()
            .map(Employee::name) // creates an intermediate list
            .filter { it.contains("p") } // creates an intermediate list
    println(namewithPList)
}
```


### 5.3.1. Executing sequence operations: intermediate and terminal operations

- The naive approach would be to call the map function on each element first and then call the filter function on each element of the resulting sequence.

- This talks about terminal operation and

**Streams vs. sequences**
- If you’re targeting Java 8, streams give you one big feature that isn’t currently implemented for Kotlin collections and sequences: the ability to run a stream operation (such as map or filter) on multiple CPUs in **parallel**.

### 5.3.2. Creating sequences

```
val generate = generateSequence(0) { it+1 }
val until100 = generate.takeWhile { it<=100 }

```

### 5.4. USING JAVA FUNCTIONAL INTERFACES

- Read this whole section in the book.

### 5.5. LAMBDAS WITH RECEIVERS: “WITH” AND “APPLY”

- The ability to call methods of a different object in the body of a lambda without any additional qualifiers. Such lambdas are called lambdas with receivers.

**5.5.1. The “with” function**
- Many languages have special statements you can use to perform multiple operations on the same object without repeating its name. Kotlin also has this facility, but it’s provided as a library function called **with**.

```
fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know the alphabet!")
    return result.toString()
}
```
**Using with receiver**

```
fun alphabetusingWith() : String{

    val result = StringBuilder()
    return with(result){
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        append("\nNow using with")
        this.toString()
    }
}

```
-  A lambda with a receiver is a way to define behavior similar to an extension function.

- The below example avoids the use of **this** keyword which simplifies it much further.

```
fun alphabetusingWithSimplified() : String{

    return with(StringBuilder()){
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow using with Simplified")
        toString()
    }
}

```

**5.5.2. The “apply” function**

```
fun alphabetApply() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet using apply!")
}.toString()
```
- The apply function is declared as an extension function of StringBuilder().

- The **with** and **apply** functions are basic generic examples of using lambdas with receivers.

## Chapter 6. The Kotlin type system

### 6.1. NULLABILITY

- Nullability is a feature of the Kotlin type system that helps you avoid NullPointer-Exception errors.

**6.1.1. Nullable types**

- Kotlin’s explicit support for nullable types.
- If a variable can be null, calling a method on it isn’t safe, because it can cause a **NullPointerException**.

```
fun strLen(s: String) = s.length

fun main(args: Array<String>) {
    strLen(null) // compiler will complain on this one.
}
```
- Adding **?** allows the caller to pass null.

```
fun strLen(s: String?) = s.length //this is still not allowed
```
-  Adding the null makes the compiler happy and below is the final code.
```
fun strLen(s: String?) = if(s!=null) s.length else 0
```

**6.1.2. The meaning of types**

- Read the book for this one. The content is really good for this one.

- Distinguishing nullable and non-null types provides a clear understanding of what operations are allowed on the value and what operations can lead to exceptions at runtime and are therefore forbidden.
- Objects of nullable or non-null types at runtime are the same; a nullable type isn’t a wrapper for a non-null type. All checks are performed at compilation time

**6.1.3. Safe call operator: “?.”**

- If it’s null, the call is skipped, and null is used as the value instead

```
fun strLenusingSafeCall(s: String?) = s?.length
```
- Safe calls can be used for accessing properties as well, not just for method calls.

```
class Car(val name : String, val user: User?)
fun carUser(car: Car) =  car?.user
fun strLenusingSafeCall(s: String?) = s?.length

```

**6.1.4. Elvis operator: “?:”**

- **Kotlin** has a handy operator to provide default values instead of null. It’s called the **Elvis** operator (or the null-coalescing operator.

```
fun strLenSafe(s: String?): Int = s?.length ?: 0
```

**6.1.5. Safe casts: “as?”**
- The as? operator tries to cast a value to the specified type and returns null if the value doesn’t have the proper type

```
fun castAs(expr: Expr?) : Num? {
    return expr as? Num
}
```

**6.1.6. Not-null assertions: “!!”**

- The not-null assertion is the simplest and bluntest tool Kotlin gives you for dealing with a value of a nullable type.

- This **!!** validates the value is null and if its null then it will thrown an exception.

```
fun ignoreNull(s: String?){
    val sNotNull : String =s!!
    println(sNotNull.length)
}
```

**6.1.7. The “let” function**

- All the let function does is turn the object on which it’s called into a parameter of the lambda.
- Lets say you want to use the value after the non null is evaluated then use the **let** function.

```
fun letExample(str: String?) : Int?{
    str?.let { return it.length}
    return null
}
```

**6.1.8. Late-initialized properties**

- A late-initialized property is always a var.

- A common use case for lateinit properties is dependency injection. In that scenario, the values of lateinit properties are set externally by a dependency-injection framework.

- Example in the book is really good. Look at it.

**6.1.9. Extensions for nullable types**

- When you define your own extension function, you need to consider whether you should define it as an extension for a nullable type.

```
val isNull = { s : String -> s.isNullOrBlank()}
```

- In the above example, even though we are sending the null as an input it does not throw the null pointer exception. Because the above check invokes the extension function not a function call on the method reference.

**6.1.10. Nullability of type parameters**

-  By default, all type parameters of functions and classes in Kotlin are nullable. Any type, including a nullable type, can be substituted for a type parameter; in this case, declarations using the type parameter as a type are allowed to be null.

```
fun printHashCode(t: Any?){
    println(t?.hashCode())
}
```

**6.1.11. Nullability and Java**

- So what happens when you combine Kotlin and Java? Do you lose all safety, or do you have to check every value for null? Or is there a better solution?

- @Nullable String in Java is seen as String? by Kotlin, and @NotNull String is just String.

- The interesting question is what happens when the annotations aren’t present. In that case, the Java type becomes a **platform type** in Kotlin.

- A platform type is essentially a type for which Kotlin doesn’t have nullability information; you can work with it as either a nullable or a non-null type (see figure 6.9). This means, just as in Java, you have full responsibility for the operations you perform with that type.

**Example**

```
public class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
```
```
fun getPersonName(person: Person){

    println(person.name.toUpperCase())

}
```
- Instead of the null pointer exception in the above case we have the below information.

```
Exception in thread "main" java.lang.IllegalStateException: person.name must not be null
	at com.learnkotlin.chapter6.NullabaleTypesKt.getPersonName(NullabaleTypes.kt:53)
	at com.learnkotlin.chapter6.NullabaleTypesKt.main(NullabaleTypes.kt:74)
```
- In fact, for public Kotlin functions, the compiler generates checks for every parameter (and a receiver as well) that has a non-null type, so that attempts to call such a function with incorrect arguments are immediately reported as exceptions. Note that the value-checking is performed right away when the function is called, not when the parameter is used.

- Let’s summarize our discussion of nullability. We’ve discussed nullable and non-null types and the means of working with them: operators for safe operations (safe call ?., Elvis operator ?:, and safe cast as?), as well as the operator for unsafe dereference (the not-null assertion !!). You’ve seen how the library function let can help you accomplish concise non-null checks and how extensions for nullable types can help move a not-null check into a function

### 6.2. PRIMITIVE AND OTHER BASIC TYPES

- Kotlin doesn’t differentiate primitive types and wrappers.

**6.2.1. Primitive types: Int, Boolean, and more**

- As you know, Java makes a distinction between primitive types and reference types. A variable of a primitive type (such as int) holds its value directly. A variable of a reference type (such as String) holds a reference to the memory location containing the object.

- Kotlin doesn’t distinguish between primitive types and wrapper types.


```
fun showProgress(progress: Int) {
    val percent = progress.coerceIn(0, 100)
    println("We're ${percent}% done!")
}

showProgress(190) // restricts the value to 100
showProgress(90) // prints  the value passed as 90.

```
- Kotlin’s Int type is compiled to the Java primitive type int.

- At runtime, the number types are represented in the most efficient way possible. In most cases—for variables, properties,parameters, and return types—The below function takes care of limiting thee value to a certain range.

- The only case in which this isn’t possible is generic classes, such as collections.

- The full list of types that correspond to Java primitive types is:                                          
  - Integer types—Byte, Short, Int, Long                                     
  - Floating-point number types—Float, Double                                       
  - Character type—Char                                       
  - Boolean type—Boolean

**6.2.2. Nullable primitive types: Int?, Boolean?, and more**

- Nullable types in Kotlin can’t be represented by Java primitive types, because null can only be stored in a variable of a Java reference type.
- That means whenever you use a nullable version of a primitive         type in Kotlin, it’s compiled to the corresponding wrapper type.


**6.2.3. Number conversions**

- Kotlin doesn’t automatically convert numbers from one type to the other, even when the other type is larger.

```
val i : Int = 1;
val j : Long = i.toLong(); // have to call these functions explicitly to make it work.
```

- Kotlin Supports  conversions explicit.

```
fun explicitConversion(){
    val intList = listOf(1,2,3)
    val longVal= 1L
    println(longVal.toInt() in intList) // explicit conversion to that type is mandatory otherwise this code wont compile.
}
```
**Primitive type literals**

- Read about these in the book.

**Conversion from String**

```
println("56".toInt())
```
- If you try to perform **toInt** on a value thats not an integer then it would throw **NumberFormatException**.

**6.2.4. “Any” and “Any?”: the root types**

- Similar to how Object is the root of the class hierarchy in Java, the Any type is the supertype of all non-nullable types in Kotlin

```
fun anyTest(){
    val answer: Any = 42
    println(answer)
}
```
- **Any** is a non-nullable type. Variable of type Any cannot hold null value.
- If you need a variable that can hold any possible value in Kotlin, including null, you must use the **Any?** type.
- Under the hood, the Any type corresponds to java.lang.Object. The Object type used in parameters and return types of Java methods is seen as **Any** in Kotlin.

**6.2.5. The Unit type: Kotlin’s “void”**

- The Unit type in Kotlin fulfills the same function as void in Java. It can be used as a return type of a function that has nothing interesting to return.

- Both the below functions behave the same. You don't have to explicitly call **Unit** as like you need to call **void** in Java.
```
fun f(): Unit { println("inside f") }
fun f1()  { println("inside f1") }
```
- What distinguishes Kotlin’s Unit from Java’s void, then? Unit is a full-fledged type, and, unlike void, it can be used as a type argument.
-  The name Unit is used traditionally in functional languages to mean “only one instance,” and that’s exactly what distinguishes Kotlin’s         Unit from Java’s void.

- Java has **java.lang.Void** type as the type parameter. If you use the second option, you still need to put in an explicit return null

**6.2.6. The Nothing type: “This function never returns”**

- For some functions in Kotlin, the concept of a “return value” doesn’t make sense because they never complete successfully.For example, many testing libraries have a function called fail that fails the current test by throwing an exception with a specified message.

- A function that has an infinite loop in it will also never complete successfully.

```
fun fail(message: String): Nothing {
    throw IllegalStateException(message)
}

val address = company.address ?: fail("No address")
println(address.city)
```

### 6.3. COLLECTIONS AND ARRAYS

**6.3.1. Nullability and collections**

- **List<Int?>** -> represents this can hold null values.
- **List<Int>?** -> represents the list can be null but not the elements inside the list.

```
fun nullableCollections(intList : List<Int?>){
    for (i in intList)
        println(i.toString().toIntOrNull())

}
```

```
fun getNonNull(intList : List<Int?>) : List<Int>{
        return intList.filterNotNull()
}
```

**6.3.2. Read-only and mutable collections**

- Java does not distinguish between mutable and immutable collections.

- **kotlin.collections.Collection** -> This interface does not allow you to mutate the state.

- **kotlin.collections.Mutable-Collection** -> This interface allow you to add/modify the elements in the Collection.

- As a general rule, you should use read-only interfaces everywhere in your code.

- If a function takes a parameter that is a Collection but not a MutableCollection, you know it’s not going to modify the collection, but only read data from it.
- And if a function requires you to pass a Mutable-Collection, you can assume that it’s going to modify the data. If you have a collection that’s part of the internal state of your component, you may need to make a copy of that collection before passing it to such a function. (This pattern is usually called a defensive copy.)

```
fun playwithList(source: Collection<Int>,
                 target: MutableCollection<Int>){

    target.add(4)
}

val source: Collection<Int> = listOf(1,2,3)
val target: MutableCollection<Int> = mutableListOf(1,2,3)
```
**6.3.3. Kotlin collections and Java**

- It’s true that every Kotlin collection is an instance of the corresponding Java collection interface.
- The basic structure of the Kotlin read-only and mutable interfaces is parallel to the structure of the Java collection interfaces in the java.util package.
- Check this table in the book - **Table 6.1. Collection-creation functions**.
- If you have a Java method that takes a java.util.Collection as a parameter, you can pass any Collection or MutableCollection value as an argument to that parameter.
- You can still modify the read only collection in Kotlin if the collection is used in Java end.

**6.3.4. Collections as platform types**

- Kotlin doesn’t have the nullability information, so the compiler allows Kotlin code to treat them as either nullable or non-null.
- A collection with a platform type is essentially a collection of unknown mutability—the Kotlin code can treat it as either read-only or mutable.
- Read the content about how the the interface declared in Java can be implemented in Kotlin with different possibilities in the book.

**6.3.5. Arrays of objects and primitive types**

- An array in Kotlin is a class with a type parameter, and the element type is specified as the corresponding type argument.

- We can use the **arrayOf** to create arrrays in Kotlin.

```
arrayOf(1,null,3).forEach { println("value arrayOf ${it.toString()}") }
```
- We can use the **arrayOfNulls** to create arrrays in Kotlin.

```
arrayOfNulls<Int>(2).forEach { println("value arrayOfNulls ${it.toString()}") }
```

- Intialize array with lamda

```
fun initialzeArrayWithLambda() : Array<Int>{

    return Array<Int>(26){it*2}
}

```
- Having said that, one of the most common cases for creating an array in Kotlin code is when you need to call a Java method         that takes an array, or a Kotlin function with a vararg parameter.

**Arrays Of Primitive Types**

-  Below has the example for **IntArray**. Similar thing is available for the other types.

```
fun primitiveArray(){

    IntArray(5){it*2}
            .forEach { println("primitive int array ${it}") }
}

```
- Array with Index auto-populated for you.

```
fun arrayWithIndex(){

    IntArray(5){it*2}
            .forEachIndexed { index, i -> println("index ${index} and the value is ${i}") }
}

```

## Chapter 7. Operator overloading and other conventions

- Operator overloading
- Conventions: special-named functions supporting various operations
- Delegated properties

**Java**
- Java has several language features tied to specific classes in the standard library. For example, objects that implement java.lang.Iterable can be used   in for loops.

**Kotlin**
- Kotlin has a number of features specific to Kotlin. It works different from Java by calling functions that you define in your code. It works by defining functions with specific names in your kotlin code.
  - For example, If you define a special method with a name **plus** then by convention you can use **+** symbol to call that method. This technique is called conventions.

### 7.1. OVERLOADING ARITHMETIC OPERATORS

**7.1.1. Overloading binary arithmetic operations**

- **operator** keyword needs to be used if you are trying to overload some function. In the below example it is **plus**.

```
data class Point(val x: Int, val y: Int){

    operator fun plus(other: Point) : Point{
        return Point(x + other.x, y+other.y)
    }
}
```

```
fun main(args: Array<String>) {
    val point = Point(1,2)
    val other = Point(5,6)
    println(point+other) //(point.plus(other))
}

```
- Under the hood it call the actual funciton.
- Check this table **Table 7.1. Overloadable binary arithmetic operators** for the kotlin supported overloaded operators.

**Operator functions and Java**
- Kotlin operators are easy to call from Java: because every overloaded operator is defined as a function, you call them as regular functions using the full name.
- When you call Java from Kotlin, you can use the operator syntax for any methods with names matching the Kotlin conventions.
- When you define an operator, you don’t need to use the same types for the two operands.
- The return type of an operator function can also be different from either of the operand types.

**7.1.2. Overloading compound assignment operators**

```
var point1 = Point(1,2)
    point1 +=  Point(5,6)
    println(point1)
```

- The Kotlin standard library defines a function plusAssign on a mutable collection. All other primitive types have its own counter parts.

```
fun plusAssign(){

    var intList = mutableListOf(1,2)
    intList.plusAssign(2)
    println(intList)

}
```
- The Kotlin standard library supports both approaches for collections.

```
fun collectionWithOperators(){

    var list = listOf(1,2,3)
    val list2 = list+ listOf(4,5)
    println(list2) // adds the 4.5 elements to the collection

    list = list- listOf(2);
    println(list)  // removes the element which has the value of 2
}
```

**7.1.3. Overloading unary operators**
- Check the table for all the available operations for Unary operators. **Table 7.2. Overloadable unary arithmetic operators**

```
operator fun unaryMinus() : Point{
        return Point(-x,-y)
}
```
### 7.2. OVERLOADING COMPARISON OPERATORS

- Kotlin lets you use comparison operators (==, !=, >, <, and so on) with any object, not just with primitive types.

**7.2.1. Equality operators: “equals”**

- If you use data class it takes care of handling the overriding part for you.

**7.2.2. Ordering operators: compareTo**
- The return type of compareTo has to be Int.
- Below is the implementation of the method that is overriden.

```
operator fun compareTo(point2: Point): Int {

        return compareValuesBy(this, point2, Point::x, Point::y )
    }
```
- Note how you can use the **compareValuesBy** function from the Kotlin standard library to implement the compareTo method easily and concisely.

- You can use the following operators instead of compare to **(<, >, <=, and >=)**.
```
fun comparingTwoPoints(point1: Point , point2: Point): Boolean{

    return point1<point2; // We can use the regular comparison operators.
}
```

### 7.3. CONVENTIONS USED FOR COLLECTIONS AND RANGES

- Some of the most common operations for working with collections are getting and setting elements by index, as well as checking whether an element belongs to a collection.

- To get or set an element by index, you use the syntax a[b] (called the **index operator**).
- The **in** operator can be used to check whether an element is in a collection or range and also to iterate over a collection.

```
val map = mutableMapOf<Int, String>(0 to "Zero",1 to "One", 2 to "two")
println(map[0])// accessing an element
map[0] = "zero" // setting a new value
println(map)
```

**get**

- Implementing a get in the **Point** class using the **operator** keyword. These needs to be extension funcitons.

```
operator fun Point.get(index: Int) : Int {
    return when(index){
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("Please pass a valid argument")
    }
}

operator fun Point.get(index: Int, index1: Int) : Point {
    return when(setOf(index, index1)){
        setOf(0,1) -> Point(x, y)
        else -> throw IndexOutOfBoundsException("Please pass a valid argument")
    }
}
```
-  How to invoke to get the values.
```
println(point[1])
println(point[0,1])

```

**set**
- You can use the bracket **index** operator to set a value of an object. Code is given below.

```
operator fun MutablePoint.set(index: Int, value: Int) {
    return when(index){
        0 -> x = value
        1 -> y = value
        else -> throw IndexOutOfBoundsException("Please pass a valid argument")
    }
}
```
- How to invoke to set the value.

```
val mutablePoint = MutablePoint(1,2)
mutablePoint[0] = 5 // this calls the set method and assigns the value to it.
println("mutablePoint : ${mutablePoint}")
```
**7.3.2. The “in” convention**

- One other operator supported by collections is the in operator, which is used to check whether an object belongs to a collection.
-  The corresponding function is called **contains**.

```
data class Rectangle(val upperLeft : Point, val lowerRight: Point)

operator fun Rectangle.contains(p : Point): Boolean{

return p.x in upperLeft.x until lowerRight.x &&
        p.y in upperLeft.y until  lowerRight.y
}
```

- How to use it using an example.

```
val rectangle = Rectangle(Point(10,10), Point(30,30))
println("Is the point inside ? ${Point(20,20) in rectangle}")
```

**7.3.3. The rangeTo convention**

- This is used to generate a range of values.

```
fun rangeToExample(){

    val now = LocalDate.now();
    val range = now .. now.plusDays(10)
    println(now.plusWeeks(1) in range) // returns a boolean

}
```

**7.3.4. The “iterator” convention for the “for” loop**

- This means a statement such as for (x in list) { ... } will be translated into a call of list.iterator(), on which the hasNext and next methods are then repeatedly called, just like in Java.

- The iterator functionality can be defined as a extension function. There is a built in iterator function available for string that makes it possible to iterate over a string using the the **for in** loop.

```
fun iterateChars(){
    for (c in "abc")
        println(c)
}
```

- Iterate over a range of Dates.

```
operator fun ClosedRange<LocalDate>.iterator() : Iterator<LocalDate> {

    return object : Iterator<LocalDate>{
        var current = start

        override fun hasNext() = current<=endInclusive

        override fun next(): LocalDate = current.apply { current = plusDays(1) }

    }
}
```

- Example using it.

```
fun iterateOverRangeOfDates(){

    var startDate = LocalDate.of(2019,4,1)
    var endDate = LocalDate.of(2019,4,14)
    val interval  = startDate..endDate

    for (date in interval){
        println(date)
    }
}
```

### 7.4. DESTRUCTURING DECLARATIONS AND COMPONENT FUNCTIONS

- This feature allows you to unpack a single composite value and use it to initialize several separate variables.

```
val p = Point(10,3)
val (x,y) = p
println("$x and $y")
```

- The above is possible only because the data class has implementations for these concepts.For a data class, the compiler generates a componentN function for every property declared in the primary constructor.

- How do we implement this for a non data class?. We will override the component class for this purpose.

```
class PointNonData(val x: Int, val y: Int) {
    operator fun component1() = x
    operator fun component2() = y
}
```
- One of the main use cases where destructuring declarations are helpful is returning multiple values from a function.
- Example below has the code that splits the file name and extension.

```
data class NameComponents(val name : String, val extension: String)

fun splitNameExtension( name : String) : NameComponents{
    val result = name.split(".")
    return  NameComponents(result[0], result[1])
}

val nameAndExtension  = splitNameExtension("example.txt")
println("File name is ${nameAndExtension.name} and the extension is ${nameAndExtension.extension} ")

```

- A simpler way to return multiple values from a function is to use the Pair and Triple classes from the standard library.

**7.4.1. Destructuring declarations and loops**

- Two things happen in the bwlow code. One is iterate over a loop and destructing the entries in the map.

```
fun destructureMap(map : Map<Int, String>) {
    for((key,value) in map){
        println("""Key is $key and the value is $value""")
    }
}
```
- The above loop is translated in to below behind the scenes.

```
for (entry in map.entries) {
    val key = entry.component1()
    val value = entry.component2()
    // ...
}
```

### 7.5. REUSING PROPERTY ACCESSOR LOGIC: DELEGATED PROPERTIES

- The foundation for this feature is **delegation**: a design pattern where an object, instead of performing a task, delegates that task to another helper object. The helper object is called a **delegate**.

**7.5.1. Delegated properties: the basics**

```
class Foo {
    var p: Type by Delegate()
}
```
- The object is obtained by evaluating the expression following the **by** keyword.

**7.5.2. Using delegated properties: lazy initialization and “by lazy()”**
- **Lazy initialization** is a common pattern that entails creating part of an object on demand, when it’s accessed for the first time.
- Accessing the property using the **backing property** technique. This technique uses two properties instead of one.

```
class Person(val name: String) {
    private var _emails: List<String>? = null
    val emails : List<String>
    get(){
        if (_emails == null) {
            println("sets the emails")
            _emails = arrayListOf("dilip", "aish")
        }
        return _emails!!
    }
}
```
- But the code is somewhat cumbersome: imagine how much longer it would become if you had several lazy properties.
- Same logic can be replaced by using the below code.

```
class Person1(val name: String) {
    val emails : List<String> by lazy { namesList() }
}

fun namesList(): ArrayList<String> {
    println("inside namesList")
    return arrayListOf("dilip", "aish")
}
```
- The lazy function returns an object that has a method called getValue with the proper signature, so you can use it together with the by keyword to create a delegated property.

**7.5.3. Implementing delegated properties**

- Java has a standard mechanism for such notifications: the **PropertyChangeSupport** and **Property-ChangeEvent** classes.
- Check the **PropertyChangeExample** and **PropertyChangeExampleSimplified** kotlin files for your reference.

**7.5.5. Storing property values in a map**

- Another common pattern where delegated properties come into play is objects that have a dynamically defined set of attributes         associated with them. Such objects are sometimes called expando objects.

```
class Person4{
    private val _attributes = hashMapOf<String, String>()
    fun setAttributes(name: String, value: String){
        _attributes[name] = value
    }
    val name : String by _attributes
    val city : String by _attributes
}

fun main(args: Array<String>) {

    var p = Person4()
    val data = mapOf("name" to "dilip", "city" to "eagan")
    for((key,value) in data)
        p.setAttributes(key,value)
    println(p.name)
    println(p.city)

}
```

- This works because the standard library defines getValue and setValue extension functions on the standard Map and MutableMap interfaces.

**7.5.6. Delegated properties in frameworks**

## Chapter 8. Higher-order functions: lambdas as parameters and return values
- higher-order functions -> a higher-order function is a function that takes another function as an argument or returns one.
- inline functions -> a powerful Kotlin feature that removes the performance overhead associated with using lambdas and enables more flexible control flow within lambdas.



### 8.1. DECLARING HIGHER-ORDER FUNCTIONS

- A higher-order function is any function to which you can pass a lambda or a function reference as an argument, or a function which returns one, or both.

- For example, the filter standard-library function takes a predicate function as an argument and is therefore a higher-order function.

```
list.filter { x > 0 }
```

**8.1.1. Function types**

```
val sum = { x: Int, y: Int -> x + y }
val action = { println(42) }
```

- How can we declare the above code using an explicit statement.
```
val sum1 : (Int,Int) -> Int = { x,y -> x+y}
println("The sum is : ${sum1(2,3)}")
```

- Check the **Function Type Syntax**

```
(parameters) -> return type
```

- Below are some examples of the function return type.

```
var canReturnNull: (Int, Int) -> Int? = { i: Int, i1: Int -> null}

var funOrNull: ((Int, Int) -> Int)? = null

```
**8.1.2. Calling functions passed as arguments**

- The syntax for calling the function passed as an argument is the same as calling a regular function: you put the parentheses  after the function name, and you put the parameters inside the parentheses.
```
fun calculator( operation : (Int, Int) -> Int){
    val result = operation(2,3)
    println("The result from calculator is :  $result")
}
```

- Lets implement the filter function using the same logic.
```
fun String.filter(predicate : (Char) -> Boolean): String {
    var sb = StringBuilder()
    for (index in 0 until length){
        val element = get(index)
        if(predicate(element)) sb.append(element)
    }
    return sb.toString()
}
```

**8.1.3. Using function types from Java**

- Under the hood, function types are declared as regular interfaces: a variable of a function type is an implementation of a **FunctionN** interface.
- A variable of a function type is an instance of a class implementing the corresponding **FunctionN** interface, with the invoke method containing the body of the lambda.


**8.1.4. Default and null values for parameters with function types**

- The example in this listing is a good example.

```
Listing 8.4. Specifying a default value for a parameter of a function type
```

- Read 8.1.5 and 8.1.6.
**8.1.5. Returning functions from functions**
-

### 8.2. INLINE FUNCTIONS: REMOVING THE OVERHEAD OF LAMBDAS
- We explained that lambdas are normally compiled to anonymous classes. But that means every time you use a lambda expression, an extra class is created; and if the lambda captures some variables, then a new object is created on every invocation.
- This introduces runtime overhead, causing an implementation that uses a lambda to be less efficient than a function that executes         the same code directly.

**8.2.1. How inlining works**
- When you declare a function as inline, its body is inlined—in other words, it’s substituted directly into places where the function is called instead of being invoked normally.

```
inline fun synchronized(lock: Lock, action: () -> Unit): Unit {
    lock.lock()
    try {
        return action()
    }finally {
        lock.unlock()
    }
}
```

- The code example in the book is really well written. **Figure 8.3. The compiled version of the foo function**

**8.2.2. Restrictions on inline functions**
- If this parameter is called, such code can be easily inlined. But if the parameter is stored somewhere for further use, the code of the lambda expression can’t be inlined.

```
fun <T, R> Sequence<T>.map(transform: (T) -> R): Sequence<R> {
    return TransformingSequence(this, transform)
}
```
- The map function doesn’t call the function passed as the transform parameter directly.
- Instead, it passes this function to the constructor of a class that stores it in a property. To support that, the lambda passed as the transform argument needs to be compiled into the standard **non-inline** representation, as an anonymous class implementing a function interface.

**8.2.3. Inlining collection operations**
- Most of the collection functions in the standard library take lambda expressions as arguments.
```
data class Person(val name: String, val age: Int)
  val people = listOf(Person("Alice", 29), Person("Bob", 31))
  println(people.filter { it.age < 30 })
```
- In Kotlin, the filter function is declared as inline. It means the bytecode of the filter function, together with the bytecode of the lambda passed to it, will be inlined where filter is called.
- Kotlin’s support for inline functions ensures that you don’t need to worry about performance.
- If the number of elements to process is large, and the overhead of an intermediate collection becomes a concern, you can use a sequence instead, by adding an as-Sequence call to the chain.
- Lambdas used to process a sequence aren’t inlined

**8.2.4. Deciding when to declare functions as inline**
-

## Best Practices:
- In most cases, however, it’s still a good practice to follow Java’s directory layout and to organize source files into directories according to the package structure.



### when

-  This is the replacement for **switch** in Java

```
package com.learnkotlin.enums_when

enum class Color {
    RED, BLUE, GREEN, ORANGE
}

fun getNameFromColor(color: Color) = when (color) {
    Color.BLUE -> "blue"
    Color.RED -> "red"
    Color.GREEN -> "greean"
    Color.ORANGE -> "orange"
}

fun mix(c1: Color, c2: Color) =
        when (setOf(c1, c2)) {
            setOf(Color.BLUE, Color.RED) -> "bluishred"
            setOf(Color.GREEN, Color.ORANGE) -> "greenish orange"
            else -> throw Exception("UnknownColor")

        }

fun mixThreeColors(c1: Color, c2: Color, c3: Color) =
        when (setOf(c1, c2,c3)) {
            setOf(Color.GREEN, Color.ORANGE,Color.RED) -> "greenish orange red"
            else -> throw Exception("UnknownColor")

        }

fun mixOptimized(c1: Color, c2: Color) =
        when{
            (c1==Color.RED && c2 == Color.BLUE ||
                    (c1 == Color.ORANGE) && c2 == Color.GREEN) -> "First Set"

            (c1==Color.GREEN && c2 == Color.BLUE ||
                    c1.equals(Color.ORANGE) && c2 == Color.RED) -> "Second Set"
            else -> throw Exception("No Match")

        }
```        
