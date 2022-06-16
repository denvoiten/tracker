package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Store;

public class DeleteAllAction implements UserAction {

    private final Output out;

    public DeleteAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete All Item";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Delete All items ===");
        for (Item item : store.findAll()) {
            if (store.delete(item.getId())) {
                out.println("All items removed");
            } else {
                out.println("Error");
            }
        }
        return true;
    }
}


