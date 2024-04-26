interface ComputerPart {
    void accept(ComputerPartVisitor visitor);
}

interface ComputerPartVisitor {
    void visit(Computer computer);
    void visit(Keyboard keyboard);
    void visit(Monitor monitor);
}

class Computer implements ComputerPart {
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}

class Keyboard implements ComputerPart {
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}

class Monitor implements ComputerPart {
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}

class MaintenanceVisitor implements ComputerPartVisitor {
    /* TODO: implement visits */
}

public class ComputerService {
    public void performMaintenance(ComputerPart part) {
        part.accept(new MaintenanceVisitor());
    }

    public static void main(String[] args) {
        ComputerService service = new ComputerService();
        service.performMaintenance(new Computer());
        service.performMaintenance(new Keyboard());
        service.performMaintenance(new Monitor());
    }
}
