package com.andreapivetta.kolor

import com.winterbe.expekt.should
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

import com.andreapivetta.kolor.RESET
import com.andreapivetta.kolor.ESCAPE

object KolorTestForeground : Spek({
    describe("foreground") {
        it("should create a string that starts with an ANSI code and ends with the reset code") {
            for (color in Color.values()) {
                Kolor.foreground("foo", color).should.equal("${ESCAPE}[${color.value}mfoo$RESET")
            }
        }
    }
})

object KolorTestBackground : Spek({
    describe("background") {
        it("should create a string that starts with an ANSI code and ends with the reset code") {
            for (color in Color.values()) {
                Kolor.background("foo", color).should.equal("${ESCAPE}[${color.background}mfoo$RESET")
            }
        }
    }
})
