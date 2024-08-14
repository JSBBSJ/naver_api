package com.green.miracle.navercp.dto.orgunit;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.ToString;

@ToString
@JsonIgnoreProperties(ignoreUnknown = true) //이 어노테이션 들어가면 필요 없는 값은 안 넣어도 됨
//Json 속성을 모두 매핑하려고 하는데 만약에 없는 것은 무시해라
@Getter
public class OrgUnit {
	
	//private List<String> aliasEmails;
	//private boolean canReceiveExternalMail;
    //private String description;
    private int displayLevel;
    private int displayOrder;
    //private int domainId;
    //private String email;
    //private List<OrgUniti18nName> i18nNames;
    //private List<OrgUnitAllowedMember> membersAllowedToUseOrgUnitEmailAsRecipient;
    //private List<OrgUnitAllowedMember> membersAllowedToUseOrgUnitEmailAsSender;
    private String orgUnitExternalKey;
    private String orgUnitId; //부서 아이디
    private String orgUnitName; //부서이름
    private String parentExternalKey;
    private String parentOrgUnitId;
    //private boolean useCalendar;
    //private boolean useFolder;
    //private boolean useMessage;
    //private boolean useNote;
    //private boolean useServiceNotification;
    //private boolean useTask;
    //private boolean visible;
    
}
