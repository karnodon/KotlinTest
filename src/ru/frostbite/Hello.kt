/**
 * Created with IntelliJ IDEA.
 * User: Frostbite
 * Date: 24.04.13
 * Time: 22:41
 */

import java.io.File
import java.util.HashMap
import java.util.ArrayList

fun main(args : Array<String>) {
    val f = File("metro.txt")
    var k = 0
    var date = ""
    var dates:HashMap<String, ArrayList<String>> = HashMap()
    f.readLines().forEach { s->
        if (!s.trim().isEmpty()) {
            when (k){
               1 -> {
                   date = s.split(' ')[0]
                   if (dates[date] == null) {
                       dates[date] = ArrayList()
                   }
                   k++
               }
               2 -> {
                   dates[date]!!.add(s)
                   k = 0
               }
               else -> k++
            }
        }
    }
    dates.iterator().filter { it.value.size > 2 }.forEach { println(it.key + " : " + it.value) }
    /*for ((d, s) in dates) {
        if (s.size > 2)
            println(d + " : " + s)
    }*/
}

