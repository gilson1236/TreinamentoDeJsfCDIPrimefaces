package com.projetojsf.financeiro.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projetojsf.financeiro.control.Usuario;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
@WebFilter("/AutorizacaoFilter")
public class AutorizacaoFilter implements Filter {

	@Inject
	private Usuario usuario;
	
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest requestHTTP = (HttpServletRequest)request;
		HttpServletResponse responseHTTP = (HttpServletResponse)response;
		
		if(!usuario.isLogado() && !requestHTTP.getRequestURI().endsWith("/Login.xhtml") && !requestHTTP.getRequestURI().contains("/javax.faces.resource/")) {
			responseHTTP.sendRedirect(requestHTTP.getContextPath() + "/Login.xhtml");
		} else {

			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
