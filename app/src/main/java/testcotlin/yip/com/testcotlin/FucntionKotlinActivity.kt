package testcotlin.yip.com.testcotlin

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.json.JSONObject
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

class FucntionKotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fucntion_kotlin)
        var name = "Niwat"
        var c = object:MyClass(name){

        }

        var num1 = 3
        var num2 = 5
        var num3 = if(true)num1 else num2


        //test //vararg function
        val a = arrayOf(1, 2, 3)
        var a2 = asLnist(1,10)
        var a3:Int = a2.get(0)
        //test Infix notation
        var strInfix = "Niwat".pString(10)
        println("-----name = "+c.getMyName()+" num1 = "+num1+" a3 = $a3 strInfix = $strInfix")

        // higher order function return function
        fun makeLogger(fo: Any) = fun(e: Error) {
            Log.d("","------------------error = "+e.message)
             println("------------------error = "+e.message)
        }
        val logger = makeLogger(this)(java.lang.Error("Test"))
        var error = Error("xxx")
        //logger(error)
        // higher order function not return
        sendData("Test",{
            println("------------------data value1 = "+it)
        })
        //higher order function have on param
        sendData("www.google.co.th",{
            var result = ""
            println("-----request it = "+it)
            result
        },{
            println("-----result")
        })
        //higher order function  more than one param
        var strToThai = "Niwat".toThaiString("///",{it,s2->
            if(it.equals("")){
                s2+","

            }else{
                s2+it
            }

        })
        println("-----strToThai = "+strToThai)


        //--------------------------
        var list = ArrayList<String>()
        list.add("1")
        list.add("2")
        list.add("3")
        list.print (10,{l->
            println("------------------data value2 = "+l)
        })
        //
        var str:String? = null
        str?.let {
            ittem->
            var len = ittem.length
        }
    }
    //Infix notation
    infix fun  String.pString(num:Int):String{
        var str:String =this+num
        return str
    }
    infix fun  Int.pString(num:Int):String{
        var str:String =""+this+num
        return str
    }
    //vararg function
    private fun <String>asLnist(vararg strs:String):List<String>{
        var rs = ArrayList<String>()
        for( str in strs){
            rs.add(str)
        }
        return rs
    }
    //Higher-Order Functions
    fun sendData(data: String, callback: (String)->Unit) {
            callback(data)
    }
    fun sendData(url:String,request:(String)->String,callback:(String)->Unit){
        callback(request(url))
    }
    fun senData(request:(String,String)->Unit):Unit{
        request("","")
    }
    fun <T>sendData(request: (T) -> String):Unit{
        var str:T = "" as T
        request(str)
    }

    fun recieveDataCallback(num:Int):Unit{

    }
    fun <T>hiOrder(num:T,con:(T)->Int):Int{
        var num1 = num
        var num2 = con(num1)+num1 as Int;
        return num2
    }
    fun ArrayList<String>.print(num:Int,list:(String)->Unit):Unit{
        for(str in this) {
            list(str)
        }
    }
    fun <T> ArrayList<T>.filterOnCondition(condition: (T) -> Boolean): ArrayList<T>{
        val result = arrayListOf<T>()
        for (item in this){
            if (condition(item)){
                result.add(item)
            }
        }

        return result
    }
    fun <A> Collection<Int>.fold(
            initial: A,
            combine: (acc: A, nextElement: Int) -> A
    ): A {
        var accumulator: A = initial
        for (element: Int in this) {
            accumulator = combine(accumulator, element)
        }
        return accumulator
    }
    fun String.toThaiString(sap:String,result:(String,String)->String):String{
        return result(sap,this)
    }
    //
    fun loadImage(url:String){
        var task = object:AsyncTask<String,Int,String>(){
            override fun doInBackground(vararg urls:String):String{
               return ""
            }
            override fun onPostExecute(result:String){
                try{
                    var json = JSONObject(result)
                    var data:String = json.getString("data")
                }catch (e:Exception){

                }
            }
        }

    }
    open class MyClass{
        lateinit var name:String
        constructor(name:String){
            this.name = name
        }
        fun getMyName():String{
            return name as String
        }
    }
}
/*
#Hiorder function and lampda
https://medium.cobeisfresh.com/kotlin-fever-part-3-lambdas-and-higher-order-functions-e9d4a7093c71
https://medium.com/@agrawalsuneet/higher-order-functions-in-kotlin-3d633a86f3d7
 */