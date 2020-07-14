import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Test : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var list = ArrayList<String>()
        for (i in 0 until 100) {
            list.add(String.format("TEXT %d", i))
        }

        /*
        var recyclerView = findViewById<RecyclerView>(R.id.recycler1)
        recyclerView.layoutManager = LinearLayoutManager(this)
        var openList = ArrayList<OpenItem>()

        var adapter = OpenRecyclerAdapter(this, openList)
        recyclerView.adapter = adapter

        ////////////////////////////// 기존 과정
*/


        /*var open = Open.OpenSystemBuilder(this)
                .setSYSTEM_BOARD(true)
                .build()

        var array = OpenUtil.makingStringArray(this,open, "SYSTEM" )
        var adapter = OpenRecyclerAdapter(this, array)
        var recyclerView = findViewById<OpenView>(R.id.recycler1)
        recyclerView.render(adapter)*/


    }
}