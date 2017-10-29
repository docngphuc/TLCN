package docongphuc.pttravle

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class welcom : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcom)
        supportActionBar!!.hide()
        // tao amng hinh cho khi moi khoi dong app
        val thread = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(4000)// set thoi gian dong Activity
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)

                    finish()
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
        thread.start()
    }
}
