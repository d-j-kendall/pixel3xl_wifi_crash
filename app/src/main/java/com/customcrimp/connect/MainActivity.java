package com.customcrimp.connect;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WifiManager mWifi = (WifiManager) this.getSystemService(this.WIFI_SERVICE);
        WifiConfiguration conf = new WifiConfiguration();
        conf.SSID = "\"yourssidhere\"";
        conf.preSharedKey = "\"yourpasshere\"";
        mWifi.addNetwork(conf);
        List<WifiConfiguration> list = mWifi.getConfiguredNetworks();
        for( WifiConfiguration i : list ) {
            if(i.SSID != null && i.SSID.equals("\"yourssidhere\"")) {
                mWifi.disconnect();
                mWifi.enableNetwork(i.networkId, true);
                mWifi.reconnect();

                break;
            }
        }
    }
}
