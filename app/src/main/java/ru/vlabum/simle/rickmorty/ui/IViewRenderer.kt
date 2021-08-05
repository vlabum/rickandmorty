package ru.vlabum.simle.rickmorty.ui

interface IViewRenderer<STATE> {
    fun render(state: STATE)
}