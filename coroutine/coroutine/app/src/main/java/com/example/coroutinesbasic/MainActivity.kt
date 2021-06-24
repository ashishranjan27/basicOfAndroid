import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

/*
fun main(){

    routinone()
    routinetwo()

}


fun routinone(){
   println("1.Thread name = ${Thread.currentThread().name}")
    println("Routine one is started")
    Thread.sleep(2000)
    println("Routine one is ended")
}

fun routinetwo(){
println("1.Thread name = ${Thread.currentThread().name}")
    println("Routine two is started")
    Thread.sleep(2000)
    println("Routine two is ended")
}*/


fun main() = runBlocking(){

    println("Main starts")
    println("1.Thread name = ${Thread.currentThread().name}")

    joinAll(
            //async is a coroutine
            async{
                coroutinone()
                println("2.Thread name = ${Thread.currentThread().name}")
                 },
            async{
                println("3.Thread name = ${Thread.currentThread().name}")
                coroutinetwo()
            }
    )
    println("Main ends")
}



suspend fun coroutinone(){
println("1.Thread name = ${Thread.currentThread().name}")
    println("coroutine one is started")
    delay(2000)
    println("Routine one is ended")
}

suspend fun coroutinetwo(){
println("1.Thread name = ${Thread.currentThread().name}")
    println("coroutine two is started")
    delay(2000)
    println("Routine two is ended")
}




/*fun main(){
    //create100thread()
    create100threadcoroutine()
}

fun create100threadcoroutine() = runBlocking{
    val duration = measureTimeMillis {
        repeat(100_000){
            launch {
                delay(1000)
                print(".")
            }
        }
    }

    println("duration is as ${duration/1000} seconds")
}

fun create100thread(){
    val duration = measureTimeMillis {
        repeat(1000){
            thread {
                Thread.sleep(1000)
                print(".")
            }
        }
    }

    println("duration is as ${duration/1000} seconds")
}*/