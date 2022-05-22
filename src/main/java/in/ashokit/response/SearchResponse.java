package in.ashokit.response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SearchResponse {

	private long caseNo;
	
	private String planName;

	private String planStatus;

	private String holderName;

	private long holderSsn;

	private double benefitAmount;

	private LocalDate startDate;

	private LocalDate endDate;

	private String denialReason;

}
