package dominando.android.layouts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonTela2.setOnClickListener {
            val intent = Intent(this, Tela2Activity::class.java)
            intent.putExtra("nome", "Igor")
            intent.putExtra("idade", 27)
            startActivity(intent)
        }

        buttonParcel.setOnClickListener {
            val intent = Intent(this, Tela2Activity::class.java)
            intent.putExtra("cliente", Cliente(2,"Coutinho"))
            startActivity(intent)
        }

        buttonSerializable.setOnClickListener {
            val intent = Intent(this, Tela2Activity::class.java)
            intent.putExtra("pessoa", Pessoa("Nobre", 27))
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("NGVL", "Tela1::onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("NGVL", "Tela1::onResume")
    }
}