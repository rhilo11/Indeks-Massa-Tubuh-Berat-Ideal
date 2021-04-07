package rhilo.bintang.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bb.*
import kotlinx.android.synthetic.main.activity_bb.txHasil1
import kotlinx.android.synthetic.main.activity_bb.txHasil2
import kotlinx.android.synthetic.main.activity_bb.txHasil3
import kotlinx.android.synthetic.main.activity_imt.*
import java.text.DecimalFormat

class bbActivity : AppCompatActivity(){

    var hasil:Double=0.0
    var var1 : String=""

    override fun onStart() {
        super.onStart()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bb)
        //check if there any package coming froming from parent activity
        var paket: Bundle? = intent.extras
        val x=(paket?.getString("x"))
        val y=(paket?.getString("y"))
        val z=(paket?.getString("z"))
        var tb=x.toString().toDouble()
        var bb=y.toString().toDouble()
        var jk=z.toString().toDouble()

        if(jk==0.1){var1 = "LAKI-LAKI"}
        else{var1 = "PEREMPUAN"}

        hasil= (tb-100)-(tb-100)*jk

        txHasil1.setText("Berat Badan Ideal Dari")
        txHasil2.setText(var1+" Dengan Tinggi "+x+" cm")
        txHasil3.setText(DecimalFormat("#.##").format(hasil)+" kg")
    }

    override fun finish() {
        var intent= Intent()
        intent.putExtra("hasil", DecimalFormat("#.##").format(hasil).toString())
        setResult(Activity.RESULT_OK,intent)
        super.finish()
    }

}