package entidad;

public class Casilla {
	
	private int posFila;
    private int posColumna;
    private boolean mina;
    private int numMinasAlrededor;

    public Casilla(int posFila, int posColumna) {
        this.posFila = posFila;
        this.posColumna = posColumna;
    }

    /**
     * @return the posFila
     */
    public int getPosFila() {
        return posFila;
    }

    /**
     * @param posFila the posFila to set
     */
    public void setPosFila(int posFila) {
        this.posFila = posFila;
    }

    /**
     * @return the posColumna
     */
    public int getPosColumna() {
        return posColumna;
    }

    /**
     * @param posColumna the posColumna to set
     */
    public void setPosColumna(int posColumna) {
        this.posColumna = posColumna;
    }

    /**
     * @return the mina
     */
    public boolean isMina() {
        return mina;
    }

    /**
     * @param mina the mina to set
     */
    public void setMina(boolean mina) {
        this.mina = mina;
    }

	public int getNumMinasAlrededor() {
		return numMinasAlrededor;
	}

	public void setNumMinasAlrededor(int numMinasAlrededor) {
		this.numMinasAlrededor = numMinasAlrededor;
	}
    
	public void incrementarNumeroMinasAlrededor(){
        this.numMinasAlrededor++;
    }


}
