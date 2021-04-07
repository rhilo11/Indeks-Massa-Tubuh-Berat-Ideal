package rhilo.bintang.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{
    var var1 :String=""
    val RC_IMT_SUKSES :Int =1
    val RC_BB_SUKSES :Int =2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rg.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.rbL -> var1 = "0.1"
                R.id.rbP -> var1 = "0.15"
            }
        }

        btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var popupMenu= PopupMenu(this,v)
        popupMenu.menuInflater.inflate(R.menu.menu_popup,popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { item->
            when(item.itemId){
                R.id.itemIMT->{
                    var intent = Intent(this, imtActivity::class.java)
                    intent.putExtra("x",x.text.toString())//send a "X" value to the second activity
                    intent.putExtra("y",y.text.toString())//send a "Y" value to the second activity
                    startActivityForResult(intent,RC_IMT_SUKSES)
                }
                R.id.itemBB->{
                    var intent = Intent(this, bbActivity::class.java)
                    intent.putExtra("x",x.text.toString())//send a "X" value to the second activity
                    intent.putExtra("y",y.text.toString())//send a "Y" value to the second activity
                    intent.putExtra("z",var1)//send a "Y" value to the second activity
                    startActivityForResult(intent,RC_BB_SUKSES)
                }
                else-> {
                    Toast.makeText(this, "Tidak ada Yang dipilih", Toast.LENGTH_SHORT).show()
                }
            }
            false
        }
        popupMenu.show()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode== Activity.RESULT_OK){
            if(requestCode==RC_IMT_SUKSES)//if the result coming from second ativity from second activity (perkalian activity)
                textView.setText("Indeks Massa Tubuh Anda = " + data?.extras?.getString("hasil"))
            if(requestCode==RC_BB_SUKSES)//if the result coming from second ativity from second activity (pembagian activity)
                textView.setText("Berat Badan Ideal Anda = " + data?.extras?.getString("hasil")+" kg")
        }
    }
}