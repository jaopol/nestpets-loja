package br.com.nestpets.loja.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.nestpets.loja.util.TokenUtil;

public class AuthenticationTokenFilter extends OncePerRequestFilter {

	private static final String AUTH_HEADER = "Authorization";
	private static final String AUTH_HEADER2 = "authorization";

	private static final String BEARER_PREFIX = "Bearer ";

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private TokenUtil tokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		String token = getAuthorizationHeaderUrl(request);
		if (token != null && token.startsWith(BEARER_PREFIX)) {
			token = token.substring(7);
		}
		String username = tokenUtil.getUsernameFromToken(token);

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

			if (tokenUtil.isTokenValidate(token)) {
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}

		chain.doFilter(request, response);
	}

	private String getAuthorizationHeaderUrl(HttpServletRequest request) {
		String token = request.getHeader(AUTH_HEADER);
		if (token == null) {
			token = request.getHeader(AUTH_HEADER2);
		}

		return token;
	}

}
