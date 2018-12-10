package fall.jonathan.octocal.principal.principal.core;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import fall.jonathan.octocal.principal.principal.dashboard.DashboardView;


public class Weather extends AsyncTask<String,Void,String> {


    String result;
    @Override
    protected String doInBackground(String... urls) {
        result = "";
        URL link;
        HttpURLConnection myconnection = null;

        try {
            link = new URL(urls[0]);
            myconnection = (HttpURLConnection)link.openConnection();
            InputStream in = myconnection.getInputStream();
            InputStreamReader myStreamReader = new InputStreamReader(in);
            int data = myStreamReader.read();
            while(data!= -1){
                char current = (char)data;
                result+= current;
                data = myStreamReader.read();
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONObject myObject = new JSONObject(result);
            JSONObject main = new JSONObject(myObject.getString("main"));
            double temperature = Double.parseDouble(main.getString("temp"));
            //fareinheit
            int tempInteger = (int) (temperature*1.8 - 459.67);
            String placeName = myObject.getString("name");

            double pressure = Double.parseDouble(main.getString("pressure"));
            int humidity = main.getInt("humidity");
            JSONObject sys = new JSONObject(myObject.getString("sys"));
            String country = sys.getString("country");


            // DashboardView.country.setText(country);
            DashboardView.pressure.setText(String.valueOf(pressure));
            DashboardView.humidity.setText(String.valueOf(humidity));

            DashboardView.place.setText(placeName+", "+country);
            DashboardView.temp.setText(String.valueOf(tempInteger));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
