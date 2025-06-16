import java.util.Random;

/**
 * This class simulates a lottery draw with random numbers and prizes.
 */
public class LottoDraw {

    /**
     * The main method of the program that initiates the lottery draw.
     *
     * @param args Command line arguments (not used in this program)
     */
    public static void main(String[] args){
        //creating linked lists to pass into methods
        StrLinkedList lottoNumbersList = new StrLinkedList();
        StrLinkedList luckyNumbersList = new StrLinkedList();
        StrLinkedList prizeMoneyList = new StrLinkedList();

        //adding prizes to linked list
        prizeMoneyList.add("$100000");
        prizeMoneyList.add("$10000");
        prizeMoneyList.add("$1000");
        prizeMoneyList.add("$100");
        prizeMoneyList.add("$10");
        prizeMoneyList.add("$0");
        prizeMoneyList.add("$0");

        //using functions to carry out the draw
        //inputs can be changed to adjust for different amount of numbers to select
        //as well as ranges, number of lotto tickets and price of each ticket
        generateLotteryNumbers(lottoNumbersList,1, 40);
        System.out.println();
        
        selectLuckyNumbers(luckyNumbersList,6, 1, 40);
        System.out.println("Prize money:");
        prizeMoneyList.print();
        System.out.println();
        System.out.println();
        generateLotteryTickets(luckyNumbersList, prizeMoneyList, 100, 6, 1, 40);
        displayFinances(10);
    }

    //creating static variables for further use
    static double total_cost = 0;
    static Random random = new Random();
    static int num_sold_tickets = 0;
    
    /**
     * Generates lottery numbers and adds them to a linked list.
     *
     * @param lottoNumbersList The linked list to store the lottery numbers
     * @param min_number The minimum number of the range
     * @param max_number The maximum number of the range
     */
    public static void generateLotteryNumbers(StrLinkedList lottoNumbersList, int min_number, int max_number){
        for (int i = min_number; i <= max_number; i++){
            lottoNumbersList.add(Integer.toString(i));
        }

        System.out.println("Full number list:");
        lottoNumbersList.print();
        System.out.println();
    }
    
    /**
     * Selects lucky numbers randomly and adds them to a linked list.
     *
     * @param luckyNumbersList The linked list to store the lucky numbers
     * @param num_to_select The number of lucky numbers to select
     * @param min_number The minimum number of the range
     * @param max_number The maximum number of the range
     */
    public static void selectLuckyNumbers(StrLinkedList luckyNumbersList, int num_to_select, int min_number, int max_number){
        //StrLinkedList luckyNumbersList = new StrLinkedList();
        int random_num = random.nextInt(max_number+1-min_number) + min_number;
        String random_num_str = Integer.toString(random_num);

        for (int i= 0; i<num_to_select; i++){
            while (luckyNumbersList.hasValue(random_num_str)) {
                random_num = random.nextInt(max_number+1-min_number) + min_number;
                random_num_str = Integer.toString(random_num);
            }
            luckyNumbersList.add(random_num_str);
        }

        System.out.println("Winning numbers:");
        luckyNumbersList.print();
        System.out.println();
    }

    /**
     * Calculates prize money based on the number of correct numbers.
     *
     * @param prizeMoneyList The linked list containing prize money information
     * @param correct_numbers The number of correct numbers matched
     * @return The calculated prize money
     */
    public static double calculatePrizeMoney(StrLinkedList prizeMoneyList, int correct_numbers){
        double prize_money = 0;

        prize_money = Double.parseDouble(prizeMoneyList.getValueAt(correct_numbers).substring(1));
        
        //incrementing the total_cost static variable by the amount each ticket has won
        total_cost+= prize_money;
        return prize_money;
    }
    
    /**
     * Generates lottery tickets, checks for correct numbers, and calculates prizes.
     *
     * @param luckyNumbersList The linked list containing lucky numbers
     * @param prizeMoneyList The linked list containing prize money information
     * @param num_lott_tickets The number of lottery tickets to generate
     * @param num_to_select The number of numbers to select for each ticket
     * @param min_number The minimum number of the range
     * @param max_number The maximum number of the range
     */
    public static void generateLotteryTickets(StrLinkedList luckyNumbersList, StrLinkedList prizeMoneyList, int num_lott_tickets, int num_to_select, int min_number, int max_number){
        num_sold_tickets = num_lott_tickets;
        for (int i = 0; i < num_lott_tickets; i++){
            StrLinkedList lotteryTicket = new StrLinkedList();
            int correct_numbers = 0;

            //generating random numbers for each lottery ticket
            for (int j=0; j<num_to_select;j++){
                int random_num = random.nextInt(max_number+1-min_number) + min_number;
                String random_num_str = Integer.toString(random_num);

                //ensuring no duplicate numbers in the ticket
                while (lotteryTicket.hasValue(random_num_str)) {
                    //generating a random number betweeen 
                    random_num = random.nextInt(max_number+1-min_number) + min_number;
                    random_num_str = Integer.toString(random_num);
                }
                //adding each number to the current lottery ticket
                lotteryTicket.add(random_num_str);
                
            }
            
            //checking for correct numbers in the ticket
            for (int j=0; j<num_to_select; j++){
                
                if (lotteryTicket.hasValue(luckyNumbersList.getValueAt(j))){
                    //incrementing the count of correct numbers in each ticket
                    correct_numbers++;
                }
            }
            
            //calculating and displaying prize earned for each ticket
            double prize_money = calculatePrizeMoney(prizeMoneyList, correct_numbers);
            System.out.print("Prize won: $" + prize_money + " Ticket: ");
            lotteryTicket.print();
            System.out.println();
        }
    }

    /**
     * Displays financial information such as total earnings, total prizes won, and total profit.
     *
     * @param ticket_price The price of each lottery ticket
     */
    public static void displayFinances(double ticket_price){
        double total_revenue = num_sold_tickets * ticket_price;
        System.out.println("Total number of tickets sold: " + num_sold_tickets);
        System.out.println("Total earnings: $" + total_revenue);
        System.out.println("Total prizes won: $" + total_cost);
        System.out.println("Total profit: $" + (total_revenue-total_cost));
    }
}