package com.altaygunbatan.uni_verse.API

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.altaygunbatan.uni_verse.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.firebase.messaging.remoteMessage

class MessagingService: FirebaseMessagingService() {
    override fun onMessageReceived(message: RemoteMessage) {
        remoteMessage.notification?.let {
            sendNotification(it.title, it.body)
        }
    }

    private fun sendNotification(title: String?, message: String?) {
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notification = NotificationCompat.Builder(this, "EVENT_CHANNEL")
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(R.drawable.ic_notification)
            .build()
        notificationManager.notify(1, notification)
    }
}