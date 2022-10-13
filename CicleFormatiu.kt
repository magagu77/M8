class CicleFormatiu(Nombre:String="???", Abreviatura:String="???") {
    var nom:String = Nombre
    var abreviatura: String = Abreviatura
    var modulo = mutableListOf<Modul>()

    @JvmName("devuelveNombre")
    fun getNom():String{return this.nom}
    @JvmName("devuelveModulo")
    fun geAbreviatura():String{return this.abreviatura}
    @JvmName("devuelveHoras")
    fun getModulos():String {
        var modulos =""
        if (modulo.size==0) {
            return modulos
        }
        for(i in 0..modulo.size-1) {
            modulos+= modulos[i]+"\n"
        }
        return modulos
    }
    @JvmName("setNombre")
    fun setNom(nombre: String) {this.nom=nombre}
    @JvmName("setAbrevia")
    fun setAbreviatura(nombre: String) {this.abreviatura=nombre}
    @JvmName("añade")
    fun setModulo(modul: Modul) {modulo.add(modul)}

    override fun toString(): String {
        var cuerda:String = nom
        if(modulo.size==0){return cuerda}
        for (i in 0.. modulo.size-1){
            cuerda+="\n\t${modulo[i]}"
        }
        return cuerda
    }
}