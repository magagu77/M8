class Tauler (n:Int=5 ,nm:Int=5) {
    var  tauler = Array(n) {Array<Casilla>(n){Casilla()}}
    var minas: Int = nm
    var tamano =n;

    fun posaMines() {
        var x: Int
        var y: Int
        var numMinas = minas;
        while (numMinas !=0){
            x=(0..tamano-1).random()
            y=(0..tamano-1).random()
            if(!tauler[x][y].getEsMina()) {
                tauler[x][y].setEsMina(true)
                numMinas--
            }
        }
    }
    fun hiHaMina(x:Int, y:Int):Boolean{return tauler[x][y].getEsMina()}
    fun descoberta(x:Int, y:Int):Boolean{return tauler[x][y].getDescoberta()}
    fun minaMarcada(x:Int, y:Int):Boolean{return tauler[x][y].getMinaMarcada()}
    fun setDescoberta(x:Int, y:Int){tauler[x][y].setDescoberta(true)}

    fun descobreixTauler(){
        for(x in 0..tauler.size-1) {
            for (y in 0..tauler.size-1) {
                tauler[x][y].setDescoberta(true)
                comptaMines(x, y)
                }
        }
    }
    fun marcaMina(x:Int, y:Int) {
        if (tauler[x][y].getMinaMarcada()) {
            tauler[x][y].setMinaMarcada(false)
        } else {
            tauler[x][y].setMinaMarcada(true)
        }
    }
    fun descobert(): Boolean {
        var contador: Int = 0
        for(x in 0..tauler.size-1) {
            for (y in 0..tauler.size-1) {
                if(tauler[x][y].getDescoberta() && !tauler[x][y].getEsMina()) {
                    contador++
                }
            }
        }
        if (contador==tamano*tamano-minas){
            return true
        }
        return false
    }

    override fun toString(): String {
        var cuerda:String = ""
        for(x in 0..tauler.size-1) {
            for (y in 0..tauler.size-1) {
                cuerda += tauler[x][y].toString()
            }
            cuerda += "\n"
        }
        return cuerda
    }

    fun comptaMines(x:Int, y:Int) {
        var contador:Int = 0
        var top: Int = 0
        var bot:Int = 0
        var left:Int = 0
        var rigth:Int = 0

        //TOP
        if (x==0) {
            top = 0;
        } else {
            top = x-1;
        }
        //BOT
        if (x==tauler.size-1) {
            bot = tauler.size-1
        } else {
            bot =x+1
        }

        // Left
        if (y==0) {
            left = 0;
        } else {
            left = y-1;
        }
        //Rigth
        if (y==tauler.size-1) {
            rigth = tauler.size-1
        } else {
            rigth =y+1
        }
        for(i in top..bot){
            for (f in left..rigth) {
                if(tauler[i][f].getEsMina()){
                    contador++
                }
            }
        }
        tauler[x][y].setNumMina(contador)
    }
}