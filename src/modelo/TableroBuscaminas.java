package modelo;

import java.util.ArrayList;
import java.util.List;

import entidad.Casilla;

public class TableroBuscaminas {

	Casilla[][] casillas;

	private int numFilas;
	private int numColumnas;
	private int numMinas;

	public TableroBuscaminas(int numFilas, int numColumnas, int numMinas) {
		this.numFilas = numFilas;
		this.numColumnas = numColumnas;
		this.numMinas = numMinas;
		inicializarCasillas();
		generarMinas();
		actualizarNumeroMinasAlrededor();

	}

	public void inicializarCasillas() {
		casillas = new Casilla[numFilas][numColumnas];
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				casillas[i][j] = new Casilla(i, j);

			}
		}
	}

	public void generarMinas() {
		int minasGeneradas = 0;
		while (minasGeneradas != numMinas) {
			int postTmpFila = (int) (Math.random() * casillas.length);
			int posTmpColumna = (int) (Math.random() * casillas[0].length);
			if (!casillas[postTmpFila][posTmpColumna].isMina()) {
				casillas[postTmpFila][posTmpColumna].setMina(true);
				minasGeneradas++;
			}
		}
		
	}

	public void imprimirTablero() {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				System.out.print(casillas[i][j].isMina() ? "X" : "0");

			}
			System.out.println("");
		}
	}
	
	public void actualizarNumeroMinasAlrededor(){
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j].isMina()){
                    List<Casilla> casillasAlrededor=obtenerCasillasAlrededor(i, j);
                    casillasAlrededor.forEach((c)->c.incrementarNumeroMinasAlrededor());
                }
            }
        }
    }
	public void imprimirPistas() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                System.out.print(casillas[i][j].getNumMinasAlrededor());
            }
            System.out.println("");
        }
    }

	
	
	public List<Casilla> obtenerCasillasAlrededor(int posFila, int posColumna){
        List<Casilla> listaCasillas=new ArrayList<Casilla>();
        for (int i = 0; i < 8; i++) {
            int tmpPosFila=posFila;
            int tmpPosColumna=posColumna;
            switch(i){
                case 0: tmpPosFila--;break; //Arriba
                case 1: tmpPosFila--;tmpPosColumna++;break; //Arriba Derecha
                case 2: tmpPosColumna++;break; //Derecha
                case 3: tmpPosColumna++;tmpPosFila++;break; //Derecha Abajo
                case 4: tmpPosFila++;break; //Abajo
                case 5: tmpPosFila++;tmpPosColumna--;break; //Abajo Izquierda
                case 6: tmpPosColumna--;break; //Izquierda
                case 7: tmpPosFila--; tmpPosColumna--;break; //Izquierda Arriba
            }
            
            if (tmpPosFila>=0 && tmpPosFila<this.casillas.length
                    && tmpPosColumna>=0 && tmpPosColumna<this.casillas[0].length){
                listaCasillas.add(this.casillas[tmpPosFila][tmpPosColumna]);
            }
            
        }
        return listaCasillas;
    }

	public Casilla[][] getCasillas() {
		return casillas;
	}

	public void setCasillas(Casilla[][] casillas) {
		this.casillas = casillas;
	}
	

	


}
