import java.util.ArrayList;
import java.util.List;

public class CommandPattern {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        MouseClick click = new MouseClick();
        MousePress press = new MousePress();

        receiver.addCommands(click);
        receiver.addCommands(press);

        receiver.runCommands();
    }
}

interface InterfaceCommand {
    void execute();
}

class MouseClick implements InterfaceCommand {

    @Override
    public void execute() {
        System.out.println("mouse click");
    }
}

class MousePress implements InterfaceCommand {

    @Override
    public void execute() {
        System.out.println("mouse press");
    }
}

class Receiver {
    private List<InterfaceCommand> commands = new ArrayList<>();

    void addCommands(InterfaceCommand command) {
        commands.add(command);
    }

    private InterfaceCommand command = new MouseClick();

    void runCommands() {
        for (InterfaceCommand command: commands) {
            command.execute();
        }
    }
}
