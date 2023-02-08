public class JuegoBolos{
	//JUEGO DE BOLOS- KAREN Y SANTIAGO :)

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Tablero de Bolos");
		int puntaje=0;  int puntajeT10=0;
		
		int[][] tableroBolos= new int[100][100];
		for (int i = 1; i <= 10; i++) {
			int lanza1=0,lanza2,tempo = 0;
			System.out.println("\nTurno " + i); //turnos
			
			for (int j = 1; j <=4; j++) {
				
				if(j!=4) {
					if(j!=3) {// la tercera casilla sera para el resultado del turno
						if(j==1) {//primer lanzamiento
							do {
								System.out.println("Lanzamiento N° "+ j+ ": " );
								lanza1=sc.nextInt();
								tempo=lanza1;
								}while(lanza1>10); //se verifica que no supere los 10 puntos posibles por turno
								tableroBolos[i][j]=lanza1;
								//System.out.println("Lanzamiento 1 es"+ tableroBolos[i][j]);
						}
						if(j==2 && i!=10) {// para que al ingresar segundo lanzamiento no pase de 10 y no este en turno 10
							int MaxTiro=10-tempo;
							do {
								System.out.println("Lanzamiento N° "+ j+ ": " );
								lanza1=sc.nextInt();
								//tempo=lanza1;
								}while(lanza1>MaxTiro); //se verifica que no supere los 10 puntos posibles por turno
								
								tableroBolos[i][j]=lanza1;
								//System.out.println("Lanzamiento 2 es"+ tableroBolos[i][j]);
								}
						
						}	
					
					if(i==10 && j==2) {// en turno 10 y segundo lanzamiento
						
						do {
							System.out.println("Lanzamiento N° "+ j+ ": " );
							lanza1=sc.nextInt();
							lanza2=lanza1;
							//tempo=lanza1;
							}while(lanza1>10); //se verifica que no supere los 10 puntos posibles por turno
							
							tableroBolos[i][2]=lanza1;
					if(tempo==10 || (lanza2+tempo==10)) {
						
							int MaxTiro=0;
							do {
								if(lanza2!=10) {
									MaxTiro=10-lanza2;
								}
								else {
									MaxTiro=10;
								}
								System.out.println("Lanzamiento N° "+ 3+ ": " );
								lanza1=sc.nextInt();
								
								//tempo=lanza1;
								}while(lanza1>MaxTiro); 
							 tableroBolos[i][3] = lanza1;// seguarda en la casilla 3
						}
					}
						puntajeT10=	tempo+tableroBolos[10][2]+ tableroBolos[10][3];// acumulador para el turno 10
					}

				if (j == 3 && i!=10)//inicializa el resultado
                {
                    tableroBolos[i][j] = 0;// cuando no es 10 se inicializa la casilla resultado en 0
                }
			}
		}
		for (int i = 1; i <=10; i++) {
			for (int j = 1; j <=4; j++) {
				
				if(j!=4) {// para que no se toque la casilla 4
					boolean ready=false;
					if(j==3&&i!=10) {// no se toca al turno 10 y se agregan resultados en casilla 3
						//chuza
					if((tableroBolos[i][1]==10)|| (tableroBolos[i][2]==10)){ // para chuza

						tableroBolos[i][j]=tableroBolos[i][1]+tableroBolos[i][2]+tableroBolos[i][1]+tableroBolos[i+1][1]+tableroBolos[i+1][2];
						puntaje=puntaje+tableroBolos[i][j];
						ready = true;
						
						if(tableroBolos[i+1][1]==0 && tableroBolos[i+2][1]==0) {
							puntaje=puntaje+tableroBolos[i+2][2];
						}
						if(tableroBolos[i+1][1]==0) {
							puntaje=puntaje+tableroBolos[i+2][1];
						}
					}
					

					//aqui guardara el resultado de los lanzamientos en j=3
						if(ready==false) { // cuando puede ser otro
							tableroBolos[i][j]=tableroBolos[i][1]+tableroBolos[i][2];//suma los lanzamientos
							puntaje=puntaje+tableroBolos[i][j];//va sumando el puntaje
							if(tableroBolos[i][j]==10) {//si la suma de los lanzamientos da 10- Proceso de stricke
							   if(tableroBolos[i+1][1]>0) {
								puntaje= puntaje + tableroBolos[i+1][1]; //se supone que aqui dbe sumar la siguiente
								}
							   else {
								   puntaje= puntaje + tableroBolos[i+1][2]; 
							   }
						}
						//se guarda el puntaje de ese turno					
						}
					tableroBolos[i][j]= puntaje;//se guarda el puntaje de todo
					}
				}
			if(j==4&&i==10){ // si j es 4 e i es 10 ese será el resulado de el tuno 10
					 puntaje=puntaje+puntajeT10;
					 tableroBolos[i][j]= puntaje;//se guardar en casilla 4 turno 10
				}
				
			}
		}
		//se imprimen

		for (int i = 1; i <=9; i++) {
			for (int j = 1; j <=3; j++) {
				System.out.print("|"+tableroBolos[i][j]+"|");
			}
			System.out.println();
		}
		for (int i = 10; i <=10; i++) {
			for (int j = 1; j <=4; j++) {
				System.out.print("|"+tableroBolos[i][j]+"|");
			}
			System.out.println();
		}
		//System.out.print("|"+tableroBolos[10][4]+ "|");

	}
}