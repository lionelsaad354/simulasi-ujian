package net.lionelsaad.ujiansim;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ActivityKuis4 extends AppCompatActivity {

    Button btnLanjut;
    private Context mContext;
    private Activity mActivity;

    private LinearLayout mLinearLayout;

    private PopupWindow mPopupWindow;
    RadioGroup radiogroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis4);
        getSupportActionBar().setSubtitle("Ujian Keempat");
        btnLanjut = (Button)findViewById(R.id.btn_lanjut_soal_keempat);
        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityKuis4.this, ActivityKuis5.class);
                startActivity(intent);
            }
        });

        mLinearLayout = (LinearLayout)findViewById(R.id.ll_keempat);
        mContext = getApplicationContext();
        mActivity = ActivityKuis4.this;
        radiogroup = (RadioGroup) findViewById(R.id.rbg_keempat);
    }
    public void pilihanKeempat (View view){
        Boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.soal_keempat_a:
                if (checked)
                    jawabanSalah(view);
                break;

            case R.id.soal_keempat_b:
                if (checked)
                    jawabanBenar(view);
                break;
            case R.id.soal_keempat_c:
                if (checked)
                    jawabanSalah(view);
                break;
        }
    }

    public void jawabanBenar(View view){
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

        View customView = inflater.inflate(R.layout.jawaban_benar,null);
        mPopupWindow = new PopupWindow(
                customView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        if(Build.VERSION.SDK_INT>=21){
            mPopupWindow.setElevation(5.0f);
        }

        ImageButton closeButtonBenar = (ImageButton) customView.findViewById(R.id.ib_close_benar);

        closeButtonBenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPopupWindow.dismiss();

            }
        });
        mPopupWindow.showAtLocation(mLinearLayout, Gravity.CENTER,0,0);
    }

    public void jawabanSalah (View view){
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

        View customView = inflater.inflate(R.layout.jawaban_salah,null);
        mPopupWindow = new PopupWindow(
                customView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        if(Build.VERSION.SDK_INT>=21){
            mPopupWindow.setElevation(5.0f);
        }

        ImageButton closeButtonSalah = (ImageButton) customView.findViewById(R.id.ib_close_salah);

        closeButtonSalah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPopupWindow.dismiss();

            }
        });
        mPopupWindow.showAtLocation(mLinearLayout, Gravity.CENTER,0,0);
    }
    @Override
    public void onBackPressed() {
        showDialog();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onRestart() {
        super.onRestart();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    private void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        alertDialogBuilder.setTitle("Kembali ke Soal Sebelumnya");
        alertDialogBuilder
                .setMessage("Apakah anda yakin ingin kembali ke soal ketiga?")
                .setIcon(R.mipmap.ic_apps)
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        ActivityKuis4.this.finish();
                    }
                })
                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();
    }
}
