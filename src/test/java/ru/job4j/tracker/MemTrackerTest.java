package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertEquals;

public class MemTrackerTest {

    @Test
    public void whenTestFindById() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item("Bug");
        Item item = memTracker.add(bug);
        Item result = memTracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenTestFindAll() {
        MemTracker memTracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        memTracker.add(first);
        memTracker.add(second);
        Item result = memTracker.findAll().get(0);
        assertThat(result.getName(), is(first.getName()));
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        MemTracker memTracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        memTracker.add(first);
        memTracker.add(second);
        memTracker.add(new Item("First"));
        memTracker.add(new Item("Second"));
        memTracker.add(new Item("First"));
        List<Item> result = memTracker.findByName(first.getName());
        assertThat(result.size(), is(3));
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        MemTracker memTracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        memTracker.add(first);
        memTracker.add(second);
        memTracker.add(new Item("First"));
        memTracker.add(new Item("Second"));
        memTracker.add(new Item("First"));
        List<Item> result = memTracker.findByName(second.getName());
        assertThat(result.get(1).getName(), is(second.getName()));
    }

    @Test
    public void whenReplace() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        memTracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        memTracker.replace(id, bugWithDesc);
        assertThat(memTracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        memTracker.add(bug);
        int id = bug.getId();
        memTracker.delete(id);
        assertThat(memTracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenTestItemSortByNameAscending() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Oliver"));
        items.add(new Item("Jack"));
        items.add(new Item("Harry"));
        items.add(new Item("Jacob"));
        items.add(new Item("Charley"));
        items.add(new Item("Oscar"));
        items.sort(new ItemAscByName());
        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Charley"));
        expected.add(new Item("Harry"));
        expected.add(new Item("Jack"));
        expected.add(new Item("Jacob"));
        expected.add(new Item("Oliver"));
        expected.add(new Item("Oscar"));
        assertEquals(items, expected);
    }

    @Test
    public void whenTestItemSortByNameDesc() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Oliver"));
        items.add(new Item("Jack"));
        items.add(new Item("Harry"));
        items.add(new Item("Jacob"));
        items.add(new Item("Charley"));
        items.add(new Item("Oscar"));
        items.sort(new ItemDescByName());
        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Oscar"));
        expected.add(new Item("Oliver"));
        expected.add(new Item("Jacob"));
        expected.add(new Item("Jack"));
        expected.add(new Item("Harry"));
        expected.add(new Item("Charley"));
        assertEquals(items, expected);
    }
}