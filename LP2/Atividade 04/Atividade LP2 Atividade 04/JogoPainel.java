import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;


public class JogoPainel extends JPanel implements Runnable, KeyListener {

    // Tamanho da janela - tamanho das bordas (640-15 = 625)
    private static final int LARGURA = 625;

    // Tamanho da janela - tamanho das bordas (480-35 = 445)
    private static final int ALTURA = 445;

    private Thread animacao;
    private int tempoEspera = 10;
    private boolean jogando = false;
    int diametroBola = 30, diametroBola2 = 30;

    /* variáveis com posição e direção iniciais utilizadas apenas para efeito de * testes */
    private int x = 50, y = 150, velocidadeX = 100, velocidadeY = 1;
    private int x2 = 50, y2 = 150, velocidadeX2 = 1, velocidadeY2 = 1;

    // Define informações da janela. 
    public JogoPainel() {
        // cor de fundo. 
        setBackground(Color.BLACK);
        addKeyListener(this);
        setFocusable(true);
    }

    // Controle de início do jogo. 
    public void addNotify() {
        super.addNotify();
        iniciarJogo();
    }

    // Função que da start nas funções de início do jogo
    private void iniciarJogo() {
        if (animacao == null || !jogando) {
            animacao = new Thread(this);
            animacao.start();
        }
    }

    public void run() {
        jogando = true;
        /*
        * Loop do jogo. Aqui as coisas acontecem. */
        while (jogando) {
            /*
            * Coloque aqui todas as ações que queira que sejam executadas a cada loop do
            * jogo
            */

            moveBola();
            repaint();

            /* fim ações para testes */
            try {
                Thread.sleep(tempoEspera);
            } catch (InterruptedException e) {
                e.printStackTrace();
        }
    }
    System.exit(0);
}

    /* Função que desenha o fundo do painel . */

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Define a cor

        g.setColor(Color.WHITE);

        // Pinta o circulo. (tente g.fillOval)

        g.drawOval(x, y, diametroBola, diametroBola);

        g.fillOval(x2, y2, diametroBola2, diametroBola2);


    }

    
    // Função que controla o movimento da bola. 
    
    private void moveBola() {
        //Bora quebra um pouco a cabeça.
         if (x2 >= LARGURA - diametroBola2)
             velocidadeX2 *= -1;
         if (x2 <= 0)
             velocidadeX2 *= -1;
         if (y2 >= ALTURA - diametroBola2)
             velocidadeY2 *= -1;
         if (y2 <= 0)
             velocidadeY2 *= -1;
         x2 += velocidadeX2;
         y2 += velocidadeY2;
    }


    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP: 
                velocidadeY = -5;

                if(y <= 0){
                    velocidadeY = 0;
                }else{
                    y += velocidadeY;                
                }
            break;
            case KeyEvent.VK_DOWN: 
                velocidadeY = 5;

                if(y >= ALTURA - diametroBola){
                    velocidadeY = 0;
                }else{
                    y += velocidadeY;                
                }
            break; 
            case KeyEvent.VK_LEFT:
                velocidadeX = -5;

                if(x <= 0){
                    velocidadeX = 0;
                }else{
                    x += velocidadeX;                
                }
            break; 
            case KeyEvent.VK_RIGHT:
                velocidadeX = 5;

                if(x >= LARGURA - diametroBola){
                    velocidadeX = 0;
                }else{
                    x += velocidadeX;                
                }
            break; 
            default:
            break; 
        } 
    }// Quando a tecla for solta 
    @Override 
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) { 
            case KeyEvent.VK_UP:  
            break; 
            case KeyEvent.VK_DOWN:
            break; 
            case KeyEvent.VK_LEFT: 
            break; 
            case KeyEvent.VK_RIGHT: 
            break; 
            default:
            break; 
        } 
    }
    
    @Override 
    public void keyTyped(KeyEvent e) { 

    } 
}