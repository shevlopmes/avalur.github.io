class SimpleComputer {
    public void maintain() {
        System.out.println("Performing general maintenance on Computer.");
    }
}

class SimpleKeyboard {
    public void maintain() {
        System.out.println("Cleaning Keyboard.");
    }
}

class SimpleMonitor {
    public void maintain() {
        System.out.println("Adjusting Monitor display settings.");
    }
}

public class SimpleMaintenanceService {
    public void performMaintenance(SimpleComputer computer) {
        computer.maintain();
    }

    public void performMaintenance(SimpleKeyboard keyboard) {
        keyboard.maintain();
    }

    public void performMaintenance(SimpleMonitor monitor) {
        monitor.maintain();
    }

    public static void main(String[] args) {
        SimpleMaintenanceService service = new SimpleMaintenanceService();
        service.performMaintenance(new SimpleComputer());
        service.performMaintenance(new SimpleKeyboard());
        service.performMaintenance(new SimpleMonitor());
    }
}
