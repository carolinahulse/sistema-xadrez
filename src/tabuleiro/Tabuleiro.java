package tabuleiro;
public class Tabuleiro {
	private int linhas;
	private int colunas;
	private Peca[][] pecas;
	
	public Tabuleiro(int linhas, int colunas) {
		if(linhas < 1 || colunas < 1) {
			throw new TabuleiroException("Erro na cria��o do tabuleiro: "
					+ "� necess�rio que tenha 1 linha e 1 coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	public int getLinha() {
		return linhas;
	}

	public int getColuna() {
		return colunas;
	}
	
	public Peca peca(int linha, int coluna) {
		if(!posicaoExiste(linha, coluna)) {
			throw new TabuleiroException("A posi��o n�o existe no tabuleiro");
		}
		return pecas[linha][coluna];
	}
	
	public Peca peca(Posicao posicao) {
		if(!posicaoExiste(posicao)) {
			throw new TabuleiroException("A posi��o n�o existe no tabuleiro");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	public void colocarPeca(Peca peca, Posicao posicao) {
		if(temUmaPeca(posicao)) {
			throw new TabuleiroException("J� possui uma pe�a na posi��o "+posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	private boolean posicaoExiste(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}
	
	public boolean posicaoExiste(Posicao posicao) {
		return posicaoExiste(posicao.getLinha(), posicao.getColuna());
	}
	
	public boolean temUmaPeca(Posicao posicao) {
		if(!posicaoExiste(posicao)) {
			throw new TabuleiroException("A posi��o n�o existe no tabuleiro");
		}
		return peca(posicao) != null;
	}
}