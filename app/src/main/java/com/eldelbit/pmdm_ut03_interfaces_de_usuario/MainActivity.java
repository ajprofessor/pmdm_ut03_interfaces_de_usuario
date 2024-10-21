package com.eldelbit.pmdm_ut03_interfaces_de_usuario;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

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

        getScreenDimensions("onCreate");

        TextView tv = new TextView(this);
        tv.setText("Nuevo Texto");
        tv.setPadding(8, 8, 8, 8);
        tv.setBackgroundColor(0xFFFFFFFF);
        tv.setTextColor(0xFF0000FF);
        ((ConstraintLayout) findViewById(R.id.main)).addView(tv);
    }

    @Override
    protected void onPause() {
        super.onPause();

        getDimensions("onPause");
    }

    private void getScreenDimensions(String tag) {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        Configuration c = getResources().getConfiguration();
        Log.d(TAG + ". " + tag,
                "Densidad: " + dm.densityDpi + "dpi. " +
                        "Ancho: " + dm.widthPixels + "px. Alto: " + dm.heightPixels + "px. " +
                        "Ancho: " + c.screenWidthDp + "dp. Alto: " + c.screenHeightDp + "dp. "
        );
    }

    private void getDimensions(String tag) {
        View view = findViewById(R.id.main);
        Log.d(TAG + ". " + tag,
                "Left: " + view.getLeft() + "px. Top: " + view.getTop()
                        + "px. Width: " + view.getWidth() + "px. Height: " + view.getHeight()
                        + "px. Measured Width: " + view.getMeasuredWidth() + "px. Measured Height: " + view.getMeasuredHeight() + "px.");
    }
}