package org.example

import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GestorTest {

    @AfterTest
    fun restaurarEstado() {

        estado_actual = Estados.Idle
        nivel_actual = 0
    }

    @Test
    fun `Ascensor pasa de nivel_0 a nivel_1 cuando pulso el botón`() {
        estado_actual = Estados.Idle
        nivel_actual = 0

        (estado_actual as Estados.Idle).nivel_1()

        assertEquals(Estados.MovingUP, estado_actual)
    }

    @Test
    fun `Ascensor vuelve a Idle cuando llega al nivel_1`() {
        estado_actual = Estados.MovingUP
        nivel_actual = 0

        (estado_actual as Estados.MovingUP).llegada_nivel_1()

        assertEquals(Estados.Idle, estado_actual)
        assertEquals(1, nivel_actual)
    }

    @Test
    fun `Ascensor bajando cuando pulso el botón de nivel_0`() {
        estado_actual = Estados.Idle
        nivel_actual = 1

        (estado_actual as Estados.Idle).nivel_0()

        assertEquals(Estados.MovingDOWN, estado_actual)
    }

    @Test
    fun `Ascensor vuelve a Idle cuando llega al nivel_0`() {
        estado_actual = Estados.MovingDOWN

        Estados.MovingDOWN.llegada_nivel_0()

        assertEquals(0, nivel_actual)
        assertEquals(Estados.Idle, estado_actual)
    }

    @Test
    fun `Ascensor pasa al estado Error cuando ocurre un fallo estando en Idle`() {
        estado_actual = Estados.Idle

        Estados.Idle.fallo()

        assertEquals(Estados.Error, estado_actual)
    }

    @Test
    fun `Ascensor indica nivel 2 cuando esta subiendo`() {
        nivel_actual = 0
        estado_actual = Estados.Idle

        Estados.Idle.nivel_1()

        assertEquals(Estados.MovingUP, estado_actual)
        assertEquals(2, gestor())
    }

    @Test
    fun `Ascensor indica nivel 2 cuando esta bajando`() {
        nivel_actual = 1
        estado_actual = Estados.Idle

        Estados.Idle.nivel_0()

        assertEquals(Estados.MovingDOWN, estado_actual)
        assertEquals(2, gestor())
    }


    @Test
    fun `Ascensor no sube si ya esta en el nivel 1`() {
        estado_actual = Estados.Idle
        nivel_actual = 1

        Estados.Idle.nivel_1()

        assertEquals(Estados.Idle, estado_actual)
    }

    @Test
    fun `Ascensor no baja si ya esta en el nivel 0`() {
        estado_actual = Estados.Idle
        nivel_actual = 0

        Estados.Idle.nivel_0()

        assertEquals(Estados.Idle, estado_actual)
    }

    @Test
    fun `Ascensor pasa a Error si falla mientras sube`() {
        estado_actual = Estados.MovingUP

        Estados.MovingUP.fallo()

        assertEquals(Estados.Error, estado_actual)
    }

    @Test
    fun `Ascensor pasa a Error si falla mientras baja`() {
        estado_actual = Estados.MovingDOWN

        Estados.MovingDOWN.fallo()

        assertEquals(Estados.Error, estado_actual)
    }

    @Test
    fun `Ascensor permanece en Error si vuelve a ocurrir un fallo`() {
        estado_actual = Estados.Error

        Estados.Error.fallo()

        assertEquals(Estados.Error, estado_actual)
    }
}