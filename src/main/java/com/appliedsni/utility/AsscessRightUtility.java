package com.appliedsni.utility;

import java.util.ArrayList;
import java.util.List;

import com.appliedsni.entity.AccessRight;

public class AsscessRightUtility {
	public static List<AccessRight> acessRightList;

	public static List<AccessRight> getAcessRightList() {
		if(acessRightList==null)
			acessRightList=new ArrayList<AccessRight>();
		return acessRightList;
	}

	public static void setAcessRightList(List<AccessRight> acessRightList) {
		AsscessRightUtility.acessRightList = acessRightList;
	}
	

}
