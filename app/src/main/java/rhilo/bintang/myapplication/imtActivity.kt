package rhilo.bintang.myapplication

import android.app.Activity
import android.content.Intent
import android.graphics.Color.red
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_imt.*
import java.text.DecimalFormat

class imtActivity : AppCompatActivity(){

    var hasil:Double=0.0
    var var1 : String=""


    override fun onStart() {
        super.onStart()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imt)
        //check if there any package coming froming from parent activity
        var paket: Bundle? = intent.extras
        val x=(paket?.getString("x"))
        val y=(paket?.getString("y"))
        var tb=x.toString().toDouble()
        var bb=y.toString().toDouble()

        hasil= bb/((tb/100)*(tb/100))


        if(hasil<18.5){txHasil3.setTextColor(getResources().getColor(R.color.blue)) ; var1 = "Berat Badan Anda KURANG"}
        else if(hasil<22.9){txHasil3.setTextColor(getResources().getColor(R.color.green)) ; var1 = "Berat Badan Anda IDEAL"}
        else if(hasil<29.9){txHasil3.setTextColor(getResources().getColor(R.color.orange)) ; var1 = "Berat Badan Anda BERLEBIH"}
        else{txHasil3.setTextColor(getResources().getColor(R.color.red)) ; var1 = "OBESITAS"}


        txHasil1.setText("Tinggi dan Berat Badan: "+ x +" dan "+ y)
        txHasil2.setText("IMT= "+ DecimalFormat("#.##").format(hasil))
        txHasil3.setText(var1)
    }

    override fun finish() {
        var intent= Intent()
        intent.putExtra("hasil", DecimalFormat("#.##").format(hasil).toString())
        setResult(Activity.RESULT_OK,intent)
        super.finish()
    }

}