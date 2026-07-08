package controllers;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import models.LabSupply;

public class InventoryController {
  public Set<LabSupply> filterAndSortSupplies(List<LabSupply> supplies, int minimumStock) {

    Set<LabSupply> result = new TreeSet<>((s1, s2) -> {
      if (s1.getCode().equalsIgnoreCase(s2.getCode())
          && s1.getStock() == s2.getStock()) {
        return 0;
      }
      int compareStock = Integer.compare(s2.getStock(), s1.getStock());

      if (compareStock != 0) {
        return compareStock;
      }
      return s1.getCode().compareToIgnoreCase(s2.getCode());

    });

    for (LabSupply supply : supplies) {

      if (supply.getStock() >= minimumStock) {
        result.add(supply);
      }

    }

    return result;
  }

  public Map<String, Set<Integer>> groupCodesByStock(List<LabSupply> supplies) {

    Map<String, Set<Integer>> groups = new TreeMap<>();

    groups.put("HIGH", new TreeSet<>());
    groups.put("LOW", new TreeSet<>());
    groups.put("MEDIUM", new TreeSet<>());

    for (LabSupply supply : supplies) {

      int yyy = Integer.parseInt(supply.getCode().split("-")[2]);

      if (supply.getStock() >= 50) {

        groups.get("HIGH").add(yyy);

      } else if (supply.getStock() >= 20) {

        groups.get("MEDIUM").add(yyy);

      } else {

        groups.get("LOW").add(yyy);

      }

    }

    return groups;
  }
}
