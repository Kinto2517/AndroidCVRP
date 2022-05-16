package com.example.yazlabproje;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;


import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.example.yazlabproje.Algorithm.Araclar;
import com.example.yazlabproje.Algorithm.GenetigiGelismisYol;
import com.example.yazlabproje.Algorithm.Yolcu;
import com.example.yazlabproje.Data.SehirVeArac;
import com.example.yazlabproje.Data.SehirVeArac2;
import com.example.yazlabproje.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private Button btnClear, btnSinirsiz, btnBelirli;
    private static int abcd = 0;
    private ArrayList<LatLng> latlngs = new ArrayList<>();
    static int[] abc = new int[12];
    DatabaseReference db = FirebaseDatabase.getInstance("https://kintoandroid-default-rtdb.europe-west1.firebasedatabase.app/").getReference().child("Sehirler");


    final String TAG = "PathGoogleMapActivity";

    private static GenetigiGelismisYol enIyiYol;
    private static GenetigiGelismisYol enIyiYol2;
    private Polyline mPolyline;
    private Polyline mPolyline1;
    private Polyline mPolyline2;
    private Polyline mPolyline3;
    private Polyline mPolyline4;
    private Polyline mPolyline5;

    public MapsActivity() {


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setScrollGesturesEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);


        db.child("Basiskele").addValueEventListener(new ValueEventListener() {
            boolean is_added = false;

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String ma = snapshot.child("Yolcu").getValue().toString();
                if (!is_added) {
                    int a = Integer.parseInt(ma);
                    abc[0] = a;
                    is_added = true;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        db.child("Cayirova").addValueEventListener(new ValueEventListener() {
            boolean is_added = false;

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String ma = snapshot.child("Yolcu").getValue().toString();
                if (!is_added) {
                    int a = Integer.parseInt(ma);
                    abc[1] = a;
                    is_added = true;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        db.child("Darica").addValueEventListener(new ValueEventListener() {
            boolean is_added = false;

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String ma = snapshot.child("Yolcu").getValue().toString();
                if (!is_added) {
                    int a = Integer.parseInt(ma);
                    abc[2] = a;
                    is_added = true;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        db.child("Derince").addValueEventListener(new ValueEventListener() {
            boolean is_added = false;

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String ma = snapshot.child("Yolcu").getValue().toString();
                if (!is_added) {
                    int a = Integer.parseInt(ma);
                    abc[3] = a;
                    is_added = true;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        db.child("Dilovasi").addValueEventListener(new ValueEventListener() {
            boolean is_added = false;

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String ma = snapshot.child("Yolcu").getValue().toString();
                if (!is_added) {
                    int a = Integer.parseInt(ma);
                    abc[4] = a;
                    is_added = true;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        db.child("Gebze").addValueEventListener(new ValueEventListener() {
            boolean is_added = false;

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String ma = snapshot.child("Yolcu").getValue().toString();
                if (!is_added) {
                    int a = Integer.parseInt(ma);
                    abc[5] = a;
                    is_added = true;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        db.child("Golcuk").addValueEventListener(new ValueEventListener() {
            boolean is_added = false;

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String ma = snapshot.child("Yolcu").getValue().toString();
                if (!is_added) {
                    int a = Integer.parseInt(ma);
                    abc[6] = a;
                    is_added = true;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        db.child("Kandira").addValueEventListener(new ValueEventListener() {
            boolean is_added = false;

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String ma = snapshot.child("Yolcu").getValue().toString();
                if (!is_added) {
                    int a = Integer.parseInt(ma);
                    abc[7] = a;
                    is_added = true;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        db.child("Karamursel").addValueEventListener(new ValueEventListener() {
            boolean is_added = false;

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String ma = snapshot.child("Yolcu").getValue().toString();
                if (!is_added) {
                    int a = Integer.parseInt(ma);
                    abc[8] = a;
                    is_added = true;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        db.child("Kartepe").addValueEventListener(new ValueEventListener() {
            boolean is_added = false;

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String ma = snapshot.child("Yolcu").getValue().toString();
                if (!is_added) {
                    int a = Integer.parseInt(ma);
                    abc[9] = a;
                    is_added = true;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        db.child("Korfez").addValueEventListener(new ValueEventListener() {
            boolean is_added = false;

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String ma = snapshot.child("Yolcu").getValue().toString();
                if (!is_added) {
                    int a = Integer.parseInt(ma);
                    abc[10] = a;
                    is_added = true;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        db.child("Izmit").addValueEventListener(new ValueEventListener() {
            boolean is_added = false;

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String ma = snapshot.child("Yolcu").getValue().toString();
                if (!is_added) {
                    int a = Integer.parseInt(ma);
                    abc[11] = a;
                    is_added = true;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });


        latlngs.add(new LatLng(40.71495046455262, 29.941688470127534));
        googleMap.addMarker(new MarkerOptions()
                .position(latlngs.get(0))
                .title("Başiskele"));

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latlngs.get(0)));

        latlngs.add(new LatLng(40.8286176989135, 29.39793387572701));
        googleMap.addMarker(new MarkerOptions()
                .position(latlngs.get(1))
                .title("Çayırova"));

        latlngs.add(new LatLng(40.77569858837939, 29.37767783324654));
        googleMap.addMarker(new MarkerOptions()
                .position(latlngs.get(2))
                .title("Darıca"));

        latlngs.add(new LatLng(40.7609035987885, 29.85022723819549));
        googleMap.addMarker(new MarkerOptions()
                .position(latlngs.get(3))
                .title("Derince"));
        latlngs.add(new LatLng(40.78304288051337, 29.540412776688587));
        googleMap.addMarker(new MarkerOptions()
                .position(latlngs.get(4))
                .title("Dilovası"));
        latlngs.add(new LatLng(40.79800193051952, 29.450187498288702));
        googleMap.addMarker(new MarkerOptions()
                .position(latlngs.get(5))
                .title("Gebze"));
        latlngs.add(new LatLng(40.712686525190755, 29.84473399031396));
        googleMap.addMarker(new MarkerOptions()
                .position(latlngs.get(6))
                .title("Gölcük"));

        latlngs.add(new LatLng(41.06254596888521, 30.15674568391825));
        googleMap.addMarker(new MarkerOptions()
                .position(latlngs.get(7))
                .title("Kandıra"));
        latlngs.add(new LatLng(40.69149108370398, 29.608308371907093));
        googleMap.addMarker(new MarkerOptions()
                .position(latlngs.get(8))
                .title("Karamürsel"));
        latlngs.add(new LatLng(40.7454357, 30.0112827));
        googleMap.addMarker(new MarkerOptions()
                .position(latlngs.get(9))
                .title("Kartepe"));
        latlngs.add(new LatLng(40.769497355774206, 29.767342302783042));
        googleMap.addMarker(new MarkerOptions()
                .position(latlngs.get(10))
                .title("Körfez"));
        latlngs.add(new LatLng(40.7718818, 29.9497846));
        googleMap.addMarker(new MarkerOptions()
                .position(latlngs.get(11))
                .title("İzmit"));



        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latlngs.get(11)));



        btnClear = (Button) findViewById(R.id.buttonClear);
        btnBelirli = (Button) findViewById(R.id.buttonGA);
        btnSinirsiz = (Button) findViewById(R.id.buttonGASinirsiz);


        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                googleMap.clear();

            }
        });

        btnBelirli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<GenetigiGelismisYol> anaPop = populasyonuDoldur();
                while (!populasyonSinir()) {
                    List<GenetigiGelismisYol> geciciPop = reproduction(anaPop);
                    List<GenetigiGelismisYol> azalanPop = makeGeneticOperations(geciciPop);

                    anaPop = succession(geciciPop, azalanPop);

                }
                double kmcost = enIyiYol.getDistance();

                for (int i = 0; i < enIyiYol.araclar.size(); i++) {
                    for (int j = 0; j < enIyiYol.araclar.get(i).gidilenYol.size(); j++) {
                        LatLng a = new LatLng(enIyiYol.araclar.get(i).gidilenYol.get(j).longitude, enIyiYol.araclar.get(i).gidilenYol.get(j).latitude);
                        if (i == 0) {
                            googleMap.addMarker(new MarkerOptions().position(a).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                        } else if (i == 1) {
                            googleMap.addMarker(new MarkerOptions().position(a).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                        } else if (i == 2) {
                            googleMap.addMarker(new MarkerOptions().position(a).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                        } else if (i == 3) {
                            googleMap.addMarker(new MarkerOptions().position(a).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
                        } else if (i == 4) {
                            googleMap.addMarker(new MarkerOptions().position(a).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
                        } else {
                            googleMap.addMarker(new MarkerOptions().position(a).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                        }

                    }
                }
                if(enIyiYol.araclar.get(0).gidilenYol.size()==3){
                    String a2 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(1).longitude);
                    String a21 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(1).latitude);
                    String url = "https://maps.googleapis.com/maps/api/directions/json?origin="+a2+","+a21+"&destination=40.824151,29.9259134&alternatives=true&mode=driving&key=AIzaSyADpzN3BGt7eRnzG3XNU5RAsUBS6WNrr4s";
                    drawRoute1(url);
                }else if(enIyiYol.araclar.get(0).gidilenYol.size()==4){
                    String a2 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(1).longitude);
                    String a21 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(1).latitude);
                    String a3 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(2).longitude);
                    String a31 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(2).latitude);
                    String url1 = "https://maps.googleapis.com/maps/api/directions/json?origin="+a2+","+a21+"&destination=40.824151,29.9259134&waypoints=|"+a3+","+a31+"|&alternatives=true&mode=driving&key=AIzaSyADpzN3BGt7eRnzG3XNU5RAsUBS6WNrr4s";
                    drawRoute1(url1);
                }else if(enIyiYol.araclar.get(0).gidilenYol.size()==5){
                    String a2 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(1).longitude);
                    String a21 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(1).latitude);
                    String a3 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(2).longitude);
                    String a31 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(2).latitude);
                    String a4 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(3).longitude);
                    String a41 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(3).latitude);
                    String url2 = "https://maps.googleapis.com/maps/api/directions/json?origin="+a2+","+a21+"&destination=40.824151,29.9259134&waypoints=|"+a3+","+a31+"||"+a4+","+a41+"|&alternatives=true&mode=driving&key=AIzaSyADpzN3BGt7eRnzG3XNU5RAsUBS6WNrr4s";
                    drawRoute1(url2);

                }else if(enIyiYol.araclar.get(0).gidilenYol.size()==6){
                    String a2 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(1).longitude);
                    String a21 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(1).latitude);
                    String a3 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(2).longitude);
                    String a31 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(2).latitude);
                    String a4 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(3).longitude);
                    String a41 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(3).latitude);
                    String a5 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(4).longitude);
                    String a51 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(4).latitude);
                    String url3 = "https://maps.googleapis.com/maps/api/directions/json?origin="+a2+","+a21+"&destination=40.824151,29.9259134&waypoints=|"+a3+","+a31+"||"+a4+","+a41+"||"+a5+","+a51+"|&alternatives=true&mode=driving&key=AIzaSyADpzN3BGt7eRnzG3XNU5RAsUBS6WNrr4s";
                    drawRoute1(url3);
                }else if(enIyiYol.araclar.get(0).gidilenYol.size()==7){
                    String a2 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(1).longitude);
                    String a21 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(1).latitude);
                    String a3 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(2).longitude);
                    String a31 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(2).latitude);
                    String a4 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(3).longitude);
                    String a41 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(3).latitude);
                    String a5 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(4).longitude);
                    String a51 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(4).latitude);
                    String a6 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(5).longitude);
                    String a61 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(5).latitude);
                    String url4 = "https://maps.googleapis.com/maps/api/directions/json?origin="+a2+","+a21+"&destination=40.824151,29.9259134&waypoints=|"+a3+","+a31+"||"+a4+","+a41+"||"+a5+","+a51+"||"+a6+","+a61+"|&alternatives=true&mode=driving&key=AIzaSyADpzN3BGt7eRnzG3XNU5RAsUBS6WNrr4s";
                    drawRoute1(url4);

                }else if(enIyiYol.araclar.get(0).gidilenYol.size()==8){
                    String a2 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(1).longitude);
                    String a21 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(1).latitude);
                    String a3 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(2).longitude);
                    String a31 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(2).latitude);
                    String a4 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(3).longitude);
                    String a41 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(3).latitude);
                    String a5 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(4).longitude);
                    String a51 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(4).latitude);
                    String a6 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(5).longitude);
                    String a61 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(5).latitude);
                    String a7 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(6).longitude);
                    String a71 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(6).latitude);
                    String url5 = "https://maps.googleapis.com/maps/api/directions/json?origin=" + a2 + "," + a21 + "&destination=40.824151,29.9259134&waypoints=|" + a3 + "," + a31 + "||" + a4 + "," + a41 + "||" + a5 + "," + a51 + "||" + a6 + "," + a61 + "||"+a7+","+a71+"|&alternatives=true&mode=driving&key=AIzaSyADpzN3BGt7eRnzG3XNU5RAsUBS6WNrr4s";
                    drawRoute1(url5);
                }else{
                    System.out.println("Process Killed");
                }



                if(enIyiYol.araclar.get(1).gidilenYol.size()==3){
                    String a2 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(1).longitude);
                    String a21 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(1).latitude);
                    String url = "https://maps.googleapis.com/maps/api/directions/json?origin="+a2+","+a21+"&destination=40.824151,29.9259134&alternatives=true&mode=driving&key=AIzaSyADpzN3BGt7eRnzG3XNU5RAsUBS6WNrr4s";
                    drawRoute2(url);
                }else if(enIyiYol.araclar.get(1).gidilenYol.size()==4){
                    String a2 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(1).longitude);
                    String a21 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(1).latitude);
                    String a3 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(2).longitude);
                    String a31 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(2).latitude);
                    String url1 = "https://maps.googleapis.com/maps/api/directions/json?origin="+a2+","+a21+"&destination=40.824151,29.9259134&waypoints=|"+a3+","+a31+"|&alternatives=true&mode=driving&key=AIzaSyADpzN3BGt7eRnzG3XNU5RAsUBS6WNrr4s";
                    drawRoute2(url1);
                }else if(enIyiYol.araclar.get(1).gidilenYol.size()==5){
                    String a2 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(1).longitude);
                    String a21 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(1).latitude);
                    String a3 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(2).longitude);
                    String a31 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(2).latitude);
                    String a4 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(3).longitude);
                    String a41 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(3).latitude);
                    String url2 = "https://maps.googleapis.com/maps/api/directions/json?origin="+a2+","+a21+"&destination=40.824151,29.9259134&waypoints=|"+a3+","+a31+"||"+a4+","+a41+"|&alternatives=true&mode=driving&key=AIzaSyADpzN3BGt7eRnzG3XNU5RAsUBS6WNrr4s";
                    drawRoute2(url2);

                }else if(enIyiYol.araclar.get(1).gidilenYol.size()==6){
                    String a2 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(1).longitude);
                    String a21 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(1).latitude);
                    String a3 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(2).longitude);
                    String a31 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(2).latitude);
                    String a4 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(3).longitude);
                    String a41 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(3).latitude);
                    String a5 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(4).longitude);
                    String a51 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(4).latitude);
                    String url3 = "https://maps.googleapis.com/maps/api/directions/json?origin="+a2+","+a21+"&destination=40.824151,29.9259134&waypoints=|"+a3+","+a31+"||"+a4+","+a41+"||"+a5+","+a51+"|&alternatives=true&mode=driving&key=AIzaSyADpzN3BGt7eRnzG3XNU5RAsUBS6WNrr4s";
                    drawRoute2(url3);
                }else if(enIyiYol.araclar.get(1).gidilenYol.size()==7){
                    String a2 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(1).longitude);
                    String a21 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(1).latitude);
                    String a3 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(2).longitude);
                    String a31 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(2).latitude);
                    String a4 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(3).longitude);
                    String a41 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(3).latitude);
                    String a5 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(4).longitude);
                    String a51 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(4).latitude);
                    String a6 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(5).longitude);
                    String a61 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(5).latitude);
                    String url4 = "https://maps.googleapis.com/maps/api/directions/json?origin="+a2+","+a21+"&destination=40.824151,29.9259134&waypoints=|"+a3+","+a31+"||"+a4+","+a41+"||"+a5+","+a51+"||"+a6+","+a61+"|&alternatives=true&mode=driving&key=AIzaSyADpzN3BGt7eRnzG3XNU5RAsUBS6WNrr4s";
                    drawRoute2(url4);

                }else if(enIyiYol.araclar.get(1).gidilenYol.size()==8){
                    String a2 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(1).longitude);
                    String a21 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(1).latitude);
                    String a3 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(2).longitude);
                    String a31 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(2).latitude);
                    String a4 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(3).longitude);
                    String a41 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(3).latitude);
                    String a5 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(4).longitude);
                    String a51 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(4).latitude);
                    String a6 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(5).longitude);
                    String a61 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(5).latitude);
                    String a7 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(6).longitude);
                    String a71 = String.valueOf(enIyiYol.araclar.get(1).gidilenYol.get(6).latitude);
                    String url5 = "https://maps.googleapis.com/maps/api/directions/json?origin=" + a2 + "," + a21 + "&destination=40.824151,29.9259134&waypoints=|" + a3 + "," + a31 + "||" + a4 + "," + a41 + "||" + a5 + "," + a51 + "||" + a6 + "," + a61 + "||"+a7+","+a71+"|&alternatives=true&mode=driving&key=AIzaSyADpzN3BGt7eRnzG3XNU5RAsUBS6WNrr4s";
                    drawRoute2(url5);
                }else{
                    System.out.println("Process Killed");
                }



                if(enIyiYol.araclar.get(2).gidilenYol.size()==3){
                    String a2 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(1).longitude);
                    String a21 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(1).latitude);
                    String url = "https://maps.googleapis.com/maps/api/directions/json?origin="+a2+","+a21+"&destination=40.824151,29.9259134&alternatives=true&mode=driving&key=AIzaSyADpzN3BGt7eRnzG3XNU5RAsUBS6WNrr4s";
                    drawRoute5(url);
                }else if(enIyiYol.araclar.get(2).gidilenYol.size()==4){
                    String a2 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(1).longitude);
                    String a21 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(1).latitude);
                    String a3 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(2).longitude);
                    String a31 = String.valueOf(enIyiYol.araclar.get(0).gidilenYol.get(2).latitude);
                    String url1 = "https://maps.googleapis.com/maps/api/directions/json?origin="+a2+","+a21+"&destination=40.824151,29.9259134&waypoints=|"+a3+","+a31+"|&alternatives=true&mode=driving&key=AIzaSyADpzN3BGt7eRnzG3XNU5RAsUBS6WNrr4s";
                    drawRoute5(url1);
                }else if(enIyiYol.araclar.get(2).gidilenYol.size()==5){
                    String a2 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(1).longitude);
                    String a21 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(1).latitude);
                    String a3 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(2).longitude);
                    String a31 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(2).latitude);
                    String a4 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(3).longitude);
                    String a41 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(3).latitude);
                    String url2 = "https://maps.googleapis.com/maps/api/directions/json?origin="+a2+","+a21+"&destination=40.824151,29.9259134&waypoints=|"+a3+","+a31+"||"+a4+","+a41+"|&alternatives=true&mode=driving&key=AIzaSyADpzN3BGt7eRnzG3XNU5RAsUBS6WNrr4s";
                    drawRoute5(url2);

                }else if(enIyiYol.araclar.get(2).gidilenYol.size()==6){
                    String a2 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(1).longitude);
                    String a21 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(1).latitude);
                    String a3 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(2).longitude);
                    String a31 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(2).latitude);
                    String a4 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(3).longitude);
                    String a41 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(3).latitude);
                    String a5 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(4).longitude);
                    String a51 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(4).latitude);
                    String url3 = "https://maps.googleapis.com/maps/api/directions/json?origin="+a2+","+a21+"&destination=40.824151,29.9259134&waypoints=|"+a3+","+a31+"||"+a4+","+a41+"||"+a5+","+a51+"|&alternatives=true&mode=driving&key=AIzaSyADpzN3BGt7eRnzG3XNU5RAsUBS6WNrr4s";
                    drawRoute5(url3);
                }else if(enIyiYol.araclar.get(2).gidilenYol.size()==7){
                    String a2 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(1).longitude);
                    String a21 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(1).latitude);
                    String a3 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(2).longitude);
                    String a31 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(2).latitude);
                    String a4 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(3).longitude);
                    String a41 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(3).latitude);
                    String a5 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(4).longitude);
                    String a51 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(4).latitude);
                    String a6 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(5).longitude);
                    String a61 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(5).latitude);
                    String url4 = "https://maps.googleapis.com/maps/api/directions/json?origin="+a2+","+a21+"&destination=40.824151,29.9259134&waypoints=|"+a3+","+a31+"||"+a4+","+a41+"||"+a5+","+a51+"||"+a6+","+a61+"|&alternatives=true&mode=driving&key=AIzaSyADpzN3BGt7eRnzG3XNU5RAsUBS6WNrr4s";
                    drawRoute5(url4);

                }else if(enIyiYol.araclar.get(2).gidilenYol.size()==8){
                    String a2 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(1).longitude);
                    String a21 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(1).latitude);
                    String a3 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(2).longitude);
                    String a31 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(2).latitude);
                    String a4 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(3).longitude);
                    String a41 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(3).latitude);
                    String a5 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(4).longitude);
                    String a51 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(4).latitude);
                    String a6 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(5).longitude);
                    String a61 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(5).latitude);
                    String a7 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(6).longitude);
                    String a71 = String.valueOf(enIyiYol.araclar.get(2).gidilenYol.get(6).latitude);
                    String url5 = "https://maps.googleapis.com/maps/api/directions/json?origin=" + a2 + "," + a21 + "&destination=40.824151,29.9259134&waypoints=|" + a3 + "," + a31 + "||" + a4 + "," + a41 + "||" + a5 + "," + a51 + "||" + a6 + "," + a61 + "||"+a7+","+a71+"|&alternatives=true&mode=driving&key=AIzaSyADpzN3BGt7eRnzG3XNU5RAsUBS6WNrr4s";
                    drawRoute5(url5);
                }else{
                    System.out.println("Process Killed");
                }






                Toast.makeText(MapsActivity.this, "" + (int) kmcost, Toast.LENGTH_SHORT).show();
            }
        });

        btnSinirsiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mMap.clear();

                List<Yolcu> yolcular = new ArrayList<>(SehirVeArac2.Yolcular);
                List<Araclar> araclar = SehirVeArac2.aracListesiAl();

                int b = 0;
                for (int i = 0; i < yolcular.size(); i++) {
                    b += yolcular.get(i).yolcuSayi;
                    System.out.println(b);
                }

                List<GenetigiGelismisYol> anaPop = null;
                if (b <= 95) {
                    anaPop = populasyonVeAracInit();
                } else if (b <= 135) {
                    anaPop = populasyonVeAracInit2();
                } else if (b <= 175) {
                    anaPop = populasyonVeAracInit3();

                } else if (b <= 215) {
                    anaPop = populasyonVeAracInit4();
                } else if (b <= 255) {
                    anaPop = populasyonVeAracInit5();
                }

                while (!populasyonSinir()) {
                    List<GenetigiGelismisYol> geciciPop = reproduction2(anaPop);
                    List<GenetigiGelismisYol> azalanPop = gaOperate(geciciPop);

                    anaPop = basariliGen(geciciPop, azalanPop);

                }

                double kmcost = 0;
                if (enIyiYol2.araclar.size() > 3) {
                    kmcost = enIyiYol2.getDistance();
                    for (int i = 0; i < enIyiYol2.araclar.size() - 3; i++) {
                        kmcost += 40;
                    }
                }
                enIyiYazdir(enIyiYol2);
                System.out.println(kmcost);


                for (int i = 0; i < enIyiYol2.araclar.size(); i++) {
                    for (int j = 0; j < enIyiYol2.araclar.get(i).gidilenYol.size(); j++) {
                        LatLng a = new LatLng(enIyiYol2.araclar.get(i).gidilenYol.get(j).longitude, enIyiYol2.araclar.get(i).gidilenYol.get(j).latitude);
                        if (i == 0) {
                            googleMap.addMarker(new MarkerOptions().position(a).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                        } else if (i == 1) {
                            googleMap.addMarker(new MarkerOptions().position(a).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                        } else if (i == 2) {
                            googleMap.addMarker(new MarkerOptions().position(a).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                        } else if (i == 3) {
                            googleMap.addMarker(new MarkerOptions().position(a).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
                        } else if (i == 4) {
                            googleMap.addMarker(new MarkerOptions().position(a).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
                        } else {
                            googleMap.addMarker(new MarkerOptions().position(a).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                        }

                    }
                }


                for (int i = 0; i < enIyiYol2.araclar.size(); i++) {
                    if(enIyiYol.araclar.get(i).gidilenYol.size()==3){
                        String a2 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(1).longitude);
                        String a21 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(1).latitude);
                        String url = "https://maps.googleapis.com/maps/api/directions/json?origin="+a2+","+a21+"&destination=40.824151,29.9259134&alternatives=true&mode=driving&key=AIzaSyADpzN3BGt7eRnzG3XNU5RAsUBS6WNrr4s";
                        if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(0)){
                            drawRoute(url);
                        }else if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(1)){
                            drawRoute1(url);
                        }else if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(2)){
                            drawRoute2(url);
                        }else if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(3)){
                            drawRoute3(url);
                        }else if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(4)){
                            drawRoute4(url);
                        }else{
                            drawRoute5(url);
                        }
                    }else if(enIyiYol.araclar.get(i).gidilenYol.size()==4){
                        String a2 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(1).longitude);
                        String a21 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(1).latitude);
                        String a3 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(2).longitude);
                        String a31 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(2).latitude);
                        String url1 = "https://maps.googleapis.com/maps/api/directions/json?origin="+a2+","+a21+"&destination=40.824151,29.9259134&waypoints=|"+a3+","+a31+"|&alternatives=true&mode=driving&key=AIzaSyADpzN3BGt7eRnzG3XNU5RAsUBS6WNrr4s";

                        if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(0)){
                            drawRoute(url1);
                        }else if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(1)){
                            drawRoute1(url1);
                        }else if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(2)){
                            drawRoute2(url1);
                        }else if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(3)){
                            drawRoute3(url1);
                        }else if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(4)){
                            drawRoute4(url1);
                        }else{
                            drawRoute5(url1);
                        }

                    }else if(enIyiYol.araclar.get(i).gidilenYol.size()==5){
                        String a2 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(1).longitude);
                        String a21 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(1).latitude);
                        String a3 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(2).longitude);
                        String a31 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(2).latitude);
                        String a4 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(3).longitude);
                        String a41 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(3).latitude);
                        String url2 = "https://maps.googleapis.com/maps/api/directions/json?origin="+a2+","+a21+"&destination=40.824151,29.9259134&waypoints=|"+a3+","+a31+"||"+a4+","+a41+"|&alternatives=true&mode=driving&key=AIzaSyADpzN3BGt7eRnzG3XNU5RAsUBS6WNrr4s";
                        if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(0)){
                            drawRoute(url2);
                        }else if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(1)){
                            drawRoute1(url2);
                        }else if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(2)){
                            drawRoute2(url2);
                        }else if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(3)){
                            drawRoute3(url2);
                        }else if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(4)){
                            drawRoute4(url2);
                        }else{
                            drawRoute5(url2);
                        }

                    }else if(enIyiYol.araclar.get(i).gidilenYol.size()==6){
                        String a2 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(1).longitude);
                        String a21 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(1).latitude);
                        String a3 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(2).longitude);
                        String a31 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(2).latitude);
                        String a4 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(3).longitude);
                        String a41 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(3).latitude);
                        String a5 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(4).longitude);
                        String a51 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(4).latitude);
                        String url3 = "https://maps.googleapis.com/maps/api/directions/json?origin="+a2+","+a21+"&destination=40.824151,29.9259134&waypoints=|"+a3+","+a31+"||"+a4+","+a41+"||"+a5+","+a51+"|&alternatives=true&mode=driving&key=AIzaSyADpzN3BGt7eRnzG3XNU5RAsUBS6WNrr4s";
                        if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(0)){
                            drawRoute(url3);
                        }else if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(1)){
                            drawRoute1(url3);
                        }else if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(2)){
                            drawRoute2(url3);
                        }else if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(3)){
                            drawRoute3(url3);
                        }else if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(4)){
                            drawRoute4(url3);
                        }else{
                            drawRoute5(url3);
                        }
                    }else if(enIyiYol.araclar.get(i).gidilenYol.size()==7){
                        String a2 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(1).longitude);
                        String a21 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(1).latitude);
                        String a3 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(2).longitude);
                        String a31 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(2).latitude);
                        String a4 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(3).longitude);
                        String a41 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(3).latitude);
                        String a5 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(4).longitude);
                        String a51 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(4).latitude);
                        String a6 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(5).longitude);
                        String a61 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(5).latitude);
                        String url4 = "https://maps.googleapis.com/maps/api/directions/json?origin="+a2+","+a21+"&destination=40.824151,29.9259134&waypoints=|"+a3+","+a31+"||"+a4+","+a41+"||"+a5+","+a51+"||"+a6+","+a61+"|&alternatives=true&mode=driving&key=AIzaSyADpzN3BGt7eRnzG3XNU5RAsUBS6WNrr4s";
                        if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(0)){
                            drawRoute(url4);
                        }else if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(1)){
                            drawRoute1(url4);
                        }else if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(2)){
                            drawRoute2(url4);
                        }else if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(3)){
                            drawRoute3(url4);
                        }else if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(4)){
                            drawRoute4(url4);
                        }else{
                            drawRoute5(url4);
                        }

                    }else if(enIyiYol.araclar.get(i).gidilenYol.size()==8){
                        String a2 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(1).longitude);
                        String a21 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(1).latitude);
                        String a3 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(2).longitude);
                        String a31 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(2).latitude);
                        String a4 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(3).longitude);
                        String a41 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(3).latitude);
                        String a5 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(4).longitude);
                        String a51 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(4).latitude);
                        String a6 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(5).longitude);
                        String a61 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(5).latitude);
                        String a7 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(6).longitude);
                        String a71 = String.valueOf(enIyiYol.araclar.get(i).gidilenYol.get(6).latitude);
                        String url5 = "https://maps.googleapis.com/maps/api/directions/json?origin=" + a2 + "," + a21 + "&destination=40.824151,29.9259134&waypoints=|" + a3 + "," + a31 + "||" + a4 + "," + a41 + "||" + a5 + "," + a51 + "||" + a6 + "," + a61 + "||"+a7+","+a71+"|&alternatives=true&mode=driving&key=AIzaSyADpzN3BGt7eRnzG3XNU5RAsUBS6WNrr4s";
                        if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(0)){
                            drawRoute(url5);
                        }else if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(1)){
                            drawRoute1(url5);
                        }else if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(2)){
                            drawRoute2(url5);
                        }else if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(3)){
                            drawRoute3(url5);
                        }else if(enIyiYol2.araclar.get(i)==enIyiYol2.araclar.get(4)){
                            drawRoute4(url5);
                        }else{
                            drawRoute5(url5);
                        }
                    }else{
                        System.out.println("Process Killed");
                    }
                }


            }

        });

        mMap.setOnMapClickListener(this);


    }






    @Override
    public void onMapClick(@NonNull LatLng latLng) {
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    private void drawRoute(String url) {
        DownloadTask downloadTask = new DownloadTask();
        downloadTask.execute(url);
    }
    private void drawRoute1(String url) {
        DownloadTask1 downloadTask = new DownloadTask1();
        downloadTask.execute(url);
    }
    private void drawRoute2(String url) {
        DownloadTask2 downloadTask = new DownloadTask2();
        downloadTask.execute(url);
    }
    private void drawRoute3(String url) {
        DownloadTask3 downloadTask = new DownloadTask3();
        downloadTask.execute(url);
    }
    private void drawRoute4(String url) {
        DownloadTask4 downloadTask = new DownloadTask4();
        downloadTask.execute(url);
    }
    private void drawRoute5(String url) {
        DownloadTask5 downloadTask = new DownloadTask5();
        downloadTask.execute(url);
    }


    private String downloadUrl5(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        } catch (Exception e) {
            Log.d("Exception on download", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }
    private String downloadUrl4(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        } catch (Exception e) {
            Log.d("Exception on download", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }
    private String downloadUrl3(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        } catch (Exception e) {
            Log.d("Exception on download", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }
    private String downloadUrl2(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        } catch (Exception e) {
            Log.d("Exception on download", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }
    private String downloadUrl1(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        } catch (Exception e) {
            Log.d("Exception on download", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }
    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        } catch (Exception e) {
            Log.d("Exception on download", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    private class DownloadTask extends AsyncTask<String, Void, String> {

        // Downloading data in non-ui thread
        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try {
                // Fetching the data from web service
                data = downloadUrl(url[0]);
                Log.d("DownloadTask", "DownloadTask : " + data);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        // Executes in UI thread, after the execution of
        // doInBackground()
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask();

            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);
        }
    }
    private class DownloadTask1 extends AsyncTask<String, Void, String> {

        // Downloading data in non-ui thread
        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try {
                // Fetching the data from web service
                data = downloadUrl1(url[0]);
                Log.d("DownloadTask", "DownloadTask : " + data);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        // Executes in UI thread, after the execution of
        // doInBackground()
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask1 parserTask = new ParserTask1();

            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);
        }
    }
    private class DownloadTask2 extends AsyncTask<String, Void, String> {

        // Downloading data in non-ui thread
        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try {
                // Fetching the data from web service
                data = downloadUrl2(url[0]);
                Log.d("DownloadTask", "DownloadTask : " + data);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        // Executes in UI thread, after the execution of
        // doInBackground()
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask2 parserTask = new ParserTask2();

            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);
        }
    }
    private class DownloadTask3 extends AsyncTask<String, Void, String> {

        // Downloading data in non-ui thread
        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try {
                // Fetching the data from web service
                data = downloadUrl3(url[0]);
                Log.d("DownloadTask", "DownloadTask : " + data);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        // Executes in UI thread, after the execution of
        // doInBackground()
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask3 parserTask = new ParserTask3();

            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);
        }
    }
    private class DownloadTask4 extends AsyncTask<String, Void, String> {

        // Downloading data in non-ui thread
        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try {
                // Fetching the data from web service
                data = downloadUrl4(url[0]);
                Log.d("DownloadTask", "DownloadTask : " + data);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        // Executes in UI thread, after the execution of
        // doInBackground()
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask4 parserTask = new ParserTask4();

            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);
        }
    }
    private class DownloadTask5 extends AsyncTask<String, Void, String> {

        // Downloading data in non-ui thread
        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try {
                // Fetching the data from web service
                data = downloadUrl5(url[0]);
                Log.d("DownloadTask", "DownloadTask : " + data);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        // Executes in UI thread, after the execution of
        // doInBackground()
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask5 parserTask = new ParserTask5();

            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);
        }
    }

    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jObject = new JSONObject(jsonData[0]);
                DataParser parser = new DataParser();

                // Starts parsing data
                routes = parser.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        // Executes in UI thread, after the parsing process
        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;

            // Traversing through all the routes
            for (int i = 0; i < result.size(); i++) {
                points = new ArrayList<LatLng>();
                lineOptions = new PolylineOptions();

                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);

                // Fetching all the points in i-th route
                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(8);
                lineOptions.color(Color.RED);
            }

            // Drawing polyline in the Google Map for the i-th route
            if (lineOptions != null) {
                if (mPolyline != null) {
                    mPolyline.remove();
                }
                mPolyline = mMap.addPolyline(lineOptions);

            } else
                Toast.makeText(getApplicationContext(), "No route is found", Toast.LENGTH_LONG).show();
        }
    }
    private class ParserTask1 extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jObject = new JSONObject(jsonData[0]);
                DataParser parser = new DataParser();

                // Starts parsing data
                routes = parser.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        // Executes in UI thread, after the parsing process
        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;

            // Traversing through all the routes
            for (int i = 0; i < result.size(); i++) {
                points = new ArrayList<LatLng>();
                lineOptions = new PolylineOptions();

                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);

                // Fetching all the points in i-th route
                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(8);
                lineOptions.color(Color.BLUE);
            }

            // Drawing polyline in the Google Map for the i-th route
            if (lineOptions != null) {
                if (mPolyline1 != null) {
                    mPolyline1.remove();
                }
                mPolyline1 = mMap.addPolyline(lineOptions);

            } else
                Toast.makeText(getApplicationContext(), "No route is found", Toast.LENGTH_LONG).show();
        }
    }
    private class ParserTask2 extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jObject = new JSONObject(jsonData[0]);
                DataParser parser = new DataParser();

                // Starts parsing data
                routes = parser.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        // Executes in UI thread, after the parsing process
        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;

            // Traversing through all the routes
            for (int i = 0; i < result.size(); i++) {
                points = new ArrayList<LatLng>();
                lineOptions = new PolylineOptions();

                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);

                // Fetching all the points in i-th route
                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(8);
                lineOptions.color(Color.GREEN);
            }

            // Drawing polyline in the Google Map for the i-th route
            if (lineOptions != null) {
                if (mPolyline2 != null) {
                    mPolyline2.remove();
                }
                mPolyline2 = mMap.addPolyline(lineOptions);

            } else
                Toast.makeText(getApplicationContext(), "No route is found", Toast.LENGTH_LONG).show();
        }
    }
    private class ParserTask3 extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jObject = new JSONObject(jsonData[0]);
                DataParser parser = new DataParser();

                // Starts parsing data
                routes = parser.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        // Executes in UI thread, after the parsing process
        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;

            // Traversing through all the routes
            for (int i = 0; i < result.size(); i++) {
                points = new ArrayList<LatLng>();
                lineOptions = new PolylineOptions();

                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);

                // Fetching all the points in i-th route
                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(8);
                lineOptions.color(Color.YELLOW);
            }

            // Drawing polyline in the Google Map for the i-th route
            if (lineOptions != null) {
                if (mPolyline3 != null) {
                    mPolyline3.remove();
                }
                mPolyline3 = mMap.addPolyline(lineOptions);

            } else
                Toast.makeText(getApplicationContext(), "No route is found", Toast.LENGTH_LONG).show();
        }
    }
    private class ParserTask4 extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jObject = new JSONObject(jsonData[0]);
                DataParser parser = new DataParser();

                // Starts parsing data
                routes = parser.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        // Executes in UI thread, after the parsing process
        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;

            // Traversing through all the routes
            for (int i = 0; i < result.size(); i++) {
                points = new ArrayList<LatLng>();
                lineOptions = new PolylineOptions();

                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);

                // Fetching all the points in i-th route
                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(8);
                lineOptions.color(Color.MAGENTA);
            }

            // Drawing polyline in the Google Map for the i-th route
            if (lineOptions != null) {
                if (mPolyline4 != null) {
                    mPolyline4.remove();
                }
                mPolyline4 = mMap.addPolyline(lineOptions);

            } else
                Toast.makeText(getApplicationContext(), "No route is found", Toast.LENGTH_LONG).show();
        }
    }
    private class ParserTask5 extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jObject = new JSONObject(jsonData[0]);
                DataParser parser = new DataParser();

                // Starts parsing data
                routes = parser.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        // Executes in UI thread, after the parsing process
        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;

            // Traversing through all the routes
            for (int i = 0; i < result.size(); i++) {
                points = new ArrayList<LatLng>();
                lineOptions = new PolylineOptions();

                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);

                // Fetching all the points in i-th route
                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(8);
                lineOptions.color(Color.BLACK);
            }

            // Drawing polyline in the Google Map for the i-th route
            if (lineOptions != null) {
                if (mPolyline5 != null) {
                    mPolyline5.remove();
                }
                mPolyline5 = mMap.addPolyline(lineOptions);

            } else
                Toast.makeText(getApplicationContext(), "No route is found", Toast.LENGTH_LONG).show();
        }
    }





    ///////////////////////////////GA BELİRLİ ARAÇ ALGORİTMASI BASLANGIC

    private static List<GenetigiGelismisYol> populasyonuDoldur() {
        List<GenetigiGelismisYol> result = new ArrayList<>();

        for (int i = 0; i < 40; i++) {


            List<Yolcu> yolcular = new ArrayList<>(SehirVeArac.Yolcular);
            yolcular.get(0).setYolcuSayi(abc[0]);
            yolcular.get(1).setYolcuSayi(abc[1]);
            yolcular.get(2).setYolcuSayi(abc[2]);

            yolcular.get(3).setYolcuSayi(abc[3]);
            yolcular.get(4).setYolcuSayi(abc[4]);
            yolcular.get(5).setYolcuSayi(abc[5]);

            yolcular.get(6).setYolcuSayi(abc[6]);
            yolcular.get(7).setYolcuSayi(abc[7]);
            yolcular.get(8).setYolcuSayi(abc[8]);

            yolcular.get(9).setYolcuSayi(abc[9]);
            yolcular.get(10).setYolcuSayi(abc[10]);
            yolcular.get(11).setYolcuSayi(abc[11]);
            yolcular.sort((client1, client2) -> client2.yolcuSayi - client1.yolcuSayi);
            List<Araclar> araclars = SehirVeArac.aracListesiAl();

            System.out.println(yolcular.get(0).getYolcuSayi());
            int whichV = 0;
            while (!yolcular.isEmpty()) {

                System.out.println(yolcular);
                Yolcu yolcu = yolcular.get(0);
                if (yolcu.getYolcuSayi() == 0 && yolcular.size() > 1) {
                    yolcu = yolcular.get(1);
                } else {
                    yolcu = yolcular.get(0);
                }

                Araclar araclar;

                if (whichV % 3 == 0) {
                    araclar = araclars.get(2);
                } else if (whichV % 3 == 1) {
                    araclar = araclars.get(1);
                } else {
                    araclar = araclars.get(0);
                }
                whichV += 1;

                boolean sehirSilindiMi = false;
                while (!sehirSilindiMi) {
                    if (yolcu.yolcuSayi == 0) {
                        sehirSilindiMi = true;
                    } else {
                        if (yolcu.getYolcuSayi() + araclar.getKullanilanKapasite() > araclar.aracKapasite) {

                            araclar.gidilenYol.add(yolcu);
                            yolcu.setYolcuSayi((yolcu.getYolcuSayi() - (araclar.aracKapasite - araclar.getKullanilanKapasite())));
                            araclar.kapasiteBosalt();
                            araclar.setKullanilanKapasite(0);

                        } else if (yolcu.getYolcuSayi() + araclar.getKullanilanKapasite() == araclar.aracKapasite) {

                            araclar.gidilenYol.add(yolcu);
                            araclar.kapasiteBosalt();
                            araclar.setKullanilanKapasite(0);
                            yolcu.setYolcuSayi(0);
                            if (yolcu.getYolcuSayi() == 0) {
                                sehirSilindiMi = true;
                            }

                        } else {
                            araclar.gidilenYol.add(yolcu);
                            araclar.setKullanilanKapasite(yolcu.getYolcuSayi() + araclar.getKullanilanKapasite());
                            yolcu.setYolcuSayi(0);

                            if (yolcu.getYolcuSayi() == 0) {
                                sehirSilindiMi = true;
                            }
                        }
                    }
                }
                if (yolcular.get(0).getYolcuSayi() == 0) {
                    yolcular.remove(0);
                }

            }

            for (Araclar araclar : araclars) {
                if (araclar.gidilenYol.get(araclar.gidilenYol.size() - 1).isim == "Umuttepe") {
                    continue;
                } else
                    araclar.kapasiteBosalt();
            }
            result.add(new GenetigiGelismisYol(araclars));
        }

        System.out.println(result);
        return result;

    }

    private static List<GenetigiGelismisYol> reproduction(List<GenetigiGelismisYol> genetigiGelismisYol) {
        genetigiGelismisYol.sort(Comparator.comparingDouble(GenetigiGelismisYol::getDistance));
        return genetigiGelismisYol.subList(0, 20);
    }

    private static List<GenetigiGelismisYol> makeGeneticOperations(List<GenetigiGelismisYol> geciciPop) {
        return mutation(crossing(geciciPop));
    }

    private static List<GenetigiGelismisYol> crossing(List<GenetigiGelismisYol> geciciPop) {

        GenetigiGelismisYol genetigiGelismisYol1 = geciciPop.get(0);
        GenetigiGelismisYol genetigiGelismisYol2 = geciciPop.get(1);

        List<GenetigiGelismisYol> result = new ArrayList<>();
        int allClients = genetigiGelismisYol1.tumYolcular().size();
        int bound = allClients - 1;
        int firstCrossingPoint = ThreadLocalRandom.current().nextInt(bound);
        int origin = firstCrossingPoint + 1;
        int secondCrossingPoint = ThreadLocalRandom.current().nextInt(origin, allClients);

        List<GenetigiGelismisYol> crossed = cross(genetigiGelismisYol1, genetigiGelismisYol2, firstCrossingPoint, secondCrossingPoint);

        for (int i = 0; i < 5; i++) {
            result.addAll(crossed);
        }

        return result;
    }

    private static List<GenetigiGelismisYol> cross(GenetigiGelismisYol genetigiGelismisYol1, GenetigiGelismisYol genetigiGelismisYol2, int start, int end) {

        GenetigiGelismisYol child1 = genetigiGelismisYol1.copy();
        GenetigiGelismisYol child2 = genetigiGelismisYol2.copy();

        for (int index = start; index < end; index++) {
            child1.replace(index, genetigiGelismisYol2.tumYolcular().get(index));
            child2.replace(index, genetigiGelismisYol1.tumYolcular().get(index));
        }

        return Arrays.asList(child1, child2);
    }

    private static List<GenetigiGelismisYol> mutation(List<GenetigiGelismisYol> geciciPop) {
        return geciciPop.stream()
                .map(MapsActivity::mutate)
                .collect(Collectors.toList());
    }

    private static GenetigiGelismisYol mutate(GenetigiGelismisYol genetigiGelismisYol) {
        GenetigiGelismisYol newGenetigiGelismisYol = genetigiGelismisYol.copy();
        int firstItemIndex;
        int secondItemIndex;
        int maxIterations = 10;
        do {
            maxIterations--;
            int allClients = newGenetigiGelismisYol.tumYolcular().size();
            int bound = allClients - 1;
            firstItemIndex = ThreadLocalRandom.current().nextInt(bound);
            int origin = firstItemIndex + 1;
            secondItemIndex = ThreadLocalRandom.current().nextInt(origin, allClients);
        } while (!genetigiGelismisYol.replace(firstItemIndex, secondItemIndex) && maxIterations > 0);

        return newGenetigiGelismisYol;

    }

    private static List<GenetigiGelismisYol> succession(List<GenetigiGelismisYol> geciciPop, List<GenetigiGelismisYol> azalanPop) {
        geciciPop.sort(Comparator.comparingDouble(GenetigiGelismisYol::getDistance));
        azalanPop.sort(Comparator.comparingDouble(GenetigiGelismisYol::getDistance));

        List<GenetigiGelismisYol> yeniPop = new ArrayList<>();
        yeniPop.addAll(geciciPop.subList(0, 10));
        yeniPop.addAll(azalanPop.subList(0, 10));

        yeniPop.sort(Comparator.comparingDouble(GenetigiGelismisYol::getDistance));

        GenetigiGelismisYol enIyiYolIter = yeniPop.get(0);

        if (enIyiYol == null || enIyiYolIter.getDistance() < enIyiYol.getDistance()) {
            enIyiYol = enIyiYolIter;
            abcd = 0;
        } else {
            abcd++;
        }

        return yeniPop;
    }

    private static boolean populasyonSinir() {
        return abcd >= 6000;
    }


    /////////////////////////////////GA BELİRLİ ARAÇ ALGORİTMASI BİTİŞ

    /////////////////////////////////GA SINIRSIZ ARAÇ ALGORİTMASI BAŞLANGIÇ

    private static List<GenetigiGelismisYol> populasyonVeAracInit() {
        List<GenetigiGelismisYol> result = new ArrayList<>();

        for (int i = 0; i < 40; i++) {
            List<Yolcu> yolcular = new ArrayList<>(SehirVeArac2.Yolcular);

            yolcular.get(0).setYolcuSayi(39);
            yolcular.get(1).setYolcuSayi(0);
            yolcular.get(2).setYolcuSayi(0);

            yolcular.get(3).setYolcuSayi(0);
            yolcular.get(4).setYolcuSayi(0);
            yolcular.get(5).setYolcuSayi(30);

            yolcular.get(6).setYolcuSayi(30);
            yolcular.get(7).setYolcuSayi(0);
            yolcular.get(8).setYolcuSayi(0);

            yolcular.get(9).setYolcuSayi(0);
            yolcular.get(10).setYolcuSayi(10);
            yolcular.get(11).setYolcuSayi(0);
            yolcular.sort((client1, client2) -> client2.yolcuSayi - client1.yolcuSayi);

            List<Araclar> araclar1 = SehirVeArac2.aracListesiAl();

            for (int j = 0; j < yolcular.size(); j++) {
                if(yolcular.get(yolcular.size()-1).getYolcuSayi()==0){
                    yolcular.remove(yolcular.remove(yolcular.size()-1));
                }
                if(yolcular.size()>3){
                    if(yolcular.get(yolcular.size()-2).getYolcuSayi()==0){
                        yolcular.remove(yolcular.remove(yolcular.size()-2));
                    }
                }
                if(yolcular.size()>4){
                    if(yolcular.get(yolcular.size()-3).getYolcuSayi()==0){
                        yolcular.remove(yolcular.remove(yolcular.size()-3));
                    }
                }
            }

            while (!yolcular.isEmpty()) {
                Yolcu yolcu = yolcular.get(0);
                int vehicleNumber;
                Araclar araclar;
                do {
                    vehicleNumber = ThreadLocalRandom.current().nextInt(araclar1.size());
                    araclar = araclar1.get(vehicleNumber);
                } while (!araclar.yolcuyaGidilirMi(yolcu));

                araclar.yolcuyuZiyaretEt(yolcu);
                yolcular.remove(0);
            }

            for (Araclar araclar : araclar1) {
                araclar.kapasiteBosalt();
            }
            result.add(new GenetigiGelismisYol(araclar1));
        }

        return result;

    }

    private static List<GenetigiGelismisYol> populasyonVeAracInit2() {
        List<GenetigiGelismisYol> result = new ArrayList<>();

        for (int i = 0; i < 40; i++) {
            List<Yolcu> yolcular = new ArrayList<>(SehirVeArac2.Yolcular);

            yolcular.get(0).setYolcuSayi(39);
            yolcular.get(1).setYolcuSayi(0);
            yolcular.get(2).setYolcuSayi(0);

            yolcular.get(3).setYolcuSayi(0);
            yolcular.get(4).setYolcuSayi(0);
            yolcular.get(5).setYolcuSayi(30);

            yolcular.get(6).setYolcuSayi(30);
            yolcular.get(7).setYolcuSayi(0);
            yolcular.get(8).setYolcuSayi(0);

            yolcular.get(9).setYolcuSayi(0);
            yolcular.get(10).setYolcuSayi(10);
            yolcular.get(11).setYolcuSayi(0);
            yolcular.sort((client1, client2) -> client2.yolcuSayi - client1.yolcuSayi);

            List<Araclar> araclar2 = SehirVeArac2.aracListesiAl1();

            for (int j = 0; j < yolcular.size(); j++) {
                if(yolcular.get(yolcular.size()-1).getYolcuSayi()==0){
                    yolcular.remove(yolcular.remove(yolcular.size()-1));
                }
                if(yolcular.size()>3){
                    if(yolcular.get(yolcular.size()-2).getYolcuSayi()==0){
                        yolcular.remove(yolcular.remove(yolcular.size()-2));
                    }
                }
                if(yolcular.size()>4){
                    if(yolcular.get(yolcular.size()-3).getYolcuSayi()==0){
                        yolcular.remove(yolcular.remove(yolcular.size()-3));
                    }
                }
            }
            while (!yolcular.isEmpty()) {
                Yolcu yolcu = yolcular.get(0);

                int vehicleNumber;

                Araclar araclar;

                do {
                    vehicleNumber = ThreadLocalRandom.current().nextInt(araclar2.size());
                    araclar = araclar2.get(vehicleNumber);
                } while (!araclar.yolcuyaGidilirMi(yolcu));

                araclar.yolcuyuZiyaretEt(yolcu);
                yolcular.remove(0);
            }

            for (Araclar araclar : araclar2) {
                araclar.kapasiteBosalt();
            }

            result.add(new GenetigiGelismisYol(araclar2));

        }
        return result;

    }


    private static List<GenetigiGelismisYol> populasyonVeAracInit3() {
        List<GenetigiGelismisYol> result = new ArrayList<>();

        for (int i = 0; i < 40; i++) {

            List<Yolcu> yolcular = new ArrayList<>(SehirVeArac2.Yolcular);

            yolcular.get(0).setYolcuSayi(39);
            yolcular.get(1).setYolcuSayi(0);
            yolcular.get(2).setYolcuSayi(0);

            yolcular.get(3).setYolcuSayi(0);
            yolcular.get(4).setYolcuSayi(0);
            yolcular.get(5).setYolcuSayi(30);

            yolcular.get(6).setYolcuSayi(30);
            yolcular.get(7).setYolcuSayi(0);
            yolcular.get(8).setYolcuSayi(0);

            yolcular.get(9).setYolcuSayi(0);
            yolcular.get(10).setYolcuSayi(10);
            yolcular.get(11).setYolcuSayi(0);
            yolcular.sort((client1, client2) -> client2.yolcuSayi - client1.yolcuSayi);


            List<Araclar> araclar3 = SehirVeArac2.aracListesiAl2();

            for (int j = 0; j < yolcular.size(); j++) {
                if(yolcular.get(yolcular.size()-1).getYolcuSayi()==0){
                    yolcular.remove(yolcular.remove(yolcular.size()-1));
                }
                if(yolcular.size()>3){
                    if(yolcular.get(yolcular.size()-2).getYolcuSayi()==0){
                        yolcular.remove(yolcular.remove(yolcular.size()-2));
                    }
                }
                if(yolcular.size()>4){
                    if(yolcular.get(yolcular.size()-3).getYolcuSayi()==0){
                        yolcular.remove(yolcular.remove(yolcular.size()-3));
                    }
                }
            }
            while (!yolcular.isEmpty()) {
                Yolcu yolcu = yolcular.get(0);

                int vehicleNumber;

                Araclar araclar;

                do {
                    vehicleNumber = ThreadLocalRandom.current().nextInt(araclar3.size());
                    araclar = araclar3.get(vehicleNumber);
                } while (!araclar.yolcuyaGidilirMi(yolcu));

                araclar.yolcuyuZiyaretEt(yolcu);
                yolcular.remove(0);
            }

            for (Araclar araclar : araclar3) {
                araclar.kapasiteBosalt();
            }

            result.add(new GenetigiGelismisYol(araclar3));

        }

        return result;

    }

    private static List<GenetigiGelismisYol> populasyonVeAracInit4() {
        List<GenetigiGelismisYol> result = new ArrayList<>();

        for (int i = 0; i < 40; i++) {
            List<Yolcu> yolcular = new ArrayList<>(SehirVeArac2.Yolcular);

            yolcular.get(0).setYolcuSayi(39);
            yolcular.get(1).setYolcuSayi(0);
            yolcular.get(2).setYolcuSayi(0);

            yolcular.get(3).setYolcuSayi(0);
            yolcular.get(4).setYolcuSayi(0);
            yolcular.get(5).setYolcuSayi(30);

            yolcular.get(6).setYolcuSayi(30);
            yolcular.get(7).setYolcuSayi(0);
            yolcular.get(8).setYolcuSayi(0);

            yolcular.get(9).setYolcuSayi(0);
            yolcular.get(10).setYolcuSayi(10);
            yolcular.get(11).setYolcuSayi(0);
            yolcular.sort((client1, client2) -> client2.yolcuSayi - client1.yolcuSayi);


            List<Araclar> araclar4 = SehirVeArac2.aracListesiAl3();

            for (int j = 0; j < yolcular.size(); j++) {
                if(yolcular.get(yolcular.size()-1).getYolcuSayi()==0){
                    yolcular.remove(yolcular.remove(yolcular.size()-1));
                }
                if(yolcular.size()>3){
                    if(yolcular.get(yolcular.size()-2).getYolcuSayi()==0){
                        yolcular.remove(yolcular.remove(yolcular.size()-2));
                    }
                }
                if(yolcular.size()>4){
                    if(yolcular.get(yolcular.size()-3).getYolcuSayi()==0){
                        yolcular.remove(yolcular.remove(yolcular.size()-3));
                    }
                }
            }
            while (!yolcular.isEmpty()) {
                Yolcu yolcu = yolcular.get(0);

                int vehicleNumber;

                Araclar araclar;

                do {
                    vehicleNumber = ThreadLocalRandom.current().nextInt(araclar4.size());
                    araclar = araclar4.get(vehicleNumber);
                } while (!araclar.yolcuyaGidilirMi(yolcu));

                araclar.yolcuyuZiyaretEt(yolcu);
                yolcular.remove(0);
            }

            for (Araclar araclar : araclar4) {
                araclar.kapasiteBosalt();
            }

            result.add(new GenetigiGelismisYol(araclar4));

        }

        return result;

    }

    private static List<GenetigiGelismisYol> populasyonVeAracInit5() {
        List<GenetigiGelismisYol> result = new ArrayList<>();

        for (int i = 0; i < 40; i++) {
            List<Yolcu> yolcular = new ArrayList<>(SehirVeArac2.Yolcular);

            yolcular.get(0).setYolcuSayi(39);
            yolcular.get(1).setYolcuSayi(0);
            yolcular.get(2).setYolcuSayi(0);

            yolcular.get(3).setYolcuSayi(0);
            yolcular.get(4).setYolcuSayi(0);
            yolcular.get(5).setYolcuSayi(30);

            yolcular.get(6).setYolcuSayi(30);
            yolcular.get(7).setYolcuSayi(0);
            yolcular.get(8).setYolcuSayi(0);

            yolcular.get(9).setYolcuSayi(0);
            yolcular.get(10).setYolcuSayi(10);
            yolcular.get(11).setYolcuSayi(0);
            yolcular.sort((client1, client2) -> client2.yolcuSayi - client1.yolcuSayi);

            List<Araclar> araclar5 = SehirVeArac2.aracListesiAl4();

            for (int j = 0; j < yolcular.size(); j++) {
                if(yolcular.get(yolcular.size()-1).getYolcuSayi()==0){
                    yolcular.remove(yolcular.remove(yolcular.size()-1));
                }
                if(yolcular.size()>3){
                    if(yolcular.get(yolcular.size()-2).getYolcuSayi()==0){
                        yolcular.remove(yolcular.remove(yolcular.size()-2));
                    }
                }
                if(yolcular.size()>4){
                    if(yolcular.get(yolcular.size()-3).getYolcuSayi()==0){
                        yolcular.remove(yolcular.remove(yolcular.size()-3));
                    }
                }
            }
            while (!yolcular.isEmpty()) {
                Yolcu yolcu = yolcular.get(0);

                int vehicleNumber;

                Araclar araclar;

                do {
                    vehicleNumber = ThreadLocalRandom.current().nextInt(araclar5.size());
                    araclar = araclar5.get(vehicleNumber);
                } while (!araclar.yolcuyaGidilirMi(yolcu));

                araclar.yolcuyuZiyaretEt(yolcu);
                yolcular.remove(0);
            }

            for (Araclar araclar : araclar5) {
                araclar.kapasiteBosalt();
            }

            result.add(new GenetigiGelismisYol(araclar5));

        }

        return result;

    }

    private static List<GenetigiGelismisYol> reproduction2(List<GenetigiGelismisYol> genetigiGelismisYols) {
        genetigiGelismisYols.sort(Comparator.comparingDouble(GenetigiGelismisYol::getDistance));
        return genetigiGelismisYols.subList(0, 20);
    }

    private static List<GenetigiGelismisYol> gaOperate(List<GenetigiGelismisYol> temporaryPopulation) {
        return gaMutation(gaCross(temporaryPopulation));
    }

    private static List<GenetigiGelismisYol> gaCross(List<GenetigiGelismisYol> temporaryPopulation) {

        GenetigiGelismisYol genetigiGelismisYol1 = temporaryPopulation.get(0);
        GenetigiGelismisYol genetigiGelismisYol2 = temporaryPopulation.get(1);

        List<GenetigiGelismisYol> result = new ArrayList<>();
        int allClients = genetigiGelismisYol1.tumYolcular().size();
        int bound = allClients - 1;
        int firstCrossingPoint = ThreadLocalRandom.current().nextInt(bound);
        int origin = firstCrossingPoint + 1;
        int secondCrossingPoint = ThreadLocalRandom.current().nextInt(origin, allClients);

        List<GenetigiGelismisYol> crossed = gaCrossover(genetigiGelismisYol1, genetigiGelismisYol2, firstCrossingPoint, secondCrossingPoint);

        for (int i = 0; i < 5; i++) {
            result.addAll(crossed);
        }

        return result;
    }

    private static List<GenetigiGelismisYol> gaCrossover(GenetigiGelismisYol genetigiGelismisYol1, GenetigiGelismisYol genetigiGelismisYol2, int start, int end) {

        GenetigiGelismisYol child1 = genetigiGelismisYol1.copy();
        GenetigiGelismisYol child2 = genetigiGelismisYol2.copy();

        for (int index = start; index < end; index++) {
            child1.replace(index, genetigiGelismisYol2.tumYolcular().get(index));
            child2.replace(index, genetigiGelismisYol1.tumYolcular().get(index));
        }

        return Arrays.asList(child1, child2);
    }

    private static List<GenetigiGelismisYol> gaMutation(List<GenetigiGelismisYol> temporaryPopulation) {
        return temporaryPopulation.stream()
                .map(MapsActivity::gaMutateChromosome)
                .collect(Collectors.toList());
    }

    private static GenetigiGelismisYol gaMutateChromosome(GenetigiGelismisYol genetigiGelismisYol) {
        GenetigiGelismisYol newGenetigiGelismisYol = genetigiGelismisYol.copy();
        int firstItemIndex;
        int secondItemIndex;
        int maxIterations = 10;
        do {
            maxIterations--;
            int allClients = newGenetigiGelismisYol.tumYolcular().size();
            int bound = allClients - 1;
            firstItemIndex = ThreadLocalRandom.current().nextInt(bound);
            int origin = firstItemIndex + 1;
            secondItemIndex = ThreadLocalRandom.current().nextInt(origin, allClients);
        } while (!genetigiGelismisYol.replace(firstItemIndex, secondItemIndex) && maxIterations > 0);

        return newGenetigiGelismisYol;

    }

    private static List<GenetigiGelismisYol> basariliGen(List<GenetigiGelismisYol> temporaryPopulation, List<GenetigiGelismisYol> descendantPopulation) {
        temporaryPopulation.sort(Comparator.comparingDouble(GenetigiGelismisYol::getDistance));
        descendantPopulation.sort(Comparator.comparingDouble(GenetigiGelismisYol::getDistance));

        List<GenetigiGelismisYol> newBasePopulation = new ArrayList<>();
        newBasePopulation.addAll(temporaryPopulation.subList(0, 10));
        newBasePopulation.addAll(descendantPopulation.subList(0, 10));

        newBasePopulation.sort(Comparator.comparingDouble(GenetigiGelismisYol::getDistance));

        GenetigiGelismisYol bestSolutionInIteration = newBasePopulation.get(0);

        if (enIyiYol2 == null || bestSolutionInIteration.getDistance() < enIyiYol2.getDistance()) {
            enIyiYol2 = bestSolutionInIteration;
            abcd = 0;
        } else {
            abcd++;
        }

        System.out.println("BEST SOLUTION    -->      " + enIyiYol2.getDistance() + "           " + abcd);
        return newBasePopulation;
    }

    private static void enIyiYazdir(GenetigiGelismisYol bestSolution) {

        System.out.println("<--FINISHED WITH-->");
        System.out.println(bestSolution);

    }

    ///////////////////////////////////////////GA SINIRSIZ ARAÇ ALGORİTMASI BİTİŞ


}
