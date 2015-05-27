package geneticAlg;

public class FuncionDeFitness { 
	// solucion y eventos tienen que ser el mismo largo que igual que el individuo (horario) 
    static byte[] solucion = new byte[15]; 
    static int[][] eventos = {{1,2},{3,4},{4,5},{3,6},{7,8},{9,11},{12,14},{15,16},{14,18},{16,19},{20,22},{23,25},{26,28},{29,30},{31,22}};

    // Establecer una solucion candidata como un arreglo de bytes
    public static void establecerSolucion(byte[] nuevaSolucion) {
        solucion = nuevaSolucion;
    }

    static void establecerSolucion(String nuevaSolucion) {
        solucion = new byte[nuevaSolucion.length()];
        for (int i = 0; i < nuevaSolucion.length(); i++) {
            String caracter = nuevaSolucion.substring(i, i + 1); 
            if (caracter.contains("0") || caracter.contains("1")) {
                solucion[i] = Byte.parseByte(caracter);
            } else {
                solucion[i] = 0;
            }
        }
    }

    /* Calcular el fitness de los individuos revisando que los eventos no choquen. Si chocan el fitness es 0 y si no,
     el fitness son las cantidades de eventos que se pueden ingresar en el individuo (calendario) */
    static int obtenerFitness(Individuo individuo) {
        int fitness = 0; 
        int actividad = 0; 
        // Iterar por todos los genes del individuo y compararlo
        // con los de nuestro candidato.
        for (int i = 0; i < individuo.tamanno(); i++) { 
        	if(individuo.obtenerGen(i) == 1 && actividad != 0){
        		if(eventos[actividad][1] <= eventos[i][0]){
        			fitness++;  
        			actividad = i; 
        		} 
        		else{ 
        			fitness = 0; 
        			return fitness; 
        		}
        	}
        	else if (individuo.obtenerGen(i) == 1) { 
            	actividad = i; 
                fitness++; 
            } 
            
        }
        return fitness;
    }
    


}
