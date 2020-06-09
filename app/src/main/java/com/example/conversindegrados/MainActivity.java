package com.example.conversindegrados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.Format;

public class MainActivity extends AppCompatActivity {

    //declaracion de las propiedades
    private EditText edNumero;
    private Button btnFAC;
    private Button btnCAF;
    private TextView txtResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //asignamos los elementos a sus propiedades correspondientes
        edNumero = (EditText) findViewById(R.id.edNumero);
        btnFAC = (Button) findViewById(R.id.btnFAC);
        btnCAF = (Button) findViewById(R.id.btnCAF);
        txtResultado = (TextView) findViewById(R.id.txtResultado);

        //manejador del evento de un click en boton FAC
        btnFAC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                //obtencion de el numero de la caja de texto
                double farenheight = Double.parseDouble(edNumero.getText().toString());

                //conversion de farenheight a  celsuis
                double celsius = (farenheight-32)/1.8;

                //se imprime en la caja de texto para resultados
                txtResultado.setText("Celsuis = "+obtenerDosDecimales(celsius));
            }


        });

        //manejador del evento en caso de oprimir el boton CAF
        btnCAF.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                //se obtiene lo que hay en la caja de texto que va a ser temp en celsuis
                double celsius = Double.parseDouble(edNumero.getText().toString());

                //conversion de temperatura de farenheight a celsuis
                double farenheight = (celsius*1.8)+32;

                //se imprime el resultado en la etiqueta para resultados
                txtResultado.setText("Farenheight = "+obtenerDosDecimales(farenheight));
            }


        });

    }

    /**
     * metodo que devuelve el numero en formato de 2 decimales
     * @param grados
     * @return
     */
    private String obtenerDosDecimales(double grados)
    {

        DecimalFormat format = new DecimalFormat("#.00");
        return format.format(grados);
    }//fin de metodo
}//fin de la clase
