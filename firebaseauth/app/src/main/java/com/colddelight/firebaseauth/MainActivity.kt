package com.colddelight.firebaseauth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    var googleSignInClient: GoogleSignInClient? = null
    var firebaseAuth: FirebaseAuth? = null
    private val auth: FirebaseAuth = Firebase.auth


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btSignIn: Button = findViewById(R.id.button)

        val googleSignInOptions = GoogleSignInOptions.Builder(
            GoogleSignInOptions.DEFAULT_SIGN_IN
        ).requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient= GoogleSignIn.getClient(this
            ,googleSignInOptions);

        btSignIn.setOnClickListener(){
            val intent = googleSignInClient!!.signInIntent
            startActivityForResult(intent, 100)
        }
        firebaseAuth=FirebaseAuth.getInstance();
        val firebaseUser = firebaseAuth!!.currentUser
//        val firebaseUser = FirebaseAuth.getInstance().currentUser

        if (firebaseUser != null) {
            startActivity(
                Intent(this@MainActivity, MainActivity::class.java)
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, @Nullable data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Check condition
        if (requestCode == 100) {
            // When request code is equal to 100
            // Initialize task
            val signInAccountTask: Task<GoogleSignInAccount> = GoogleSignIn
                .getSignedInAccountFromIntent(data)
            // check condition
            if (signInAccountTask.isSuccessful()) {
                // When google sign in successful
                // Initialize string
                val s = "Google sign in successful"
                // Initialize sign in account
                try {
                    // Initialize sign in account
                    val googleSignInAccount: GoogleSignInAccount = signInAccountTask
                        .getResult(ApiException::class.java)
                    // Check condition
                    if (googleSignInAccount != null) {
                        // When sign in account is not equal to null
                        // Initialize auth credential
                        val authCredential = GoogleAuthProvider
                            .getCredential(
                                googleSignInAccount.idToken, null
                            )
                        // Check credential
                        firebaseAuth!!.signInWithCredential(authCredential)
                            .addOnCompleteListener(
                                this
                            ) { task ->
                                // Check condition
                                if (task.isSuccessful) {
                                    // When task is successful
                                    // Redirect to profile activity
                                    startActivity(
                                        Intent(this@MainActivity, MainActivity::class.java)
                                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                    )
                                } else {
                                    // When task is unsuccessful
                                }
                            }
                    }
                } catch (e: ApiException) {
                    e.printStackTrace()
                }
            }
        }
    }
}