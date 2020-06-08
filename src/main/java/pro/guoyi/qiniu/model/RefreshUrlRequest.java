package pro.guoyi.qiniu.model;

import lombok.Data;

/**
 * 提币
 */

@Data
/**
 * @param coinCode     币种代码
 * @param chainId      链id
 * @param withdrawNum  提币数量
 * @param withdrawAddr 收币地址
 * @param withdrawTag  收币标签
 */
public class RefreshUrlRequest {

    String[] linkList;
}