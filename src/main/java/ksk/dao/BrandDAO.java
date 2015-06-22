package ksk.dao;

import java.util.List;

public interface BrandDAO {

    List<Brand> getBrands();

    Brand getBrand(int brandID);
}
