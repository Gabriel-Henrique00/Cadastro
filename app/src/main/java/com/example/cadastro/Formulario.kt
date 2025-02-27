package com.example.cadastro

class Formulario(
    var nomeCompleto: String,
    var telefone: String,
    var email: String,
    var ingressoEmail: Boolean,
    var sexo: String,
    var cidade: String,
    var uf: String
) {
    override fun toString(): String {
        return """
            Nome: $nomeCompleto
            Telefone: $telefone
            E-mail: $email
            IngressoEmail: $ingressoEmail
            Sexo: $sexo
            Cidade: $cidade
            
            UF: $uf
            """.trimIndent()
    }
}