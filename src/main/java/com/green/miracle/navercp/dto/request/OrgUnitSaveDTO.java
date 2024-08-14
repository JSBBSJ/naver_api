package com.green.miracle.navercp.dto.request;

import lombok.Data;

@Data
public class OrgUnitSaveDTO {
	private String orgUnitName;
	private int displayOrder;
	private int domainId;
}
