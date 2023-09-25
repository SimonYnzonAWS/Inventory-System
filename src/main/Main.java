package main;

public class Main {

	static Scanner scan = new Scanner(System.in);
	static InventorySystem invSys = new InventorySystem();
	static ArrayList<Drinks> drinksList = new ArrayList<>();
	static ArrayList<Foods> foodsList = new ArrayList<>();

	public static void main(String[] args) {

		boolean useApp = true;
		drinksList.add(new Drinks(1, "Gatorade", 50.0, 100));
		drinksList.add(new Drinks(2, "Coke", 20.0, 100));
		drinksList.add(new Drinks(3, "Sprite", 30.0, 100));

		foodsList.add(new Foods(1, "Onigiri", 100.0, 100));
		foodsList.add(new Foods(2, "Noodles", 10.0, 100));
		foodsList.add(new Foods(3, "Can", 34.0, 100));

		for (Drinks item : drinksList) {
			invSys.addDrinks(item);
		}

		for (Foods item : foodsList) {
			invSys.addFoods(item);
		}

		while (useApp) {
			System.out.print("Select 1 to add inventory/n" + "2 View inventory/n"
					+ "3 Edit inventory/n" + "4 sell/nSelect 0 to Exit");
			String selection = scan.next();
			switch (selection) {
			case "1":
				addInventory();
				break;
			case "2":
				viewInventory();
				break;
			case "3":
				editInventory();
				break;
			case "4":
				sell();
				break;
			case "0":
				useApp = false;
				break;
			}
		}

		scan.close();

	}

	static void addInventory() {
		boolean isAdd = true;
		while (isAdd) {
			System.out.println("Enter Menu\nD Drinks\nF Foods\nE Exit");
			String selection = scan.next().toUpperCase();
			switch (selection) {
			case "D":
				invSys.addProduct("drinks");
				break;
			case "F":
				invSys.addProduct("Foods");
				break;
			case "E":
				isAdd = false;
				break;
			}
		}
	}

	static void viewInventory() {
		System.out.print("Foods\n");
		for (Foods item : invSys.getFoods().values()) {
			System.out.println("Product ID: " + item.getProductID() + "\tName: " + item.getProductName()
					+ "\tUnit Price: " + item.getUnitPrice() + "\tQuantity Left: " + item.getStockQuantity());
		}

		System.out.print("Drinks\n");
		for (Drinks item : invSys.getDrinks().values()) {
			System.out.println("Product ID: " + item.getProductID() + "\tName: " + item.getProductName()
					+ "\tUnit Price: " + item.getUnitPrice() + "\tQuantity Left: " + item.getStockQuantity());
		}

		System.out.println();
	}

	static void editInventory() {
		boolean isEdit = true;
		while (isEdit) {
			System.out.print("Enter product name you want to update, select E to Home");
			String selection = scan.next();
			if (!selection.toLowerCase().equals("e")) {
				invSys.productTypeCheckEdit(selection);
			} else {
				isEdit=false;
			}
		}
	}
	
	static void sell() {
		System.out.print("Enter product to be dispatched");
		String prodName = scan.next();
		System.out.print("Enter quantity to be dispatched: ");
		int quant = scan.nextInt();
		invSys.sellProduct(prodName, quant);
	}

}
