class Modul(nom:String="",numModul: Int=0,hores:Int=0) {
    var nom:String = nom
    var numModul:Int= numModul
    var hores:Int = hores

    @JvmName("devuelveNombre")
    fun getNom():String{return this.nom}
    @JvmName("devuelveModulo")
    fun geModul():Int{return this.numModul}
    @JvmName("devuelveHoras")
    fun getHores():Int {return this.hores}
    @JvmName("setNombre")
    fun setNom(nombre: String) {this.nom=nombre}
    @JvmName("A")
    fun setNumModul(nombre: Int) {this.numModul=nombre}
    @JvmName("B")
    fun setHores(nombre: Int) {this.hores=nombre}

    override fun toString(): String {
        var nombre = "${numModul}. $nom (${hores}h)"
        return  nombre
    }
}

fun main() {
    var hora:Modul =Modul("a",3,88)
    println(hora)
}