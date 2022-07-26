import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Movel {
	protected int diametro, x, y;
	private int velocidadeX=1, velocidadeY=1;
	protected Color cor;	

	// Cria um móvel com posição, cor e diâmetro aleatórios
	public Movel(int altura, int largura) {
		Random random = new Random();
		diametro = random.nextInt(70)+30;
		x = random.nextInt(largura-diametro-25)+25;
		y = random.nextInt(altura-diametro-25)+25;
		Color cores[] = {
			Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.CYAN,
			Color.YELLOW, Color.ORANGE, Color.PINK
		};
		cor = cores[random.nextInt(8)];
	}

	public Movel(int novoX, int novoY, int novoDiametro, Color novaCor) {
		x = novoX;
		y = novoY;
		diametro = novoDiametro;
		cor = novaCor;
	}
	
	public void draw(Graphics g) {
		g.setColor(cor);
		g.drawOval(x, y, diametro, diametro);
	}

	public void update(int altura, int largura) {
		if (x >= largura - diametro || x <= 25) velocidadeX *= -1;
		if (y >= altura - diametro || y <= 25) velocidadeY *= -1;
		x += velocidadeX;
		y += velocidadeY;
	}
}