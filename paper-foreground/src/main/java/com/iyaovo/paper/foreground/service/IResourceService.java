package com.iyaovo.paper.foreground.service;

import com.iyaovo.paper.foreground.domain.vo.ResourceVo;
import org.springframework.web.multipart.MultipartFile;

public interface IResourceService{
    ResourceVo addResource(MultipartFile file);
}
