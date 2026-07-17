package com.manage.library.repository;

import com.manage.library.projection.*;
import com.manage.library.dto.IssueDto;
import com.manage.library.dto.RequestDto;
import com.manage.library.entity.IssuedRecord;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<IssuedRecord, Long> {
	
	List<IssueBookProjection> findAllBy();

	IssueDto save(RequestDto requestDto);

}
