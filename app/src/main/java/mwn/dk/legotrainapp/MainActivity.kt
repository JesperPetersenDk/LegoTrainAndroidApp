package mwn.dk.legotrainapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        host.setText("192.168.43.234")
        port.setText("3000")

        send.setOnClickListener {
            val address = host.text.toString()
            val port = Integer.parseInt(port.text.toString())
            val speed = speed.text.toString()
            val magnets = magnets.text.toString()

            GlobalScope.launch {
                UDPSender(address, port).send("$magnets, $speed,")
            }
        }

        stop.setOnClickListener {
            val address = host.text.toString()
            val port = Integer.parseInt(port.text.toString())

            GlobalScope.launch {
                UDPSender(address, port).send("0,0,")
            }
        }
    }


}
