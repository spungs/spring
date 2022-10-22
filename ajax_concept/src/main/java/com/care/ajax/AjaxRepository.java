package com.care.ajax;

import org.springframework.stereotype.Repository;

@Repository
public interface AjaxRepository {
	int insert(AjaxDTO dto);
}
