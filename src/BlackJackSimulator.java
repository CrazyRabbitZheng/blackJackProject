/**
 * <pre>
 *     Black Jack Game Rules:
 * [Non-Ace] Cards 2-10 are worth the value of the number on the face of the card.
 * J, Q, K worth 10, except for the Ace, which is worth 1 or 11.
 * If player only have 2 cards and they are ACE and J, or Q, or K -- Black Jack (a value of 21).
 * The most important blackjack rule is simple: beat the dealer’s hand without going over 21.
 * If you go over 21 you are Bust. If you get 21 points exactly on the deal, that is called a “blackjack.”
 * !!If you and the dealer both get blackjack, dealer wins!!
 * </pre>
 * <p>
 * This class allows you to play Black Jack on the console
 *
 * @author--Zheng Wang
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJackSimulator {
    public static void main(String[] args) throws IOException {
        BlackJackWelcome.printWelcome();

        MoneyEaterThread eater = new MoneyEaterThread();
        eater.start();

        printMeun();

        char choice;
        int balance = 200;
        int bet = 0;
        Boolean permissionNewRound = false;
        Boolean permittedHitOrStand = false;


        Scanner scanner = new Scanner(System.in);

        do {
            do {
                System.out.print("Would you like to start a round? (Y/N): ");
                choice = scanner.next().toUpperCase().charAt(0);
            } while (choice != 'N' && choice != 'Y' && !permittedHitOrStand);

            if (choice == 'Y') {

                DeckOfCards playingDeck = new DeckOfCards();
                List<Card> playerHand = new ArrayList<>();
                List<Card> dealerHand = new ArrayList<>();

                int playerTotal = 0;
                int dealerTotal = 0;

                char hitOrStand;

                System.out.print("How much would you like to bet? ");
                bet = scanner.nextInt();

                while (bet <= 0) {
                    System.out.println("Invalid bet! Try again");
                    bet = scanner.nextInt();
                }
                if (bet > balance) {
                    System.out.println("You can not bet more than you have. Please leave.");
                } else {
                    playerHand.add(playingDeck.deal());
                    playerHand.add(playingDeck.deal());

                    System.out.println("You got these cards: ");
                    showHand(playerHand);

                    dealerHand.add(playingDeck.deal());
                    dealerHand.add(playingDeck.deal());


                    if ((playerHand.get(0).getFace() == Face.ACE && (playerHand.get(1).getFace() == Face.JACK || playerHand.get(1).getFace() == Face.QUEEN || playerHand.get(1).getFace() == Face.TEN || playerHand.get(1).getFace() == Face.KING))
                            || (playerHand.get(1).getFace() == Face.ACE && (playerHand.get(0).getFace() == Face.TEN || playerHand.get(0).getFace() == Face.JACK || playerHand.get(0).getFace() == Face.QUEEN || playerHand.get(0).getFace() == Face.KING))) {
                        System.out.println("You call Black Jack! You win!");
                        balance += bet;
                        System.out.printf("Now you have $%d left.%n", balance);
                        permissionNewRound = true;
                    } else if ((dealerHand.get(0).getFace() == Face.ACE && (dealerHand.get(1).getFace() == Face.TEN || dealerHand.get(1).getFace() == Face.JACK || dealerHand.get(1).getFace() == Face.QUEEN || dealerHand.get(1).getFace() == Face.KING))
                            || (dealerHand.get(1).getFace() == Face.ACE && (dealerHand.get(0).getFace() == Face.TEN || (dealerHand).get(0).getFace() == Face.JACK || dealerHand.get(0).getFace() == Face.QUEEN || dealerHand.get(1).getFace() == Face.KING))) {
                        System.out.println("Dealer calls Black Jack! You lose.");
                        System.out.println("Dealer got these cards: ");
                        showHand(dealerHand);
                        balance -= bet;
                        if (balance > 0) {
                            System.out.printf("Now you have $%d left.%n", balance);
                            permissionNewRound = true;
                        } else {
                            System.out.println("You've run out of money.");
                            permissionNewRound = false;
                        }
                    } else {
                        int numberOfAcePlayer = 0;
                        int numberOfAceDealer = 0;
                        for (Card card : playerHand) {
                            playerTotal += card.getValue();
                            if (card.getFace() == Face.ACE) {
                                numberOfAcePlayer++;
                            }
                        }

                        for (Card card : dealerHand) {
                            dealerTotal += card.getValue();
                            if (card.getFace() == Face.ACE) {
                                numberOfAceDealer++;
                            }
                        }

                        do {
                            do {
                                System.out.println("Would you like to (H)hit or (S)stand?");
                                hitOrStand = scanner.next().toUpperCase().charAt(0);
                            } while (hitOrStand != 'H' && hitOrStand != 'S');

                            if (hitOrStand == 'H') {
                                playerHand.add(playingDeck.deal());
                                showHand(playerHand);
                                playerTotal += playerHand.get(playerHand.size() - 1).getValue();

                                if (playerHand.get(playerHand.size() - 1).getValue() == 11) {
                                    numberOfAcePlayer++;
                                }

                                if (playerTotal == 21) {
                                    System.out.println("You total points are " + playerTotal);
                                    System.out.println("You win!");
                                    balance += bet;
                                    System.out.printf("Now you have $%d left.%n", balance);
                                    permissionNewRound = true;
                                    permittedHitOrStand = false;
                                } else if (playerTotal > 21) {
                                    if (numberOfAcePlayer > 0) {
                                        playerTotal -= 10;
                                        numberOfAcePlayer--;
                                        System.out.println("Your total points are " + playerTotal);
                                        permittedHitOrStand = true;

                                        if (playerTotal == 21) {
                                            System.out.println("You win!");
                                            balance += bet;
                                            permissionNewRound = true;
                                            permittedHitOrStand = false;
                                        }

                                    } else {
                                        System.out.println("Your total points are " + playerTotal);
                                        System.out.println("You bust!");
                                        balance -= bet;
                                        if (balance > 0) {
                                            System.out.printf("Now you have $%d left.%n", balance);
                                            permissionNewRound = true;
                                            permittedHitOrStand = false;
                                        } else {
                                            System.out.println("You've run out of money.");
                                            permittedHitOrStand = false;
                                            permissionNewRound = false;
                                        }
                                    }
                                } else {
                                    System.out.println("Your total points are " + playerTotal);
                                    permittedHitOrStand = true;
                                    permissionNewRound = false;
                                }
                            } else {
                                dealerHand.add(playingDeck.deal());
                                dealerTotal += dealerHand.get(dealerHand.size() - 1).getValue();
                                if (dealerHand.get(dealerHand.size() - 1).getValue() == 11) {
                                    numberOfAceDealer++;
                                }

                                if (dealerTotal == 21) {
                                    System.out.println("Dealer wins!");
                                    showHand(dealerHand);
                                    permittedHitOrStand = false;
                                    balance -= bet;
                                    if (balance > 0) {
                                        System.out.printf("Now you have $%d left.%n", balance);
                                        permissionNewRound = true;
                                    } else {
                                        System.out.println("You've run out of money.");
                                        permissionNewRound = false;
                                    }
                                } else if (dealerTotal > 21) {

                                    if (numberOfAceDealer > 0) {
                                        dealerTotal -= 10;
                                        numberOfAceDealer--;
                                        System.out.println("Dealer drew a card. Now is your turn.");
                                        permittedHitOrStand = true;
                                        permissionNewRound = false;
                                    } else {
                                        System.out.println("Dealer bust! You win!");
                                        System.out.println("Dealer has these cards:");
                                        showHand(dealerHand);
                                        balance += bet;
                                        System.out.printf("Now you have $%d left.%n", balance);
                                        permittedHitOrStand = false;
                                        permissionNewRound = true;
                                    }
                                } else {
                                    System.out.println("Dealer drew a card. Now is your turn.");
                                    permittedHitOrStand = true;
                                    permissionNewRound = false;
                                }
                            }

                        } while (permittedHitOrStand);
                    }
                }
            } else {
                permissionNewRound = false;
            }
        } while (permissionNewRound);
        System.out.print("\nSee you next time.\n");
    }

    /**
     * This method reveals dealer's cards, and player's cards
     * @param hand
     */
    public static void showHand(List hand) {
        for (Object card : hand) {
            System.out.println(card);
        }
    }

    /**
     * This method displays the rules on Black Jack
     */
    private static void printMeun() {
        System.out.println("   Rules:");
        System.out.printf(" ♥ Player always goes first.%n%n");

        System.out.printf(" \u2667 You have $200 to start the game. Each round you can choose how much to bet.%n" +
                " \u2667 If you win, you gets the amount of money you bet.%n" +
                " ♣ If you lose, you lose the money you bet.%n%n");

        System.out.println(" ♦ Whoever gets 21 first, wins." +
                " ♦ Other situations, if you and dealer get same points, dealer wins.");

        System.out.println(" \u2662 Press Y to start the game. Press N to quit.");
        System.out.println(" \u2662 Press H to hit. Press S to stand.\n");

        System.out.println(" \u2664 Each round the deck will be shuffled. No need to memorize cards dealt.");
        System.out.println(" ♠ You are not allowed to bet more than you have.\n\n");
    }

}