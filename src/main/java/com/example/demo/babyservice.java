package com.example.demo;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class babyservice {
@Autowired
repository repo;
public Optional<data> getData(int id)
{
	return repo.findById(id);
}
public List<data> sort(String field)
{
	return repo.findAll(Sort.by(Sort.Direction.DESC,field));
}

public List<data> setPages(@PathVariable int offset,@PathVariable int pageSize)
{
	Page<data> page = repo.findAll(PageRequest.of(offset, pageSize));
	return page.getContent();
}
public Page<data> pagesort(@PathVariable int offset,@PathVariable int pages,@PathVariable String field)
{
	Pageable paging = PageRequest.of(offset,pages,Sort.by(field));
	return repo.findAll(paging);
}
}
