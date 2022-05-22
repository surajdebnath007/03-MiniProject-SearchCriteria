package in.ashokit.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ELIGIBILITY_DTLS")
@Data
public class EligibilityDtlsEntity {

	@Id
	@GeneratedValue
	@Column(name = "ELIG_ID")
	private int eligId;

	@Column(name = "CASE_NUM")
	private long caseNo;

	@Column(name = "PLAN_NAME")
	private String planName;

	@Column(name = "PLAN_STATUS")
	private String planStatus;

	@Column(name = "HOLDER_NAME")
	private String holderName;

	@Column(name = "HOLDER_SSN")
	private long holderSsn;

	@Column(name = "BENEFIT_AMT")
	private float benefitAmount;

	@Column(name = "START_DATE")
	private LocalDate startDate;

	@Column(name = "END_DATE")
	private LocalDate endDate;

	@Column(name = "DENIAL_REASON")
	private String denialReason;

}
