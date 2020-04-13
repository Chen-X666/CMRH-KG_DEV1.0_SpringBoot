package com.canton.controller;

import com.canton.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 目录
 * @Auther ChenX
 * @Date 2020.3.20
 **/
@Controller
public class CatalogController {
	@Autowired
	private CatalogService catalogService;

	@RequestMapping(value = "/catalog-getTopClasses")
	@ResponseBody
	public String getTopClasses() {
		//获取目录头结点
		return catalogService.getTopClassNodes();
	}

}
