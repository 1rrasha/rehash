import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		OpenHashing openHashing = new OpenHashing(1000);// the size of the array
		try {
			System.out.println("Welcome to my Project :)");
			File file = new File("input_file.txt");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String name = scanner.nextLine();
				openHashing.add(name);// adding the names from the file
			}
			scanner.close();
			openHashing.rehash(2000); // Call rehash method to increase the size to 2000
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}

		Scanner inputScanner = new Scanner(System.in);
		int choice = 0;
		while (choice != 5) {
			System.out.println("1. Add name\n2. Delete name\n3. Search name\n4. Get size of list at index\n5. Exit");
			System.out.print("Enter your choice: ");
			choice = inputScanner.nextInt();
			switch (choice) {
				case 1:
					System.out.print("Enter name to add: ");
					String addName = inputScanner.next();
					openHashing.add(addName);
					break;
				case 2:
					System.out.print("Enter name to delete: ");
					String deleteName = inputScanner.next();
					openHashing.delete(deleteName);
					break;
				case 3:
					System.out.print("Enter name to search: ");
					String searchName = inputScanner.next();
					openHashing.search(searchName);
					break;
				case 4:
					System.out.print("Enter index to get size: ");
					int index = inputScanner.nextInt();
					if (index >= 0 && index < openHashing.hashTable.length) {
						int size = openHashing.hashTable[index].size();
						System.out.println("Size of list at index " + index + ": " + size);
					} else {
						System.out.println("Invalid index :(.");
					}
					break;

				case 5:
					System.out.println("Bye Bye :)");
					break;
				default:
					System.out.println("Invalid choice :(.");
			}
		}
		inputScanner.close();
	}

}
