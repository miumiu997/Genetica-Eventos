package geneticAlg;

public class AG {

	  public static void main(String[] args) {

	        // Establecer una solucion candidata (la mejor solución sería poder ir a todos los eventos) 
	        FuncionDeFitness.establecerSolucion("111111111111111");
	       
	        // Crear una poblacion inicial (cantidad de posibles calendarios que se crean) 
	        Poblacion poblacion = new Poblacion(10, true);
	        
	        /* Evolucionar los calendarios hasta llegar a la solución óptima (donde se pueda ir a todos los eventos)
	        o hasta llegar a 50 generaciones */
	        int contadorDeGeneraciones = 0; 
	        while (poblacion.obtenerFittest().obtenerFitness() <= 15 && contadorDeGeneraciones <=50) {
	            contadorDeGeneraciones++;
	            System.out.println("Generacion: " + contadorDeGeneraciones + " Mejor: " + poblacion.obtenerFittest().obtenerFitness());
	            poblacion = Algorithm.evolucionarPoblacion(poblacion);
	        }
	        System.out.println("Solucion encontrada!");
	        System.out.println("Generacion: " + contadorDeGeneraciones);
	        System.out.println("Genes:");
	        System.out.println(poblacion.obtenerFittest());
	    }
}
