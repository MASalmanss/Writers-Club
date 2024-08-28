package com.MASalmanss.writers_club.service.business;

import com.MASalmanss.writers_club.dto.bookDtos.PageDto;
import com.MASalmanss.writers_club.entity.Page;
import com.MASalmanss.writers_club.repository.PageRepository;
import com.MASalmanss.writers_club.service.abstracks.PageService;
import com.MASalmanss.writers_club.utils.mappers.PageMapper;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PageServiceImpl implements PageService {
    private final PageRepository pageRepository;
    private final PageMapper pageMapper;
    @Override
    public Page findById(Long id) {
       return pageRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Page with id " + id + " not found"));
    }

    @Override
    public List<Page> findAll() {
        return pageRepository.findAll();
    }

    @Override
    public Page save(PageDto pageDto) {
        return pageRepository.save(pageMapper.pageDtoToPage(pageDto));
    }

    @Override
    public void delete(Long id) {
        Page page = pageRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Page with id " + id + " not found"));
        pageRepository.delete(page);
    }

    public PageDto update(PageDto pageDto , Long id) throws BadRequestException {
        Page page = findById(id);

        if(page.getIsComplicated()){
            throw new BadRequestException("Complicated Page");
        }
        else {
            var contentReview = pageDto.content();
            page.setContent(pageDto.content());
            pageRepository.save(page);
            return pageMapper.pageToPageDto(page);
        }
    }
}
