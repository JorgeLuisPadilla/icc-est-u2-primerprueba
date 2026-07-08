import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import controllers.InventoryController;
import models.LabSupply;

public class App {
    public static void main(String[] args) throws Exception {
        List<LabSupply> supplies = new ArrayList<>();

        supplies.add(new LabSupply("IN-205-104", "Ana Torres", 80));
        supplies.add(new LabSupply("IN-201-101", "Luis Mora", 15));
        supplies.add(new LabSupply("IN-208-108", "Carlos Vega", 45));
        supplies.add(new LabSupply("iN-205-104", "Ana Torres", 80));
        supplies.add(new LabSupply("IN-203-103", "Luis Andrade", 30));
        supplies.add(new LabSupply("IN-207-107", "Mateo Rojas", 8));
        supplies.add(new LabSupply("IN-202-102", "Sofia Cordero", 55));
        supplies.add(new LabSupply("IN-206-106", "Carlos Mendez", 90));
        supplies.add(new LabSupply("IN-204-105", "Ana Molina", 20));
        // Mis datos
        supplies.add(new LabSupply("IN-207-107", "AnA MolInA", 34));
        supplies.add(new LabSupply("IN-201-106", "Jonas Martinez", 25));
        supplies.add(new LabSupply("IN-208-101", "Jose Vega", 25));
        supplies.add(new LabSupply("IN-204-105", "Ana Peralta", 80));
        supplies.add(new LabSupply("IN-207-107", "Ana peralta", 80));
        supplies.add(new LabSupply("In-200-100", "Jose Caceres", 20));
        
        

        InventoryController controller = new InventoryController();

        Set<LabSupply> result = controller.filterAndSortSupplies(supplies, 20);

        System.out.println("Supplies filtrados:");
        System.out.println("Metodo A: ");

        for (LabSupply supply : result) {
            System.out.println(supply);
        }

        System.out.println();
        System.out.println("Metodo B: ");

        Map<String, Set<Integer>> groups = controller.groupCodesByStock(supplies);

        System.out.println(groups);

    }
}
