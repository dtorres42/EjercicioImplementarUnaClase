fun main() {
    val p1 = Punto(3.0, 4.0)
    val p2 = Punto(1.0, 2.0)
    val p3 = Punto(3.0, 4.0)

    // 1. Uso de mover
    println("--- 1. Mover ---")
    println("p1 antes de mover: $p1")
    p1.mover(10.0, 20.0)
    println("p1 después de mover: $p1") // Salida: Punto(x=10.0, y=20.0)
    println("-".repeat(20))

    // 2. Uso de distanciaA
    println("--- 2. Distancia ---")
    val pA = Punto(0.0, 0.0)
    val pB = Punto(3.0, 4.0)
    println("Distancia de pA a pB: ${pA.distanciaA(pB)}") // Salida: 5.0
    println("-".repeat(20))

    // 3. Sobrecarga de Operadores
    println("--- 3. Operadores (+ y -) ---")
    val resultadoSuma = pA + pB
    println("pA + pB (0,0) + (3,4): $resultadoSuma") // Salida: Punto(x=3.0, y=4.0)

    val resultadoResta = pB - pA
    println("pB - pA (3,4) - (0,0): $resultadoResta") // Salida: Punto(x=3.0, y=4.0)

    val opuesto = -pB
    println("Opuesto de pB (-(3,4)): $opuesto") // Salida: Punto(x=-3.0, y=-4.0)
    println("-".repeat(20))

    // 4. Implementación de equals
    println("--- 4. Equals ---")
    println("p1 (10,20) == p2 (1,2): ${p1 == p2}") // Salida: false
    println("pB (3,4) == p3 (3,4): ${pB == p3}") // Salida: true
}
}

class Punto(var x: Double, var y: Double) {

    // Constructor secundario: inicializa el punto a (0.0, 0.0)
    constructor() : this(0.0, 0.0)

    // --- Métodos Útiles ---

    fun distanciaA(otro: Punto): Double {
        val dx = this.x - otro.x
        val dy = this.y - otro.y
        return Math.sqrt(dx * dx + dy * dy)
    }
    /**
     * Sobrecarga del operador binario '+'.
     * Realiza la suma vectorial de dos puntos.
     * @param otro El punto a sumar.
     * @return Un nuevo Punto que es el resultado de la suma.
     */
    operator fun plus(otro: Punto): Punto {
        return Punto(this.x + otro.x, this.y + otro.y)
    }

    /**
     * Sobrecarga del operador unario '-'.
     * Invierte las coordenadas del punto (vector opuesto).
     * @return Un nuevo Punto con las coordenadas negadas.
     */
    operator fun unaryMinus(): Punto {
        return Punto(-this.x, -this.y)
    }

    /**
     * Sobrecarga del operador binario '-'.
     * Realiza la resta vectorial de dos puntos.
     * @param otro El punto a restar.
     * @return Un nuevo Punto que es el resultado de la resta.
     */
    operator fun minus(otro: Punto): Punto {
        // También se podría implementar como: this + (-otro)
        return Punto(this.x - otro.x, this.y - otro.y)
    }

    // --- 4. Implementación de equals ---

    /**
     * Implementa la comparación de igualdad. Dos puntos son iguales si sus
     * coordenadas x e y son iguales.
     * @param other El objeto a comparar.
     * @return true si las coordenadas x e y son iguales, false en caso contrario.
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true // Son el mismo objeto en memoria
        if (other !is Punto) return false // other no es un Punto

        // Compara las coordenadas
        return this.x == other.x && this.y == other.y
   
    fun trasladar(delta: Punto) {
        this.x += delta.x
        this.y += delta.y
    }

   
    fun crearTraslado(delta: Punto): Punto {
        return Punto(this.x + delta.x, this.y + delta.y)
    }

   
    fun moverA(nuevoX: Double, nuevoY: Double) {
        
    }

    
    override fun toString(): String {
        return "Punto(x=$x, y=$y)"
    }
}