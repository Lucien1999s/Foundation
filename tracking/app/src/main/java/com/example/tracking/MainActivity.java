package com.example.tracking;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvResult;
    Button btShow;
    public static final String TAG = MainActivity.class.getSimpleName()+"My";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btShow = findViewById(R.id.button);
        tvResult = findViewById(R.id.textView);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            ActivityCompat.requestPermissions(this,new String[]{
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION
            },100);
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        getLocal();
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void getLocal() {

        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        String localProvider = "";

        Location location = manager.getLastKnownLocation(localProvider);
        if (location != null){
            showLocation(location);
        }else{
            Log.d(TAG, "getLocal: ");
            manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 1, mListener);
            manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, mListener);
        }
    }

    LocationListener mListener = new LocationListener() {
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
        @Override
        public void onProviderEnabled(String provider) {
        }
        @Override
        public void onProviderDisabled(String provider) {
        }
        @Override
        public void onLocationChanged(Location location) {
            showLocation(location);
        }
    };
    private void showLocation(Location location){
        String address = "緯度："+location.getLatitude()+"\n經度："+location.getLongitude();
        tvResult.setText(address);
        btShow.setOnClickListener(view -> {
            String url = "https://www.google.com/maps/@"+location.getLatitude()+","+location.getLongitude()+",15z";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });

    }
}