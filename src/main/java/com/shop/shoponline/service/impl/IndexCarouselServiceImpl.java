package com.shop.shoponline.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.shop.shoponline.entity.IndexCarousel;
import com.shop.shoponline.mapper.IndexCarouselMapper;
import com.shop.shoponline.service.IndexCarouselService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zero
 * @since 2023-11-11
 */
@Service
public class IndexCarouselServiceImpl extends ServiceImpl<IndexCarouselMapper, IndexCarousel> implements IndexCarouselService {

    @Override
    public List<IndexCarousel> getList(Integer distributionSite) {
        // 使用wrapper设置查询条件，当distributionSite不为空时，作为条件查询
        LambdaQueryWrapper<IndexCarousel> wrapper = new LambdaQueryWrapper<>();
        // distributionSite为1时查询首页广告，为2时查询商品分类页广告
        if (distributionSite != null) {
            wrapper.eq(IndexCarousel::getType, distributionSite);
        }
        // 设置排序 根据创建时间倒序排序
        wrapper.orderByDesc(IndexCarousel::getCreateTime);
        // 查询广告列表
        return baseMapper.selectList(wrapper);
    }
}
