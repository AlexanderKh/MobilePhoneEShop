package ksk.dao;

import ksk.entity.Product;

import java.util.List;

public interface CharacteristicDAO {
    List<Characteristic> getCharacteristicsByProduct(Product product);
}
