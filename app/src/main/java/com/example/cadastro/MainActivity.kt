package com.example.cadastro

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var editNomeCompleto: TextInputEditText
    private lateinit var editTelefone: TextInputEditText
    private lateinit var editEmail: TextInputEditText
    private lateinit var checkEmailLista: CheckBox
    private lateinit var radioGroupSexo: RadioGroup
    private lateinit var editCidade: TextInputEditText
    private lateinit var spinnerUF: Spinner
    private lateinit var btnSalvar: Button
    private lateinit var btnLimpar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialização das views
        editNomeCompleto = findViewById(R.id.editNomeCompleto)
        editTelefone = findViewById(R.id.editTelefone)
        editEmail = findViewById(R.id.editEmail)
        checkEmailLista = findViewById(R.id.checkEmailLista)
        radioGroupSexo = findViewById(R.id.radioGroupSexo)
        editCidade = findViewById(R.id.editCidade)
        spinnerUF = findViewById(R.id.spinnerUF)
        btnSalvar = findViewById(R.id.btnSalvar)
        btnLimpar = findViewById(R.id.btnLimpar)

        btnSalvar.setOnClickListener {
            salvarFormulario()
        }

        btnLimpar.setOnClickListener {
            limparFormulario()
        }
    }

    private fun salvarFormulario() {
        val nomeCompleto = editNomeCompleto.text?.toString()?.trim()
        val telefone = editTelefone.text?.toString()?.trim()
        val email = editEmail.text?.toString()?.trim()
        val ingressoEmail = checkEmailLista.isChecked
        val cidade = editCidade.text?.toString()?.trim()
        val uf = spinnerUF.selectedItem?.toString() ?: ""

        val sexo = when (radioGroupSexo.checkedRadioButtonId) {
            R.id.radioMasculino -> "Masculino"
            R.id.radioFeminino -> "Feminino"
            else -> ""
        }

        if (nomeCompleto.isNullOrEmpty() || telefone.isNullOrEmpty() || email.isNullOrEmpty() ||
            sexo.isEmpty() || cidade.isNullOrEmpty() || uf.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
            return
        }

        val formulario = Formulario(
            nomeCompleto = nomeCompleto,
            telefone = telefone,
            email = email,
            ingressoEmail = ingressoEmail,
            sexo = sexo,
            cidade = cidade,
            uf = uf
        )

        Toast.makeText(this, formulario.toString(), Toast.LENGTH_LONG).show()
    }

    private fun limparFormulario() {
        editNomeCompleto.text?.clear()
        editTelefone.text?.clear()
        editEmail.text?.clear()
        radioGroupSexo.clearCheck()
        checkEmailLista.isChecked = false
        editCidade.text?.clear()
        spinnerUF.setSelection(0)
    }
}
