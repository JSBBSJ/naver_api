package com.green.miracle.navercp.dto.orgunit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrgUnitAllowedMember {
	
	private String userId;
	private String userExternalKey;

}
