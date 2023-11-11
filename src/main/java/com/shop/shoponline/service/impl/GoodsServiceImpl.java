package com.shop.shoponline.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.shoponline.common.exception.ServerException;
import com.shop.shoponline.common.result.PageResult;
import com.shop.shoponline.convert.GoodsConvert;
import com.shop.shoponline.entity.Goods;
import com.shop.shoponline.entity.IndexRecommend;
import com.shop.shoponline.entity.IndexRecommendTab;
import com.shop.shoponline.mapper.GoodsMapper;
import com.shop.shoponline.mapper.IndexRecommendMapper;
import com.shop.shoponline.mapper.IndexRecommendTabMapper;
import com.shop.shoponline.query.RecommendByTabGoodsQuery;
import com.shop.shoponline.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.shoponline.vo.IndexTabGoodsVO;
import com.shop.shoponline.vo.IndexTabRecommendVO;
import com.shop.shoponline.vo.RecommendGoodsVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zero
 * @since 2023-11-07
 */
@Service
@AllArgsConstructor
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    private final IndexRecommendMapper indexRecommendMapper;
    private final IndexRecommendTabMapper indexRecommendTabMapper;

    @Override
    public IndexTabRecommendVO getTabRecommendGoodsByTabId(RecommendByTabGoodsQuery query) {
        // 1.根据推荐的recommendId查询实体
        IndexRecommend indexRecommend = indexRecommendMapper.selectById(query.getSubType());
        if (indexRecommend==null){
            throw new ServerException("推荐分类不存在");
        }
        // 2.查询该分类下的tab列表
        LambdaQueryWrapper<IndexRecommendTab> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(IndexRecommendTab::getRecommendId,indexRecommend.getId());
        List<IndexRecommendTab> tabList  = indexRecommendTabMapper.selectList(wrapper);
        if (tabList.size()==0){
            throw new ServerException("该分类下不存在tab分类");
        }
        // 3.tab分类下的商品列表
        List<IndexTabGoodsVO> list = new ArrayList<>();
        for (IndexRecommendTab item:tabList){
            IndexTabGoodsVO tabGoods = new IndexTabGoodsVO();
            tabGoods.setId(item.getId());
            tabGoods.setName(item.getName());
            Page<Goods> page = new Page<>(query.getPage(),query.getPageSize());
            Page<Goods> goodsPage = baseMapper.selectPage(page,new LambdaQueryWrapper<Goods>());
            List<RecommendGoodsVO> goodsList = GoodsConvert.INSTANCE.convertToRecommendGoodsVOList(goodsPage.getRecords());
            PageResult<RecommendGoodsVO> result = new PageResult<>(page.getTotal(),  query.getPageSize(), query.getPage(),page.getPages(),goodsList);
            tabGoods.setGoodsItems(result);
            list.add(tabGoods);

        }
        IndexTabRecommendVO recommendVO = new IndexTabRecommendVO();
        recommendVO.setId(indexRecommend.getId());
        recommendVO.setName(indexRecommend.getName());
        recommendVO.setCover(indexRecommend.getCover());
        recommendVO.setSubTypes(list);
        return recommendVO;
    }
}
