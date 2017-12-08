package com.remp.work.control;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.remp.work.model.service.AssetService;
import com.remp.work.model.service.CustomerService;
import com.remp.work.model.service.EisService;
import com.remp.work.model.service.MemberService;
import com.remp.work.model.service.RentalService;

public abstract class ControllerAdapter {
	//빌드패스
	public static final String BUILD_PATH = "/WEB-INF/views/";
	public static final String SERVICE_PATH = "/WEB-INF/views/service/";
	public static final String STRUCTURE_PATH = "/WEB-INF/views/structure/";
	public static final String ERROR_PATH = "/WEB-INF/views/error/";
	//탬플릿
	public static final String PLAIN = "plain";
	public static final String PLAIN_RED = "plain_red";
	public static final String HEAD_DETIAL = "head_detail";
	public static final String HEAD_DETIAL_RED = "head_detial_red";
	public static final String TAB = "tab";
	public static final String TAB_RED = "tab_red";
	//기타
	public static final String TITLE = "ReMP : 렌탈관리 통합 플랫폼";
	//서비스
	@Autowired
	protected MemberService memberService;
	@Autowired
	protected CustomerService customerService;
	@Autowired
	protected AssetService assetService;
	@Autowired
	protected RentalService rentalService;
	@Autowired
	protected EisService eisService;
	
	private static final Logger logger = LoggerFactory.getLogger(ControllerAdapter.class);
	
	//---------------------- 기능 --------------------------------
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public abstract ModelAndView home();
	
	
	
	//---------------------- 유틸리티 --------------------------------
	//업무시스템 템플릿
	protected ModelAndView getPlainPage(String content) {
		return getInnerPage(SERVICE_PATH + content);
	}
	
	protected ModelAndView getPlainPage(ModelAndView mav, String content) {
		return getInnerPage(mav, null, SERVICE_PATH + content, PLAIN);
	}
	
	protected ModelAndView getHeadDetailPage(String headContent, String detailContent) {
		ModelAndView returnValue = getInnerPage(null, "head", SERVICE_PATH + headContent, HEAD_DETIAL);
		returnValue = getInnerPage(returnValue, "detail", SERVICE_PATH + detailContent, HEAD_DETIAL);
		return returnValue;
	}
	
	protected ModelAndView getHeadDetailPage(ModelAndView mav, String headContent, String detailContent) {
		mav = getInnerPage(mav, "head", SERVICE_PATH + headContent, HEAD_DETIAL);
		mav = getInnerPage(mav, "detail", SERVICE_PATH + detailContent, HEAD_DETIAL);
		return mav;
	}
	
	protected ModelAndView getTabPage(String content) {
		return getInnerPage(null, null, SERVICE_PATH + content, TAB);
	}
	
	protected ModelAndView getTabPage(ModelAndView mav, String content) {
		return getInnerPage(mav, null, SERVICE_PATH + content, TAB);
	}
	
	//사용자시스템 템플릿
	protected ModelAndView getPlainRedPage(String content) {
		return getInnerPage(null, null, SERVICE_PATH + content, PLAIN_RED);
	}
	
	protected ModelAndView getPlainRedPage(ModelAndView mav, String content) {
		return getInnerPage(mav, null, SERVICE_PATH + content, PLAIN_RED);
	}
	
	protected ModelAndView getHeadDetailRedPage(String headContent, String detailContent) {
		ModelAndView returnValue = getInnerPage(null, "head", SERVICE_PATH + headContent, HEAD_DETIAL_RED);
		returnValue = getInnerPage(returnValue, "detail", SERVICE_PATH + detailContent, HEAD_DETIAL_RED);
		return returnValue;
	}
	
	protected ModelAndView getHeadDetailRedPage(ModelAndView mav, String headContent, String detailContent) {
		mav = getInnerPage(mav, "head", SERVICE_PATH + headContent, HEAD_DETIAL_RED);
		mav = getInnerPage(mav, "detail", SERVICE_PATH + detailContent, HEAD_DETIAL_RED);
		return mav;
	}
	
	protected ModelAndView getTabRedPage(String content) {
		return getInnerPage(null, null, SERVICE_PATH + content, TAB);
	}
	
	protected ModelAndView getTabRedPage(ModelAndView mav, String content) {
		return getInnerPage(mav, null, SERVICE_PATH + content, TAB);
	}
	
	//페이지로드
	protected ModelAndView getInnerPage(String fileName) {
		return getInnerPage(null, null, fileName, null);
	}
	
	protected ModelAndView getInnerPage(String fileName, String templeteId) {
		return getInnerPage(null, null, fileName, templeteId);
	}
	
	protected ModelAndView getInnerPage(String viewName, String fileName, String templeteId) {
		return getInnerPage(null, viewName, fileName, templeteId);
	}
	
	protected ModelAndView getInnerPage(ModelAndView mav, String viewName, String fileName, String templeteId) {
		if (mav == null) {
			mav = new ModelAndView();
		}
		if (viewName == null || viewName.trim().length() == 0) {
			viewName = "servicePage";
		}
		if (templeteId == null || templeteId.trim().length() == 0) {
			templeteId = PLAIN;
		}
		mav.addObject(viewName, fileName);
		mav.setViewName(templeteId);
		return mav;
	}
	
	//DBMS transaction controller
	protected Map<String, String> isUpdatedToMap(int result) {
		Map<String, String> returnValue = new HashMap<>();
		StringBuilder value = new StringBuilder();
		if (result == 1) {
			value.append("success");
		} else if (result == 0) {
			value.append("invalid");
		} else if (result > 1) {
			value.append("violated");
		} else {
			value.append("network");
		}
		returnValue.put("result", value.toString());
		return returnValue;
	}
	
	protected Map<String, String> areUpdatedToMap(int result) {
		Map<String, String> returnValue = new HashMap<>();
		StringBuilder value = new StringBuilder();
		if (result >= 1) {
			value.append("success");
		} else if (result == 0) {
			value.append("invalid");
		} else {
			value.append("network");
		}
		returnValue.put("result", value.toString());
		return returnValue;
	}
	
	protected boolean isUpdated(int result) {
		if (result == 1) {
			return true;
		}
		return false;
	}
	
	protected boolean areUpdated(int result) {
		if (result >= 1) {
			return true;
		}
		return false;
	}
	
	protected Map<String, String> isInsertedToMap(int result) {
		Map<String, String> returnValue = new HashMap<>();
		StringBuilder value = new StringBuilder();
		if (result == 1) {
			value.append("success");
		} else if (result == 0) {
			value.append("invalid");
		} else if (result > 1) {
			value.append("violated");
		} else {
			value.append("network");
		}
		returnValue.put("result", value.toString());
		return returnValue;
	}
	
	protected Map<String, String> areInsertedToMap(int result) {
		Map<String, String> returnValue = new HashMap<>();
		StringBuilder value = new StringBuilder();
		if (result >= 1) {
			value.append("success");
		} else if (result == 0) {
			value.append("invalid");
		} else {
			value.append("network");
		}
		returnValue.put("result", value.toString());
		return returnValue;
	}
	
	protected boolean isInserted(int result) {
		if (result == 1) {
			return true;
		}
		return false;
	}
	
	protected boolean areInserted(int result) {
		if (result >= 1) {
			return true;
		}
		return false;
	}
	
	protected Map<String, String> isDeletedToMap(int result) {
		Map<String, String> returnValue = new HashMap<>();
		StringBuilder value = new StringBuilder();
		if (result == 1) {
			value.append("success");
		} else if (result == 0) {
			value.append("invalid");
		} else if (result > 1) {
			value.append("violated");
		} else {
			value.append("network");
		}
		returnValue.put("result", value.toString());
		return returnValue;
	}
	
	protected Map<String, String> areDeletedToMap(int result) {
		Map<String, String> returnValue = new HashMap<>();
		StringBuilder value = new StringBuilder();
		if (result >= 1) {
			value.append("success");
		} else if (result == 0) {
			value.append("invalid");
		} else {
			value.append("network");
		}
		returnValue.put("result", value.toString());
		return returnValue;
	}
	
	protected boolean isDeleted(int result) {
		if (result == 1) {
			return true;
		}
		return false;
	}
	
	protected boolean areDeleted(int result) {
		if (result >= 1) {
			return true;
		}
		return false;
	}
}
