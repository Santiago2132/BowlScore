public class JuegoBolos{

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
						if(j==2 && i!=10) {// para que al ingresar segundo lanzamiento no pase de 10
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
					
					if(i==10 && j==2) {
							//int MaxTiro2=10-tempo;
						if(tempo!=10 ) {
							do {
								System.out.println("Lanzamiento N° "+ j+ ": " );
								lanza1=sc.nextInt();
								//tempo=lanza1;
								}while(lanza1>10); //se verifica que no supere los 10 puntos posibles por turno
								
								tableroBolos[i][2]=lanza1;
								//System.out.println("Lanzamiento 2 es"+ tableroBolos[i][j]);
								}
						if(tempo==10 || (lanza1+tempo==10)) {
							do {
								System.out.println("Lanzamiento N° "+ j+ ": " );
								lanza1=sc.nextInt();
								//tempo=lanza1;
								}while(lanza1>10); //se verifica que no supere los 10 puntos posibles por turno
								
								tableroBolos[i][2]=lanza1;
						
							do {
								System.out.println("Lanzamiento N° "+ 3+ ": " );
								lanza1=sc.nextInt();
								//tempo=lanza1;
								}while(lanza1>10); 
							 tableroBolos[i][3] = lanza1;
						}
					}
						puntajeT10=	tempo+tableroBolos[10][2]+ tableroBolos[10][3];
					}

				if (j == 3 && i!=10)//inicializa el resultado
                {
                    tableroBolos[i][j] = 0;
                }
			}
		}
		for (int i = 1; i <=10; i++) {
			for (int j = 1; j <=4; j++) {
				
				if(j!=4) {
					boolean ready=false;
					if(j==3&&i!=10) {
						//chuza
					if((tableroBolos[i][1]==10)|| (tableroBolos[i][2]==10)){

						tableroBolos[i][j]=tableroBolos[i][1]+tableroBolos[i][2]+tableroBolos[i][1]+tableroBolos[i+1][1]+tableroBolos[i+1][2];
						puntaje=puntaje+tableroBolos[i][j];
						ready = true;
					}
					

					//aqui guardara el resultado de los lanzamientos en j=3
						if(ready==false) {
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
						tableroBolos[i][j]= puntaje;
					}
				}
				if(j==4&&i==10) {
					 puntaje=puntaje+puntajeT10;
					 tableroBolos[i][j]= puntaje;
				}
				
			}
		}

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