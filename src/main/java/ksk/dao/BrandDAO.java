package ksk.dao;

import ksk.entity.Brand;

import java.util.List;

public interface BrandDAO {

    List<Brand> getBrands();

    Brand getBrand(int brandID);
}
