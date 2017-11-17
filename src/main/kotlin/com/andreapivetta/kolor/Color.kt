package com.andreapivetta.kolor

/**
 * The amount of codes required in order to jump from a foreground code to a background code. Equal to 10. For example,
 * the foreground code for blue is "[33m", its respective background code is "[43m"
 */
private const val BG_OFFSET = 10

/**
 * An enumeration of colors supported by most terminals. Can be applied to both foreground and background.
 */
enum class Color(
        override val value: Int,
        val background: Int = value + BG_OFFSET,
        override val reset: Int = 0) : AnsiCode {

    BLACK(30),
    RED(31),
    GREEN(32),
    YELLOW(33),
    BLUE(34),
    MAGENTA(35),
    CYAN(36),
    LIGHT_GRAY(37),

    DARK_GRAY(90),
    LIGHT_RED(91),
    LIGHT_GREEN(92),
    LIGHT_YELLOW(93),
    LIGHT_BLUE(94),
    LIGHT_MAGENTA(95),
    LIGHT_CYAN(96),
    WHITE(97);

    fun BG(text: String) = wrap(text, background, reset)
}
