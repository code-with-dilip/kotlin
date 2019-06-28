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