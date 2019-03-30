import java.util.Scanner;

import static java.lang.Character.*;

public class Analiser {

    public static Scanner scanner;

    public static int value = 0;
    public static String expressao;

    public static void main(String[] args) {

//        System.out.println("bExpr -> bTermoS");
//        System.out.println("S -> oubtermo | null");
//        System.out.println("bTermo -> bFatorT ");
//        System.out.println("T -> ebFator | null ");
//        System.out.println("bFator -> not bFator| (bExpr)| VERDADEIRO| FALSO");

        System.out.println("");

        //COLOQUE NO MINIMO UM ESPAÇO ENTRE OS SIMBOLOS TERMINAIS
        //$ X = @ X ( 8 ) ;

        Scanner scan = new Scanner(System.in);
        System.out.println("Digite a expressão: \n");
        expressao = scan.nextLine();
        String[] exper = expressao.split(" ");

        if (comd(exper)) {
            System.out.println("Deu Certo");
        } else {
            System.out.println("Não Deu Certo");
        }


    }


//    public  static  boolean Bexp(String[] exper) {
//        if(Btermo(exper)) {
//            if (S(exper)) {
//                return true;
//            }
//        }
//        return false;
//    }
//    public static boolean S(String[] exper) {
//        if(exper[value].equals("|")){
//            value++;
//            if (Btermo(exper)) {
//                return true;
//            }
//        }
//        return true;
//    }
//    public static boolean Btermo(String[] exper) {
//        if(Bfator(exper)) {
//            if(T(exper)) {
//                return true;
//            }
//        }
//        return false;
//    }
//    public static boolean T(String[] exper) {
//        if(exper[value].equals("&")){
//            value++;
//            if (Bfator(exper)) {
//                return true;
//            }
//        }
//        return true;
//    }
//    public static boolean Bfator(String[] exper) {
//        if(exper[value].equals("~")) {
//            value++;
//            if (Bfator(exper)) {
//                return true;
//            }
//        }
//        else if (exper[value].equals("(")) {
//            value++;
//            if (Bexp(exper)) {
//                if(exper[value].equals(")")){
//                    return true;
//                }
//                else{
//                    return Bexp(exper);
//                }
//            }
//        }
//        else if (exper[value].equals("true")){
//            return true;
//        }
//
//        else if (exper[value].equals("false")){
//            return true;
//        }
//        return false;
//    }


    public static boolean comd(String[] exper){
        if(func(exper)){
            if(exper[value].equals(";")){
//                value++;
                return true;
            }
        }else if(vatrib(exper)){
            if(exper[value].equals(";")){
                value++;
                return true;
            }
        }else if (expr(exper)){
            if(exper[value].equals(";")){
                return true;
            }
        }
        return false;
    }

    public static boolean func(String[] exper){
        if(funcid(exper)){
            if(exper[value].equals("(")){
                value++;
                if(fpars(exper)){
                    if(exper[value].equals("(")){
                        value++;
                        if(vatrib(exper)){
                            if(expr(exper)){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean vatrib(String[] exper){
        if(varid(exper)){
            if(exper[value].equals("=")){
                value++;
                if(expr(exper)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean expr(String[] exper){
        if(numl(exper)){
            return true;
        }else if(varid(exper)){
            return true;
        }else if(resid(exper)){
            return true;
        }else if(fcall(exper)){
            return true;
//        }else if(expr(exper)){
//            if(oprbin(exper)){
//                if(expr(exper)){
//                    return true;
//                }
//            }
        }else if(oprun(exper)){
            if(expr(exper)){
                return true;
            }
        }else if(exper[value].equals("(")){
            if(expr(exper)){
                if(exper[value].equals(")")){
                    value++;
                    return true;
                }
            }
        }
            return false;
    }

    public static boolean fcall(String[] exper){
        if(funcid(exper)){
            if(exper[value].equals("(")){
                value++;
                if(rpars(exper)){
                    if(exper[value].equals(")")){
                        value++;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean fpars(String[] exper){
        if(varid(exper)){
            if(exper[value].equals(",")){
                value++;
                if(fpars(exper)){
                    return true;
                }
            }
            return true;
        }
        return true;
    }

    public static boolean rpars(String[] exper){
        if(expr(exper)){
            if(exper[value].equals(",")){
                value++;
                if(rpars(exper)){
                    return true;
                }
            }
            return true;
        }
        return true;
    }

    public static boolean oprun(String[] exper){
        if(exper[value].equals("+")){
            value++;
            return true;
        }else if(exper[value].equals("-")){
            value++;
            return true;
        }
        return false;
    }

    public static boolean oprbin(String[] exper){
        if(exper[value].equals("+")){
            value++;
            return true;
        }else if(exper[value].equals("-")){
            value++;
            return true;
        }else if(exper[value].equals("*")){
            value++;
            return true;
        }else if(exper[value].equals("/")){
            value++;
            return true;
        }else if(exper[value].equals("%")){
            value++;
            return true;
        }else if(exper[value].equals("^")){
            value++;
            return true;
        }
        return false;
    }

    public static boolean varid(String[] exper){
        if(exper[value].equals("$")){
            value++;
            if(exper[value].equals("X")){
                value++;
                return true;
            }
        }
        return false;
    }

    public static boolean resid(String[] exper){
        if(exper[value].equals("$")){
            value++;
            if(exper[value].equals("8")){
                return true;
            }
        }
        return false;
    }

    public static boolean funcid(String[] exper){
        if(exper[value].equals("@")){
            value++;
            if(exper[value].equals("X")){
                value++;
                return true;
            }
        }
        return false;
    }

    public static boolean numl(String[] exper){
        if(exper[value].equals("0")){
            value++;
            return true;
        }
        return false;
    }



}
