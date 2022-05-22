package in.ashokit.service;

import java.util.List;

import in.ashokit.request.SearchRequest;
import in.ashokit.response.SearchResponse;

public interface RecordService {

	public List<String> getPlanNames();

	public List<String> getPlanStatus();

	public List<SearchResponse> searchPlans(SearchRequest request);

	public void exportExcel(List<SearchResponse> records);

	public void exportPdf(List<SearchResponse> records);
}
