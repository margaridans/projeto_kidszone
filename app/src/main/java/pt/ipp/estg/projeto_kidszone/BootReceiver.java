package pt.ipp.estg.projeto_kidszone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Bernardino on 19/01/2018.
 */

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Service stops", "Ohhh");
        context.startService(new Intent(context, NotificationService.class));
    }
}
