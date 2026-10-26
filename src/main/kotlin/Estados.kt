package org.example

sealed class Estados {


    object Idle : Estados(){

        fun nivel_0(){
            if (nivel_actual == 1){
                estado_actual = MovingDOWN
            }
        }

        fun nivel_1(){
            if (nivel_actual == 0){
                estado_actual = MovingUP
            }
        }

        fun error(){
            estado_actual = Error
        }
    }

    object MovingUP : Estados(){

        fun llegada_nivel_1(){
            nivel_actual = 1
            estado_actual = Idle
        }

        fun error(){
            estado_actual = Error
        }
    }


    object MovingDOWN : Estados() {
    }
    object Error : Estados(){
    }
}







