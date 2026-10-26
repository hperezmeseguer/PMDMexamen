package org.example
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("Estado inicial: $estado_actual")
    println("Nivel inicial: ${gestor()}")

    println("\nPulsamos el botón del nivel 1")
    Estados.Idle.nivel_1()
    println("Estado: $estado_actual")
    println("Nivel: ${gestor()}")

    println("\nLlegamos al nivel 1")
    Estados.MovingUP.llegada_nivel_1()
    println("Estado: $estado_actual")
    println("Nivel: ${gestor()}")

    println("\nPulsamos el botón del nivel 0")
    Estados.Idle.nivel_0()
    println("Estado: $estado_actual")
    println("Nivel: ${gestor()}")

    println("\nLlegamos al nivel 0")
    Estados.MovingDOWN.llegada_nivel_0()
    println("Estado: $estado_actual")
    println("Nivel: ${gestor()}")

    println("\nProvocamos un fallo")
    Estados.Idle.fallo()
    println("Estado: $estado_actual")
    println("Nivel: ${gestor()}")
}