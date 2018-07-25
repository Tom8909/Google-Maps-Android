package com.example.tom.introtomaps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final LatLng CHAPEL_STREET_UK = new LatLng( 53.4618112,-2.74432); //locations
    private static final LatLng OLD_TRAFFORD = new LatLng( 53.463055555556,-2.2913888888889);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }




    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.addMarker(new MarkerOptions()
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.oldtrafford)) //sets marker to be the specified image
                                .anchor(0.0f, 1.0f) //sets anchor of image
                                .title("Old Trafford")
                                .position(OLD_TRAFFORD)); //from gloabl variable above OLD_TRAFFORD

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.homeuk)) //sets marker to be the specified image
                .anchor(0.0f, 1.0f) //sets anchor of image
                .title("Home!!")
                .position(CHAPEL_STREET_UK)); //from gloabl variable above CHAPEL_STREET_UK

        //allows us to set default camera position at start of app
        CameraPosition cameraPosition = new CameraPosition.Builder()
                            .target(CHAPEL_STREET_UK)
                            .zoom(15)
                            .bearing(0)
                            .tilt(30)
                            .build(); //builds the above settings

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition)); //runs the above code
    }


    //returns option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.maps, menu); //inflates the menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_normal: //make connection to the action_normal item in menu
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL); //displays the normal map type
                break;

            case R.id.action_hybrid: //make connection to the action_normal item in menu
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID); //displays the hybrid map type
                break;

            case R.id.action_satellite: //make connection to the action_normal item in menu
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE); //displays the satellite map type
                break;

            case R.id.action_terrain: //make connection to the action_normal item in menu
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN); //displays the terrain map type
                break;

            case R.id.action_none: //make connection to the action_normal item in menu
                mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
                break;
        }




        return true;
    }
}
