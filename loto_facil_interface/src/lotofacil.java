import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class lotofacil extends JFrame {

    private JTextField inputField;
    private JLabel outputLabel;
    private Random random;

    public lotofacil() {
        setTitle("Lotofácil");
        setSize(900, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel menuLabel = new JLabel("Menu LOTOFÁCIL:");
        panel.add(menuLabel);

        JButton btnApostar0a100 = new JButton("Apostar de 0 a 100");
        panel.add(btnApostar0a100);

        JButton btnApostarAaZ = new JButton("Apostar de A à Z");
        panel.add(btnApostarAaZ);

        JButton btnApostarParOuImpar = new JButton("Apostar em par ou ímpar");
        panel.add(btnApostarParOuImpar);

        JButton btnSair = new JButton("Sair");
        panel.add(btnSair);

        outputLabel = new JLabel();
        panel.add(outputLabel);

        random = new Random();

        btnApostar0a100.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apostarDe0a100();
            }
        });

        btnApostarAaZ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apostarDeAaZ();
            }
        });

        btnApostarParOuImpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apostarParOuImpar();
            }
        });

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(panel);
        setVisible(true);
    }

    private void apostarDe0a100() {
        try {
            int numeroApostado = Integer.parseInt(JOptionPane.showInputDialog("Digite um número de 0 a 100:"));

            if (numeroApostado < 0 || numeroApostado > 100) {
                outputLabel.setText("Aposta inválida.");
                return;
            }

            int numeroSorteado = random.nextInt(101);

            if (numeroApostado == numeroSorteado) {
                outputLabel.setText("Você ganhou R$ 1.000,00 reais.");
            } else {
                outputLabel.setText("Que pena! O número sorteado foi: " + numeroSorteado + ".");
            }
        } catch (NumberFormatException e) {
            outputLabel.setText("Entrada inválida. Insira um número inteiro.");
        }
    }

    private void apostarDeAaZ() {
        try {
            String letraApostada = JOptionPane.showInputDialog("Digite uma letra de A à Z:");
            char letraApostadaChar = letraApostada.toUpperCase().charAt(0);

            if (!Character.isLetter(letraApostadaChar)) {
                outputLabel.setText("Aposta inválida.");
                return;
            }

            char letraPremiada = 'G';
            if (letraApostadaChar == letraPremiada) {
                outputLabel.setText("Você ganhou R$ 500,00 Reais.");
            } else {
                outputLabel.setText("Que pena! A letra sorteada foi: " + letraPremiada + ".");
            }
        } catch (Exception e) {
            outputLabel.setText("Entrada inválida. Insira uma letra.");
        }
    }

    private void apostarParOuImpar() {
        try {
            int numeroDigitado = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro:"));

            if (numeroDigitado % 2 == 0) {
                outputLabel.setText("Você ganhou R$ 100,00 reais.");
            } else {
                outputLabel.setText("Que pena! O número digitado é ímpar e a premiação foi para números pares.");
            }
        } catch (NumberFormatException e) {
            outputLabel.setText("Entrada inválida. Insira um número inteiro.");
        }
    }

    public static void main(String[] args) {
        new lotofacil();
    }
}
