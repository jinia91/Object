package chapter7.traditional.ver2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


// 모든 기본급 총합을 구하는 기능을 추가해달라는 새로운 요구사항
public class PaymentCalculator {

    static public Map<String, Integer> db = new HashMap<>();
    static public Scanner sc = new Scanner(System.in);

    static {
        db.put("직원A",400);
        db.put("직원B",300);
        db.put("직원C",250);
    }

    public static void main(String[] args) {
        System.out.println("1. 'operation1' : 직원 기본급 합계구하기");
        System.out.println("2. 'operation2' : 직원 급여 구하기");
        String operation = sc.next();
        switch (operation) {
            case "1" :
                sumOfBasePays();
                return;
            case "2" :
                calculatePay();
                return;
            default:
                throw new IllegalArgumentException("잘못된 명령이에용");
        }
    }

    private static void calculatePay(){
        String name = sc.next();
        double taxRate = getTaxRate();
        double pay = calculatePayFor(name, taxRate);
        puts(describeResult(name, pay));
    }

    private static double getTaxRate() {
        System.out.println("세율을 입력하세요");
        String inputTaxRate = sc.next();
        double taxRate;
        try {
            taxRate = Double.parseDouble(inputTaxRate);
        }catch (Exception e){
            throw new IllegalArgumentException("입력값이 잘못됬어용");
        }
        return taxRate;
    }

    private static double calculatePayFor(String name, double taxRate) {
        Integer basicPayment = db.get(name);
        if(basicPayment == null){
            throw new IllegalArgumentException("없는 회원이에용");
        }
        return basicPayment - (basicPayment * taxRate);
    }

    private static String describeResult(String name, double pay) {
        return String.format("이름: %s, 급여: %f", name, pay);
    }

    private static void puts(String describeResult) {
        System.out.println(describeResult);
    }

    private static void sumOfBasePays(){
        Integer sum = 0;
        for (String key : db.keySet()) {
            sum += db.get(key);
        }
        puts(sum +"");
    }
}
