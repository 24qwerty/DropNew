package com.example.csa.dropnew;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap m_map;
    GoogleApiClient client;
    Button signin;
    EditText uname,password,email;
    JSONParser jParser = new JSONParser();
    String uname1,pass1,email1,lat1,lng1;
    JSONObject json;
    private static String url_login = "http://10.0.2.2:8080/AndroidLogin/login_servlet";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signin= (Button) findViewById(R.id.button1);
        uname= (EditText) findViewById(R.id.txtUser);
        password= (EditText) findViewById(R.id.txtPass);
        email= (EditText) findViewById(R.id.txtEmail);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname1=uname.getText().toString();
                pass1=password.getText().toString();
                email1=email.getText().toString();
                UserLocation ul=new UserLocation();
                try {
                    Socket soc=new Socket("localhost",6789);
                    ul.setEmail(email1);
                    ul.setPassword(Integer.parseInt(pass1));
                    ul.setName(uname1);
                    ul.setLatitude(12.22);
                    ul.setLongitude(23.45);
                    OutputStream os=soc.getOutputStream();
                    ObjectOutputStream oos=new ObjectOutputStream(os);
                    oos.writeObject(ul);
                    oos.flush();
                    os.close();
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //         String url = "//localhost:3000//DropImpl";
//                IDrop objc = (IDrop)Naming.lookup(url);
//                byte[] grade = objc.getfile(ar[2]);
//                for(int i=0;i<grade.length;i++)
//                {
//                    System.out.print((char)grade[i]);
//                    //System.out.println("we r here");
//                }
//                new Login().execute();
//                addUser();
//                Intent i=new Intent(MainActivity.this,HomeActivity.class);
//                startActivity(i);
            }
        });
        final MapFragment mapFragment= (MapFragment) getFragmentManager().findFragmentById(R.id.googleMap1);
        mapFragment.getMapAsync(this);
        client=new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        //addMarker();
    }
    void addUser(){

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        m_map = googleMap;
        LatLng vad = new LatLng(22.3072, 73.1812);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        m_map.setMyLocationEnabled(true);
        final CameraPosition cp = CameraPosition.builder().target(vad).zoom(10).build();
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(cp));

        m_map.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                addUserLocation2(latLng.latitude,latLng.longitude);
                lat1=(latLng.latitude)+"";
                lng1=latLng.longitude+"";
                Toast.makeText(MainActivity.this,"Location Added.\nPress Done", Toast.LENGTH_LONG).show();
            }
        });
    }
    void addUserLocation2(final double lat, final double log){
        //add insert code.
    }
    void addMarker(UserLocation userLocation) {
        LatLng latLng=new LatLng(userLocation.getLatitude(),userLocation.getLongitude());
        MarkerOptions buf = new MarkerOptions().position(latLng);//icon(BitmapDescriptorFactory.fromResource(resource)).
        m_map.addMarker(buf);

    }
//    private class Login extends AsyncTask<String, String, String> {
//
//        @Override
//        protected String doInBackground(String... args) {
//            // Getting username and password from user input
////            String username = uname.getText().toString();
////            String pass = password.getText().toString();
////            String email=email.getText().toString();
//            List<NameValuePair> params = new ArrayList<NameValuePair>();
//            params.add(new BasicNameValuePair("u",uname1));
//            params.add(new BasicNameValuePair("p",pass1));
//            params.add(new BasicNameValuePair("e",email1));
//            params.add(new BasicNameValuePair("lat",lat1));
//            params.add(new BasicNameValuePair("lng",lng1));
//            json = jParser.makeHttpRequest(url_login, "GET", params);
//            String s=null;
//
//            try {
//                s= json.getString("info");
//                Log.d("Msg", json.getString("info"));
//                if(s.equals("success")){
//                    Intent login = new Intent(getApplicationContext(), HomeActivity.class);
//                    login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    startActivity(login);
//                    finish();
//                }
//            } catch (JSONException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//
//            return null;
//        }
//
//    }
}
