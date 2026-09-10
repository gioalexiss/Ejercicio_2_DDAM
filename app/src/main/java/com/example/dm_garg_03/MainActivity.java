package com.example.dm_garg_03;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    // Declaración de variables
    private EditText etMetros;
    private EditText etPies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Vincular los componentes de la interfaz con las variables de Java usando sus IDs
        etMetros = findViewById(R.id.etMetros);
        etPies = findViewById(R.id.editTextNumber2);
        Button btnPies = findViewById(R.id.btnPies);
        Button btnMetros = findViewById(R.id.btnMetros);

        // Configurar el evento clic para el botón de convertir a Pies
        btnPies.setOnClickListener(view -> {
            // Obtener el texto ingresado en el campo de metros
            String metrosStr = etMetros.getText().toString();
            // Verificar que el campo no esté vacío
            if (!metrosStr.isEmpty()) {
                try {
                    // Convertir el texto a número decimal (double)
                    double metros = Double.parseDouble(metrosStr);
                    // Realizar la conversión de metros a pies (1 metro = 3.28084 pies)
                    double pies = metros * 3.28084;
                    // Mostrar el resultado en el campo de pies con 2 decimales
                    etPies.setText(String.format(Locale.US, "%.2f", pies));
                } catch (NumberFormatException e) {
                    // Si ocurre un error al parsear, limpiar el campo de salida
                    etPies.setText("");
                }
            }
        });

        // Configurar el emitter/clic para el botón de convertir a Metros
        btnMetros.setOnClickListener(view -> {
            // Obtener el texto ingresado en el campo de pies
            String piesStr = etPies.getText().toString();
            // Verificar que el campo no esté vacío
            if (!piesStr.isEmpty()) {
                try {
                    // Convertir el texto a número decimal (double)
                    double pies = Double.parseDouble(piesStr);
                    // Realizar la conversión de pies a metros (1 pie = 1 / 3.28084 metros)
                    double metros = pies / 3.28084;
                    // Mostrar el resultado en el campo de metros con 2 decimales
                    etMetros.setText(String.format(Locale.US, "%.2f", metros));
                } catch (NumberFormatException e) {
                    // Si ocurre un error al parsear, limpiar el campo de salida
                    etMetros.setText("");
                }
            }
        });
    }
}