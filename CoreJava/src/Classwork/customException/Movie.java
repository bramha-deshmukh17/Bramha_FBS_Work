package Classwork.customException;

import java.util.Scanner;

class Movie {

	static String movieName = "Chhichhore";
	static int ticketPrice = 200;
	static int maxAvailableTickets = 50;

	static void bookTickets(int tickets) throws InvalidTicketNumberException, TicketsSoldOutException {

		if (tickets <= 0) {

			throw new InvalidTicketNumberException();

		}
		if (tickets > maxAvailableTickets) {

			throw new TicketsSoldOutException();
		}

		maxAvailableTickets -= tickets;

		System.out.println("\nBooking Successful for \"" + movieName + "\"!");
		System.out.println("Tickets booked: " + tickets);
		System.out.println("Total amount: ₹" + (tickets * ticketPrice));
		System.out.println("Remaining tickets: " + maxAvailableTickets + "\n");
	}

	static int getRemainingTickets() {
		return maxAvailableTickets;
	}

}

class MovieTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Movie: " + Movie.movieName);
		System.out.println("Ticket Price: ₹" + Movie.ticketPrice);

		while (true) {
			System.out.print("\nEnter number of tickets to book or type 'exit' to quit: ");
			String input = sc.next();

			if (input.equalsIgnoreCase("exit")) {
				break;
			}

			try {
				int tickets = Integer.parseInt(input);

				if (Movie.getRemainingTickets() == 0) {
					System.out.println("Sorry! Tickets are sold out.");
					continue;
				}

				Movie.bookTickets(tickets);

			} catch (InvalidTicketNumberException | TicketsSoldOutException e) {
				System.out.println(e.getMessage());

			}
		}

		System.out.println("\nSorry! Tickets are sold out.");
		sc.close();
	}
}