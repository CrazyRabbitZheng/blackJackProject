/**
 * <pre>
 *
 *  _         _                _      _                _
 * | |       | |              | |    (_)              | |
 * | |____   | |  __  _   ____| |  __ _   __  _   ____| |  __
 * | |  __  \| |/  _ ` |/  ___| |/  /| |/  _ ` |/  ___| |/  /
 * | | |  |  | |  ( |  |  (   |    < | |  ( |  |  (   |    <
 * | |  --  /| |\  -   |\  ---| |\  \| |\  -   |\  ---| |\  \
 *  - -----   -   --,- |  ---- -   --/ |  --,- |  ---- -   --
 *                                |___/
 * </pre>
 * This class displays the figure above
 * @author Zheng Wang
 */
public class BlackJackWelcome {
    public static void printWelcome(){
        System.out.println();
        System.out.printf("%1$3s%1$10s%1$17s%1$7s%17s%n","_");
        System.out.printf("%2s%1$2s%1$8s%1$2s%1$15s%1$2s%2$7s%1$15s |%n","|","(_)");
        System.out.printf("%2s%1$2s____%1$4s%1$2s%2$4s%3$3s%2$5s__|%1$2s%2$4s%3$2s%2$5s%3$3s%2$5s__| |%2$4s%n","|","__","_");
        System.out.printf("%2s%1$2s%3$4s%2$3s%1$s%1$2s%4$s%5$3s%6$2s%1$2s/%3$4s_|%1$2s/%4$3s|%1$2s/%5$3s%6$2s |/%3$4s_| |/%4$3s%n","|","\\","__","/","_","`");
        System.out.printf("%2s%1$2s%1$2s%1$3s%1$3s%1$2s%2$3s%1$2s%1$3s%2$3s%1$4s%3$5s%1$2s%1$2s%2$3s |%1$3s %2$2s%1$4s%3$5s%n","|","(","<");
        System.out.printf("%2s%1$2s%2$4s%3$3s%1$s%1$2s%4$s%5$3s%1$4s\\%2$4s-|%1$2s\\%4$3s|%1$2s\\%5$3s%1$4s\\%2$4s-| |\\%4$3s%n","|","--","/","\\","-");
        System.out.printf("%1$3s%2$3s%2$s%1$s%1$4s%2$5s,-%3$2s%2$4s-- -%2$5s/%3$2s%2$4s,- |%2$4s-- -%2$5s%n","-","--","|");
        System.out.printf("%38s","|___/");
        System.out.println();
        System.out.println();
    }
}
