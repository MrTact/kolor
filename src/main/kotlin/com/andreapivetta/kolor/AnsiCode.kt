package com.andreapivetta.kolor

internal const val ESCAPE = '\u001B'
internal const val RESET = "$ESCAPE[0m"

interface AnsiCode {
    val value: Int
    val reset: Int

    operator fun invoke(text: String) = wrap(text, value, reset)

    fun wrap(text: String, begin: Int, end: Int) = "${escape(begin)}$text${escape(end)}"

    fun escape(code: Int) = "$ESCAPE[${code}m"
}
