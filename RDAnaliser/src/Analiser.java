import java.util.Scanner;

public class Analiser {

    public static Scanner scanner;

    public static int value = 0;
    public static String expressao;

    public static void main(String[] args) {

        System.out.println("bExpr -> bTermoS");
        System.out.println("S -> oubtermo | null");
        System.out.println("bTermo -> bFatorT ");
        System.out.println("T -> ebFator | null ");
        System.out.println("bFator -> not bFator| (bExpr)| VERDADEIRO| FALSO");

        System.out.println("");

        //COLOQUE NO MINIMO UM ESPAÇO ENTRE OS SIMBOLOS TERMINAIS
        //expressao = "true";
        //expressao = "false";
        //expressao = "~ true";
        //expressao = "~ false";
        //expressao = "( true & false )";
        //expressao = "( false | true )";
        //expressao = "~ ( true & false )";
        //expressao = "~ ( false | true )";
        //expressao = "( true ) & ( false )";
        expressao = "~ false )";

        String[] exper = expressao.split(" ");

        if (Bexp(exper)) {
            System.out.println("Deu Certo");
        } else {
            System.out.println("Não Deu Certo");
        }


    }


    public  static  boolean Bexp(String[] exper) {
        if(Btermo(exper)) {
            if (S(exper)) {
                return true;
            }
        }
        return false;
    }

    public static boolean S(String[] exper) {
        if(exper[value].equals("|")){
            value++;
            if (Btermo(exper)) {
                return true;
            }
        }
        return true;
    }

    public static boolean Btermo(String[] exper) {
        if(Bfator(exper)) {
            if(T(exper)) {
                return true;
            }
        }
        return false;
    }

    public static boolean T(String[] exper) {
        if(exper[value].equals("&")){
            value++;
            if (Bfator(exper)) {
                return true;
            }
        }
        return true;
    }


    public static boolean Bfator(String[] exper) {
        if(exper[value].equals("~")) {
            value++;
            if (Bfator(exper)) {
                return true;
            }
        }
        else if (exper[value].equals("(")) {
            value++;
            if (Bexp(exper)) {
                if(exper[value].equals(")")){
                    return true;
                }
                else{
                    return Bexp(exper);
                }
            }
        }
        else if (exper[value].equals("true")){
            return true;
        }

        else if (exper[value].equals("false")){
            return true;
        }
        return false;
    }



}
