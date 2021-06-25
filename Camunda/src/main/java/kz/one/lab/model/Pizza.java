package kz.one.lab.model;

public class Pizza {
    private Long pizzaId;
    private String name;
    private Integer availablePizzaAmount;

    public Long getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Long pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAvailablePizzaAmount() {
        return availablePizzaAmount;
    }

    public void setAvailablePizzaAmount(Integer availablePizzaAmount) {
        this.availablePizzaAmount = availablePizzaAmount;
    }
}
