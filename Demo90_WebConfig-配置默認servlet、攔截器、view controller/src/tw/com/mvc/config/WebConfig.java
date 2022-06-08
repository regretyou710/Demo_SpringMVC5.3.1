package tw.com.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import tw.com.mvc.interceptors.Interceptor;

/**
 * 代替SpringMVC的配置文件 
 * 1.掃描組件 
 * 2.視圖解析器
 * 3.view-controller
 * 4.default-servlet-handler
 * 5.mvc註解驅動
 * 6.文件上傳解析器
 * 7.異常處理
 * 8.攔截器
 */

@Configuration // 將當前標示為一個配置類
@ComponentScan("tw.com.mvc.controller") // 1.掃描組件
@EnableWebMvc // 5.mvc註解驅動
public class WebConfig implements WebMvcConfigurer{
	
	// 4.default-servlet-handler
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	// 8.攔截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 攔截所有請求路徑
		registry.addInterceptor(new Interceptor()).addPathPatterns("/**");
	}
	
	// 3.view-controller
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/hello").setViewName("hello");
	}

	// 配置生成範本解析器
	@Bean
	public ITemplateResolver templateResolver() {
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		// ServletContextTemplateResolver需要一個ServletContext作為構造參數，可通過WebApplicationContext
		// 的方法獲得
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(
				webApplicationContext.getServletContext());
		templateResolver.setPrefix("/WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setCharacterEncoding("UTF-8");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		return templateResolver;
	}

	// 生成範本引擎並為範本引擎注入範本解析器
	@Bean
	public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		return templateEngine;
	}

	// 生成視圖解析器並未解析器注入範本引擎
	@Bean
	public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setCharacterEncoding("UTF-8");
		viewResolver.setTemplateEngine(templateEngine);
		return viewResolver;
	}

}
