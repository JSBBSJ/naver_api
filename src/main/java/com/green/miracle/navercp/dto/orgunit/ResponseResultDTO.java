package com.green.miracle.navercp.dto.orgunit;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseResultDTO {
	
	//이름(필드명)이 일치해야함
	private ResponseMetaData responseMetaData;
	List<OrgUnit> orgUnits;
	//OrgUnit[] orgUnits;

}
