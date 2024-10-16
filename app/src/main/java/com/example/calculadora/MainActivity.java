package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import Calculadoras.Calculadora;

public class MainActivity extends AppCompatActivity {

    // Variables para la interfaz y lógica de la calculadora
    private TextView display;
    private Calculadora calculadora;
    private StringBuilder entradaActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialización de la calculadora y el TextView
        display = findViewById(R.id.display);
        calculadora = new Calculadora();
        entradaActual = new StringBuilder();

        // Enlazar los botones con sus respectivas acciones
        setupBotones();
    }

    // Método para enlazar y configurar los botones
    private void setupBotones() {
        // Botones numéricos
        Button btnN0 = findViewById(R.id.btnN0);
        Button btnN1 = findViewById(R.id.btnN1);
        Button btnN2 = findViewById(R.id.btnN2);
        Button btnN3 = findViewById(R.id.btnN3);
        Button btnN4 = findViewById(R.id.btnN4);
        Button btnN5 = findViewById(R.id.btnN5);
        Button btnN6 = findViewById(R.id.btnN6);
        Button btnN7 = findViewById(R.id.btnN7);
        Button btnN8 = findViewById(R.id.btnN8);
        Button btnN9 = findViewById(R.id.btnN9);

        // Botones de operaciones
        Button btnSuma = findViewById(R.id.btnSuma);
        Button btnResta = findViewById(R.id.btnMenos);
        Button btnMultiplicacion = findViewById(R.id.btnMultiplicar);
        Button btnDivision = findViewById(R.id.btnDivision);
        Button btnIgual = findViewById(R.id.btnIgual);
        Button btnAC = findViewById(R.id.btnAC);
        Button btnPunto = findViewById(R.id.btnPunto);

        // Listener para botones numéricos
        View.OnClickListener listenerNumeros = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button boton = (Button) v;
                entradaActual.append(boton.getText().toString());
                display.setText(entradaActual.toString());
            }
        };

        // Listener para botones de operaciones
        View.OnClickListener listenerOperadores = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button boton = (Button) v;
                if (entradaActual.length() > 0) {
                    calculadora.setOperando1(Double.parseDouble(entradaActual.toString()));
                    calculadora.setOperador(boton.getText().toString());
                    entradaActual.setLength(0); // Reset de la entrada
                }
            }
        };

        // Listener para el botón igual
        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (entradaActual.length() > 0) {
                    calculadora.setOperando2(Double.parseDouble(entradaActual.toString()));
                    double resultado = calculadora.calcularResultado();
                    display.setText(String.valueOf(resultado));
                    entradaActual.setLength(0); // Reset de la entrada
                    calculadora.reset();
                }
            }
        });

        // Listener para el botón AC (reset)
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entradaActual.setLength(0);
                display.setText("0");
                calculadora.reset();
            }
        });

        // Asignar listeners a los botones
        btnN0.setOnClickListener(listenerNumeros);
        btnN1.setOnClickListener(listenerNumeros);
        btnN2.setOnClickListener(listenerNumeros);
        btnN3.setOnClickListener(listenerNumeros);
        btnN4.setOnClickListener(listenerNumeros);
        btnN5.setOnClickListener(listenerNumeros);
        btnN6.setOnClickListener(listenerNumeros);
        btnN7.setOnClickListener(listenerNumeros);
        btnN8.setOnClickListener(listenerNumeros);
        btnN9.setOnClickListener(listenerNumeros);

        // Asignar listeners a los botones de operaciones
        btnSuma.setOnClickListener(listenerOperadores);
        btnResta.setOnClickListener(listenerOperadores);
        btnMultiplicacion.setOnClickListener(listenerOperadores);
        btnDivision.setOnClickListener(listenerOperadores);

        // Listener para el botón de punto decimal
        btnPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!entradaActual.toString().contains(".")) {
                    entradaActual.append(".");
                    display.setText(entradaActual.toString());
                }
            }
        });
    }
}

