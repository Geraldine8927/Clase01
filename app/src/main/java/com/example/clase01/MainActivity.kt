package com.example.clase01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

     var Costo:Double=0.0
     var Cantidad:Double=0.0
    var Total:Double=0.0
    var Descuento=0.0
    var CostoDelivery:Double=0.0
    var TotalPagar:Double=0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun CalcularTotales():Boolean

    {
        if(EdtCosto.text.isEmpty() || EdtCosto.text.equals("0"))
        {
            Toast.makeText(baseContext,"por favor ingresar la cantidad",Toast.LENGTH_LONG).show()
            return false
        }
        Costo=EdtCosto.text.toString().toDouble()
        Cantidad=EdtCantidad.text.toString().toDouble()
        Total=Costo*Cantidad

        if (Total>300)
        {
            Descuento=Total*0.10
        }
    if (chkDelivery.isChecked)
    {
        CostoDelivery=20.0
    }
        TotalPagar=(Total-Descuento)+CostoDelivery
        return true;
}
    public fun btnCalcularClick(v:View)
    {
        if(CalcularTotales())
        {
            EdtTotal.setText(Total.toString())
            EdtDescuento.setText(Descuento.toString())
            EdtTotalPagar.setText(TotalPagar.toString())
        }

    }
    public fun btnImprimir_OnClick(v:View)
    {
        EdtTotal.setText(Total.toString())
        EdtDescuento.setText(Descuento.toString())
        EdtTotalPagar.setText(TotalPagar.toString())

        var oVentaImprimir:Intent=Intent(this,ConfirmarMenu::class.java)
        oVentaImprimir.putExtra("DetallePedido",EdtDetallePedido.text)
        oVentaImprimir.putExtra("Costo",EdtCosto.text)
        oVentaImprimir.putExtra("Cantidad",EdtCantidad.text)
        oVentaImprimir.putExtra("Total",EdtTotal.text)
        oVentaImprimir.putExtra("Descuento",EdtDescuento.text)
        oVentaImprimir.putExtra("Delivery",CostoDelivery.toString())
        oVentaImprimir.putExtra("Totalpagar",EdtTotalPagar.toString())
        startActivity(oVentaImprimir)

    }
    public fun btnllamarProveedor_OnClick(v:View)
    {
        var oActivity:Intent= Intent(this,ListadoProveedor::class.java)
        startActivity(oActivity)
    }

}

