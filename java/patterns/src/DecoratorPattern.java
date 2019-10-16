import java.util.zip.CheckedInputStream;

public class DecoratorPattern {
    public static void main(String[] args) {
        InterfaceFile fileReader = new FileBufferingReader(new FileStreamReader());
        fileReader.read();
    }
}

interface InterfaceFile {
    void read();
}

class FileStreamReader implements InterfaceFile {

    @Override
    public void read() {
        System.out.println("Read file");
    }
}

abstract class FileDecorator implements InterfaceFile {
    private InterfaceFile fileDecorator;

    FileDecorator(InterfaceFile fileDecorator) {
        this.fileDecorator = fileDecorator;
    }

    public abstract void read();
}

class FileBufferingReader extends FileDecorator {
    InterfaceFile fileDecorator;

    FileBufferingReader(InterfaceFile fileDecorator){
        super(fileDecorator);
        this.fileDecorator = fileDecorator;
    }

    @Override
    public void read() {
        System.out.println("Buffering");
        fileDecorator.read();
    }
}