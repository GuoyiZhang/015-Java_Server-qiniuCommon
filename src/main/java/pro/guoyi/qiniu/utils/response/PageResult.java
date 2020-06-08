package pro.guoyi.qiniu.utils.response;


import lombok.Data;

import java.io.Serializable;

@Data
public class PageResult<T> implements Serializable {

    private long currentPage = 0;
    private int currentSize = 0;
    private long pageTotal = 0;
    private long totalSize = 0;
    private T list = null;

    public static <T> PageResult getResult(long page, int size, long totalSize, T data) {
        PageResult<T> result = new PageResult<T>();
        result.list = data;
        result.currentPage = page;
        result.currentSize = size;
        result.totalSize = totalSize;
        result.pageTotal = (long) Math.ceil((double) totalSize / size);
        return result;
    }
}