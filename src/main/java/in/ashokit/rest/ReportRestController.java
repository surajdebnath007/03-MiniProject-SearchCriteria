package in.ashokit.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.report.ExcelGenerator;
import in.ashokit.report.PdfGenerator;
import in.ashokit.request.SearchRequest;
import in.ashokit.response.SearchResponse;
import in.ashokit.service.RecordService;

@RestController
public class ReportRestController {

	@Autowired
	private RecordService service;

	@GetMapping("/plan-names")
	public List<String> getPlanNames() {
		return service.getPlanNames();
	}

	@GetMapping("/plan-status")
	public List<String> getPlanStatus() {
		return service.getPlanStatus();
	}

	@PostMapping("/search")
	public List<SearchResponse> search(@RequestBody SearchRequest request) {
		return service.searchPlans(request);
	}

	@GetMapping("/excel")
	public void generateExcel(HttpServletResponse httpResponse) throws Exception {

		httpResponse.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Plans.xls";
		httpResponse.setHeader(headerKey, headerValue);

		List<SearchResponse> records = service.searchPlans(null);
		ExcelGenerator excel = new ExcelGenerator();
		excel.generateExcel(records, httpResponse);
	}

	@GetMapping("/pdf")
	public void generatePdf(HttpServletResponse httpResponse) throws Exception {

		httpResponse.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Plans.pdf";
		httpResponse.setHeader(headerKey, headerValue);

		List<SearchResponse> records = service.searchPlans(null);
		PdfGenerator pdfGen = new PdfGenerator();
		pdfGen.generatePdf(records, httpResponse);
	}
}
