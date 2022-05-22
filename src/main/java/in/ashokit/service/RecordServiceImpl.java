package in.ashokit.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.entities.EligibilityDtlsEntity;
import in.ashokit.repository.EligibilityDtlsRepository;
import in.ashokit.request.SearchRequest;
import in.ashokit.response.SearchResponse;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	private EligibilityDtlsRepository repo;

	@Override
	public List<String> getPlanNames() {
		return repo.getPlans();
	}

	@Override
	public List<String> getPlanStatus() {
		return repo.getPlanStatus();
	}

	@Override
	public List<SearchResponse> searchPlans(SearchRequest request) {

		List<EligibilityDtlsEntity> eligRecords = null;

		if (isSearchRequestEmpty(request) == true) {

			eligRecords = repo.findAll();
		} else {

			String planName = request.getPlanName();
			String planStatus = request.getPlanStatus();
			LocalDate startDate = request.getStartDate();
			LocalDate endDate = request.getEndDate();

			EligibilityDtlsEntity entity = new EligibilityDtlsEntity();

			if (planName != null && !planName.equals("")) {
				entity.setPlanName(planName);
			}

			if (planStatus != null && !planStatus.equals("")) {
				entity.setPlanStatus(planStatus);
			}
			if (startDate != null && endDate != null) {
				entity.setStartDate(startDate);
				entity.setEndDate(endDate);
			}

			Example<EligibilityDtlsEntity> of = Example.of(entity);
			eligRecords = repo.findAll(of);
		}

		List<SearchResponse> response = new ArrayList<>();
		for (EligibilityDtlsEntity eligRecord : eligRecords) {
			SearchResponse sr = new SearchResponse();
			BeanUtils.copyProperties(eligRecord, sr);
			response.add(sr);
		}
		return response;
	}

	private boolean isSearchRequestEmpty(SearchRequest request) {
		if (request == null) {
			return true;
		}

		if (request.getPlanName() != null && !request.getPlanName().equals("")) {
			return false;
		}

		if (request.getPlanStatus() != null && !request.getPlanStatus().equals("")) {
			return false;
		}

		if (request.getStartDate() != null && request.getEndDate() != null) {
			return false;
		}

		return true;
	}

	@Override
	public void exportExcel(List<SearchResponse> records) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exportPdf(List<SearchResponse> records) {
		// TODO Auto-generated method stub

	}

}
