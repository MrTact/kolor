package com.andreapivetta.kolor

internal const val ESCAPE = '\u001B'
internal const val RESET = "$ESCAPE[0m"

interface AnsiCode {
    val value: Int
    val reset: Int

    fun wrap(text: String, begin: Int = value, end: Int = reset) = "${escape(begin)}$text${escape(end)}"

    fun escape(code: Int) = "$ESCAPE[${code}m"
}
