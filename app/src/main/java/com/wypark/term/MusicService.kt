package com.wypark.term

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MusicService : Service() {

    var m1=MediaPlayer()

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onDestroy() {
        m1.stop()
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        m1=MediaPlayer.create(this,R.raw.for_river)
        m1.start()
        return super.onStartCommand(intent, flags, startId)
    }


}
