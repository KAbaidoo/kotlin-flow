package com.example.kotlin_flow.ui.stateflow

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/*
*   A flow is a coroutine that can emit multiple values over a period of time
* */
class StateFlowViewModel : ViewModel() {

    /*val countDownFlow = flow<Int> {
        val startingValue = 5
        var currentValue = startingValue
        emit(startingValue)
        while (currentValue > 0) {
            delay(1000L)
            currentValue--
            emit(currentValue)
        }
    }*/

    /*
    * ===================================================
    * StateFlow
    * ===================================================*/

    private val _stateFlow = MutableStateFlow(0)
    val stateFlow = _stateFlow.asStateFlow()

    fun incrementCounter(){
        _stateFlow.value += 1
    }




   /* init {
        collectFlow()
    }

    private fun collectFlow() {
        viewModelScope.launch {
            *//*countDownFlow
                .filter { time -> //flow operators all you to manipulate your flow emission
                time % 2 == 0
            }.map { time ->
                time * time
            }.onEach { time -> println(time) }

                .collect { time ->
                    //delay(1500L) // when we use 'collectLatest', this block is cancelled
                    // useful for UI state since you want to display the latest state
                    println("The current time is : $time")
                }*//*

            *//*
            * terminal operators such as count , fold,  reduce return a result
            * and end the flow*//*

          //  val result = countDownFlow.reduce { accumulator, value -> // val: next, acc: total so far
            //    accumulator + value
          //  }

            val result =countDownFlow.fold(10){ // initial value in acc
                acc, value ->  acc + value
            }
            println("The count is $result")
        }

    }*/
}