package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val message = Message.builder()
        .putData("action", "NEWPOST")
        .putData("content", """{
          "postAuthor": "Netology",
          "postText": " оманда Ќетологии помогает освоить новую профессию и навыки из любой точки мира. Ёто даЄт человеку возможность жить более счастливой и наполненной жизнью: заниматьс€ любимым делом, путешествовать, проводить врем€ с семьЄй и в целом Ч гармонично развиватьс€. Ѕольшинство наших студентов проход€т через эту важную трансформацию и станов€тс€ успешными. ƒл€ нас это показатель, что мы двигаемс€ в правильном направлении."
        }""".trimIndent())
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(message)
}