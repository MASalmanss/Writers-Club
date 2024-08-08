package com.MASalmanss.writers_club.controller;

import com.MASalmanss.writers_club.dto.bookDtos.PageDto;
import com.MASalmanss.writers_club.entity.Page;
import com.MASalmanss.writers_club.service.abstracks.PageService;
import com.MASalmanss.writers_club.utils.mappers.PageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pages")
@PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN')")
@RequiredArgsConstructor
@Slf4j
public class PageController {
    private final PageService pageService;
    private final PageMapper pageMapper;

    @PostMapping("")
    public void createPage(@RequestBody PageDto pageDto) {
        log.info(pageDto.toString());
    }

    @GetMapping("")
    public List<PageDto> getPages() {
        List<PageDto> pageDtos = pageMapper.pageToPageDto(pageService.findAll());
        return pageDtos;
    }

    @GetMapping("/{id}")
    public List<Page> getAllPagesByUserId(@PathVariable Long id){
        return null;
    }


}
