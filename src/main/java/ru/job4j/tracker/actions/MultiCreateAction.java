package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.actions.UserAction;

public class MultiCreateAction implements UserAction {

    private final Output out;

    public MultiCreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add many Item";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Create many new Item ===");
        String name = input.askStr("Enter name: ");
        int count = input.askInt("How much Items create: ");
        for (int i = 1; i <= count; i++) {
            Item item = new Item(name + " " + i);
            store.add(item);
        }
        out.println("Добавленно заявок: " + count);
        return true;
    }
}
