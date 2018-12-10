package fall.jonathan.octocal.principal.principal.dashboard;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.TimeZone;

import fall.jonathan.octocal.R;
import fall.jonathan.octocal.databinding.ActivityDashboardBinding;
import fall.jonathan.octocal.principal.principal.core.Weather;
import fall.jonathan.octocal.principal.principal.login.LogView;

public class DashboardView extends AppCompatActivity implements DashUnderpinningInterf.dashViewStuff {
    private DashboardPresenter myPres;
    public static TextView place;
    public static TextView temp;
    public static TextView humidity;
    public static TextView pressure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDashboardBinding binder = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);
        myPres = new DashboardPresenter(this);
       binder.setDashPresenter(myPres);

       View  av=new View(this);
       myPres.onFilling(av);
       myPres.onGetData(av);
       // fillSpace();
    }


    protected void onResume() {
        super.onResume();

    }



    @Override
    public void fillSpace() {
        TextView dataTZ = findViewById(R.id.timezone);
        dataTZ.setText(TimeZone.getDefault().getDisplayName());
        Intent data = getIntent();
        String message = "Welcome ";
        if (data.hasExtra("Username")) {
            TextView usrN = findViewById(R.id.toFill);
            usrN.setText(message + data.getExtras().getString("Username"));
        }

    }

    @Override
    public void getData() {


        place =  findViewById(R.id.place);
        temp =  findViewById(R.id.temp);
        humidity = findViewById(R.id.humidity);
        pressure = findViewById(R.id.pressure);

        LocationManager locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        String provider = locManager.getBestProvider(new Criteria(), false);
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            Toast.makeText(this,"Please grant location access permission!",Toast.LENGTH_SHORT).show();
            return;
        }
        Location location = locManager.getLastKnownLocation(provider);
        Double longitude = location.getLongitude();
        Double latitude = location.getLatitude();

        Weather getData = new Weather();
        getData.execute("https://samples.openweathermap.org/data/2.5/weather?lat="+String.valueOf(latitude)+"&lon="+String.valueOf(longitude)+"&appid=b6907d289e10d714a6e88b30761fae22");

    }

    @Override
    public void logout() {
        Intent intent = new Intent(this, LogView.class);
        startActivity(intent);
        finish();
    }




}
