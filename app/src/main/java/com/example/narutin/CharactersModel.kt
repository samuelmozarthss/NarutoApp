package com.example.narutin

import com.google.gson.annotations.SerializedName


class CharactersModel {

    lateinit var about: List<String>
    lateinit var info : Info
    var page : String = ""
    var name : String = ""
    var id : Int = 0
    lateinit var images : List<String>

    override fun toString(): String {
        return "CharactersModel(about=$about, page='$page', name='$name', images=$images)"
    }
}

class Info {

    var sexo: String = ""
    var aniversário: String = ""
    var idade: String = ""
    var altura: String = ""
    var peso: String = ""
    var tipoSanguíneo: String = ""
    var ocupação: String = ""
    var afiliação: String = ""
    var parceiro: String = ""
    var patenteNinja: String = ""
    var registroNinja: String = ""

    override fun toString(): String {
        return "Info(sexo='$sexo', aniversário='$aniversário', idade='$idade', altura='$altura', peso='$peso', tipoSanguíneo='$tipoSanguíneo', ocupação='$ocupação', afiliação='$afiliação', parceiro='$parceiro', patenteNinja='$patenteNinja', registroNinja='$registroNinja')"
    }
}