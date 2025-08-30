package br.edu.ifsp.scl.ads.prdm.sc3039129.havagas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.scl.ads.prdm.sc3039129.havagas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.formacaoSp.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val formacao= (view as TextView).text.toString()
                val todasViews = listOf(
                    binding.anoConclusaoLl,
                    binding.instituicaoLl,
                    binding.tituloOrientadorLl
                )

                todasViews.forEach { it.visibility = View.GONE }

                val viewsVisiveis = when (formacao) {
                    "Ensino Fundamental", "Ensino Médio" -> listOf(binding.anoConclusaoLl)
                    "Ensino Superior", "Especialização" -> listOf(binding.anoConclusaoLl, binding.instituicaoLl)
                    "Mestrado", "Doutorado" -> listOf(binding.anoConclusaoLl, binding.instituicaoLl, binding.tituloOrientadorLl)
                    else -> emptyList()
                }

                viewsVisiveis.forEach { it.visibility = View.VISIBLE }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

    }
}