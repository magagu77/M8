class Casilla ( mina: Boolean= false, marcada: Boolean= false,descubierta: Boolean= false,numMinas: Int = 0){
    var mina: Boolean = mina
    var marcada: Boolean = marcada
    var descubierta: Boolean = descubierta
    var numMinas:Int = numMinas

    @JvmName("getNumMina")
    fun getNumMina():Int {return this.numMinas}
    fun setNumMina(numMina: Int) {this.numMinas = numMina}

    fun getEsMina() = mina
    fun setEsMina(mina: Boolean) {this.mina=mina}

    fun getDescoberta()= descubierta
    fun setDescoberta(descubierta: Boolean) {this.descubierta = descubierta}

    fun getMinaMarcada()=marcada
    fun setMinaMarcada(marcada: Boolean) {this.marcada = marcada}

    override fun toString(): String {
        if (getDescoberta()){
            if(getEsMina()) {
                return String.format(" # ")
            }else {
                return  String.format(" ${getNumMina()} ")
            }
        } else {
            if(getMinaMarcada()) {
                return String.format(" * ")
            }
        }
        return " · "
    }

}
