/**
 * This class extends Thread class and sleep method
 * to let the dealer prints something and erasers it
 * re-write at the same line.
 * @author--Zheng Wang
 */
public class MoneyEaterThread extends Thread {

    @Override
    public void run() {

        try {
            System.out.printf("%40s%n%n", "Welcome to Black Jack!");
            Thread.sleep(1500);
            System.out.print("Ho Ho Ho ~ ~ ~ ~ I am Money Eater!");
            Thread.sleep(2800);
            System.out.print("\b-");
            Thread.sleep(1000);
            System.out.print("\b\b-");
            Thread.sleep(1000);
            System.out.print("\b\b-");
            Thread.sleep(1000);
            System.out.print("\b-");
            Thread.sleep(1000);
            System.out.print("\b\b-");
            Thread.sleep(1000);
            System.out.print("\b\b-");
            Thread.sleep(1000);
            System.out.print("\b\b-");
            Thread.sleep(1000);
            System.out.print("\b\b-");
            Thread.sleep(1000);
            System.out.print("\b\b-");
            Thread.sleep(1000);
            System.out.print("\b\b-");
            Thread.sleep(1000);
            System.out.print("\b\b-");
            Thread.sleep(1000);
            System.out.print("\b\b-");
            Thread.sleep(1000);
            System.out.print("\b\b-");

            Thread.sleep(1500);
            System.out.print("\by");
            Thread.sleep(800);
            System.out.print("o");
            Thread.sleep(800);
            System.out.print("u");
            Thread.sleep(800);
            System.out.print("r");
            Thread.sleep(800);
            System.out.print(" ");
            Thread.sleep(800);
            System.out.print("f");
            Thread.sleep(800);
            System.out.print("a");
            Thread.sleep(800);
            System.out.print("i");
            Thread.sleep(800);
            System.out.print("r");
            Thread.sleep(800);
            System.out.print(" ");
            Thread.sleep(800);
            System.out.print("d");
            Thread.sleep(800);
            System.out.print("e");
            Thread.sleep(800);
            System.out.print("a");
            Thread.sleep(800);
            System.out.print("l");
            Thread.sleep(800);
            System.out.print("e");
            Thread.sleep(800);
            System.out.print("r");
            Thread.sleep(800);
            System.out.print("!");
            System.out.println();

            Thread.sleep(1000);
            System.out.print("Let's");
            Thread.sleep(800);
            System.out.print(" have");
            Thread.sleep(800);
            System.out.print(" fun!");
            System.out.println();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

}
