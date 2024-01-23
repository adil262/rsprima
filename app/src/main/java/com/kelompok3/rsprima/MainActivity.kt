package com.kelompok3.rsprima

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.kelompok3.rsprima.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //ProgressDialog
    private lateinit var progressDialog: ProgressDialog

    //firebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth
    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //configure progress dialog
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please Wait")
        progressDialog.setMessage("Logging In...")
        progressDialog.setCanceledOnTouchOutside(false)

        //init firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

//        btnLog.setOnClickListener {
//            val email = inputE.text.toString()
//            val password = inputPass.text.toString()
//            if (email.isEmpty()|| password.isEmpty()) {
//                validateData()
//            }
//            if(email == "admin@gmail.com" || password == "admin"){
//                val progressDialog = ProgressDialog(this,
//                    R.style.Theme_MaterialComponents_Light_Dialog)
//                progressDialog.isIndeterminate = true
//                progressDialog.setMessage("Loading...")
//                progressDialog.show()
//                val intent = Intent (this,AdminActivity::class.java)
//                startActivity(intent)
//                finish()
//            }
//        }

        //handle click, begin login
        binding.btnLog.setOnClickListener{
            //before logging in, validate data
            validateData()
            startActivity(Intent(this, DashboardActivity::class.java))
        }
//        //handle click, open register activity
        binding.btnRegis.setOnClickListener {
            startActivity(Intent(this, RegistActivity::class.java))
        }
//        //handle click, open signupActivity
        binding.btnRegis.setOnClickListener{
            startActivity(Intent(this, RegistActivity::class.java))
        }
        binding.btnAdmin.setOnClickListener{
            startActivity(Intent(this, AdminActivity::class.java))
        }

    }

    private fun validateData() {
        //get data
        email = binding.inputE.text.toString().trim()
        password = binding.inputPass.text.toString().trim()

        //validate data
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            //invalid email format
            binding.inputE.error = "Invalid Email Format"
        }
        else if (TextUtils.isEmpty(password)){
            //no password entered
            binding.inputPass.error="Please enter your Password"
        }
        else{
            //data is validated, begin login
            firebaseLogin()
        }
    }

    private fun firebaseLogin() {
        progressDialog.show()
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {

                //login Sucess
                progressDialog.dismiss()
                //get user info
                val firebaseUser = firebaseAuth.currentUser
                val email = firebaseUser!!.email
                Toast.makeText(this, "Logged $email", Toast.LENGTH_SHORT).show()
                finish()

                //open profile

            }
            .addOnFailureListener{ e->
                //login failed
                progressDialog.dismiss()
                Toast.makeText(this, "Login failed due to $(e.message)", Toast.LENGTH_SHORT).show()
            }
    }


    private fun checkUser() {
        // if user already logged in go to profile activity
        //get current bar
        val firebaseUser = firebaseAuth.currentUser
        if(firebaseUser != null){
            //user is already logged in

        }
    }
}