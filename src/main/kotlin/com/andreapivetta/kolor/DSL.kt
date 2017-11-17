package com.andreapivetta.kolor

import com.andreapivetta.kolor.Kolor.ESCAPE
import com.andreapivetta.kolor.TextEffect.*

interface AnsiContent {
    fun render(): String
}

data class AnsiCodeContent(val code: AnsiCode, val child: AnsiContent) : AnsiContent {

    constructor(code: AnsiCode, text: String) : this(code, AnsiStringContent(text))

    override fun toString(): String = render()

    override fun render(): String = if (child is AnsiCodeContent) {
        child.render(mutableListOf(code))
    } else {
        wrap(mutableListOf(code), child.render())
    }

    fun render(codes: MutableList<AnsiCode>): String = if (child is AnsiCodeContent) {
        child.render(codes.append(code))
    } else {
        wrap(codes, child.render())
    }

    fun wrap(codes: List<AnsiCode>, wrappedText: String) =
            "$ESCAPE[${
            codes.map(AnsiCode::value).joinToString(";")
            }m$wrappedText$ESCAPE[${
            codes.reversed().map(AnsiCode::reset).joinToString(";")}m"
}

data class AnsiStringContent(val text: String) : AnsiContent {
    override fun render(): String = text
}

fun ansiWrapperFactory(code: AnsiCode, content: Any) = when (content) {
    is AnsiCodeContent -> AnsiCodeContent(code, content)
    is String -> AnsiCodeContent(code, AnsiStringContent(content))
    else -> throw Exception("Unexpected AnsiContent instance $content")
}

fun bold(block: () -> Any) = ansiWrapperFactory(BOLD, block())

//fun dim(text: String) = AnsiCodeContent(DIM, AnsiStringContent(text))

//fun dim(block: () -> AnsiContent) = AnsiCodeContent(DIM, block())

fun italic(block: () -> Any) = ansiWrapperFactory(ITALIC, block())

//fun underline(text: String) = AnsiCodeContent(UNDERLINE, AnsiStringContent(text))
//
//fun underline(block: () -> AnsiContent) = AnsiCodeContent(UNDERLINE, block())
//
//fun blink(text: String) = AnsiCodeContent(BLINK, AnsiStringContent(text))
//
//fun blink(block: () -> AnsiContent) = AnsiCodeContent(BLINK, block())
//
//fun reversed(text: String) = AnsiCodeContent(REVERSED, AnsiStringContent(text))
//
//fun reversed(block: () -> AnsiContent) = AnsiCodeContent(REVERSED, block())
//
//fun hidden(text: String) = AnsiCodeContent(HIDDEN, AnsiStringContent(text))
//
//fun hidden(block: () -> AnsiContent) = AnsiCodeContent(HIDDEN, block())
//
//fun strikethrough(text: String) = AnsiCodeContent(STRIKETHROUGH, AnsiStringContent(text))
//
//fun strikethrough(block: () -> AnsiContent) = AnsiCodeContent(STRIKETHROUGH, block())


