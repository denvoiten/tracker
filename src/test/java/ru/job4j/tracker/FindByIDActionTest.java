package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.actions.FindByIDAction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByIDActionTest {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    @Test
    public void whenFound() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("First item"));
        LocalDateTime created = LocalDateTime.now();
        tracker.add(new Item("Second item"));
        FindByIDAction findByIDAction = new FindByIDAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(2);
        findByIDAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by id ===" + ln + "Item {id = 2, name = 'Second item', created = "
                + created.format(FORMATTER) + "}" + ln));
    }

    @Test
    public void whenNotFound() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("First item"));
        tracker.add(new Item("Second item"));
        FindByIDAction findByIDAction = new FindByIDAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(3);
        findByIDAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by id ===" + ln + "Заявка с введенным id: 3 не найдена." + ln));
    }
}