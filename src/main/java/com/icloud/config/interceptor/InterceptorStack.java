package com.icloud.config.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置拦截器
 */
@Configuration
public class InterceptorStack {


	@Configuration
	public static class WebMvcConfigurer extends WebMvcConfigurerAdapter {

//		@Bean
//		public WxUserLoginInterceptor getWxUserLoginInterceptor()
//		{
//			return new WxUserLoginInterceptor();
//		}
		public void addInterceptors(InterceptorRegistry registry) {
//			registry.addInterceptor(new XssCsrfInterceptor()).addPathPatterns("/**").excludePathPatterns("/thirdInterfacePath/**")
//					.excludePathPatterns("/beanGoods/goodsDetail").excludePathPatterns("/checkToken/removeToken")
//					.excludePathPatterns("/backpage/setting/beforeUpdate").excludePathPatterns("/backpage/setting/update");
            //xcxUserLogin小程序端登陆拦截
            registry.addInterceptor(new XcxLoginInterceptor()).addPathPatterns("/xcxpath/**")
                    .excludePathPatterns("/xcxpath/xcxUserLogin/**");

		    registry.addInterceptor(new PermissionsInterceptor()).addPathPatterns("/admin/**").addPathPatterns("/backpage/**");
//			registry.addInterceptor(new AddTokenInterceptor()).addPathPatterns("/beanGoods/goodsDetail");
//		    registry.addInterceptor(new RemoveTokenInterceptor()).addPathPatterns("/checkToken/removeToken");
//            registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/frontpage/**"); //手机端拦截
////            registry.addInterceptor(getWxUserLoginInterceptor()).addPathPatterns("/frontpage/**"); //手机端拦截 本地
//			registry.addInterceptor(new ThirdInterfaceInterceptor()).addPathPatterns("/thirdInterfacePath/**"); //第三方接口拦截
		}
	}
}
