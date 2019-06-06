package com.willian.horaparahash;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtDia = (TextView) findViewById(R.id.txtDia);
        final TextView txtMes = (TextView) findViewById(R.id.txtMes);
        final TextView txtAno = (TextView) findViewById(R.id.txtAno);
        final TextView txtHora = (TextView) findViewById(R.id.txtHora);
        final TextView txtMinuto = (TextView) findViewById(R.id.txtMinuto);

        final Handler atualizador = new Handler();

        atualizador.post(new Runnable() {
            @Override
            public void run() {
                atualizaHora(txtDia,txtMes,txtAno,txtHora,txtMinuto);
                atualizador.postDelayed(this, 60000);
            }
        });
    }

    public void atualizaHora(TextView txtDia,TextView txtMes,TextView txtAno,TextView txtHora,TextView txtMinuto) {
        GregorianCalendar calendario = new GregorianCalendar();

        int d = calendario.get(GregorianCalendar.DAY_OF_MONTH);
        int m = calendario.get(GregorianCalendar.MONTH);
        int a = calendario.get(GregorianCalendar.YEAR);
        int h = calendario.get(GregorianCalendar.HOUR_OF_DAY);
        int mim = calendario.get(GregorianCalendar.MINUTE);


        txtDia.setText(d);
        txtMes.setText(m);
        txtAno.setText(a);
        txtHora.setText(h);
        txtMinuto.setText(mim);
    }

}
