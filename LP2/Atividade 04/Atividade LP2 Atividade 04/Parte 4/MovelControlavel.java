import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;
import java.awt.event.KeyEvent;

public class MovelControlavel extends Movel {
	private int velocidadeX = 0, velocidadeY = 0;

	// Herda os construtores da classe pai
	public MovelControlavel(int altura, int largura) {
		super(altura, largura);
	}

	public MovelControlavel(int novoX, int novoY, int novoDiametro, Color novaCor) {
		super(novoX, novoY, novoDiametro, novaCor);
	}

	public void draw(Graphics g) {
		g.setColor(cor);
		g.fillOval(x, y, diametro, diametro);
	}

	public void update(int altura, int largura) {
		x += velocidadeX;
		y += velocidadeY;
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				velocidadeY = -3;
			break;
			case KeyEvent.VK_DOWN:
				velocidadeY = +3;
			break;
			case KeyEvent.VK_LEFT:
				velocidadeX = -3;
			break;
			case KeyEvent.VK_RIGHT:
				velocidadeX = +3;
			break;
			default:
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
			case KeyEvent.VK_DOWN:
				velocidadeY = 0;
			break;
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_RIGHT:
				velocidadeX = 0;
			break;
			default:
			break;
		}
	}
}
