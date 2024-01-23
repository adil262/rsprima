package com.kelompok3.rsprima

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.kelompok3.rsprima.databinding.ActivityRegistBinding

class RegistActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistBinding

    //ActionBar
//    private lateinit var actionBar: ActionBar

    //ProgressDialog
    private lateinit var progressDialog: ProgressDialog

    //firebase aut
    private lateinit var firebaseAuth: FirebaseAuth
    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //configure ActionBar // enable back button
//        actionBar = supportActionBar!!
//        actionBar.setDisplayHomeAsUpEnabled(true)
//        actionBar.setDisplayHomeAsUpEnabled(true)
//        actionBar.title ="SignUp"

        //configre progress dialog
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please Wait")
        progressDialog.setMessage("Creatig account In...")
        progressDialog.setCanceledOnTouchOutside(false)

        //init firebase auth
        firebaseAuth = FirebaseAuth.getInstance()

        //handle, click, begin signup
        binding.btnRegis.setOnClickListener{
            validateData()
        }
//        binding.kembali.setOnClickListener{
//            startActivity(Intent(this, MainActivity::class.java))
//        }

    }

    private fun validateData(){
        //get data
        email= binding.inputE.text.toString().trim()
        password = binding.inputPass.text.toString().trim()

        //validate data
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            //invalid email format
            binding.inputE.error = "Invalid email format"
        }
        else if (TextUtils.isEmpty(password)){
            //password isnt entered
            binding.inputPass.error = "Please enter Password"
        }
        else if (password.length <8){
            //password length is less than 8
            binding.inputPass.error = "Password mush atleast 8 characters long"
        }
        else{
            //data is valid,contonue ssignup
            firebaseSignUp()
        }
    }

    private fun firebaseSignUp() {
        //show progress
        progressDialog.show()

        //create Account
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                //signup success
                progressDialog.dismiss()
                //get current user
                val firebaseUser = firebaseAuth.currentUser
                val email = firebaseUser!!.email
                Toast.makeText(this, "Account Created with email $email", Toast.LENGTH_SHORT).show()

                //open profile


            }
            .addOnFailureListener{ e->
                //signup failed
                progressDialog.dismiss()
                Toast.makeText(this, "SignUp failed due to $(e.message)", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super. onSupportNavigateUp()
    }
}