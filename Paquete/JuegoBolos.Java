public class JuegoBolos{
    
    public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Tablero de Bolos");
		int lanza1, lanza2, puntuacionTotal, tempoPuntuacion,total;
		
		for (int i = 1; i <= 10; i++) {
			
			System.out.println("Turno " + i);
			do {
			System.out.println("Lanzamiento N° 1: " );
			lanza1=sc.nextInt();
			}while(lanza1>10); //se verifica que no supere los 10 puntos posibles por turno
			
			if(lanza1<10) {
				
				do {
					System.out.println("Lanzamiento N° 2" );
					lanza2=sc.nextInt();
					total=lanza1+lanza2;
					}while(total>10);
			}
			
		}
		
	}
}