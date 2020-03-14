package mx.edu.ittepic.ladm_u2_p2_gerardo_huizar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    var lienzo  : Lienzo ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lienzo = Lienzo(this)
        setContentView(lienzo)

        HiloAnimacion(this).start()

    }//Fin del onCreate



}
