package com.example.permissions

import android.Manifest
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.security.Permission

class MainActivity : AppCompatActivity() {
    private val PERMISSION_RECORD_AUDIO = Manifest.permission.RECORD_AUDIO
    private val PERMISSION_CAMERA = Manifest.permission.CAMERA
    private val PERMISSION_RES_CODE = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener{
            requestPermission()
        }
    }

    private fun requestPermission(){

        if(checkSelfPermission(PERMISSION_RECORD_AUDIO)==PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this,"Permission Granted on 1 IF",Toast.LENGTH_SHORT).show()
        }
        else{
            AlertDialog.Builder(this).apply {
                setTitle("Permission Required")
                setCancelable(false)
                setMessage("This app needs to use Microphone")
                setPositiveButton("Grant Permission",DialogInterface.OnClickListener { dialogInterface, i ->
                    ActivityCompat.requestPermissions(this@MainActivity, arrayOf(PERMISSION_RECORD_AUDIO),10)
                    dialogInterface.dismiss()
                })
                setNegativeButton("Cancel",DialogInterface.OnClickListener { dialogInterface, i ->
                    dialogInterface.dismiss()
                })
                show()
            }
        }
        if(checkSelfPermission(PERMISSION_CAMERA)==PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this,"Permission Granted on 1 IF",Toast.LENGTH_SHORT).show()
        }
        else{
            AlertDialog.Builder(this).apply {
                setTitle("Permission Required")
                setCancelable(false)
                setMessage("This app needs to use Camera")
                setPositiveButton("Grant Permission",DialogInterface.OnClickListener { dialogInterface, i ->
                    ActivityCompat.requestPermissions(this@MainActivity, arrayOf(PERMISSION_CAMERA),100)
                    dialogInterface.dismiss()
                })
                setNegativeButton("Cancel",DialogInterface.OnClickListener { dialogInterface, i ->
                    dialogInterface.dismiss()
                })
                show()
            }
        }
    }

}