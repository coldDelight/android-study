package com.colddelight.firebaseauth

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.colddelight.firebaseauth.databinding.ActivityMainBinding
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
    private lateinit var  binding: ActivityMainBinding
    private  val auth : FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(auth.currentUser==null){//로그인 안함
            replaceFragment(LoginFragment())
        }else{//로그인 한 상태
            replaceFragment(HomeFragment())
        }
    }
    fun replaceFragment(fragment:Fragment) {//프레그먼트 교체
        supportFragmentManager.beginTransaction().replace(R.id.fcv, fragment).commit()
    }

    fun removeCache(){
        GoogleSignIn.getClient(this , GoogleSignInOptions.DEFAULT_SIGN_IN).signOut()
    }

    fun signInGoogle(){
        val googleSignInOptions = GoogleSignInOptions.Builder(
            GoogleSignInOptions.DEFAULT_SIGN_IN
        ).requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        val googleSignInClient = GoogleSignIn.getClient(this , googleSignInOptions)
        val signInIntent = googleSignInClient.signInIntent
        launcher.launch(signInIntent)
    }
    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if (result.resultCode == Activity.RESULT_OK){
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            handleResults(task)
        }
    }
    private fun handleResults(task: Task<GoogleSignInAccount>) {
        if (task.isSuccessful){
            val account : GoogleSignInAccount? = task.result
            if (account != null){
                updateUI(account)
            }
        }else{
            Log.e("res err", "handleResults: ${task.exception.toString()}", )
        }
    }
    private fun updateUI(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken , null)
        auth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful){
                replaceFragment(HomeFragment())
            }else{
                Toast.makeText(this, it.exception.toString() , Toast.LENGTH_SHORT).show()
            }
        }
    }

}