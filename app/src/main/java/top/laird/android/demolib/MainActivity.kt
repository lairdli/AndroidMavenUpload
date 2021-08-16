package top.laird.android.demolib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import top.laird.android.testlib.TestLib

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TestLib.testPrint()
    }
}