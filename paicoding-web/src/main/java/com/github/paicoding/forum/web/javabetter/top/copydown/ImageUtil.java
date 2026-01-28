package com.github.paicoding.forum.web.javabetter.top.copydown;

/**
 * 微信搜索「AI技术圈」，回复 Java
 *
 * @author AI技术圈
 * @date 5/31/22
 */
public class ImageUtil {
    public static String getImgExt(String url) {
        for (String extItem : Constants.imgExtension) {
            if (url.indexOf(extItem) != -1) {
                return extItem;
            }
        }
        return Constants.imgExtension[0];
    }
}
