package com.kelompok2.inversmatriks;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText satux, satuy, satuz, duax, duay, duaz, tigax, tigay, tigaz, hasil1, hasil2, hasil3;
    private TextView jawabanx, jawabany, jawabanz;
    private double[] baris1, baris2, baris3;
    private double konstanta1, konstanta2, konstanta3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ambil editText
        satux = (EditText) findViewById(R.id.satux);
        satuy = (EditText) findViewById(R.id.satuy);
        satuz = (EditText) findViewById(R.id.satuz);
        duax = (EditText) findViewById(R.id.duax);
        duay = (EditText) findViewById(R.id.duay);
        duaz = (EditText) findViewById(R.id.duaz);
        tigax = (EditText) findViewById(R.id.tigax);
        tigay = (EditText) findViewById(R.id.tigay);
        tigaz = (EditText) findViewById(R.id.tigaz);
        hasil1 = (EditText) findViewById(R.id.hasilsatu);
        hasil2 = (EditText) findViewById(R.id.hasildua);
        hasil3 = (EditText) findViewById(R.id.hasiltiga);
        jawabanx = (TextView) findViewById(R.id.jawabanx);
        jawabany = (TextView) findViewById(R.id.jawabany);
        jawabanz = (TextView) findViewById(R.id.jawabanz);
    }

    public void hitung(View view) {
        try {
            // ambil nilai dari editText
            String a11 = satux.getText().toString();
            String a12 = satuy.getText().toString();
            String a13 = satuz.getText().toString();
            String a21 = duax.getText().toString();
            String a22 = duay.getText().toString();
            String a23 = duaz.getText().toString();
            String a31 = tigax.getText().toString();
            String a32 = tigay.getText().toString();
            String a33 = tigaz.getText().toString();
            String k1 = hasil1.getText().toString();
            String k2 = hasil2.getText().toString();
            String k3 = hasil3.getText().toString();

            // ubah nilai String menjadi double
            double finala11 = Double.parseDouble(a11);
            double finala12 = Double.parseDouble(a12);
            double finala13 = Double.parseDouble(a13);
            double finala21 = Double.parseDouble(a21);
            double finala22 = Double.parseDouble(a22);
            double finala23 = Double.parseDouble(a23);
            double finala31 = Double.parseDouble(a31);
            double finala32 = Double.parseDouble(a32);
            double finala33 = Double.parseDouble(a33);

            // ===============
            // +==LANGKAH 1==+
            // ===============

            // masukkan nilai konstanta ke dalam variabel
            konstanta1 = Double.parseDouble(k1);
            konstanta2 = Double.parseDouble(k2);
            konstanta3 = Double.parseDouble(k3);

            // ===============
            // +==LANGKAH 2==+
            // ===============

            // masukkan nilai-nilai koefisien ke dalam array (anggap sebagai matriks)
            // sehingga membentuk matriks berikut
            baris1 = new double[] {finala11, finala12, finala13, 1, 0, 0};
            baris2 = new double[] {finala21, finala22, finala23, 0, 1, 0};
            baris3 = new double[] {finala31, finala32, finala33, 0, 0, 1};

            // melakukan OBE untuk menyelesaikan persamaan

            // mengubah baris 1 kolom 1 menjadi bilangan 1
            if (baris1[0] != 1) {
                if (baris2[0] == 1) {
                    double[] temp = baris1;
                    baris1 = baris2;
                    baris2 = temp;
                } else if (baris3[0] == 1) {
                    double[] temp = baris1;
                    baris1 = baris3;
                    baris3 = temp;
                } else {
                    double temp = baris1[0];
                    for (int i=0; i<baris1.length; i++)
                    {
                        baris1[i] = baris1[i]/temp;
                    }
                }
            }

            // mengubah baris 2 kolom 1 dan baris 3 kolom 1 menjadi bilangan 0
            if (baris2[0] != 0) {
                double temp = baris2[0] * -1;
                for (int i=0; i<baris2.length; i++)
                {
                    baris2[i] = temp*baris1[i] + baris2[i];
                }
            }

            if (baris3[0] != 0) {
                double temp = baris3[0] * -1;
                for (int i=0; i<baris3.length; i++)
                {
                    baris3[i] = temp*baris1[i] + baris3[i];
                }
            }

            // mengubah baris 2 kolom 2 menjadi bilangan 1
            if (baris2[1] != 1) {

                double temp = baris2[1];
                for (int i=0; i<baris2.length; i++)
                {
                    baris2[i] = baris2[i]/temp;
                }
            }

            // mengubah 2 baris lainnya pada kolom 2 menjadi bilangan 0
            if (baris1[1] != 0) {
                double temp = baris1[1] * -1;
                for (int i=0; i<baris1.length; i++)
                {
                    baris1[i] = temp*baris2[i] + baris1[i];
                }
            }

            if (baris3[1] != 0) {
                double temp = baris3[1] * -1;
                for (int i=0; i<baris3.length; i++)
                {
                    baris3[i] = temp*baris2[i] + baris3[i];
                }
            }

            // mengubah baris 3 kolom 3 menjadi bilangan 1
            if (baris3[2] != 1) {

                double temp = baris3[2];
                for (int i=0; i<baris3.length; i++)
                {
                    baris3[i] = baris3[i]/temp;
                }
            }

            // mengubah 2 baris lainnya pada kolom 3 menjadi bilangan 0
            if (baris1[2] != 0) {
                double temp = baris1[2] * -1;
                for (int i=0; i<baris1.length; i++)
                {
                    baris1[i] = temp*baris3[i] + baris1[i];
                }
            }

            if (baris2[2] != 0) {
                double temp = baris2[2] * -1;
                for (int i=0; i<baris2.length; i++)
                {
                    baris2[i] = temp*baris3[i] + baris2[i];
                }
            }

            // ===============
            // +==LANGKAH 3==+
            // ===============

            // langkah 3 ini sama dengan langkah 4 pada contoh soal

            // melakukan perkalian hasil matriks tadi dengan konstanta
            double x = (baris1[3]*konstanta1)+(baris1[4]*konstanta2)+(baris1[5]*konstanta3);
            double y = (baris2[3]*konstanta1)+(baris2[4]*konstanta2)+(baris2[5]*konstanta3);
            double z = (baris3[3]*konstanta1)+(baris3[4]*konstanta2)+(baris3[5]*konstanta3);

            // tampilkan output hasil
            DecimalFormat df = new DecimalFormat("#.##");

            String hasil1 = String.valueOf(df.format(x));
            String hasil2 = String.valueOf(df.format(y));
            String hasil3 = String.valueOf(df.format(z));
            jawabanx.setText(hasil1);
            jawabany.setText(hasil2);
            jawabanz.setText(hasil3);

        } catch (Exception e) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Silahkan mengisi seluruh isian dengan benar!")
                    .setTitle("Alert!")
                    .setCancelable(false)
                    .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            // do something
                            dialogInterface.cancel();
                        }
                    }).show();
        }
    }
}