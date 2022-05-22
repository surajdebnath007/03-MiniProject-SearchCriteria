package in.ashokit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ashokit.entities.EligibilityDtlsEntity;

public interface EligibilityDtlsRepository extends JpaRepository<EligibilityDtlsEntity, Integer>{


	@Query("select distinct(planName) from EligibilityDtlsEntity")
	public List<String> getPlans();
	
	@Query("select distinct(planStatus) from EligibilityDtlsEntity")
	public List<String> getPlanStatus();
}
