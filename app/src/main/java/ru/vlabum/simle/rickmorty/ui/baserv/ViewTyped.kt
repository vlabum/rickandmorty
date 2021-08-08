package ru.vlabum.simle.rickmorty.ui.baserv

interface ViewTyped {
    val viewType: Int
        get() = error("Not implemented $this")
    val uid: Int
        get() = error("Not implemented $this")

    override fun equals(other: Any?): Boolean
}