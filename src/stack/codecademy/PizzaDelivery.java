package stack.codecademy;

public class PizzaDelivery {
    public Stack deliveryGal;
    public Stack pizzaHouse;

    public PizzaDelivery() {
        // 1. Instantiate deliveryGal and pizzaHouse stacks below
        this.deliveryGal = new Stack(5);
        this.pizzaHouse = new Stack();
    }

    public void assign(String [] pizzas) {
        for (String pizza : pizzas) {
            try {
                // 2. Push pizzas onto deliveryGal and print the update
                this.deliveryGal.push(pizza);
                System.out.println(pizza + " pizza added to deliveryGal stack.");

            } catch (Error e) {
                // 3. Push pizzas onto pizzaHouse and print the update
                this.pizzaHouse.push(pizza);
                System.out.println("deliveryGal left to make deliveries! " + pizza + " pizza added to pizzaHouse stack.");
            }
        }

        System.out.println("\nDELIVERIES ARE UNDERWAY...\n");

    }

    public void deliver() {
        int numPizzas = this.deliveryGal.size;
        for (int i = 0; i < numPizzas; i++) {
            // 4. Pop off each pizza from deliveryGal and print the update
            String pizzaType = this.deliveryGal.pop();
            System.out.println(pizzaType + " pizza delivered!");
        }
    }

    public static void main(String[]args) {
        String [] pizzas = {"pepperoni","cheese","veggie","meat","hawaiian", "margherita"};
        PizzaDelivery pizzaDelivery = new PizzaDelivery();
        pizzaDelivery.assign(pizzas);
        pizzaDelivery.deliver();
    }
}
