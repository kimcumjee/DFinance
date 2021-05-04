package com.study.dfinance.view

import android.content.Intent
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.project.simplecode.spaIntent
import com.study.dfinance.BaseActivity
import com.study.dfinance.viewModel.LoginViewModel
import com.study.dfinance.R
import com.study.dfinance.databinding.ActivityLoginBinding


class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {
    override lateinit var binding: ActivityLoginBinding
    override val viewModel = LoginViewModel()
    override val layoutRes: Int
        get() = R.layout.activity_login
    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var googleSignInClient: GoogleSignInClient

    private val RC_SIGN_IN = 99
    override fun observerViewModel() {

    }
    override fun init() {
        val loginBtn = findViewById<SignInButton>(R.id.google_login_btn)
        loginBtn.setOnClickListener { signIn() }

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        firebaseAuth = FirebaseAuth.getInstance()
    }

    //현재 로그인 되어 있는지 확인
    public override fun onStart() {
        super.onStart()
        val account = GoogleSignIn.getLastSignedInAccount(this)
        if (account !== null) {
            toMainActivity(firebaseAuth.currentUser)
            spaIntent(MainActivity::class.java)
        }
    }

    //LoginActivity 로 이동
    private fun toMainActivity(user: FirebaseUser?) {
        if (user != null) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    //google login view 호출
    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {

                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account!!)

            } catch (e: ApiException) {

                Log.w("LoginActivity", "Google sign in failed", e)
            }
        }
    }
    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        Log.d("LoginActivity", "firebaseAuthWithGoogle:" + acct.id!!)

        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.w("LoginActivity", "firebaseAuthWithGoogle 성공", task.exception)
                    val user = firebaseAuth.currentUser
                    Log.d("account", "account : ${user!!.email}")
                    spaIntent(MainActivity::class.java)

                } else {
                    Log.w("LoginActivity", "firebaseAuthWithGoogle 실패", task.exception)
                    Log.e("로그인", "로그인에 실패했습니다.")
                }
            }
    }
}