package com.example.android.sunshine.sync;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

// TODO (9) Create a class called SunshineSyncUtils
    //  TODO (10) Create a public static void method called startImmediateSync
    //  TODO (11) Within that method, start the SunshineSyncIntentService
    public class SunshineSyncUtils{
        public static void startImmediateSync(@NonNull final Context context){

            /*Por ejemplo, una actividad puede iniciar el servicio
             usando una intent explícita con startService():
            Intent intent = new Intent(this, HelloService.class);
            startService(intent);*/

            Intent intentToSyncImmediately = new Intent(context, SunshineSyncIntentService.class);
            context.startService(intentToSyncImmediately);
        }
}