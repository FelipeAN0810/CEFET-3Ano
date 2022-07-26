import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JPanel;
import java.util.ArrayList;

public class JogoPainel extends JPanel implements Runnable,KeyListener {
	private static final int ALTURA = 445, LARGURA = 625;
	private Thread Movimento;
	private int Tempo = 10;
	private boolean jogando = false;

	ArrayList<Movel> moveis = new ArrayList<Movel>();
	MovelControlavel jogador = null;

	public JogoPainel() {
		setBackground(Color.BLACK);
		addKeyListener(this);
		setFocusable(true);
	}
	
	public void addNotify() {
		super.addNotify();
		iniciarJogo();
	}

	private void iniciarJogo() {
		if (Movimento == null || !jogando) {
			Movimento = new Thread(this);
			Movimento.start();
		}
	}

	public void run() {
		for (int i = 0; i < 9; i++)
			moveis.add(new Movel(ALTURA, LARGURA));
	
		jogador = new MovelControlavel(ALTURA, LARGURA);
		moveis.add(jogador);

		jogando = true;
		
		while (jogando) {
			repaint();
			for (Movel movel : moveis)
				movel.update(ALTURA, LARGURA);
			try {
				Thread.sleep(Tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.exit(0);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Movel movel : moveis)
			movel.draw(g);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		jogador.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		jogador.keyReleased(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}