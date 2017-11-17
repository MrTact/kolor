package com.andreapivetta.kolor

private const val RESET_OFFSET = 20

enum class TextEffect(
        override val value: Int,
        override val reset: Int = when (value) {
            1 -> 22 // BOLD doesn't follow the pattern :-(
            else -> value + RESET_OFFSET
        }) : AnsiCode {

    BOLD(1),
    DIM(2),
    ITALIC(3),
    UNDERLINE(4),
    BLINK(5),
    REVERSED(7),
    HIDDEN(8),
    STRIKETHROUGH(9);
}
