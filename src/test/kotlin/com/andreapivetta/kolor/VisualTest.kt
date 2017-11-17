package com.andreapivetta.kolor

import com.andreapivetta.kolor.Color.RED
import com.andreapivetta.kolor.Color.YELLOW
import com.andreapivetta.kolor.TextEffect.*
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object VisualTest : Spek({
    // This test doesn't make any assertions, but rather lets the tester visually verify that everything is working as
    // expected
    it("should print out a string for every color") {
        for (c in Color.values()) {
            println(Kolor.foreground("${c.name} in foreground", c))
            println(Kolor.background("${c.name} in background", c))
        }
    }

    describe("Color::wrap test with foreground and background") {
        it("should print a string with red background and yellow foreground") {
            println(RED.BG(YELLOW("Yellow foreground on red background")))
        }
    }

    it("should print strings formatted appropriately") {
        doPrint("Normal", BOLD("Bold"), "Normal")
        doPrint("Normal", ITALIC("Italic"), "Normal")
        doPrint("Normal", DIM("Dim"), "Normal")
        doPrint("Normal", REVERSED("Reversed"), "Normal")
        doPrint("Normal", BOLD(ITALIC("Bold Italic") + " Just bold"), "Normal")
        doPrint("Normal", ITALIC(BOLD("Bold Italic") + " Just italic"), "Normal")
    }
})


// For debugging purposes, so I can break execution and examine the generated string
fun doPrint(vararg strings: String) {
    val text = strings.joinToString(" ")
    println(text)
}
