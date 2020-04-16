package lee.study.kotlinmessenger.registerlogin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import lee.study.kotlinmessenger.R
import lee.study.kotlinmessenger.messages.LatestMessagesActivity

class LoginActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_button_login.setOnClickListener {
            val email = email_edittext_login.text.toString()
            val password = password_edittext_login.text.toString()
            Log.d("Login", "Attempt login with email/pw: $email/$password")
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
                .addOnSuccessListener {
                    Log.d("Login", "Login Success")
                    val intent = Intent(this, LatestMessagesActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                }
                .addOnSuccessListener {
                    Log.d("Login", it.toString())
                }
                .addOnFailureListener {
                    Log.d("Login", it.toString())
                }

        }

        back_to_register_text_view.setOnClickListener{
            finish()
        }

    }
}