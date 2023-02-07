public class JuegoBolos{

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Tablero de Bolos");
		int puntaje=0;
		
		int[][] tableroBolos= new int[100][100];
		for (int i = 1; i <= 10; i++) {
			int lanza1,lanza2,tempo = 0;
			System.out.println("\nTurno " + i); //turnos
			
			for (int j = 1; j <=3; j++) {
				
				
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
					if(j==2) {// para que al ingresar segundo lanzamiento no pase de 10
						int MaxTiro=10-tempo;
						do {
							System.out.println("Lanzamiento N° "+ j+ ": " );
							lanza1=sc.nextInt();
							tempo=lanza1;
							}while(lanza1>MaxTiro); //se verifica que no supere los 10 puntos posibles por turno
							
							tableroBolos[i][j]=lanza1;
							//System.out.println("Lanzamiento 2 es"+ tableroBolos[i][j]);
	
					}
						
				}
				if (j == 3)//inicializa el resultado
                {
                    tableroBolos[i][j] = 0;
                }
			}
		}
		for (int i = 1; i <=10; i++) {
			for (int j = 1; j <=3; j++) {
				boolean ready=false;
				if(j==3) {
					//chuza
				if((tableroBolos[i][1]==10)||(tableroBolos[i][2]==10))
				{
					tableroBolos[i][j]=10+tableroBolos[i+1][1]+tableroBolos[i+1][2];
					puntaje=puntaje+tableroBolos[i][j];
					if(i>1)
                        {
                            int anterior = i -1;
                            tableroBolos[anterior][3]=tableroBolos[anterior][3]+10;
                        }
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
	}
		
		for (int i = 1; i <=10; i++) {
			for (int j = 1; j <=3; j++) {
				System.out.print("|"+tableroBolos[i][j]+"|");
			}
			System.out.println();
		}

	}
}