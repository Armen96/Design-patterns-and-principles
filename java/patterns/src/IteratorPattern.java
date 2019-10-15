public class IteratorPattern {
    public static void main( String[] args) {
        Container container = new Container();
        InterfaceIterator iterator = container.getIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

interface InterfaceIterator {
    boolean hasNext();
    Object next();
}

interface InterfaceContainer {
    InterfaceIterator getIterator();
}

class Container implements InterfaceContainer {
    private String[] array = {"Mark", "Nick", "Peter"};

    @Override
    public InterfaceIterator getIterator() {
        return new ArrayIterator();
    }

    class ArrayIterator  implements InterfaceIterator {
        int index;

        @Override
        public boolean hasNext() {
            return index < array.length;
        }

        @Override
        public Object next() {

            if(hasNext()) {
                return array[index++];
            }

            return null;
        }
    }
}