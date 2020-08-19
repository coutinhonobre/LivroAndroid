package dominando.android.layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tela2.*

class Tela2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)

        val cliente = intent.getParcelableExtra<Cliente>("cliente")
        val pessoa = intent.getSerializableExtra("pessoa") as Pessoa ? // O objeto pessoa pode ser nulo

        when {
            cliente != null -> textMensagem.text = "Nome: ${cliente.nome} / Código: ${cliente.codigo}"
            pessoa != null -> textMensagem.text =
                mostrarPessoa(pessoa)
            else -> textMensagem.text =
                mostrarPessoa(Pessoa(intent.getStringExtra("nome"), intent.getIntExtra("idade", -1)))
        }
    }

    private fun mostrarPessoa(pessoa: Pessoa) =
        "Nome: ${pessoa.idade} Idade: ${pessoa.idade}"
}