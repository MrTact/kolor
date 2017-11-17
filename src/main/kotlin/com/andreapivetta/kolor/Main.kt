package com.andreapivetta.kolor

fun main(args: Array<String>) {
//    doPrint("Normal " + bold { "Bold" })
//    doPrint("Normal " + dim { "Dim" })
//    doPrint("Normal " + italic { "Italic" })
//    doPrint("Normal " + underline { "Underline" })
//    doPrint("Normal " + blink { "Blink" })
//    doPrint("Normal " + reversed { "Reversed" })
//    doPrint("Normal " + hidden { "Hidden" })
//    doPrint("Normal " + strikethrough { "Strikethrough" })
    doPrint("Normal " + bold { italic { "Bold Italic" }})

    println("Normal " + html { b { i { "Bold Italic" }}})
//    doPrint("Normal " + bold { italic { underline { "Bold Italic Underline" }}})
//    doPrint("Normal " + dim { italic { "Dim Italic" }})
}

fun doPrint(text: String) = println(text)
