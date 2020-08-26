package com.example.googleapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends FragmentActivity implements
        OnMapReadyCallback, GoogleMap.OnMapClickListener{
    GoogleMap Mapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Mapa = googleMap;
        Mapa.setOnMapClickListener(this);
    }

    public void CambiarVistaMapa(View view){
        Mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        Mapa.getUiSettings().setZoomControlsEnabled(true);
    }

    public void MoverVistaMapa(View view){
        CameraUpdate camUpd1 = CameraUpdateFactory.newLatLngZoom(new LatLng(-1.021631, -79.465786), 10);
        Mapa.getUiSettings().setZoomControlsEnabled(true);
        Mapa.moveCamera(camUpd1);

    }

    public void pintarPoligono(View view){
        //-1.011886, -79.467007
        //-1.011918, -79.471963
        //-1.013602, -79.472028
        //-1.013620, -79.467015
        CameraUpdate camUpd1 = CameraUpdateFactory.newLatLngZoom(new LatLng(-1.013120, -79.469633), 16);
        Mapa.getUiSettings().setZoomControlsEnabled(true);
        Mapa.moveCamera(camUpd1);
        PolylineOptions lineas = new PolylineOptions()
                .add(new LatLng(-1.011886, -79.467007))
                .add(new LatLng(-1.011918, -79.471963))
                .add(new LatLng(-1.013602, -79.472028))
                .add(new LatLng(-1.013620, -79.467015))
                .add(new LatLng(-1.011886, -79.467007));
        lineas.width(8);
        lineas.color(Color.CYAN);
        Mapa.addPolyline(lineas);
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012343, -79.468417)))
                .setTitle("Biblioteca");
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012212, -79.469674)))
                .setTitle("Instituto de Informática");
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012942, -79.469993)))
                .setTitle("Comedor Universitario");
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.013119, -79.469724)))
                .setTitle("UBU");
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012291, -79.468821)))
                .setTitle("Centro Médico");
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012619, -79.470664)))
                .setTitle("FCI");
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012195, -79.470113)))
                .setTitle("FCE");
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012688, -79.471062)))
                .setTitle("FCA");
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012359, -79.471295)))
                .setTitle("Polideportivo");

    }
    @Override
    public void onMapClick(LatLng latLng) {
        Mapa.addMarker(new MarkerOptions().position(latLng)).setTitle("Marker in Sydney");
        Projection proj = Mapa.getProjection();
        Point coord = proj.toScreenLocation(latLng);
        Toast.makeText(
                MainActivity.this,
                "Click\n" +
                        "Lat: " + latLng.latitude + "\n" +
                        "Lng: " + latLng.longitude + "\n" +
                        "X: " + coord.x + " - Y: " + coord.y,
                Toast.LENGTH_LONG).show();
    }
}