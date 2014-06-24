package com.ninja_squad.geektic.service;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.GeekDao;
import com.ninja_squad.geektic.entity.Geek;

@RestController
@Transactional
@RequestMapping("/api/geek")
public class GeekService {
	@Autowired
	private GeekDao dao;
	
	@RequestMapping(method = RequestMethod.GET)
    public List<Geek> ListAll() {
        return dao.finAll();
    }
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Geek> search(@RequestParam String query) {
		return dao.findintret(query);
		
	}

}
