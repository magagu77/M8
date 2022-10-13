fun main(args: Array<String>) {
    var cursos = mutableListOf<CicleFormatiu>()
    while(true) {
        println(
            "Escull una opció:\n" +
                    "1. Afegir un cicle formatiu\n" +
                    "2. Afegir un mòdul a un cicle\n" +
                    "3. Mostrar tots els cicles i els seus mòduls associats\n" +
                    "4. Mostrar la durada d’un cicle\n" +
                    "5. Sortir\n"
        );
        var entrada = readLine() ?: "0"
        entrada = entrada.trim()
        if (entrada.equals("1")) {
            println("Dime el nombre del ciclo que quieres añadir")
            var ciclo = readLine() ?: "".trim()
            println("Dime la abreviatura del ciclo")
            var abrev = readLine() ?: "".trim()
            cursos.add(CicleFormatiu(ciclo, abrev))
        } else if (entrada.equals("2")) {
            if (cursos.size == 0) {
                println("No hay ningun elemento en la lista")
                continue
            }
            for (i in 0..cursos.size-1) {
                println("${i + 1}. ${cursos[i].getNom()}")
            }
                println("Di el numero del ciclo al que le quieres asignar un modulo")
                entrada = readLine() ?: "0"
                var numCiclo = entrada.toInt()
                if(numCiclo == 0){
                    println("No has seleccionado ningun ciclo")
                    continue
                }
                println("Dime el nombre del modulo")
                var nombre = readLine() ?: "???"
                println("Dime las horas del modulo")
                entrada = readLine() ?: "0"
                var horas:Int =entrada.toInt()
                println("Dime el numero del modulo")
                entrada = readLine() ?: "0"
                var num:Int =entrada.toInt()
                var newModulo:Modul = Modul(nombre,num,horas)
                cursos[numCiclo-1].setModulo(newModulo)

        } else if (entrada.equals("3")) {
                if (cursos.size==0){
                    println("No hay cursos")
                    continue
                }
                for(i in 0..cursos.size-1) {
                    println("${i + 1}. ${cursos[i]}")
                }
        } else if (entrada.equals("4")) {
            for (i in 0..cursos.size-1) {
                println("${i + 1}. ${cursos[i].getNom()}")
            }

        } else if (entrada.equals("5")) {
            println("Hasta luego!")
            return
        }
        println()
    }
}