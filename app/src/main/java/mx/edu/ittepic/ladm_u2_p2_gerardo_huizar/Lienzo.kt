package mx.edu.ittepic.ladm_u2_p2_gerardo_huizar

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class Lienzo (p:MainActivity) : View(p){
    var puntero = p
    //Configuracion de los circulos burbujas
    var c1 = FiguraGeometrica(150, 150, 30) //chico
    var c2 = FiguraGeometrica(50, 25, 80)  //med
    var c3 = FiguraGeometrica(250, 480, 120) //gra
    var c4 = FiguraGeometrica(350, 750, 35) //chi
    var c5 = FiguraGeometrica(450, 150, 148) //gra
    var c6 = FiguraGeometrica(550, 106, 58) //med
    var c7= FiguraGeometrica(650, 370, 80) //med
    var c8 = FiguraGeometrica(750, 790, 42) //med
    var c9 = FiguraGeometrica(850, 150, 25) //chi

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var paint = Paint()

        canvas.drawColor(Color.BLACK)





        var punteroFiguraGeometrica : FiguraGeometrica? =null


        //Dibujando un círculo rojo con contorno blanco
        paint.color = Color.BLUE
        c1.pintar(canvas, paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.WHITE
        paint.strokeWidth = 10f
        c1.pintar(canvas, paint)



        c1.pintar(canvas, paint)
        c2.pintar(canvas, paint)
        c3.pintar(canvas, paint)
        c4.pintar(canvas, paint)
        c5.pintar(canvas, paint)
        c6.pintar(canvas, paint)
        c7.pintar(canvas, paint)
        c8.pintar(canvas, paint)
        c9.pintar(canvas, paint)



    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        puntero.setTitle("")

        invalidate()
        return true
    }

    fun animarCirculo() {
        c1.reboteChico(width,height)
        c2.reboteMediano(width,height)
        c3.reboteGrande(width,height)
        c4.reboteChico(width,height)
        c5.reboteGrande(width,height)
        c6.reboteMediano(width,height)
        c7.reboteMediano(width,height)
        c8.reboteMediano(width,height)
        c9.reboteChico(width,height)


        invalidate()
    }

}//Fin de la clase view