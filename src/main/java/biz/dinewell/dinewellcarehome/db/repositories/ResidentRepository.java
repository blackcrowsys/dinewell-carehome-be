package biz.dinewell.dinewellcarehome.db.repositories;

import biz.dinewell.dinewellcarehome.db.entity.Resident;
import org.springframework.data.repository.CrudRepository;

public interface ResidentRepository extends CrudRepository<Resident, String> {
}
