package tw.com.mvc.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//web專案的初始化類，用來代替web.xml
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * 指定spring的配置類
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { SpringConfig.class };
	}

	/**
	 * 指定springMVC的配置類
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { WebConfig.class };
	}

	/**
	 * 指定DispatcherServlet的映射規則，即url-pattern
	 */
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/" };
	}

	/**
	 * 註冊過濾器
	 */
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("utf-8");
		characterEncodingFilter.setForceResponseEncoding(true);

		HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
		return new Filter[] { characterEncodingFilter, hiddenHttpMethodFilter };
	}

}
