package com.learnkotlin.string


fun parsepath(str: String): String {
    var filePath = str.substringBeforeLast("/")
    var fullName = str.substringAfterLast("/")
    var fileName = fullName.substringBeforeLast(".")
    var extension = fullName.substringAfterLast(".")
    println("The values are filePath $filePath , fileName $fileName and the extension is $extension")
    return filePath+fileName+extension
}

fun parsePathRegex(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        println("Dir: $directory, name: $filename, ext: $extension")
    }
}

fun main(args: Array<String>) {
    println("di.lip".split("\\.".toRegex()))
    println("di.lip".split("."))
    var path = "/Users/z001qgd/Dilip/study/kotlin/codebase/learn-kotlin/src/com/learnkotlin/string/StringExample.kt"
    println(parsepath(path))
    println(parsePathRegex(path))

    val kotlinLogo = """| //
                       .|//
                       .|/ \"""

    println(kotlinLogo.trimMargin("."))
    val price1 = """$99.9""";
    val price = """${'$'}99.9""";

    println(price)
    println(price1)

}