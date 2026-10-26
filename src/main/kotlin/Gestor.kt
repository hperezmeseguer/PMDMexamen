package org.example

var nivel_actual: Int = 0

var estado_acual: Estados = Estados.Idle


fun gestor(): Int {
    when (estado_acual) {

        is Estados.Idle -> {
            return nivel_actual
        }

        is Estados.MovingUP -> {
            nivel_actual = 2
            return nivel_actual
        }

        is Estados.MovingDOWN -> {
            nivel_actual = 2
            return nivel_actual
        }

        is Estados.Error -> {
            nivel_actual = -1
            return nivel_actual
        }
    }
}
