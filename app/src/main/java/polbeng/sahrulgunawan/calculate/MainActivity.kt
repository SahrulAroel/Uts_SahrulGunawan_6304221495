package polbeng.sahrulgunawan.calculate

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import polbeng.sahrulgunawan.calculate.databinding.ActivityMainBinding

const val SECOND_ACTIVITY = 1000

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.inputFirstNumber.setHint("Masukkan Jari Jari")
        binding.inputSecondNumber.setHint("Masukkan Tinggi")

        binding.btnVolume.setOnClickListener {
            calculate('+')
        }

        binding.btnLuas.setOnClickListener {
            calculate('-')
        }
    }

    override fun onResume() {
        super.onResume()
        clearInputs()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun calculate(operator: Char) {
        val firstNumberString = binding.inputFirstNumber.text.toString()
        val secondNumberString = binding.inputSecondNumber.text.toString()

        if (firstNumberString.isNotEmpty() && secondNumberString.isNotEmpty()) {
            val firstNumber = firstNumberString.toDouble()
            val secondNumber = secondNumberString.toDouble()
            var result = 0.0
            var phi = 3.14;

            when (operator) {
                '+' -> result = phi * (firstNumber*firstNumber) * secondNumber
                '-' -> result = 2*phi * firstNumber* (firstNumber+secondNumber)
            }
            binding.txtHasil.text = "Hasil: $result Cm^3"
            clearInputs()
        } else {
            binding.txtHasil.text = "Masukkan kedua angka"
        }
    }

    private fun clearInputs() {
        binding.inputFirstNumber.setText("")
        binding.inputSecondNumber.setText("")
    }
}
