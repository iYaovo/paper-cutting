package com.iyaovo.paper.admin.service;

import com.iyaovo.paper.admin.domain.vo.ResourceVo;
import org.springframework.web.multipart.MultipartFile;

public interface IResourceService {
    ResourceVo addResource(MultipartFile file);
}
