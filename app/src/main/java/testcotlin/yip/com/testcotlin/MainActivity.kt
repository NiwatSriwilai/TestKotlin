package testcotlin.yip.com.testcotlin
//import testcotlin.yip.com.test.test
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import testcotlin.yip.com.test.test
import java.util.zip.Inflater

//import kotlinx.android.synthetic.main.<layout>.*
class MainActivity : AppCompatActivity() {
    var name:String? = String();
    private var name2:String=""
    private lateinit var tv:TextView
    //private lateinit var next:Button
    var context:Context? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        context = this
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        next.setOnClickListener(View.OnClickListener {
            var intent = Intent(context as Context,FucntionKotlinActivity::class.java);
            startActivity(intent)
        })

        this.name = "sssssss";



        val letter: String    // defining a variable
        letter = "AAAAAAAAA"        // Assigning a value to it

        //println("$letter")
        Log.d("","-------------")
        var a: String?
        a = null // compilation error
        println("----a = $a")
        var  str:String? = "sss"
        var len:String? = str?.length as? String
        len = null
        println("--------str3 = $len")

        val sc1:String = "xx"
        val sc2:String? = "xx"
        val b:Boolean? = sc1.equals(sc2)
        val arr = Array<Int>(5,{i->i})
        for( i in arr.size-1 downTo 0){
            println("---compare = ${arr.get(i)}")
        }

        loop@ for (i in 1..100) {
            loop2@for (j in 1..100) {
                println("i=$i j=$j")
                if (j==1) break@loop2 ;break@loop
            }
        }
        var list = listOf<String>("10")
        var x:Any = "10"
        when(x){
            in 0..10-> {
                println("0..10")
                println("10..0")
            }
            in list->{
                println("----i am 10")
            }
            else->{

            }
        }
        str.let {

            println("--------it  = "+it+"   ");
        }
        val listWithNulls: List<String?> = listOf("A", null)
        for (item in listWithNulls) {
            item?.let {
                println(it)
            }
        }

        test(14)
        var infla:Inflater?
        infla = Inflater()

       // var listView:ListView? = findViewById<ListView>(R.id.listView)
        //list = listOf<String>("Niwat","Niwat")
        var arrList:ArrayList<String>? = null
        arrList = ArrayList<String>()
        arrList.add("Ped")
        arrList.add("Sun")
        var adapter = MyAdapter(arrList,this)
        listView?.adapter = adapter
        listView?.setOnItemClickListener(AdapterView.OnItemClickListener { adapterView, view, i, l ->

            println("------position = "+i)
        })

        println("------${setString()}")

    }
    fun setString(str:String? = "set string to"):String{
        return str as String
    }
    fun getString(str:String):String{
        var s:String?  = str;
        return s as String;

    }
    open class MyClass(name:String?){
        //var myName:String? = name;
        var name:String?
        var list:List<String>? = null
        /*constructor(l:List<String>?){
            this.list = l
            println("construct is "+list?.size)
        }*/
        init {
            this.name = name
            println("Init block "+this.name)
            num(i=1,j=2)
        }
        fun num(i:Int,j:Int){

        }
    }
    class MyClass2(var l2:String):MyClass(null){

    }

    class MyAdapter(var list:List<String>,private val context: Context):BaseAdapter(){
        private val inflater: LayoutInflater
                = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        //var list:List<String>? = list;
        open fun init(){
            for(i in 0..10){

            }
        }
        override fun getCount(): Int {
            return list?.size as Int
        }

        //2
        override fun getItem(position: Int): Any {
            return list?.get(position) as Int
        }

        //3
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        //4
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            // Get view for row item
            var view:View? = null
            if(convertView==null) {
                val rowView = inflater.inflate(R.layout.list_item_recipe, parent, false)

                rowView.findViewById<TextView>(R.id.text).setText(list?.get(position))
                view = rowView;
            }else{
                view = convertView
            }
            return view as View
        }
    }
}
/*
kotlin tutorial
https://developer.android.com/guide
https://www.programiz.com/kotlin-programming/object-singleton

lamda function link
https://www.journaldev.com/18835/kotlin-lambda-higher-order-functions
https://medium.com/tompee/idiomatic-kotlin-higher-order-functions-and-function-types-adb59172796

higher order function
https://medium.cobeisfresh.com/kotlin-fever-part-3-lambdas-and-higher-order-functions-e9d4a7093c71
 */

