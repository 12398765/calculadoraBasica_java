package calcu;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.String.valueOf;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Calcu extends JFrame implements ActionListener{
    
    int cont = 0, Operator=0, number1=0, number2=0;
    String num1 = "", num2 = "", val = "";

    JTextField r = new JTextField("");
    JButton cero = new JButton("0");
    JButton uno = new JButton("1");
    JButton dos = new JButton("2");
    JButton tres = new JButton("3");
    JButton cuat = new JButton("4");
    JButton cin = new JButton("5");
    JButton seis = new JButton("6");
    JButton siete = new JButton("7");
    JButton ocho = new JButton("8");
    JButton nueve = new JButton("9");
    JButton mas = new JButton("+");
    JButton menos = new JButton("-");
    JButton por = new JButton("*");
    JButton entre = new JButton("/");
    JButton pot = new JButton("^");
    JButton modul = new JButton("%");
    JButton borrar = new JButton("DEL");
    JButton igual = new JButton("=");

    boolean cond = false;

    public Calcu() {
        setTitle("Calculadora");
        setSize(350, 300);
        setLocationRelativeTo(null);  //centrado
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        calcu();
    }

    public void calcu() {
        JPanel cal = new JPanel();
        JPanel windo = new JPanel();

        r.setEnabled(false);
        windo.setLayout(null);
        windo.add(r);
        r.setBounds(37, 220, 260, 20);
        r.setBackground(Color.black);
        add(r);

        //Teclado
        cal.setLayout(new GridLayout(8, 8));
        cal.add(seis);
        cal.add(siete);
        cal.add(ocho);
        cal.add(nueve);
        cal.add(dos);
        cal.add(tres);
        cal.add(cuat);
        cal.add(cin);
        cal.add(cero);
        cal.add(uno);
        cal.add(mas);
        cal.add(menos);
        cal.add(por);
        cal.add(entre);
        cal.add(pot);
        cal.add(modul);

        mas.setBackground(Color.red);
        menos.setBackground(Color.red);
        por.setBackground(Color.red);
        entre.setBackground(Color.red);
        pot.setBackground(Color.red);
        modul.setBackground(Color.red);
        borrar.setBackground(Color.LIGHT_GRAY);
        igual.setBackground(Color.blue);

        cal.add(borrar);
        cal.add(igual);

        cero.addActionListener(this);
        uno.addActionListener(this);
        dos.addActionListener(this);
        tres.addActionListener(this);
        cuat.addActionListener(this);
        cin.addActionListener(this);
        seis.addActionListener(this);
        siete.addActionListener(this);
        ocho.addActionListener(this);
        nueve.addActionListener(this);
        mas.addActionListener(this);
        menos.addActionListener(this);
        por.addActionListener(this);
        entre.addActionListener(this);
        pot.addActionListener(this);
        modul.addActionListener(this);
        borrar.addActionListener(this);
        igual.addActionListener(this);

        add(cal);
        setVisible(true);
    }
    
    public String CheckNum(ActionEvent e) {
        String val = "";

        if (e.getSource() == uno) {
            val += "1";
        } else if (e.getSource() == dos) {
            val += "2";
        } else if (e.getSource() == tres) {
            val += "3";
        } else if (e.getSource() == cuat) {
            val += "4";
        } else if (e.getSource() == cin) {
            val += "5";
        } else if (e.getSource() == seis) {
            val += "6";
        } else if (e.getSource() == siete) {
            val += "7";
        } else if (e.getSource() == ocho) {
            val += "8";
        } else if (e.getSource() == nueve) {
            val += "9";
        } else if (e.getSource() == cero) {
            val += "0";
        }
        return val;
    }

    public void Process(int Operator){
        float res=0;
        Operacion op = new Operacion();

            switch (Operator) {
                case 1:
                    res = op.suma(number1, number2);
                    r.setText(valueOf(number1) +" + "+ valueOf(number2) + "  =  "+valueOf(res));
                    break;

                case 2:
                    res = op.resta(number1, number2);
                    r.setText(valueOf(number1) +" - "+ valueOf(number2) + "  =  "+valueOf(res));
                    break;

                case 3:
                    res = op.multi(number1, number2);
                    r.setText(valueOf(number1) +" * "+ valueOf(number2) + "  =  "+valueOf(res));
                    break;

                case 4:
                    res = op.div(number1, number2);
                    r.setText(valueOf(number1) +" / "+ valueOf(number2) + "  =  "+valueOf(res));
                    break;

                case 5:
                    res = op.potencia(number1, number2);
                    r.setText(valueOf(number1) +" ^ "+ valueOf(number2) + "  =  "+valueOf(res));
                    break;
                case 6:
                    res = op.modulo(number1, number2);
                    r.setText(valueOf(number1) +" % "+ valueOf(number2) + "  =  "+valueOf(res));
                    break;
            }
    }
    
    
    public static void main(String[] args) {
        new Calcu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==borrar){
            r.setText("");
            num1=""; num2="";  number1=0; number2=0; cond=false; Operator=0;
            cont=0;
        }else
        //primer num
        if (cond == false) {
            //primer dÃ­gito
            if (e.getSource() != mas && e.getSource() != menos && e.getSource() != por
                    && e.getSource() != entre && e.getSource() != pot
                    && e.getSource() != modul) {
                num1 = r.getText() + CheckNum(e);
                r.setText(num1);
                number1 = Integer.parseInt(num1);
                System.out.println("num1::: "+number1);
            }
            //Operador
            else {
                cond = true;

                if (e.getSource() == mas) {
                    val = r.getText() + "+";
                    Operator = 1;
                } else if (e.getSource() == menos) {
                    val = r.getText() + "-";
                    Operator = 2;
                } else if (e.getSource() == por) {
                    val = r.getText() + "*";
                    Operator = 3;
                } else if (e.getSource() == entre) {
                    val = r.getText() + "/";
                    Operator = 4;
                } else if (e.getSource() == pot) {
                    val = r.getText() + "^";
                    Operator = 5;
                } else if (e.getSource() == modul) {
                    val = r.getText() + "%";
                    Operator = 6;
                }
                //r.setText(num1+value);
            }

        } //segundo dÃ­gito
        else {
            if (cont == 0) {
                r.setText("");
                cont = 1;
            }
            num2 = r.getText() + CheckNum(e);
            r.setText(num2);
            number2 = Integer.parseInt(num2);
        }

        //igual
        if (e.getSource() == igual) {
            Process(Operator);
            num1=""; num2="";  number1=0; number2=0; cond=false; Operator=0;cont=0;
        }
        
        
        

    }
    
}
