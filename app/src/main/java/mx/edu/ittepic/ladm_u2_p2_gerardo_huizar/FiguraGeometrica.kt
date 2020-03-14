package mx.edu.ittepic.ladm_u2_p2_gerardo_huizar

import android.graphics.Canvas
import android.graphics.Paint
import android.view.MotionEvent

class FiguraGeometrica (){
    var x=0f
    var y=0f
    var radio=0f
    var ancho =0f
    var alto = 0f
    var incX = 20
    var incY = 20
    var incXM = 10
    var incYM = 10
    var incXG = 5
    var incYG = 5
    var tipo = 1

    constructor(x:Int , y:Int , radio:Int):this(){
        this.x=x.toFloat()
        this.y=y.toFloat()
        this.radio=radio.toFloat()

        ancho = this.radio*2
        alto = ancho

    }


    fun pintar(c: Canvas, p: Paint){
        when(tipo){
            1->{
                c.drawCircle(x+radio,y+radio,radio,p)
            }
            2->{
                c.drawRect(x,y,x+ancho,y+alto,p)
            }

            3->{
               // c.drawBitmap(imgMuestra,x,y,p)

            }
        }
    }//Fin del metodo pintar


    fun estaEnArea(event: MotionEvent):Boolean{

        if(event.x >= x && event.x<=x+ancho){
            if(event.y >= y && event.y<=y+alto){
                return true
            }
        }

        /*when(tipo){
            1->{
                if(event.x>=x-radio && event.x<=x+radio){
                    if(event.y>=y-radio && event.y<=y+radio){
                        return true
                    }
                }
            }
            2->{

            }
        }*/
        return false
    }

    fun arrastrar(event: MotionEvent){

        x = event.x - (ancho/2)
        y = event.y - (alto/2)

        /*when(tipo){
            1->{
                x = event.x
                y = event.y
            }
            2->{

            }
        }*/

    }

    //Radio <= 40
    fun reboteChico(ancho:Int, alto:Int){

        x+= incX
        if(x<=-100 || x>=ancho){
            incX *= -1
        }
        y+= incY
        if(y<=-100 || y>=alto){
            incY *= -1
        }

    }

    //radio >40 && radio <= 80
    fun reboteMediano(ancho:Int, alto:Int){

        x+= incXM
        if(x<=-100 || x>=ancho){
            incXM *= -1
        }
        y+= incYM
        if(y<=-100 || y>=alto){
            incYM *= -1
        }

    }

    //Radio > 80
    fun reboteGrande(ancho:Int, alto:Int){

        x+= incXG
        if(x<=-100 || x>=ancho){
            incXG *= -1
        }
        y+= incYG
        if(y<=-100 || y>=alto){
            incYG *= -1
        }

    }

    fun colision(objetoB:FiguraGeometrica):Boolean{

        //caso 1
        if (objetoB.estaEnArea(x+ancho,y+alto)){
            return true
        }
        //caso 2
        if (objetoB.estaEnArea(x,y+alto)){
            return true
        }
        //caso 3
        if (objetoB.estaEnArea(x+ancho,y)){
            return true
        }
        //caso 4
        if (objetoB.estaEnArea(x,y)){
            return true
        }
        return false
    }

    fun estaEnArea(postx:Float,posty:Float):Boolean{

        if(postx >= x && postx<=x+ancho){
            if(posty >= y && posty<=y+alto){
                return true
            }
        }

        return false
    }
}//FiguraGeometrica
