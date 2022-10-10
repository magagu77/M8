fun main(args: Array<String>) {
    val tauler: Tauler
    val tablero:Int
    val minas:Int
    var x: Int
    var y:Int
    var opcion:String
    println("Dime el tamaño del tablero (solo valores numericos) ")
    var entrada = readLine() ?:"0"
    tablero = entrada.toInt()
    if(tablero<=4){
        println("Dime un número más grande mongolín(>4)a")
        return
    }
    println("Dime el numero de minas con las que quieres jugar (recuerda que no puede ser mayor o igual que el tamaño del tablero)")
    entrada = readLine() ?:"0"
    minas = entrada.toInt()
    if(minas>=tablero*tablero){
        println("Veo que tus padres estan cerca de ser primos")
        return
    }
    tauler = Tauler(tablero,minas)
    tauler.posaMines()
    println("Empieza el juego!")
    while (true) {
        println("Que quieres hacer?\n")
        println("m para marcar o desmarcar una posible mina")
        println("d para descubrir una casilla")
        println("/ff para rendirte\n\n")
        println(tauler)
        opcion = readLine() ?:"/ff"

        if(opcion.equals("/ff")) {
            println("Te rendiste (No responder equivale a rendirse)")
            tauler.descobreixTauler()
            println(tauler)
            return
        }

        println("Dime la posicion X:")
        entrada = readLine() ?:"0"
        x = entrada.toInt()
        println("Dime la posicion Y:")
        entrada = readLine() ?:"0"
        y = entrada.toInt()

        if(x<0 || y<0) {
            println("Números iguales o mayores que 0 mongolín")
            continue
        }

        if(opcion.equals("m")) {
            tauler.marcaMina(x, y)
        } else if (opcion.equals("d")){
            tauler.setDescoberta(x, y)
            tauler.comptaMines(x,y)
            if(tauler.hiHaMina(x,y)) {
                println("Has perdido")
                println(tauler)
                return
            }
        }

        if(tauler.descobert()) {
            println(tauler)
            println("HAS GANADO!!")
            return
        }
    }
}