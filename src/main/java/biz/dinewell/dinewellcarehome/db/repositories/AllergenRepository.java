package biz.dinewell.dinewellcarehome.db.repositories;

import biz.dinewell.dinewellcarehome.db.entity.Allergen;
import org.springframework.data.repository.CrudRepository;

public interface AllergenRepository extends CrudRepository<Allergen, String> {
}
