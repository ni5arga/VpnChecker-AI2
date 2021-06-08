package xyz.nisarga.VpnChecker;

import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.common.*;
import java.io.*;
import java.util.*;
import java.net.*;
import android.util.*;


@DesignerComponent(version = 1,
                   description = "VpnChecker Extension",
                   category = ComponentCategory.EXTENSION,
                   nonVisible = true,
                   iconName = "images/extension.png") // Change your extension's icon from here; can be a direct url
@SimpleObject(external = true)
public class VpnChecker extends AndroidNonvisibleComponent {

    public VpnChecker(ComponentContainer container) {
        super(container.$form());
    }

    @SimpleFunction(description = "")
    public boolean isUsingVPN() {
    String iface = "";
    try {
        for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
            if (networkInterface.isUp())
                iface = networkInterface.getName();
            if ( iface.contains("tun") || iface.contains("ppp") || iface.contains("pptp")) {
                return true;
            }
        }
    } catch (SocketException e1) {
        e1.printStackTrace();
    }

    return false;
}

}