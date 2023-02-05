public class JuegoBolos{

    public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Tablero de Bolos");
		int puntaje=0;
		
		int[][] tableroBolos= new int[100][100];
		for (int i = 1; i <= 10; i++) {
			int lanza1,lanza2,tempo = 0;
			System.out.println("\nTurno " + i);
			
			for (int j = 1; j <=3; j++) {
				
				
				if(j!=3) {// la tercera casilla sera para el resultado del turno
					if(j==1) {
						do {
							System.out.println("Lanzamiento N° "+ j+ ": " );
							lanza1=sc.nextInt();
							tempo=lanza1;
							}while(lanza1>10); //se verifica que no supere los 10 puntos posibles por turno
							tableroBolos[i][j]=lanza1;
							//System.out.println("Lanzamiento 1 es"+ tableroBolos[i][j]);
					}
					if(j==2) {// para que al ingresar segundo numero no pase de 10
						int MaxTiro=10-tempo;
						do {
							System.out.println("Lanzamiento N° "+ j+ ": " );
							lanza1=sc.nextInt();
							tempo=lanza1;
							}while(lanza1>MaxTiro); //se verifica que no supere los 10 puntos posibles por turno
							
							tableroBolos[i][j]=lanza1;
							//System.out.println("Lanzamiento 2 es"+ tableroBolos[i][j]);
							if(lanza1==10) {
								j++;
							}
							
					}
						
				}
				
				if(j==3) {
						tableroBolos[i][j]=tableroBolos[i][1]+tableroBolos[i][2];
						puntaje=puntaje+tableroBolos[i][j];
						//System.out.println(puntaje);
						if(tableroBolos[i][j]==10) {//si la suma de los lanzamientos da 10- Proceso de stricke
							puntaje= puntaje + tableroBolos[i+1][1];
						}
						tableroBolos[i][j]= puntaje;
						System.out.println(tableroBolos[i][j]);					
					}
					
				}
			}
		for (int i = 1; i <=10; i++) {
			for (int j = 1; j <=3; j++) {
				System.out.print("|"+tableroBolos[i][j]+"|");
			}
			System.out.println();
		}
		
	}
}