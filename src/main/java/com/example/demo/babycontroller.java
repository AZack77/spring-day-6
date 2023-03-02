package com.example.demo;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
//import org.springframework.data.2EWSdomain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class babycontroller {
@Autowired
	repository repo;
@Autowired
	babyservice service;

@GetMapping("/getvalues/{id}")
public Optional<data> getById(@PathVariable int id)
{
	return service.getData(id);
}
@PostMapping("/")
public data create(@RequestBody data dt)
{
	return repo.save(dt);
}

@GetMapping("/sort/{field}")
public List<data> asc (@PathVariable String field)
{
	return service.sort(field);
}
@GetMapping("/data/{offset}/{pageSize}")
public List<data>dataWithPagination(@PathVariable int offset , @PathVariable int pageSize)
{
	return service.setPages(offset, pageSize);
}
@GetMapping("/get/{offset}/{pages}/{field}")
public Page<data> paginationsorting(@PathVariable int offset,@PathVariable int pages,@PathVariable String field)
{
	return service.pagesort(offset, pages, field);
//	return pi.getContent();
}
}
