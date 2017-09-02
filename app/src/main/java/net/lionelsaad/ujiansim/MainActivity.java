package net.lionelsaad.ujiansim;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Button btnExit, btnRules, btnNext;
    private Context mContext;
    private Activity mActivity;

    private RelativeLayout mRelativeLayout;
    private Button mButton;

    private PopupWindow mPopupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setSubtitle("Ujian Singkat SIM C");
        toolbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
        btnExit = (Button)findViewById(R.id.btn_exit);
        btnRules = (Button)findViewById(R.id.peraturan);
        btnNext = (Button)findViewById(R.id.next_kuis);
        mContext = getApplicationContext();

        mActivity = MainActivity.this;

        mRelativeLayout = (RelativeLayout) findViewById(R.id.rl);
        mButton = (Button) findViewById(R.id.peraturan);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

                View customView = inflater.inflate(R.layout.activity_rules,null);
                mPopupWindow = new PopupWindow(
                        customView,
                        LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT
                );

                if(Build.VERSION.SDK_INT>=21){
                    mPopupWindow.setElevation(5.0f);
                }

                ImageButton closeButton = (ImageButton) customView.findViewById(R.id.ib_close);

                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mPopupWindow.dismiss();

                    }
                });
                mPopupWindow.showAtLocation(mRelativeLayout, Gravity.CENTER,0,0);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityKuis1.class);
                startActivity(intent);
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
        //Navigation Drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.profile) {
            Intent intent = new Intent(this, Profileku.class);
            startActivity(intent);
        }
        if (id == R.id.tentang_iak) {
            Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);
        }
        if (id == R.id.tentang_apilkasi) {
            Intent intent = new Intent(this, TentangAplikasi.class);
            startActivity(intent);
        }
        if (id == R.id.exit) {
            showDialog();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_profile) {

            Intent intent = new Intent(MainActivity.this, Profileku.class);
            startActivity(intent);
        } else if (id == R.id.nav_iak) {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);

        } else if (id == R.id.nav_apps) {
            Intent intent = new Intent(MainActivity.this, TentangAplikasi.class);
            startActivity(intent);

        } else if (id == R.id.soal_1) {
            Intent intent = new Intent(MainActivity.this, ActivityKuis1.class);
            startActivity(intent);

        } else if (id == R.id.soal_2) {
            Intent intent = new Intent(MainActivity.this, ActivityKuis2.class);
            startActivity(intent);

        } else if (id == R.id.soal_3) {
            Intent intent = new Intent(MainActivity.this, ActivityKuis3.class);
            startActivity(intent);

        }else if (id == R.id.soal_4) {
            Intent intent = new Intent(MainActivity.this, ActivityKuis4.class);
            startActivity(intent);

        } else if (id == R.id.soal_5) {
            Intent intent = new Intent(MainActivity.this, ActivityKuis5.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
        private void showDialog(){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    this);

            alertDialogBuilder.setTitle("Keluar dari ujian sim C");
            alertDialogBuilder
                    .setMessage("Apakah anda yakin ingin keluar?")
                    .setIcon(R.mipmap.ic_apps)
                    .setCancelable(false)
                    .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            finishAffinity();
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
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            showDialog();
        }
    }
    @Override
    public void onPause(){
        super.onPause();
    }
    @Override
    public void onStart(){
        super.onStart();
    }
    @Override
    public void onResume(){
        super.onResume();
    }
    @Override
    public void onRestart(){
        super.onRestart();
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
    }
}
